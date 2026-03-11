package org.sada.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sada.ApplicantInfo;
import org.sada.util.Logger;

public class DeclarationPage extends BasePage{
    public final By pageTitle = By.id("consent.page.title");
    public DeclarationPage(WebDriver driver) {
        super(driver);
    }

    // -----------------------------
    // Actions (public API)
    // -----------------------------
    private void createDeclaration(ApplicantInfo applicantInfo){
        Logger.info("Creating ConsentForm");
        if(applicantInfo.isODSP() && !applicantInfo.isMultiProgram()){
            utility.clickCheckbox(By.id("consent.declaration-checkbox-option1"), By.cssSelector("label[for='consent.declaration-checkbox-option1']"));
        }else{
            utility.click(By.cssSelector("label[for='consent.EoReferral.consent-checkbox-checkbox-option1']"));
            utility.click(By.cssSelector("label[for='consent.declaration-checkbox-option1']"));
        }
        utility.click(By.id("continue-button"));
        Logger.info("Created ConsentForm");
    }

    public void complete(ApplicantInfo applicantInfo){
        //Consent
        if(utility.isElementPresent(By.id("consent.page.title"))) {
            this.createDeclaration(applicantInfo);
        }
    }
}
