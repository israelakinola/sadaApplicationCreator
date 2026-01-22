
package org.sada.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sada.ApplicantInfo;

public class AdditionalFamilyInformation extends BasePage {

    public final By pageTitle = By.cssSelector("h1[data-e2e='pageTitle']");
    // -----------------------------
    // Locators (radio inputs + labels)
    // -----------------------------

    // Has anyone received social assistance in Ontario in the past?
    private final By receivedSocialAssistancePastYesInput = By.id("familyReceivedSocialAssistanceInPast-radio-button-option-0");
    private final By receivedSocialAssistancePastNoInput  = By.id("familyReceivedSocialAssistanceInPast-radio-button-option-1");
    private final By receivedSocialAssistancePastYesLabel = By.cssSelector("label[for='familyReceivedSocialAssistanceInPast-radio-button-option-0']");
    private final By receivedSocialAssistancePastNoLabel  = By.cssSelector("label[for='familyReceivedSocialAssistanceInPast-radio-button-option-1']");

    // Living in an institution?
    private final By residingInInstitutionYesInput = By.id("familyMembersResidingInInstitution-radio-button-option-0");
    private final By residingInInstitutionNoInput  = By.id("familyMembersResidingInInstitution-radio-button-option-1");
    private final By residingInInstitutionYesLabel = By.cssSelector("label[for='familyMembersResidingInInstitution-radio-button-option-0']");
    private final By residingInInstitutionNoLabel  = By.cssSelector("label[for='familyMembersResidingInInstitution-radio-button-option-1']");

    // In jail/prison/overnight detention centre?
    private final By currentlyIncarceratedYesInput = By.id("familyMembersCurrentlyIncarcerated-radio-button-option-0");
    private final By currentlyIncarceratedNoInput  = By.id("familyMembersCurrentlyIncarcerated-radio-button-option-1");
    private final By currentlyIncarceratedYesLabel = By.cssSelector("label[for='familyMembersCurrentlyIncarcerated-radio-button-option-0']");
    private final By currentlyIncarceratedNoLabel  = By.cssSelector("label[for='familyMembersCurrentlyIncarcerated-radio-button-option-1']");

    // Need support accessing services?
    private final By accommodationServicesYesInput = By.id("additionalFamilyAccommodationServices-radio-button-option-0");
    private final By accommodationServicesNoInput  = By.id("additionalFamilyAccommodationServices-radio-button-option-1");
    private final By accommodationServicesYesLabel = By.cssSelector("label[for='additionalFamilyAccommodationServices-radio-button-option-0']");
    private final By accommodationServicesNoLabel  = By.cssSelector("label[for='additionalFamilyAccommodationServices-radio-button-option-1']");

    // Getting employment program/service support?
    private final By employmentServicesYesInput = By.id("additionalFamilyEmploymentServices-radio-button-option-0");
    private final By employmentServicesNoInput  = By.id("additionalFamilyEmploymentServices-radio-button-option-1");
    private final By employmentServicesYesLabel = By.cssSelector("label[for='additionalFamilyEmploymentServices-radio-button-option-0']");
    private final By employmentServicesNoLabel  = By.cssSelector("label[for='additionalFamilyEmploymentServices-radio-button-option-1']");

    // Special diet due to medical condition?
    private final By specialDietYesInput = By.id("specialDietOrMedicalConditionInFamily-radio-button-option-0");
    private final By specialDietNoInput  = By.id("specialDietOrMedicalConditionInFamily-radio-button-option-1");
    private final By specialDietYesLabel = By.cssSelector("label[for='specialDietOrMedicalConditionInFamily-radio-button-option-0']");
    private final By specialDietNoLabel  = By.cssSelector("label[for='specialDietOrMedicalConditionInFamily-radio-button-option-1']");

    // Person with disability in family?
    private final By disabilityYesInput = By.id("personWithDisabilityInFamily-radio-button-option-0");
    private final By disabilityNoInput  = By.id("personWithDisabilityInFamily-radio-button-option-1");
    private final By disabilityYesLabel = By.cssSelector("label[for='personWithDisabilityInFamily-radio-button-option-0']");
    private final By disabilityNoLabel  = By.cssSelector("label[for='personWithDisabilityInFamily-radio-button-option-1']");

    // Need money for immediate needs?
    private final By immediateNeedMoneyYesInput = By.id("moneyForImmediateNeedInFamily-radio-button-option-0");
    private final By immediateNeedMoneyNoInput  = By.id("moneyForImmediateNeedInFamily-radio-button-option-1");
    private final By immediateNeedMoneyYesLabel = By.cssSelector("label[for='moneyForImmediateNeedInFamily-radio-button-option-0']");
    private final By immediateNeedMoneyNoLabel  = By.cssSelector("label[for='moneyForImmediateNeedInFamily-radio-button-option-1']");

