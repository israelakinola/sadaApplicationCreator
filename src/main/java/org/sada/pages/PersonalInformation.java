package org.sada.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.sada.ApplicantInfo;
import org.sada.util.Utility;

import java.util.Objects;

public class PersonalInformation {
    private final WebDriver driver;
    private Utility utility;
    public final By pageTitle = By.id("personal-information.page.title");


    public PersonalInformation(WebDriver driver) {
        this.driver = Objects.requireNonNull(driver, "driver must not be null");
        this.utility = new Utility(driver);
    }

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



    public void setFirstName(String s) {
        utility.clearAndType(firstNameInput, s);
    }

    public void setLastName(String s) {
        utility.clearAndType(lastNameInput, s);
    }

    public void setDOBYear(String number) {
        utility.clearAndType(dobYearInput, number);
    }

    public void setDOBMonth(String number) {
        utility.clearAndType(dobMonthInput, number);
    }

    public void setDOBDay(String number) {
        utility.clearAndType(dobDayInput, number);
    }

    public void setSexMale() {
        utility.click(sexMaleRadio);
    }

    public void setSexFemale() {
        utility.click(sexFemaleRadio);
    }


    public void setMaritalStatus(String maritalStatus) {
        WebElement selectEl = utility.scrollIntoView(maritalStatusSelect);
        new Select(selectEl).selectByVisibleText(maritalStatus);
    }

    public void setChildrenNO() {
        utility.click(childrenNoRadio);
    }

    public void setStatusInCanadaSelect(String visibleText) {
        WebElement selectEl = utility.scrollIntoView(statusInCanadaSelect);
        new Select(selectEl).selectByVisibleText(visibleText);
    }


    public void setSIN(String SIN) {
        String sin = System.getProperty("sin", SIN);
        utility.clearAndType(sinInput, sin);
        if(utility.isElementPresent(signExpiredNo)){
            utility.click(signExpiredNo);
        }
    }


    public void setPhoneNumber(String phoneNumber) {
        String phone = System.getProperty("phone", phoneNumber);
        utility.clearAndType(phoneInput, phone);
    }

    public void setEmail(String email) {
        utility.clearAndType(emailInput, email);
//        WebElement el = utility.useWait().until(ExpectedConditions.visibilityOfElementLocated(emailInput));
//        el.clear();
//        el.sendKeys(email);
    }

    public void setLangEnglish() {
        utility.click(langEnglishRadio);
    }

    public void setNoLangHelp() {
        utility.click(langHelpNoGoodRadio);
    }

    public void setHealthStatus(String visibleText) {
        WebElement selectEl = utility.scrollIntoView(healthStatusSelect);
        new Select(selectEl).selectByVisibleText(visibleText);
    }

    public void clickContinueButton() {
        utility.click(continueButton);
    }

    public void createPersonalInformation(ApplicantInfo primaryApplicant) {
        Utility.copyToClipboard(primaryApplicant.email);
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
    }






}
