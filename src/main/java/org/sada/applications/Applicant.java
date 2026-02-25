package org.sada.applications;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sada.ApplicantInfo;
import org.sada.pages.*;
import org.sada.util.Logger;
import org.sada.util.Utility;

public class Applicant {
    WebDriver driver;
    Utility utility;
    ApplicantInfo applicantInfo;

    public Applicant(WebDriver driver) {
        this.driver = driver;
        this.utility = new Utility(driver);
    }

    protected void createApplicationBase(ApplicantInfo applicantInfo){
        this.applicantInfo = applicantInfo;

        //First Page
        BasePage basePage = new BasePage(driver);
        basePage.startNewApplication();

        //Before you apply | Social assistance application
        BeforeYouApply beforeYouApply = new BeforeYouApply(driver);
        if(utility.isElementPresent(beforeYouApply.pageTitle)) {
            beforeYouApply.beforeYouApply(applicantInfo.isODSP(), "Canadian citizen born in Canada");
        }

        PersonalInformation personalInformation = new PersonalInformation(driver);
        if(utility.isElementPresent(personalInformation.pageTitle)){
            personalInformation.createPersonalInformation(applicantInfo);
        }

        //Setup MyB
        MyBAccount myB = new MyBAccount(driver);
        if(utility.isElementPresent(myB.pageTitle)) {
            myB.createMyB(applicantInfo.isHasMyB(), applicantInfo.getEmail(), applicantInfo.getPassword());
            Logger.info("Done with MYB");
            //Save and Continue
        }else{
            personalInformation.createPersonalInformation(applicantInfo);
            Logger.info("Creating Per again");
            myB.createMyB(applicantInfo.isHasMyB(), applicantInfo.getEmail(), applicantInfo.getPassword());
            Logger.info("Creating MYB");
            Utility.copyToClipboard(applicantInfo.getEmailSpouce());
        }
    }

    protected void addressInformationPage(){
        //Address Information
        if(utility.isElementPresent(By.id("address-information.page.title"))) {
            AddressInformationPage addressInformationPage = new AddressInformationPage(driver);
            Logger.info("Creating Address Information");
            addressInformationPage.createAddressInformation(false, applicantInfo.getStreetNumber(),
                    applicantInfo.getStreetName(), applicantInfo.getCity(), applicantInfo.getPostalCode());
        }
    }

    protected void houseHoldIncomePage(){
        if(utility.isElementPresent(By.id("household-income.page.title"))) {
            HouseholdIncome householdIncome = new HouseholdIncome(driver);
            Logger.info("Creating HH Income");
            householdIncome.setHHIncome();
            utility.click(By.id("household-income-save-continue-button"));
        }
    }

    protected void financialAssetPage(){
        if(utility.isElementPresent(By.id("financial-assets.page.title"))) {
            FinancialAssets financialAssets = new FinancialAssets(driver);
            Logger.info("Creating Financial Assets");
            financialAssets.setNoneOfTheAboveCheckbox();
            financialAssets.setGivenAwayAssets(false);
            utility.click(By.id("financial-assets-save-continue-button"));
        }
    }

    protected void reviewApplicationPage(){
        //Review your application
        if(utility.isElementPresent(By.id("review.page.title"))) {
            Logger.info("Creating REVIEW");
            utility.click(By.id("review-save-continue-button"));
            Logger.info("Created REVIEW");
        }
    }

    protected void bankDetailsPage(){
        //Direct deposit details
        //Would you like to provide your banking details?
        if(utility.isElementPresent(By.id("bank-details.page.title"))) {
            Logger.info("Creating BANK DETAILS");
            utility.click(By.cssSelector("label[for='hasChequingAccounts-radio-button-option-1']"));
            utility.click(By.cssSelector("label[for='hasSavingsAccounts-radio-button-option-1']"));
            utility.click(By.id("bank-details-save-continue-button"));
            Logger.info("Created BANK DETAILS");
        }
    }
}
