package org.sada.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.sada.data.ApplicantInfo;
import org.sada.util.Logger;

public class EidPage extends BasePage {

    // -----------------------------
    // Locators
    // -----------------------------
    private final By pageTitle = By.id("eid-page.page.title");
    private final By confirmBtn = By.id("confirm-button");
    private final By submitBtn = By.id("submit-button");

    // -----------------------------
    // Constructor
    // -----------------------------
    public EidPage(WebDriver driver) {
        super(driver);
    }

    // -----------------------------
    // Actions
    // -----------------------------
    public void complete(ApplicantInfo applicantInfo) {
        // Confirm identity
        if (!utility.isElementPresent(pageTitle)) {
            Logger.info("Skipping : " + pageTitle.toString());
            return;
        }
        Logger.info("Filling : " + pageTitle.toString());

        utility.click(confirmBtn);

        if(applicantInfo.applicationType < 3){
            utility.click(confirmBtn);
        }else{
            for (int i = 0; i < 2; i++) {
                try {
                    driver.findElement(By.id("confirm-button")).click();
                    break;
                } catch (StaleElementReferenceException e) {
                    // retry
                }
            }

        }

        // Wait up to 10 seconds for submit button
        if (utility.isElementPresent10(submitBtn)) {
            utility.click(submitBtn);
        }
    }
}