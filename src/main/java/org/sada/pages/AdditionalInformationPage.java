package org.sada.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sada.ApplicantInfo;
import org.sada.util.Logger;

public class AdditionalInformationPage extends BasePage {
    // -----------------------------
    // Constructor
    // -----------------------------
    public AdditionalInformationPage(WebDriver driver) {
        super(driver);
    }

    // -----------------------------
    // Locators
    // -----------------------------
    // Page Title
    private final By pageTitle = By.id("additional-information.singleApplicant.page.title");

    //Buttons
    private final By saveAndContinueBtn =  By.id("additional-information-save-continue-button");
//    private final By saveAndExitBtn     = By.id("additional-information-save-exit-button");


    // Are you living in an institution ... ?
    private final By currentlyResidingGroup = By.id("additionalCurrentlyResidingInAnInstitution_radio");
    private final By currentlyResidingYesLabel = By.cssSelector(
            "label[for='additionalCurrentlyResidingInAnInstitution-radio-button-option-0']");
    private final By currentlyResidingNoLabel = By.cssSelector(
            "label[for='additionalCurrentlyResidingInAnInstitution-radio-button-option-1']");

    // Do you need support accessing our services?
    private final By accommodationGroup = By.id("additionalAccommodationServices_radio");
    private final By accommodationYesLabel = By.cssSelector(
            "label[for='additionalAccommodationServices-radio-button-option-0']");
    private final By accommodationNoLabel = By.cssSelector(
            "label[for='additionalAccommodationServices-radio-button-option-1']");

    // Are you getting support from a program or service to help you find a job?
    private final By employmentGroup = By.id("additionalEmploymentServices_radio");
    private final By employmentYesLabel = By.cssSelector(
            "label[for='additionalEmploymentServices-radio-button-option-0']");
    private final By employmentNoLabel = By.cssSelector(
            "label[for='additionalEmploymentServices-radio-button-option-1']");

    // Do you need to follow a special diet because of a medical condition?
    private final By specialDietGroup = By.id("additionalSpecialDietOrMedicalCondition_radio");
    private final By specialDietYesLabel = By.cssSelector(
            "label[for='additionalSpecialDietOrMedicalCondition-radio-button-option-0']");
    private final By specialDietNoLabel = By.cssSelector(
            "label[for='additionalSpecialDietOrMedicalCondition-radio-button-option-1']");

    // Do you have a disability?
    private final By disabilityGroup = By.id("personWithDisability_radio");
    private final By disabilityYesLabel = By.cssSelector(
            "label[for='personWithDisability-radio-button-option-0']");
    private final By disabilityNoLabel = By.cssSelector(
            "label[for='personWithDisability-radio-button-option-1']");

    // adult developmental services support if diabled
    private final By disabilityDsoNoLabel = By.cssSelector(
            "label[for='disabilityProgramQuestionsPanel_developmentServicesOntario0-radio-button-option-2']");



    // Do you have additional nutritional needs because you are pregnant or breastfeeding?
    private final By nutritionalNeedsGroup = By.id("additionalNutritionalNeeds_radio");
    private final By nutritionalNeedsYesLabel = By.cssSelector(
            "label[for='additionalNutritionalNeeds-radio-button-option-0']");
    private final By nutritionalNeedsNoLabel = By.cssSelector(
            "label[for='additionalNutritionalNeeds-radio-button-option-1']");

    // Are you a full-time student enrolled in secondary school, college or university?
    private final By fullTimeStudentGroup = By.id("additionalFullTimeStudent_radio");
    private final By fullTimeStudentYesLabel = By.cssSelector(
            "label[for='additionalFullTimeStudent-radio-button-option-0']");
    private final By fullTimeStudentNoLabel = By.cssSelector(
            "label[for='additionalFullTimeStudent-radio-button-option-1']");

    // Are you caring for anyone else's child temporarily ... ?
    private final By caringForChildGroup = By.id("additionalCaringForChild_radio");
    private final By caringForChildYesLabel = By.cssSelector(
            "label[for='additionalCaringForChild-radio-button-option-0']");
    private final By caringForChildNoLabel = By.cssSelector(
            "label[for='additionalCaringForChild-radio-button-option-1']");





    // -----------------------------
    // Actions (public API)
    // -----------------------------


    private void setCurrentlyResidingInInstitution(boolean yes) {
        utility.waitVisible(currentlyResidingGroup);
        selectYesNo(yes,currentlyResidingYesLabel, currentlyResidingNoLabel );
    }

    private void setAccommodationServices(boolean yes) {
        utility.waitVisible(accommodationGroup);
        selectYesNo(yes,accommodationYesLabel, accommodationNoLabel );
    }

    private void setEmploymentServices(boolean yes) {
        utility.waitVisible(employmentGroup);
        selectYesNo(yes,employmentYesLabel, employmentNoLabel );
    }

    private void setSpecialDietOrMedicalCondition(boolean yes) {
        utility.waitVisible(specialDietGroup);
        selectYesNo(yes,specialDietYesLabel, specialDietNoLabel );
    }

    private void setPersonWithDisability(boolean yes) {
        utility.click(disabilityGroup);
        if(yes) {
            utility.click(disabilityYesLabel);
            utility.click(disabilityDsoNoLabel);
        }else{
            utility.click(disabilityNoLabel);
        }
    }

    private void setAdditionalNutritionalNeeds(boolean yes) {
        utility.waitVisible(nutritionalNeedsGroup);
        selectYesNo(yes,nutritionalNeedsYesLabel, nutritionalNeedsNoLabel );
    }

    private void setFullTimeStudent(boolean yes) {
        utility.waitVisible(fullTimeStudentGroup);
        utility.click(yes ? fullTimeStudentYesLabel : fullTimeStudentNoLabel);
        selectYesNo(yes,currentlyResidingYesLabel, currentlyResidingNoLabel );
    }

    private void setCaringForChild(boolean yes) {
        utility.waitVisible(caringForChildGroup);
        selectYesNo(yes,caringForChildYesLabel, caringForChildNoLabel );
    }

    public void complete(ApplicantInfo applicantInfo){
        if(!utility.isElementPresent(pageTitle)) {
            Logger.info("Skipping : " + pageTitle.toString());
            return;
        }

        Logger.info("Filling : " + pageTitle.toString());
        //Are you living in an institution such as a hospital or long-term care facility or a
        // residential school for vision or hearing impaired?(
        setCurrentlyResidingInInstitution(applicantInfo.currentlyResidingInInstitution);
        //Do you need support accessing our services?
        setAccommodationServices(applicantInfo.accommodationServices);
        //Are you getting support from a program or service to help you find a job?
        setEmploymentServices(applicantInfo.employmentServices);
        //Do you need to follow a special diet because of a medical condition?
        setSpecialDietOrMedicalCondition(applicantInfo.specialDietOrMedicalCondition);
        //Do you have a disability?(required)Being a person with a disability means:
        setPersonWithDisability(applicantInfo.personWithDisability);
        //Do you have additional nutritional needs because you are pregnant or breastfeeding?
        setAdditionalNutritionalNeeds(applicantInfo.additionalNutritionalNeeds);
        //Are you a full-time student enrolled in secondary school, college or university?
        setFullTimeStudent(applicantInfo.fullTimeStudent);
        //Are you caring for anyone else's child temporarily, for example a child whose parent is staying in a hospital?
        setCaringForChild(applicantInfo.caringForChild);

        if (utility.isElementPresent(saveAndContinueBtn)) {
            utility.clickButton(saveAndContinueBtn);
        }
    }




}
