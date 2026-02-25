package org.sada.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Signature extends BasePage {
    public Signature(WebDriver driver) {
        super(driver);
    }

    /* -----------------------------
       Locators (class properties)
     ----------------------------- */

    private final By infoBtn =  By.xpath("//a[normalize-space()='OK']");
    // 1st signature
    By firstSignature = By.xpath(
            "(//span[normalize-space()='Signature']/ancestor::div[contains(@class,'img--wrapper')])[1]"
    );

    // 2nd signature
    By secondSignature = By.xpath(
            "(//span[normalize-space()='Signature']/ancestor::div[contains(@class,'img--wrapper')])[2]"
    );

    // 3rd signature
    By thirdSignature = By.xpath(
            "(//span[normalize-space()='Signature']/ancestor::div[contains(@class,'img--wrapper')])[3]"
    );

    By termsCheckbox = By.id("input--terms");

    By inputName = By.id("input--name");
    By saveAndInsertBtn = By.id("insert_bottom");

    By savedSignature = By.cssSelector("label[title='Saved signature']");

    By finalizeBtn = By.cssSelector("a span[data-msgid='DOCUMENT_PREPARE_FINALIZE']");

    By signBtn = By.cssSelector("span[data-msgid='TERMS_CONDITIONS_AGREE_SIGN']");


    // -----------------------------
    // Actions (public API)
    // -----------------------------
    protected void inputSignature(By signBox, By signInput, By saveBtn){
        utility.click(signBox);
        utility.clearAndType(signInput, "123");
        utility.click(saveBtn);

    }

    protected void inputSignature(By signBox, By signatureButton){
        utility.click(signBox);
        utility.click(signatureButton);
    }

    public void SignApplication(){
        utility.click(infoBtn);
        inputSignature(firstSignature, inputName, saveAndInsertBtn);
        inputSignature(secondSignature, savedSignature);
        inputSignature(thirdSignature, savedSignature);
        utility.click(finalizeBtn);
        utility.click(termsCheckbox);
        utility.click(signBtn);
    }
}
