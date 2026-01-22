package org.sada.applications;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.sada.ApplicantInfo;
import org.sada.pages.*;
import org.sada.util.Utility;
import org.sada.pages.*;


public class MultipleApplicant {

    WebDriver driver;
    Utility utility;
    ApplicantInfo applicantInfo;


    public MultipleApplicant(WebDriver driver, ApplicantInfo applicantInfo) {
        this.driver = driver;
        this.utility = new Utility(driver);
        this.applicantInfo = applicantInfo;
    }






    public void createApplication(){
        //First Page
        BasePage basePage = new BasePage(driver);
        basePage.startNewApplication();

        BeforeYouApply beforeYouApply = new BeforeYouApply(driver);
        if(utility.isElementPresent(beforeYouApply.pageTitle)) {
            beforeYouApply.beforeYouApply(applicantInfo.ODSP, "Canadian citizen born in Canada");
        }

        PersonalInformation personalInformation = new PersonalInformation(driver);
        if(utility.isElementPresent(personalInformation.pageTitle)){
            personalInformation.createPersonalInformation(applicantInfo);
        }

        //Setup MyB
        MyBAccount myB = new MyBAccount(driver);
        if(utility.isElementPresent(myB.pageTitle)) {
            myB.createMyB(applicantInfo.hasMyB, applicantInfo.email, applicantInfo.password);
            System.out.println("Done with MYB");
            //Save and Continue
        }else{
            personalInformation.createPersonalInformation(applicantInfo);
            System.out.println("Creating Per again");
            myB.createMyB(applicantInfo.hasMyB, applicantInfo.email, applicantInfo.password);
            System.out.println("Creating MYB");
            Utility.copyToClipboard(applicantInfo.emailSpouce);
        }

        //Spouce Information
        if(utility.isElementPresent(By.id("spouse-information.page.title"))) {
            SpouceInformation spouceInformation = new SpouceInformation(driver);
            System.out.println("Creating Spouce Information");
            spouceInformation.createSpouceInformation(applicantInfo);
        }

        //Additional Family Information
        if(utility.isElementPresent(By.id("additional-information.multipleApplicants.page.title"))) {
            AdditionalFamilyInformation additionalFamilyInformation = new AdditionalFamilyInformation(driver);
            System.out.println("Creating Additional Family Information");
            additionalFamilyInformation.createAdditionalFamilyInformation(applicantInfo);
        }


        //Address Information
        if(utility.isElementPresent(By.id("address-information.page.title"))) {
            AddressInformationPage addressInformationPage = new AddressInformationPage(driver);
            System.out.println("Creating Address Information");
            addressInformationPage.createAddressInformation(false, applicantInfo.streetNumber,
                    applicantInfo.streetName, applicantInfo.city, applicantInfo.postalCode);
        }

        //Hosuing Situation
        if(utility.isElementPresent( By.id("housing-situation.page.title"))) {
            System.out.println("Creating Hosuing Situation");
            HousingSituation housingSituation = new HousingSituation(driver);
            housingSituation.setCurrentHousingSituation(applicantInfo.housingSituation);
            utility.click(By.id("housing-situation-save-continue-button"));
        }

        //Earned Income
        if(utility.isElementPresent(By.id("earned-income.page.title"))) {
            EarnedIncome earnedIncome = new EarnedIncome(driver);
            System.out.println("Creating Earned Income");
            earnedIncome.setEarnedIncomeFamily(applicantInfo.earnedIncome);
            utility.click(By.id("earned-income-save-continue-button"));
        }

        if(utility.isElementPresent(By.id("household-income.page.title"))) {
            HouseholdIncome householdIncome = new HouseholdIncome(driver);
            System.out.println("Creating HH Income");
            householdIncome.setHHIncome();
            utility.click(By.id("household-income-save-continue-button"));
        }

        if(utility.isElementPresent(By.id("financial-assets.page.title"))) {
            FinancialAssets financialAssets = new FinancialAssets(driver);
            System.out.println("Creating Financial Assets");
            financialAssets.setNoneOfTheAboveCheckbox();
            financialAssets.setGivenAwayAssets(false);
            utility.click(By.id("financial-assets-save-continue-button"));
        }

        //Direct deposit details
        //Would you like to provide your banking details?
        if(utility.isElementPresent(By.id("bank-details.page.title"))) {
            System.out.println("Creating BANK DETAILS");
            utility.click(By.cssSelector("label[for='bank-details.provideBankDetails-radio-button-option-1']"));
            utility.click(By.id("bank-details-save-continue-button"));
            System.out.println("Created BANK DETAILS");
        }

        //Review your application
        if(utility.isElementPresent(By.id("review.page.title"))) {
            System.out.println("Creating REVIEW");
            utility.click(By.id("review-save-continue-button"));
            System.out.println("Created REVIEW");
        }


        //Program recommendation
        if(utility.isElementPresent(By.id("program-recommendation.page.title"))) {
            System.out.println("Creating program-recommendation");
            if(applicantInfo.multiProgram){
                utility.click(By.id("onwods-radio-button-option-label"));
            }

            //Confirm Submmision
            utility.click(By.id("program-recommendation-save-continue-button"));
            utility.click(By.id("dialog-button"));

            System.out.println("Created program-recommendation");
        }


    }
}

