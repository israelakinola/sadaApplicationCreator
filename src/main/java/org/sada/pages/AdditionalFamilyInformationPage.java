
package org.sada.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sada.data.ApplicantInfo;
import org.sada.util.Logger;

public class AdditionalFamilyInformationPage extends BasePage {
    // -----------------------------
    // Constructor
    // -----------------------------
    public AdditionalFamilyInformationPage(WebDriver driver) {
        super(driver);
    }
    // -----------------------------
    // Locators
    // -----------------------------
    private final By pageTitle = By.cssSelector("h1[data-e2e='pageTitle']");
    // Buttons
    private final By saveAndContinueBtn = By.id("additional-information-save-continue-button");
    private final By saveAndExitBtn     = By.id("additional-information-save-exit-button");

    // -----------------------------
    // Locators
    // -----------------------------

    // Has anyone received social assistance in Ontario in the past?
    private final By receivedSocialAssistancePastYesLabel = By.cssSelector("label[for='familyReceivedSocialAssistanceInPast-radio-button-option-0']");
    private final By receivedSocialAssistancePastNoLabel  = By.cssSelector("label[for='familyReceivedSocialAssistanceInPast-radio-button-option-1']");

    // Living in an institution?
    private final By residingInInstitutionYesLabel = By.cssSelector("label[for='familyMembersResidingInInstitution-radio-button-option-0']");
    private final By residingInInstitutionNoLabel  = By.cssSelector("label[for='familyMembersResidingInInstitution-radio-button-option-1']");


    private final By currentlyIncarceratedYesLabel = By.cssSelector("label[for='familyMembersCurrentlyIncarcerated-radio-button-option-0']");
    private final By currentlyIncarceratedNoLabel  = By.cssSelector("label[for='familyMembersCurrentlyIncarcerated-radio-button-option-1']");

    // Need support accessing services?
    private final By accommodationServicesYesInput = By.id("additionalFamilyAccommodationServices-radio-button-option-0");
    private final By accommodationServicesNoInput  = By.id("additionalFamilyAccommodationServices-radio-button-option-1");
    private final By accommodationServicesYesLabel = By.cssSelector("label[for='additionalFamilyAccommodationServices-radio-button-option-0']");
    private final By accommodationServicesNoLabel  = By.cssSelector("label[for='additionalFamilyAccommodationServices-radio-button-option-1']");

    // Getting employment program/service support?
    private final By employmentServicesYesLabel = By.cssSelector("label[for='additionalFamilyEmploymentServices-radio-button-option-0']");
    private final By employmentServicesNoLabel  = By.cssSelector("label[for='additionalFamilyEmploymentServices-radio-button-option-1']");

    // Special diet due to medical condition?
    private final By specialDietYesLabel = By.cssSelector("label[for='specialDietOrMedicalConditionInFamily-radio-button-option-0']");
    private final By specialDietNoLabel  = By.cssSelector("label[for='specialDietOrMedicalConditionInFamily-radio-button-option-1']");

    // Person with disability in family?

    private final By disabilityYesLabel = By.cssSelector("label[for='personWithDisabilityInFamily-radio-button-option-0']");
    private final By disabilityNoLabel  = By.cssSelector("label[for='personWithDisabilityInFamily-radio-button-option-1']");

    // Need money for immediate needs?

    private final By immediateNeedMoneyYesLabel = By.cssSelector("label[for='moneyForImmediateNeedInFamily-radio-button-option-0']");
    private final By immediateNeedMoneyNoLabel  = By.cssSelector("label[for='moneyForImmediateNeedInFamily-radio-button-option-1']");

    // Pregnant or breastfeeding (additional nutritional needs)?

    private final By pregnantOrBreastfeedingYesLabel = By.cssSelector("label[for='pregnantOrBreastFeedingInFamily-radio-button-option-0']");
    private final By pregnantOrBreastfeedingNoLabel  = By.cssSelector("label[for='pregnantOrBreastFeedingInFamily-radio-button-option-1']");

    // Full-time student?
    private final By fullTimeStudentYesLabel = By.cssSelector("label[for='fullTimeStudentInFamily-radio-button-option-0']");
    private final By fullTimeStudentNoLabel  = By.cssSelector("label[for='fullTimeStudentInFamily-radio-button-option-1']");

    // Caring for someone else’s child temporarily? (optional)

