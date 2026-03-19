package org.sada.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.sada.ApplicantInfo;
import org.sada.util.Logger;

public class PersonalInformationPage extends BasePage {

    public final By pageTitle = By.id("personal-information.page.title");


    public PersonalInformationPage(WebDriver driver) {
      super(driver);
    }

    /* -----------------------------
       Locators
     ----------------------------- */

    // Text inputs
    private final By firstNameInput = By.id("input-personal-information.firstName");
    private final By lastNameInput  = By.id("input-personal-information.lastName");

    // Date of Birth inputs
    private final By dobYearInput  = By.id("personal-information-dateOfBirthYearInput");
    private final By dobMonthInput = By.id("personal-information-dateOfBirthMonthInput");
    private final By dobDayInput   = By.id("personal-information-dateOfBirthDayInput");

    // Sex at birth radios
    private final By sexMaleRadio   = By.cssSelector("label[for='personal-information.sexAtBirth-radio-button-option-0']");
    private final By sexFemaleRadio = By.cssSelector("personal-information.sexAtBirth-radio-button-option-1");

    // Marital status dropdown
    private final By maritalStatusSelect = By.id("select-personal-information.maritalStatus");

    // Children living with you radios
    private final By childrenYesRadio = By.cssSelector("label[for='personal-information.childrenLivingWithYou-radio-button-option-0']");
    private final By childrenNoRadio  = By.cssSelector("label[for='personal-information.childrenLivingWithYou-radio-button-option-1']");

    // Status in Canada dropdown
    private final By statusInCanadaSelect = By.id("select-personal-information.status.statusInCanada");

    // SIN input + helper checkbox (optional)
    private final By sinInput      = By.id("input-personal-information.status.sinNumber");
    private final By noSinCheckbox = By.id("personal-information.status.noSin-checkbox-option1"); //
    private final By signExpiredNo = By.cssSelector("label[for='personal-information.status.isSinExpired-radio-button-option-1']");// not used here

    // Phone input
    private final By phoneInput = By.id("input-personal-information.phone");

    //Email Input
    private final By emailInput = By.id("input-personal-information.email");

    // Contact language radios
    private final By langEnglishRadio = By.cssSelector("label[for='personal-information.contactLanguage-radio-button-option-0']");
    private final By langFrenchRadio  = By.cssSelector("label[for='personal-information.contactLanguage-radio-button-option-1']");

    // Language support radios (help improving language skills)
    private final By langHelpYesRadio     = By.cssSelector("label[for='personal-information.languageSupport.label-radio-button-option-0']");
    private final By langHelpNoGoodRadio  = By.cssSelector("label[for='personal-information.languageSupport.label-radio-button-option-1']"); // "good enough"
    private final By langHelpNoStrongRadio= By.cssSelector("label[for='personal-information.languageSupport.label-radio-button-option-2']"); // "strong"

    // Health status dropdown
    private final By healthStatusSelect = By.id("select-personal-information.healthStatus");

    // Continue button
    private final By continueButton = By.id("personal-information-continue-button");


    // -----------------------------
    // Actions (public API)
    // -----------------------------

    private void setFirstName(String s) {
        utility.clearAndType(firstNameInput, s);
    }

    private void setLastName(String s) {
        utility.clearAndType(lastNameInput, s);
    }

    private void setDOBYear(String number) {
        utility.clearAndType(dobYearInput, number);
    }

    private void setDOBMonth(String number) {
        utility.clearAndType(dobMonthInput, number);
    }

    private void setDOBDay(String number) {
        utility.clearAndType(dobDayInput, number);
    }

    private void isGenderMale(Boolean isMale) {
        if(isMale){
            utility.click(sexMaleRadio);
        }else{
            utility.click(sexFemaleRadio);
        }
    }


    private void setMaritalStatus(String maritalStatus) {
        WebElement selectEl = utility.scrollIntoView(maritalStatusSelect);
        new Select(selectEl).selectByVisibleText(maritalStatus);
    }

    private void isChildren(Boolean hasChildren) {
        if(hasChildren){
            utility.click(childrenYesRadio);
        }else{
            utility.click(childrenNoRadio);
        }
    }

    private void setStatusInCanadaSelect(String visibleText) {
        WebElement selectEl = utility.scrollIntoView(statusInCanadaSelect);
        new Select(selectEl).selectByVisibleText(visibleText);
    }

    private void setSIN(String SIN) {
        String sin = System.getProperty("sin", SIN);
        utility.clearAndType(sinInput, sin);
        if(utility.isElementPresent(signExpiredNo)){
            utility.click(signExpiredNo);
        }
    }


    private void setPhoneNumber(String phoneNumber) {
        String phone = System.getProperty("phone", phoneNumber);
        utility.clearAndType(phoneInput, phone);
    }

    private void setEmail(String email) {
        utility.clearAndType(emailInput, email);
    }

    private void setLangEnglish() {
        utility.click(langEnglishRadio);
    }

    private void setNoLangHelp() {
        utility.click(langHelpNoGoodRadio);
    }

    private void setHealthStatus(String visibleText) {
        WebElement selectEl = utility.scrollIntoView(healthStatusSelect);
        new Select(selectEl).selectByVisibleText(visibleText);
    }

    private void clickContinueButton() {
        utility.click(continueButton);
    }


    public void complete(ApplicantInfo applicantInfo) {
        if(!utility.isElementPresent(this.pageTitle)){
            Logger.info("Skipping : " + pageTitle.toString());
            return;
        }
        Logger.info("Filling : " + pageTitle.toString());
        this.setFirstName(applicantInfo.getFirstName());
        this.setLastName(applicantInfo.getLastName());

        this.setDOBYear(applicantInfo.getDOBYear());
        this.setDOBMonth(applicantInfo.getDOBMonth());
        this.setDOBDay(applicantInfo.getDOBDay());

        //Set at Birth
        this.isGenderMale(applicantInfo.isGenderMale);

        this.setMaritalStatus(applicantInfo.getMaritalStatus());
        this.isChildren(applicantInfo.hasChildren);
        this.setStatusInCanadaSelect(applicantInfo.getStatusinCanadaSelect());

        this.setSIN(applicantInfo.getSIN());
        this.setPhoneNumber(applicantInfo.getPhoneNumber());
        this.setEmail(applicantInfo.getEmail());
        this.setLangEnglish();
        this.setNoLangHelp();
        this.setHealthStatus(applicantInfo.getHealthStatus());

        this.clickContinueButton();
    }



}
