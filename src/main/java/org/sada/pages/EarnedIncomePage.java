package org.sada.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sada.ApplicantInfo;
import org.sada.util.Logger;

public class EarnedIncomePage extends BasePage {

    private final By pageTitle =  By.id("earned-income.page.title");

    //Button
    private final By saveAndContinueBtn = By.id("earned-income-save-continue-button");


    /* -----------------------------
       Locators (class properties)
     ----------------------------- */

    //Will you receive income from a job, a training program, or self-employment in January 2026?
    private final By receiveIncomeYes = By.cssSelector("label[for='earned-income-applicant-receive-income-radio-button-option-0']");
    private final By receiveIncomeNo = By.cssSelector("label[for='earned-income-applicant-receive-income-radio-button-option-1']");

    private final By receiveIncomeAnyOneNoneInput = By.id("earned-income.anyone.receive.income-checkbox-option3");
    private final By receiveIncomeAnyOneNoneLabel = By.cssSelector("label[for='earned-income.anyone.receive.income-checkbox-option3']");

    public EarnedIncomePage(WebDriver driver) {
        super(driver);
    }


    private void setEarnedIncome(boolean earnedIncome) {
        if (earnedIncome) {
            utility.click(receiveIncomeYes);
        }else{
            utility.click(receiveIncomeNo);
        }
    }

    private void setEarnedIncomeFamily(boolean earnedIncome) {
        if (earnedIncome) {
            //
        }else{
            Logger.info("Income Family None");
            utility.clickCheckbox(receiveIncomeAnyOneNoneInput,receiveIncomeAnyOneNoneLabel);
        }

    }

    public void complete(ApplicantInfo applicantInfo){
        if(!utility.isElementPresent(pageTitle)) {
            Logger.info("Skipping : " + pageTitle.toString());
           return;
        }
        Logger.info("Filling : " + pageTitle.toString());
        //Will you receive income from a job, a training program, or self-employment in March 2026?
        this.setEarnedIncome(applicantInfo.earnedIncome);

        utility.click(saveAndContinueBtn);
    }

}
