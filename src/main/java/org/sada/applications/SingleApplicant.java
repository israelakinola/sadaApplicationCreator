package org.sada.applications;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sada.data.ApplicantInfo;
import org.sada.pages.*;
import org.sada.util.Logger;

public class SingleApplicant extends Application {

    //Buttons
    By newApplicationBtn = By.id("continue-button");

    public SingleApplicant(WebDriver driver) {
        super(driver);
    }
    private void startNewApplication(){
        utility.click(newApplicationBtn);
        Logger.info("HomePage: Creating Application");
    }

    public void createApplication(ApplicantInfo applicantInfo){



        startNewApplication();

        new BeforeYouApplyPage(driver).complete(applicantInfo);


        new PersonalInformationPage(driver).complete(applicantInfo);

        new MyBAccountPage(driver).complete(applicantInfo);


        new AdditionalInformationPage(driver).complete(applicantInfo);


        new AddressInformationPage(driver).complete(applicantInfo);


        new HousingSituationPage(driver).complete(applicantInfo);


        new EarnedIncomePage(driver).complete(applicantInfo);


        new HouseholdIncomePage(driver).complete(applicantInfo);

        new FinancialAssetsPage(driver).complete(applicantInfo);


        new BankDetailsPage(driver).complete(applicantInfo);

        new ReviewApplicationPage(driver).complete(applicantInfo);

        new ProgramRecommedationPage(driver).complete(applicantInfo);

        new DemographicInformationPage(driver).complete(applicantInfo);


        new DeclarationPage(driver).complete(applicantInfo);


        new EidPage(driver).complete(applicantInfo);


        new SignaturePage(driver).complete(applicantInfo);

//        new Signature(driver).signApplication(applicantInfo.firstName);
        Logger.info("Application Created");
    }

    public static void runSingleApplicantOnw(WebDriver driver, ApplicantInfo info) {
        Logger.info("Started Single Application");
        info.maritalStatus = "Single";
        info.hasDisability = false;
        new SingleApplicant(driver).createApplication(info);
    }
    public static void runSingleApplicantOdsp(WebDriver driver, ApplicantInfo info) {
        Logger.info("Started Single Application");
        info.maritalStatus = "Single";
        info.hasDisability = true;
        new SingleApplicant(driver).createApplication(info);
    }

    public static void runSingleMultiProgram(WebDriver driver, ApplicantInfo info) {
        Logger.info("Started Single Application");
        info.maritalStatus = "Single";
        info.multiProgram = true;
        info.hasDisability = true;
        new SingleApplicant(driver).createApplication(info);
    }
}
