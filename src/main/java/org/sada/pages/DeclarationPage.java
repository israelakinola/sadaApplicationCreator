package org.sada.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sada.ApplicantInfo;
import org.sada.util.Logger;

public class DeclarationPage extends BasePage{
    // -----------------------------
    // Locators
    // -----------------------------
    public final By pageTitle = By.id("consent.page.title");
    public final By consentDeclarationCheckbox1Id = By.id("consent.declaration-checkbox-option1");
    public final By consentDeclarationCheckbox1Label = By.cssSelector("label[for='consent.declaration-checkbox-option1']");
    public final By eoReferralCheckbox1 = By.cssSelector("label[for='consent.EoReferral.consent-checkbox-checkbox-option1']");

    //Button
    public final By continueBtn = By.id("continue-button");


    public DeclarationPage(WebDriver driver) {
        super(driver);
    }

    // -----------------------------
    // Actions (public API)
    // -----------------------------
    private void createDeclaration(ApplicantInfo applicantInfo){
        Logger.info("Creating ConsentForm");
        if(applicantInfo.hasDisability && !applicantInfo.multiProgram){
            utility.clickCheckbox(consentDeclarationCheckbox1Id, consentDeclarationCheckbox1Label);
        }else{
            utility.click(eoReferralCheckbox1);
            utility.click(consentDeclarationCheckbox1Label);
        }
        utility.click(continueBtn);
    }

    public void complete(ApplicantInfo applicantInfo){
        //Consent
        if(!utility.isElementPresent(pageTitle)) {
            Logger.info("Skipping : " + pageTitle.toString());
            return;
        }
        Logger.info("Filling : " + pageTitle.toString());
        this.createDeclaration(applicantInfo);
    }
}
