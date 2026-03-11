package org.sada.applications;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sada.ApplicantInfo;
import org.sada.pages.*;
import org.sada.util.Logger;

import java.time.Duration;

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

        Logger.info("Before You Apply Page: Creating Application");
        new BeforeYouApplyPage(driver).complete(applicantInfo);

        Logger.info("Informational Page: Creating Application");
        new PersonalInformationPage(driver).complete(applicantInfo);

        Logger.info("MyB Account Page: Creating Application");
        new MyBAccountPage(driver).complete(applicantInfo);

        Logger.info("Additional Information Page: Creating Application");
        new AdditionalInformationPage(driver).complete(applicantInfo);

        Logger.info("Address Information Page: Creating Application");
        new AddressInformationPage(driver).complete(applicantInfo);

        Logger.info("Housing Situation Page: Creating Application");
        new HousingSituationPage(driver).complete(applicantInfo);

        Logger.info("HomePage: Creating Application");
        new EarnedIncomePage(driver).complete(applicantInfo);

        Logger.info("Household Income Page: Creating Application");
        new HouseholdIncomePage(driver).complete(applicantInfo);

        Logger.info("Finicial Asset Page: Creating Application");
        new FinancialAssetsPage(driver).complete(applicantInfo);

        Logger.info("Review Application Page: Creating Application");
        new ReviewApplicationPage(driver).complete(applicantInfo);

        Logger.info("Creating Application Page: Creating Application");
        new BankDetailsPage(driver).complete(applicantInfo);

        Logger.info("Program Recommendation Page: Creating Application");
        new ProgramRecommedationPage(driver).complete(applicantInfo);

        Logger.info("Demophraphics: Creating Application");
        new DemographicInformationPage(driver).complete(applicantInfo);

        Logger.info("Declearation Page: Creating Application");
        new DeclarationPage(driver).complete(applicantInfo);

        Logger.info("EID Page: Creating Application");
        new EidPage(driver).complete(applicantInfo);

        Logger.info("Signature Page: Creating Application");
        new SignaturePage(driver).complete(applicantInfo);
    }

}
