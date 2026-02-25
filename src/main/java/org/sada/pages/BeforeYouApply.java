package org.sada.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.sada.util.Utility;

import javax.swing.text.Utilities;
import java.time.Duration;

public class BeforeYouApply extends BasePage {

    public final By pageTitle = By.id("before-you-apply.page.title");
    public BeforeYouApply(WebDriver driver) {
       super(driver);
    }


    /* -----------------------------
       Locators (class properties)
     ----------------------------- */

    // Radio: Are you in an emergency or crisis...?
    private final By receivingMoneyForReasonYes =
            By.id("start-two.receivingMoneyForReason-radio-button-option-0");
    private final By receivingMoneyForReasonNo  =
           By.id("start-two.receivingMoneyForReason-radio-button-option-1");

    // Radio: Are you currently getting money from OW or ODSP?
    private final By receivingMoneyFromExistingProgramYes =
            By.id("start-two.receivingMoneyFromExistingProgram-radio-button-option-0");
    private final By receivingMoneyFromExistingProgramNo  =
            By.id("start-two.receivingMoneyFromExistingProgram-radio-button-option-1");

    // Radio: Do you need money to pay for your immediate needs...?
    private final By moneyForImmediateNeedYes =
            By.id("start-two.moneyForImmediateNeed-radio-button-option-0");
    private final By moneyForImmediateNeedNo  =
            By.id("start-two.moneyForImmediateNeed-radio-button-option-1");

    // Radio: Have you received social assistance in Ontario in the past?
    private final By receivedSocialAssistanceInPastYes =
            By.id("start-two.receivedSocialAssistanceInPast-radio-button-option-0");
    private final By receivedSocialAssistanceInPastNo  =
            By.id("start-two.receivedSocialAssistanceInPast-radio-button-option-1");




    // Radio: Do you have a disability?
    private final By hasDisabilityYes =
            By.id("start-two.hasDisability-radio-button-option-0");
    private final By hasDisabilityNo  =
            By.id("start-two.hasDisability-radio-button-option-1");

    // Dropdown: What is your legal status in Canada?
    private final By statusInCanadaSelect =
            By.id("select-start-two.statusInCanada");

    // Radio: Are you in a jail, prison, or overnight detention centre?
    private final By releasedFromInstitutionYes =
            By.id("start-two.releasedFromInstitution-radio-button-option-0");
    private final By releasedFromInstitutionNo  =
            By.id("start-two.releasedFromInstitution-radio-button-option-1");

    // Radio: Are you currently living in a First Nations’ community?
    private final By livingOnFirstNationsReserveLandYes =
            By.id("start-two.livingOnFirstNationsReserveLand-radio-button-option-0");
    private final By livingOnFirstNationsReserveLandNo  =
            By.id("start-two.livingOnFirstNationsReserveLand-radio-button-option-1");


    // Radio: Are you applying for yourself or for someone else?
    private final By applyingForYourselfYes =
            By.id("start-two.applyingForYourselfOrSomeoneElse-radio-button-option-0"); // Applying for myself
    private final By applyingForSomeoneElse =
            By.id("start-two.applyingForYourselfOrSomeoneElse-radio-button-option-1"); // Applying for someone else

    // Submit button
    private final By continueButton =
            By.id("before-you-apply-continue-button");

    // -----------------------------
    // Actions (public API)
    // -----------------------------

    protected void setEmergencyAsNo(){
        utility.findElement(receivingMoneyForReasonNo).click();
    }

    protected void setGetiingMoneyAsNo(){
        //Are you currently getting money from Ontario Works or the Ontario Disability Support Program?
        utility.findElement(receivingMoneyFromExistingProgramNo).click();
    }

    protected void setMoneyForImmediateNeedNo(){
        driver.findElement(moneyForImmediateNeedNo).click();
    }

    protected void setReceivedSocialAssistanceInPastNo(){
        utility.findElement(receivedSocialAssistanceInPastNo).click();
    }

    protected void setHasDisabilityNo(){
        utility.findElement(hasDisabilityNo).click();
    }

    protected void setHasDisabilityYes(){
        utility.findElement(hasDisabilityYes).click();
    }

    protected void setStatusInCanadaSelect(String visibleText){
        WebElement selectEl = driver.findElement(statusInCanadaSelect);
        new Select(selectEl).selectByVisibleText(visibleText);
    }

    protected void setReleasedFromInstitutionNo(){
        driver.findElement(releasedFromInstitutionNo).click();
    }
    protected void setLivingOnFirstNationsReserveLandNo(){
        utility.findElement(livingOnFirstNationsReserveLandNo).click();
    }

    protected void setApplyingForYourselfYes(){
        driver.findElement(applyingForYourselfYes).click();
    }

    protected void clickContinueButton(){
        driver.findElement(continueButton).click();
    }

    public void beforeYouApply(boolean ODSP, String status){
        this.setEmergencyAsNo();
        this.setGetiingMoneyAsNo();
        this.setMoneyForImmediateNeedNo();
        this.setReceivedSocialAssistanceInPastNo();
        if(ODSP){
            this.setHasDisabilityYes();
        }else{
            this.setHasDisabilityNo();
        }
        this.setStatusInCanadaSelect(status);
        this.setReleasedFromInstitutionNo();
        this.setLivingOnFirstNationsReserveLandNo();
        this.setApplyingForYourselfYes();
        this.clickContinueButton();
    }



}
