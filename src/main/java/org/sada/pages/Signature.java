package org.sada.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Signature extends BasePage {

    // -----------------------------
    // Constructor
    // -----------------------------
    public Signature(WebDriver driver) {
        super(driver);
    }

    // -----------------------------
    // Locators
    // -----------------------------
    private final By okayBtn = By.linkText("OK");
    private final By signatureFields = By.cssSelector("div.img--wrapper.editable");
    private final By nameInputField = By.cssSelector("input[id*='name']");
    private final By saveBtn = By.id("insert_bottom");
    private final By finalizeBtn = By.cssSelector("a span[data-msgid='DOCUMENT_PREPARE_FINALIZE']");

    // -----------------------------
    // Methods
    // -----------------------------
    public void signApplication(String name) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Click OK button
        utility.click(okayBtn);

        // Get number of signature fields
        int count = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(signatureFields)
        ).size();

        for (int i = 0; i < count; i++) {

            // Re-fetch elements every iteration (avoid stale elements)
            List<WebElement> signatures = wait.until(
                    ExpectedConditions.visibilityOfAllElementsLocatedBy(signatureFields)
            );

            WebElement sigField = wait.until(
                    ExpectedConditions.elementToBeClickable(signatures.get(i))
            );

            // JS click for reliability
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sigField);
            System.out.println("Clicked signature index: " + i);

            // -----------------------------
            // Handle iframe if present
            // -----------------------------
            List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
            if (!iframes.isEmpty()) {
                driver.switchTo().frame(iframes.get(0));
                System.out.println("Switched to iframe");
            }

            // -----------------------------
            // Wait for either saved signature modal or input field
            // -----------------------------
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement modalOrInput = null;

            try {
                modalOrInput = shortWait.until(d -> {
                    List<WebElement> savedModals = d.findElements(By.id("signatures--saved"));
                    if (!savedModals.isEmpty() && savedModals.get(0).isDisplayed()) {
                        return savedModals.get(0);
                    }
                    List<WebElement> nameInputs = d.findElements(By.cssSelector("input[id*='name']"));
                    if (!nameInputs.isEmpty() && nameInputs.get(0).isDisplayed()) {
                        return nameInputs.get(0);
                    }
                    return null;
                });
            } catch (Exception e) {
                System.out.println("No modal or input found; skipping signature field");
            }

            // -----------------------------
            // Fill or select signature
            // -----------------------------
            if (modalOrInput != null && "signatures--saved".equals(modalOrInput.getAttribute("id"))) {
                System.out.println("Using saved signature");
                List<WebElement> savedSignatures = modalOrInput.findElements(By.cssSelector(".signature__list label"));
                if (!savedSignatures.isEmpty()) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", savedSignatures.get(0));
                }
            } else if (modalOrInput != null) {
                System.out.println("Typing signature");
                WebElement nameInput = modalOrInput;
                nameInput.clear();
                nameInput.sendKeys(name);

                WebElement save = wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", save);
            }

            // Switch back to main DOM
            driver.switchTo().defaultContent();

            // Wait for modal/input to disappear before next iteration
            try {
                wait.until(ExpectedConditions.invisibilityOfElementLocated(nameInputField));
            } catch (Exception ignored) {
            }
        }

        // Finalize application
        utility.click(finalizeBtn);
    }
}