package org.sada.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sada.ApplicantInfo;
import org.sada.util.Logger;

public class SignaturePage extends BasePage {

    // -----------------------------
    // Locators
    // -----------------------------
    private final By pageTitle = By.id("eid-page.page.title");
    private final By continueBtn = By.id("continue-button");

    // -----------------------------
    // Constructor
    // -----------------------------
    public SignaturePage(WebDriver driver) {
        super(driver);
    }

    // -----------------------------
    // Actions
    // -----------------------------
    public void complete(ApplicantInfo applicantInfo) {
        if (!utility.isElementPresent(pageTitle)) {
            Logger.info("Skipping : " + pageTitle.toString());
         return;
        }
        Logger.info("Filling : " + pageTitle.toString());
        utility.click(continueBtn); // Take me to sign Application
    }
}