package org.sada.applications;

import org.openqa.selenium.*;
import org.openqa.selenium.bidi.log.Log;
import org.sada.ApplicantInfo;
import org.sada.pages.*;
import org.sada.pages.*;
import org.sada.util.Logger;
import org.sada.util.Utility;


public class SingleApplicant extends Applicant {

    ApplicantInfo applicantInfo;

    public SingleApplicant(WebDriver driver) {
        super(driver);
    }
    public void createApplication(ApplicantInfo applicantInfo){
        createApplicationBase(applicantInfo);


        //Additional Information
        if(utility.isElementPresent(By.id("additional-information.singleApplicant.page.title"))){
            AdditionalInformation additionalInformation = new AdditionalInformation(driver);
            Logger.info("Creating Additional Information");
            additionalInformation.createAdditionalInformationSingle(applicantInfo);
        }

        addressInformationPage();


        if(utility.isElementPresent( By.id("housing-situation.page.title"))) {
            Logger.info("Creating Hosuing Situation");
            HousingSituation housingSituation = new HousingSituation(driver);
            housingSituation.setCurrentHousingSituation(applicantInfo.getHousingSituation());
            utility.click(By.id("housing-situation-save-continue-button"));
        }

        if(utility.isElementPresent(By.id("earned-income.page.title"))) {
            EarnedIncome earnedIncome = new EarnedIncome(driver);
            Logger.info("Creating Earned Income");
            earnedIncome.setEarnedIncome(applicantInfo.isEarnedIncome());
            utility.click(By.id("earned-income-save-continue-button"));
        }

        houseHoldIncomePage();

        financialAssetPage();



        bankDetailsPage();

        reviewApplicationPage();

        //Program recommendation
        if(utility.isElementPresent(By.id("program-recommendation.page.title"))) {
            Logger.info("Creating program-recommendation");
            if(applicantInfo.isMultiProgram()){
                utility.click(By.id("onwods-radio-button-option-label"));
            }

            //Confirm Submmision
            utility.click(By.id("program-recommendation-save-continue-button"));
            utility.click(By.id("dialog-button"));

            Logger.info("Created program-recommendation");
        }



        //Demographic
        if(utility.isElementPresent10(By.id("demographic-information.page.title"))) {//Wait for 10second when checking element
            Logger.info("Creating demographic-information");
            utility.click(By.id("continue-button"));

            DemographicInformation demographicInformation = new DemographicInformation(driver);
            Logger.info("Creating Demographic");
            demographicInformation.setDemographicsInformation("Prefer not to say","Prefer not to say", "Prefer not to say",
                    "Prefer not to say", "English");

            Logger.info("Created Demographic");
        }



        //Consent
        if(utility.isElementPresent(By.id("consent.page.title"))) {
            Logger.info("Creating declaration");
            Declaration declaration = new Declaration(driver);
            declaration.createDeclaration(applicantInfo);
        }


        //Confirm Idenity
        if(utility.isElementPresent(By.id("eid-page.page.title"))) {
            Logger.info("Confirming Identity");
            utility.click(By.id("confirm-button"));
            if(utility.isElementPresent10(By.id("submit-button"))){
                utility.click(By.id("submit-button"));
            }

        }


        //Signature
        if(utility.isElementPresent(By.id("eid-page.page.title"))) {
            Logger.info("Creating Signature");
            utility.click(By.id("continue-button")); // Take me to sign Application
        }


    }
}
