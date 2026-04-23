package org.sada.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.sada.data.ApplicantInfo;
import org.sada.util.Logger;

public class SpouceInformationPage extends BasePage {
    // -----------------------------
    // Constructor
    // -----------------------------
    public SpouceInformationPage(WebDriver driver) {
      super(driver);
    }

    private final By pageTitle = By.id("");
    // Text inputs
    private final By firstNameInput = By.id("input-spouse-information.spouseFirstName");
    private final By lastNameInput  = By.id("input-spouse-information.spouseLastName");

    // Date of Birth inputs
    private final By dobYearInput  = By.id("spouse-information-spouseDateOfBirthYearInput");
    private final By dobMonthInput = By.id("spouse-information-spouseDateOfBirthMonthInput");
    private final By dobDayInput   = By.id("spouse-information-spouseDateOfBirthDayInput");

    // Sex at birth radios
    private final By sexMaleRadio   = By.cssSelector("label[for='spouse-information.spouseSexAtBirth-radio-button-option-0']");
    private final By sexFemaleRadio = By.cssSelector("label[for='spouse-information.spouseSexAtBirth-radio-button-option-1']");



    // Status in Canada dropdown
    private final By statusInCanadaSelect = By.id("select-spouse-information.status.statusInCanada");

    // SIN input + helper checkbox (optional)
    private final By sinInput      = By.id("input-spouse-information.status.sinNumber");


    //Email Input
    private final By emailInput = By.id("input-spouse-information.spouseEmail");


    // Language support radios (help improving language skills)
    private final By langHelpYesRadio     = By.cssSelector("label[for='spouse-information.languageSupport.label-radio-button-option-0']");
    private final By langHelpNoGoodRadio  = By.cssSelector("label[for='spouse-information.languageSupport.label-radio-button-option-1']"); // "good enough"
    private final By langHelpNoStrongRadio= By.cssSelector("label[for='spouse-information.languageSupport.label-radio-button-option-2]"); // "strong"

    // Health status dropdown
    private final By healthStatusSelect = By.id("select-spouse-information.healthStatus");

    // Continue button
    private final By continueButton = By.id("spouse-information-save-continue-button");



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


    // -----------------------------
    // Actions (public API)
    // -----------------------------
    public void setStatusInCanadaSelect(String visibleText) {
        WebElement selectEl = utility.scrollIntoView(statusInCanadaSelect);
        new Select(selectEl).selectByVisibleText(visibleText);
    }


    public void setSIN(String SIN) {
        if(utility.getValue(sinInput).equals("")){
            utility.clearAndType(sinInput, SIN);
        }
    }



    public void setEmail(String email) {
        if(utility.getValue(emailInput).equals("")){
            utility.clearAndType(emailInput, email);
        }
    }


    public void setNoLangHelp() {
        utility.click(langHelpNoGoodRadio);
    }

    public void setHealthStatus(String visibleText) {
        WebElement selectEl = utility.scrollIntoView(healthStatusSelect);
        new Select(selectEl).selectByVisibleText(visibleText);
    }

    public void complete(ApplicantInfo applicantInfo) {
        if(!utility.isElementPresent(pageTitle)){
            Logger.info("Skipping : " + pageTitle.toString());
            return;
        }
        Logger.info("Filling : " + pageTitle.toString());
        this.setFirstName(applicantInfo.firstNameSpouce);
        this.setLastName(applicantInfo.lastNameSpouce);

        this.setDOBYear(applicantInfo.DOBYearSpouce);
        this.setDOBMonth(applicantInfo.DOBMonthSpouce);
        this.setDOBDay(applicantInfo.DOBDaySpouce);

        //Sex at Birth
        this.setSexMale();


        this.setStatusInCanadaSelect(applicantInfo.statusinCanadaSelect);

        this.setSIN(applicantInfo.SINSpouce);
        this.setEmail(applicantInfo.emailSpouce);
        this.setNoLangHelp();
        this.setHealthStatus(applicantInfo.healthStatusSpouce);

        this.clickContinueButton();

    }

    public void clickContinueButton() {
        utility.click(continueButton);
    }






}
