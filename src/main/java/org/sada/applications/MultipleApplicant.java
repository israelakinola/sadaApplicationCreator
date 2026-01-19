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


    public MultipleApplicant(WebDriver driver) {
        this.driver = driver;
        this.utility = new Utility(driver);
        this.applicantInfo = new ApplicantInfo();
    }

    public void createPersonalInformation(ApplicantInfo primaryApplicant) {
        PersonalInformation personalInformation = new PersonalInformation(driver);
        personalInformation.setFirstName(primaryApplicant.fitstName);
        personalInformation.setLastName(primaryApplicant.lastName);

        personalInformation.setDOBYear(primaryApplicant.DOBYear);
        personalInformation.setDOBMonth(primaryApplicant.DOBMonth);
        personalInformation.setDOBDay(primaryApplicant.DOBDay);

        //Set at Birth
        personalInformation.setSexMale();

        personalInformation.setMaritalStatus(primaryApplicant.maritalStatus);
        personalInformation.setChildrenNO();
        personalInformation.setStatusInCanadaSelect(primaryApplicant.statusinCanadaSelect);

        personalInformation.setSIN(primaryApplicant.SIN);
        personalInformation.setPhoneNumber(primaryApplicant.phoneNumber);
        personalInformation.setEmail(primaryApplicant.email);
        personalInformation.setLangEnglish();
        personalInformation.setNoLangHelp();
        personalInformation.setHealthStatus(primaryApplicant.healthStatus);

        personalInformation.clickContinueButton();
        Utility.copyToClipboard(primaryApplicant.email);

        //Save and Continue
        By saveContinueBtn = By.id("personal-information-save-continue-button");

        //Setup MyB
        MyBAccount myB = new MyBAccount(driver);
        myB.createMyB(primaryApplicant.hasMyB, primaryApplicant.email, primaryApplicant.password);


        if (utility.isElementPresent(saveContinueBtn)) {
            utility.clickButton(saveContinueBtn);
        }
    }

    private void createSpouceInformation(){
        SpouceInformation spouceInformation = new SpouceInformation(driver);
        spouceInformation.setFirstName(applicantInfo.fitstNameSpouce);
        spouceInformation.setLastName(applicantInfo.lastNameSpouce);

        spouceInformation.setDOBYear(applicantInfo.DOBYearSpouce);
        spouceInformation.setDOBMonth(applicantInfo.DOBMonthSpouce);
        spouceInformation.setDOBDay(applicantInfo.DOBDaySpouce);

        //Sex at Birth
        spouceInformation.setSexMale();


        spouceInformation.setStatusInCanadaSelect(applicantInfo.statusinCanadaSelect);

        spouceInformation.setSIN(applicantInfo.SINSpouce);
        spouceInformation.setEmail(applicantInfo.emailSpouce);
        spouceInformation.setNoLangHelp();
        spouceInformation.setHealthStatus(applicantInfo.healthStatus);

        spouceInformation.clickContinueButton();

    }



    protected void createAdditionalFamilyInformation() {
        AdditionalFamilyInformation additionalFamilyInformation = new AdditionalFamilyInformation(this.driver);

        // Answer all radio questions (adjust true/false to your test needs)
        additionalFamilyInformation.setReceivedSocialAssistancePast(false);         // Has anyone received social assistance in the past?
        additionalFamilyInformation.setResidingInInstitution(false);               // Living in an institution?
        additionalFamilyInformation.setCurrentlyIncarcerated(false);               // In jail/prison/detention?
        additionalFamilyInformation.setAccommodationServicesNeeded(false);         // Need support accessing services?
        additionalFamilyInformation.setEmploymentServicesSupport(false);           // Getting job-program/service support?
        additionalFamilyInformation.setSpecialDietMedicalCondition(false);         // Need special diet due to medical condition?
        additionalFamilyInformation.setDisabilityInFamily(false);                  // Person with disability in family?
        additionalFamilyInformation.setImmediateNeedMoney(false);                  // Need money for immediate needs?
        additionalFamilyInformation.setPregnantOrBreastfeeding(false);             // Pregnant or breastfeeding?
        additionalFamilyInformation.setFullTimeStudent(false);                     // Full-time student?
        additionalFamilyInformation.setCaringForChild(false);                      // Caring for someone else’s child?

        // Save and Continue
        By saveContinueBtn = By.id("additional-information-save-continue-button");
        if (utility.isElementPresent(saveContinueBtn)) {
            utility.clickButton(saveContinueBtn);
        } else {
            // Optional: small wait + fallback in case of async render
            utility.waitClickable(saveContinueBtn);
            utility.clickButton(saveContinueBtn);
        }
    }



    public void createApplication(){
        //First Page
        BasePage basePage = new BasePage(driver);
        basePage.startNewApplication();

        BeforeYouApply beforeYouApply = new BeforeYouApply(driver);
        beforeYouApply.beforeYouApply(applicantInfo.ODSP, "Canadian citizen born in Canada");

        PersonalInformation personalInformation = new PersonalInformation(driver);
        personalInformation.createPersonalInformation(applicantInfo);
        createSpouceInformation();

        createAdditionalFamilyInformation();

        AddressInformationPage addressInformationPage = new AddressInformationPage(driver);
        addressInformationPage.createAddressInformation(false, applicantInfo.streetNumber,
                applicantInfo.streetName, applicantInfo.city, applicantInfo.postalCode);

    }
}