    // Pregnant or breastfeeding (additional nutritional needs)?
    private final By pregnantOrBreastfeedingYesInput = By.id("pregnantOrBreastFeedingInFamily-radio-button-option-0");
    private final By pregnantOrBreastfeedingNoInput  = By.id("pregnantOrBreastFeedingInFamily-radio-button-option-1");
    private final By pregnantOrBreastfeedingYesLabel = By.cssSelector("label[for='pregnantOrBreastFeedingInFamily-radio-button-option-0']");
    private final By pregnantOrBreastfeedingNoLabel  = By.cssSelector("label[for='pregnantOrBreastFeedingInFamily-radio-button-option-1']");

    // Full-time student?
    private final By fullTimeStudentYesInput = By.id("fullTimeStudentInFamily-radio-button-option-0");
    private final By fullTimeStudentNoInput  = By.id("fullTimeStudentInFamily-radio-button-option-1");
    private final By fullTimeStudentYesLabel = By.cssSelector("label[for='fullTimeStudentInFamily-radio-button-option-0']");
    private final By fullTimeStudentNoLabel  = By.cssSelector("label[for='fullTimeStudentInFamily-radio-button-option-1']");

    // Caring for someone else’s child temporarily? (optional)
    private final By caringForChildYesInput = By.id("caringForChild-radio-button-option-0");
    private final By caringForChildNoInput  = By.id("caringForChild-radio-button-option-1");
    private final By caringForChildYesLabel = By.cssSelector("label[for='caringForChild-radio-button-option-0']");
    private final By caringForChildNoLabel  = By.cssSelector("label[for='caringForChild-radio-button-option-1']");

    // Buttons
    private final By saveAndContinueBtn = By.id("additional-information-save-continue-button"); // or: By.cssSelector("button[data-e2e='saveContinueBtn']")
    private final By saveAndExitBtn     = By.id("additional-information-save-exit-button");     // or: By.cssSelector("button[data-e2e='saveExitBtn']")

    public AdditionalFamilyInformation(WebDriver driver) {
        super(driver);
    }

    // -----------------------------
    // Actions (public API)
    // -----------------------------

    public void setReceivedSocialAssistancePast(boolean yes) {
        utility.click(yes ? receivedSocialAssistancePastYesLabel : receivedSocialAssistancePastNoLabel);
    }

    public void setResidingInInstitution(boolean yes) {
        utility.click(yes ? residingInInstitutionYesLabel : residingInInstitutionNoLabel);
    }

    public void setCurrentlyIncarcerated(boolean yes) {
        utility.click(yes ? currentlyIncarceratedYesLabel : currentlyIncarceratedNoLabel);
    }

    public void setAccommodationServicesNeeded(boolean yes) {
        utility.clickRadio(yes ? accommodationServicesYesInput : accommodationServicesNoInput,
                yes ? accommodationServicesYesLabel : accommodationServicesNoLabel);
    }

    public void setEmploymentServicesSupport(boolean yes) {
        System.out.println("EmploymentServicesSupport");
        utility.click(yes ? employmentServicesYesLabel : employmentServicesNoLabel);
    }

    public void setSpecialDietMedicalCondition(boolean yes) {
        utility.click(yes ? specialDietYesLabel : specialDietNoLabel);
    }

    public void setDisabilityInFamily(boolean yes) {
                By noDSO = By.cssSelector("label[for='personWithDisabilityInFamilyCheckboxPanelApplicant_developmentServicesOntario0-radio-button-option-2']");
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
        utility.click(yes ? immediateNeedMoneyYesLabel : immediateNeedMoneyNoLabel);
    }

    public void setPregnantOrBreastfeeding(boolean yes) {
        utility.click(yes ? pregnantOrBreastfeedingYesLabel : pregnantOrBreastfeedingNoLabel);
    }

    public void setFullTimeStudent(boolean yes) {
        utility.click(yes ? fullTimeStudentYesLabel : fullTimeStudentNoLabel);
    }

    public void setCaringForChild(boolean yes) {
        utility.click(yes ? caringForChildYesLabel : caringForChildNoLabel);
    }

    public void clickSaveAndContinue() {
        utility.click(saveAndContinueBtn);
    }

    public void clickSaveAndExit() {
        utility.click(saveAndExitBtn);
    }


    public void createAdditionalFamilyInformation(ApplicantInfo applicantInfo){
        // Answer all radio questions (adjust true/false to your test needs)
        this.setReceivedSocialAssistancePast(false);         // Has anyone received social assistance in the past?
        this.setResidingInInstitution(false);               // Living in an institution?
        this.setCurrentlyIncarcerated(false);               // In jail/prison/detention?
        this.setAccommodationServicesNeeded(false);         // Need support accessing services?
        this.setEmploymentServicesSupport(false);           // Getting job-program/service support?
        this.setSpecialDietMedicalCondition(false);         // Need special diet due to medical condition?
        this.setDisabilityInFamily(applicantInfo.ODSP);                  // Person with disability in family?
        this.setImmediateNeedMoney(false);                  // Need money for immediate needs?
        this.setPregnantOrBreastfeeding(false);             // Pregnant or breastfeeding?
        this.setFullTimeStudent(false);                     // Full-time student?
        this.setCaringForChild(false);                      // Caring for someone else’s child?

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



}