    private final By caringForChildYesLabel = By.cssSelector("label[for='caringForChild-radio-button-option-0']");
    private final By caringForChildNoLabel  = By.cssSelector("label[for='caringForChild-radio-button-option-1']");

    //No DSO
    By noDSO = By.cssSelector("label[for='personWithDisabilityInFamilyCheckboxPanelApplicant_developmentServicesOntario0-radio-button-option-2']");



    // -----------------------------
    // Actions (public API)
    // -----------------------------


    public void setReceivedSocialAssistancePast(boolean yes) {
        selectYesNo(yes, receivedSocialAssistancePastYesLabel, receivedSocialAssistancePastNoLabel);

    }

    public void setResidingInInstitution(boolean yes) {
        selectYesNo(yes, residingInInstitutionYesLabel, residingInInstitutionNoLabel);
    }

    public void setCurrentlyIncarcerated(boolean yes) {
        selectYesNo(yes, currentlyIncarceratedYesLabel, currentlyIncarceratedNoLabel);

    }

    public void setAccommodationServicesNeeded(boolean yes) {
        By input = yes ? accommodationServicesYesInput : accommodationServicesNoInput;
        By label = yes ? accommodationServicesYesLabel : accommodationServicesNoLabel;
        utility.clickRadio(input, label);
    }

    public void setEmploymentServicesSupport(boolean yes) {
        selectYesNo(yes, employmentServicesYesLabel, employmentServicesNoLabel);
    }

    public void setSpecialDietMedicalCondition(boolean yes) {
        selectYesNo(yes, specialDietYesLabel, specialDietNoLabel);
    }

    public void setDisabilityInFamily(boolean yes) {

                if(yes){
                    utility.click(disabilityYesLabel);
                    if(utility.isElementPresent10(noDSO)){
                        utility.click(noDSO);
                    }
                }else{
                    utility.click(disabilityNoLabel);
                }


    }

    public void setImmediateNeedMoney(boolean yes) {
        selectYesNo(yes, immediateNeedMoneyYesLabel, immediateNeedMoneyNoLabel);
    }

    public void setPregnantOrBreastfeeding(boolean yes) {
        selectYesNo(yes, pregnantOrBreastfeedingYesLabel, pregnantOrBreastfeedingNoLabel);

    }

    public void setFullTimeStudent(boolean yes) {
        selectYesNo(yes, fullTimeStudentYesLabel, fullTimeStudentNoLabel);
    }

    public void setCaringForChild(boolean yes) {
        selectYesNo(yes, caringForChildYesLabel, caringForChildNoLabel);
    }

    public void clickSaveAndContinue() {
        utility.click(saveAndContinueBtn);
    }

    public void clickSaveAndExit() {
        utility.click(saveAndExitBtn);
    }


    public void complete(ApplicantInfo applicantInfo){
        if(!utility.isElementPresent(this.pageTitle)){
            Logger.info("Skipping : " + pageTitle.toString());
            return;
        }
        Logger.info("Filling : " + pageTitle.toString());
        this.setReceivedSocialAssistancePast(applicantInfo.receivedSocialAssistancePast);         // Has anyone received social assistance in the past?
        this.setResidingInInstitution(applicantInfo.residingInInstitution);               // Living in an institution?
        this.setCurrentlyIncarcerated(applicantInfo.currentlyIncarcerated);               // In jail/prison/detention?
        this.setAccommodationServicesNeeded(applicantInfo.accommodationServicesNeeded);         // Need support accessing services?
        this.setEmploymentServicesSupport(applicantInfo.employmentServicesSupport);           // Getting job-program/service support?
        this.setSpecialDietMedicalCondition(applicantInfo.specialDietMedicalCondition);         // Need special diet due to medical condition?
        this.setDisabilityInFamily(applicantInfo.disabilityInFamily);                  // Person with disability in family?
        this.setImmediateNeedMoney(applicantInfo.immediateNeedMoney);                  // Need money for immediate needs?
        this.setPregnantOrBreastfeeding(applicantInfo.pregnantOrBreastfeeding);             // Pregnant or breastfeeding?
        this.setFullTimeStudent(applicantInfo.additionalFamilyfullTimeStudent);                     // Full-time student?
        this.setCaringForChild(applicantInfo.additionalFamilyCaringForChild);                      // Caring for someone else’s child?

        // Save and Continue
        clickSaveAndContinue();

    }



}
