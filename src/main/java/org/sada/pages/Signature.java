package org.sada.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sada.util.Logger;


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
    private final By firstSignatureField = By.cssSelector("div.img--wrapper.editable:first-of-type");
    private final By saveBtn = By.id("insert_bottom");
    private final By nameInputField = By.id("input--name");

    private final By SignaturePage2 = By.cssSelector("#page-container-1 div.img--wrapper.editable");
    private final By signatureBtn2 = By.cssSelector("#page-container-1 div.img--wrapper.editable");

    private final By SignaturePage3 = By.cssSelector("#page-container-2 div.img--wrapper.editable");
    private final By signatureBtn3 = By.cssSelector("#page-container-2 div.img--wrapper.editable");

    private final By aggrementInput = By.id("input--terms");
    private final By signBtn =  By.cssSelector("button.tab_navigation_white.button.button--info.button--fluid.button--invert[type='submit']");
    private final By finalizeBtn = By.cssSelector("a span[data-msgid='DOCUMENT_PREPARE_FINALIZE']");

    // -----------------------------
    // Methods
    // -----------------------------
    public void signApplication(String name) {

        Logger.info("Signing the Application");
        // Click OK button
        utility.click(okayBtn);

        // Click first signature and save
        utility.click(firstSignatureField);
        utility.clearAndType(nameInputField, name);
        utility.click(saveBtn);


        // Select second page
        utility.click(SignaturePage2);
        utility.click(signatureBtn2);
        utility.click(By.xpath("//label[@aria-label='Saved signature']"));

        // Select second page
        utility.click(SignaturePage3);
        utility.click(signatureBtn3);
        utility.click(By.xpath("//label[@aria-label='Saved signature']"));

        utility.click(finalizeBtn);

        if(utility.isElementPresent(aggrementInput)){
            utility.click(aggrementInput);
            utility.click(signBtn);
        }
    }
}