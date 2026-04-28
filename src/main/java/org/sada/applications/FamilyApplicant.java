package org.sada.applications;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sada.data.ApplicantInfo;
import org.sada.pages.*;
import org.sada.util.Logger;

public class FamilyApplicant extends Application {

    //Buttons
    By newApplicationBtn = By.id("continue-button");

    public FamilyApplicant(WebDriver driver) {
        super(driver);
    }
    private void startNewApplication(){
        utility.click(newApplicationBtn);
        Logger.info("HomePage: Creating Application");
    }

    public void createApplication(ApplicantInfo applicantInfo){

        applicantInfo.hasChildren = true;
        applicantInfo.maritalStatus = "Married";

        startNewApplication(); //same

        new BeforeYouApplyPage(driver).complete(applicantInfo); //same

        new PersonalInformationPage(driver).complete(applicantInfo);

        new MyBAccountPage(driver).complete(applicantInfo); //Same

        new SpouceInformationPage(driver).complete(applicantInfo);

        new ChildrenInformation(driver).complete(applicantInfo);

        new AdditionalFamilyInformationPage(driver).complete(applicantInfo);


        new AddressInformationPage(driver).complete(applicantInfo); //Same


        new HousingSituationPage(driver).complete(applicantInfo); //Same


        new EarnedIncomePage(driver).completeFamily(applicantInfo);


        new HouseholdIncomePage(driver).complete(applicantInfo); //same

        new FinancialAssetsPage(driver).complete(applicantInfo); //same


        new BankDetailsPage(driver).complete(applicantInfo); //same

        new ReviewApplicationPage(driver).complete(applicantInfo); //same

        new ProgramRecommedationPage(driver).complete(applicantInfo); //same

        new DemographicInformationPage(driver).complete(applicantInfo);


        new DeclarationPage(driver).complete(applicantInfo);


        new EidPage(driver).complete(applicantInfo);


        new SignaturePage(driver).complete(applicantInfo);

//        new Signature(driver).signApplication(applicantInfo.firstName);

        Logger.info("Application Created");
//        utility.writeToTextFile(applicantInfo.firstName + " " +
//                applicantInfo.lastName  + " - "  + new Confirmation(driver).getRefCode());

    }

    public static void runFamilyApplicantOnw(WebDriver driver, ApplicantInfo info) {
        Logger.info("Started Single Application");
        info.hasDisability = false;
        new FamilyApplicant(driver).createApplication(info);
    }
    public static void runFamilyApplicantOdsp(WebDriver driver, ApplicantInfo info) {
        Logger.info("Started Single Application");
        info.hasDisability = true;
        new FamilyApplicant(driver).createApplication(info);
    }

    public static void runFamilyApplicantMultiProgram(WebDriver driver, ApplicantInfo info) {
        Logger.info("Started Single Application");
        info.multiProgram = true;
        info.hasDisability = true;
        new FamilyApplicant(driver).createApplication(info);
    }
}



