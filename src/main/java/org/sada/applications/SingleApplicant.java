package org.sada.applications;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.sada.ApplicantInfo;
import org.sada.pages.*;
import org.sada.pages.*;
import org.sada.util.Utility;


public class SingleApplicant {

    WebDriver driver;
    Utility utility;
    ApplicantInfo applicantInfo;

    public SingleApplicant(WebDriver driver) {
        this.driver = driver;
        this.utility = new Utility(driver);
        this.applicantInfo = new ApplicantInfo();
    }






    public void createApplication(){
        //First Page
        BasePage basePage = new BasePage(driver);
        basePage.startNewApplication();

        //Before you apply | Social assistance application
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
        }

        //Additional Information
        if(utility.isElementPresent(By.id("additional-information.singleApplicant.page.title"))){
            AdditionalInformation additionalInformation = new AdditionalInformation(this.driver);
            System.out.println("Creating Additional Information");
            additionalInformation.createAdditionalInformationSingle();
        }


        if(utility.isElementPresent(By.id("address-information.page.title"))) {
            AddressInformationPage addressInformationPage = new AddressInformationPage(driver);
            System.out.println("Creating Address Information");
            addressInformationPage.createAddressInformation(false, applicantInfo.streetNumber,
                    applicantInfo.streetName, applicantInfo.city, applicantInfo.postalCode);
        }


        if(utility.isElementPresent( By.id("housing-situation.page.title"))) {
            System.out.println("Creating Hosuing Situation");
            HousingSituation housingSituation = new HousingSituation(driver);
            housingSituation.setCurrentHousingSituation(applicantInfo.housingSituation);
            utility.click(By.id("housing-situation-save-continue-button"));
        }

        if(utility.isElementPresent(By.id("earned-income.page.title"))) {
            EarnedIncome earnedIncome = new EarnedIncome(driver);
            System.out.println("Creating Earned Income");
            earnedIncome.setEarnedIncome(applicantInfo.earnedIncome);
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
            utility.click(By.id("program-recommendation-save-continue-button"));

            //Confirm Submmision
            utility.click(By.id("dialog-button"));

            System.out.println("Created program-recommendation");
        }



        //Demographic
        if(utility.isElementPresent10(By.id("demographic-information.page.title"))) {//Wait for 10second when checking element
            System.out.println("Creating demographic-information");
            utility.click(By.id("continue-button"));

            DemographicInformation demographicInformation = new DemographicInformation(driver);
            System.out.println("Creating Demographic");
            demographicInformation.setDemographicsInformation("Prefer not to say","Prefer not to say", "Prefer not to say",
                    "Prefer not to say", "English");

            System.out.println("Created Demographic");
        }



        //Consent
        if(utility.isElementPresent(By.id("consent.page.title"))) {
            System.out.println("Creating declaration");
            Declaration declaration = new Declaration(driver);
            declaration.createDeclaration();
        }


        //Confirm Idenity
        if(utility.isElementPresent(By.id("eid-page.page.title"))) {
            System.out.println("Confirming Identity");
            utility.click(By.id("confirm-button"));
            if(utility.isElementPresent10(By.id("submit-button"))){
                utility.click(By.id("submit-button"));
            }

        }


        //Signature
//        if(utility.isElementPresent(By.id("eid-page.page.title"))) {
//            System.out.println("Creating Signature");
//            utility.click(By.id("continue-button")); // Take me to sign Application
//            Signature signature = new Signature(driver);
//            signature.SignApplication();
//        }


    }
}
