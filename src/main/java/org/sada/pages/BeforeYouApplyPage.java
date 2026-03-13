package org.sada.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.sada.ApplicantInfo;
import org.sada.util.Logger;

public class BeforeYouApplyPage extends BasePage {

    public final By pageTitle = By.id("before-you-apply.page.title");
    public BeforeYouApplyPage(WebDriver driver) {
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

    private void setEmergency(Boolean inEmergency){
        if(inEmergency){
            utility.findElement(receivingMoneyForReasonYes).click();
        }else{
            utility.findElement(receivingMoneyForReasonNo).click();
        }
    }

    private void setGetiingMoney(Boolean isGettingMoney){
        //Are you currently getting money from Ontario Works or the Ontario Disability Support Program?
       if(isGettingMoney){
           utility.findElement(receivingMoneyFromExistingProgramYes).click();
       }else{
           utility.findElement(receivingMoneyFromExistingProgramNo).click();
       }
    }

    private void setMoneyForImmediateNeed(Boolean isMoneyForImmediateNeed){
        if(isMoneyForImmediateNeed){
            utility.findElement(moneyForImmediateNeedYes).click();
        }else{
            utility.findElement(moneyForImmediateNeedNo).click();
        }
    }

    private void setReceivedSocialAssistanceInPast(Boolean isReceivedSocialAssistanceInPast){
        if(isReceivedSocialAssistanceInPast){
            utility.findElement(receivedSocialAssistanceInPastYes).click();
        }else{
            utility.findElement(receivedSocialAssistanceInPastNo).click();
        }
    }

    private void setHasDisability(Boolean hasDisability){
       if(hasDisability){
           utility.findElement(hasDisabilityYes).click();
       }else{
           utility.findElement(hasDisabilityNo).click();
       }
    }


    private void setStatusInCanadaSelect(String visibleText){
        WebElement selectEl = driver.findElement(statusInCanadaSelect);
        new Select(selectEl).selectByVisibleText(visibleText);
    }

    private void setReleasedFromInstitution(Boolean releasedFromInstitution){
        if(releasedFromInstitution){
            utility.findElement(releasedFromInstitutionYes).click();
        }else{
            utility.findElement(releasedFromInstitutionNo).click();
        }
    }
    private void setLivingOnFirstNationsReserveLand(Boolean livingOnFirstNationsReserveLand){
        if(livingOnFirstNationsReserveLand){
            utility.findElement(livingOnFirstNationsReserveLandYes).click();
        }else{
            utility.findElement(livingOnFirstNationsReserveLandNo).click();
        }
    }

    private void setApplyingForYourself(Boolean applyingForYourself){
        if(applyingForYourself){
            utility.findElement(applyingForYourselfYes).click();
        }else{
            utility.findElement(applyingForSomeoneElse).click();
        }
    }

    private void clickContinueButton(){
        utility.findElement(continueButton).click();
    }

    public void complete(ApplicantInfo applicantInfo){
        if(!utility.isElementPresent(this.pageTitle)) {
          return;
        }
        this.setEmergency(applicantInfo.isEmergency);
        this.setGetiingMoney(applicantInfo.isGettingMoney);
        this.setMoneyForImmediateNeed(applicantInfo.isMoneyForImmediateNeed);
        this.setReceivedSocialAssistanceInPast(applicantInfo.isReceivedSocialAssistanceInPast);
        this.setHasDisability(applicantInfo.hasDisability);
        this.setStatusInCanadaSelect(applicantInfo.statusinCanadaSelect);
        this.setReleasedFromInstitution(applicantInfo.releasedFromInstitution);
        this.setLivingOnFirstNationsReserveLand(applicantInfo.livingOnFirstNationsReserveLand);
        this.setApplyingForYourself(applicantInfo.applyingForYourself);
        this.clickContinueButton();

    }





}
