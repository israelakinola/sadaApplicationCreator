//package org.sada.applications;
//
//import org.openqa.selenium.*;
//import org.sada.ApplicantInfo;
//import org.sada.pages.*;
//import org.sada.util.Logger;
//import org.sada.util.Utility;
//import org.sada.pages.*;
//
//
//public class MultipleApplicant extends Applicant {
//
//    ApplicantInfo applicantInfo;
//
//
//    public MultipleApplicant(WebDriver driver) {
//        super(driver);
//    }
//
//
//
//    public void createApplication(ApplicantInfo applicantInfo) {
//        createApplicationBase(applicantInfo);
//
//
//        //Spouce Information
//        if(utility.isElementPresent(By.id("spouse-information.page.title"))) {
//            SpouceInformation spouceInformation = new SpouceInformation(driver);
//            Logger.info("Creating Spouce Information");
//            spouceInformation.createSpouceInformation(applicantInfo);
//        }
//
//        //Additional Family Information
//        if(utility.isElementPresent(By.id("additional-information.multipleApplicants.page.title"))) {
//            AdditionalFamilyInformation additionalFamilyInformation = new AdditionalFamilyInformation(driver);
//            Logger.info("Creating Additional Family Information");
//            additionalFamilyInformation.createAdditionalFamilyInformation(applicantInfo);
//        }
//
//
//        addressInformationPage();
//
//        //Hosuing Situation
//        if(utility.isElementPresent( By.id("housing-situation.page.title"))) {
//            Logger.info("Creating Hosuing Situation");
//            HousingSituation housingSituation = new HousingSituation(driver);
//            housingSituation.setCurrentHousingSituation(applicantInfo.getHousingSituation());
//            utility.click(By.id("housing-situation-save-continue-button"));
//        }
//
//        //Earned Income
//        if(utility.isElementPresent(By.id("earned-income.page.title"))) {
//            EarnedIncome earnedIncome = new EarnedIncome(driver);
//            Logger.info("Creating Earned Income");
//            earnedIncome.setEarnedIncomeFamily(applicantInfo.isEarnedIncome());
//            utility.click(By.id("earned-income-save-continue-button"));
//        }
//
//        houseHoldIncomePage();
//
//        financialAssetPage();
//
//        bankDetailsPage();
//
//        reviewApplicationPage();
//
//
//        //Program recommendation
//        if(utility.isElementPresent(By.id("program-recommendation.page.title"))) {
//            Logger.info("Creating program-recommendation");
//            if(applicantInfo.isMultiProgram()){
//                utility.click(By.id("onwods-radio-button-option-label"));
//            }
//
//            //Confirm Submmision
//            utility.click(By.id("program-recommendation-save-continue-button"));
//            utility.click(By.id("dialog-button"));
//
//            Logger.info("Created program-recommendation");
//        }
//
//
//    }
//}
//
