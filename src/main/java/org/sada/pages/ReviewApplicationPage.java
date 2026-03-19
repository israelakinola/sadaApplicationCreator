package org.sada.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sada.ApplicantInfo;
import org.sada.util.Logger;

public class ReviewApplicationPage extends BasePage {

    // -----------------------------
    // Locators
    // -----------------------------
    private final By pageTitle = By.id("review.page.title");
    private final By saveAndContinueBtn = By.id("review-save-continue-button");

    // -----------------------------
    // Constructor
    // -----------------------------
    public ReviewApplicationPage(WebDriver driver) {
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
        utility.click(saveAndContinueBtn);
    }
}