package org.sada.util;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.Objects;
import java.util.Scanner;


public class Utility {

    private WebDriver driver;
    private final WebDriverWait wait;
    private static final Scanner SCANNER = new Scanner(System.in);

    public Utility (WebDriver driver) {
        this.driver = Objects.requireNonNull(driver, "driver must not be null");
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    // -----------------------------
    // Selenium Based Utilities
    // -----------------------------


    public WebElement findElement(By by){
        try{
            return driver.findElement(by);
        }catch(NoSuchElementException ex){
            Logger.error("Element not found: " + by);
            throw new NoSuchElementException("Element not found: " + by, ex);
        }
    }
    public WebElement waitPresent(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebElement waitVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitClickable(By locator) {
        try{
            return wait.until(ExpectedConditions.elementToBeClickable(waitVisible(locator)));
        }catch (TimeoutException e){
            throw new TimeoutException(e.getMessage());
        }
    }

    public WebElement scrollIntoView(By locator) {
        WebElement el = waitPresent(locator);
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior:'instant',block:'center'});", el);
        return el;
    }

    public void clearAndType(By locator, String text) {
        WebElement el = waitVisible(locator);
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", el);

        el.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        el.sendKeys(Keys.DELETE);
        el.sendKeys(text);
    }

    public boolean click(By locator) {
        try {
            WebElement el = scrollIntoView(locator);

            try {
                waitClickable(locator).click();
            } catch (TimeoutException | ElementClickInterceptedException e) {
                ((JavascriptExecutor) driver)
                        .executeScript("arguments[0].click();", el);
            }

            return true;

        } catch (TimeoutException | NoSuchElementException e) {
            Logger.error("Element not found: " + locator);
            return false;
        }
    }
    public void clickCheckbox(By inputLocator, By labelLocator) {
        WebElement input = driver.findElement(inputLocator); // wait for the actual checkbox input
        WebElement clickable = scrollIntoView(labelLocator);

        // Only click if not already selected
        if (!input.isSelected()) {
            try {
                waitClickable(labelLocator).click();
            } catch (TimeoutException | ElementClickInterceptedException e) {
                // Fallback to JS click
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickable);
            }
        }
    }



    public void clickButton(By btnID){
        this.click(btnID);
    }



    public void setCheckbox(By locator, boolean value){

        WebElement checkbox = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior:'instant',block:'center'});", checkbox);

        boolean isChecked = checkbox.isSelected();
        if (isChecked != value) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
        }

    }


    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementPresent10(By locator) {
        try {
            // Wait up to 10 seconds for the element to be present in the DOM
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return element != null;
        } catch (Exception e) {
            Logger.error(e.getMessage());
            return false; // timeout or other exceptions
        }
    }

    public void getElement(){
        //
    }




    public String getValue(By by) {
        WebElement element = waitPresent(by);
        return element.getDomProperty("value");
    }

    // -----------------------------
    // Internal helper: input click with label fallback
    // -----------------------------
    public void clickRadio(By inputBy, By labelBy) {
        try {
            this.click(inputBy); // prefer clicking the actual input
        } catch (Exception e) {
            // Fallback to clicking the label (bigger target and often not obstructed)
            this.click(labelBy);
        }
    }



    // -----------------------------
    // UI Based Utilities
    // -----------------------------
    public static void copyToClipboard(String contentType, String content) {
        try {

            // 1. Get the system clipboard
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

            // 2. Clear the clipboard by setting a null StringSelection
            // The system handles the details of clearing old data when new data is set,
            // but for explicit "clearing", we can use a temporary empty selection first.
            Transferable emptySelection = new StringSelection("");
            clipboard.setContents(emptySelection, null);


            // Create a transferable object (StringSelection) that holds the string content.
            StringSelection stringSelection = new StringSelection(content);

            // Set the content of the clipboard.
            clipboard.setContents(stringSelection, null);

            System.out.println(contentType + " successfully copied to clipboard: \"" + content + "\"");

        } catch (Exception e) {
            Logger.error("Error copying to clipboard: " + e.getMessage());
            // Handle exceptions such as if the AWT environment is not available (e.g., in a headless server environment).
        }
    }

    public void writeToTextFile(String text) {

        try (FileWriter writer = new FileWriter("output.txt", true)) {
            writer.write(text + System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException("Failed to write to file", e);
        }
    }
}
