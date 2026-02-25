package org.sada.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sada.util.Logger;

public class EarnedIncome extends BasePage {

    public By pageTitle =  By.id("earned-income.page.title");

    /* -----------------------------
       Locators (class properties)
     ----------------------------- */

    //Will you receive income from a job, a training program, or self-employment in January 2026?
    private final By receiveIncomeYes = By.cssSelector("label[for='earned-income-applicant-receive-income-radio-button-option-0']");
    private final By receiveIncomeNo = By.cssSelector("label[for='earned-income-applicant-receive-income-radio-button-option-1']");

    private final By receiveIncomeAnyOneNoneInput = By.id("earned-income.anyone.receive.income-checkbox-option3");
    private final By receiveIncomeAnyOneNoneLabel = By.cssSelector("label[for='earned-income.anyone.receive.income-checkbox-option3']");

    public EarnedIncome(WebDriver driver) {
        super(driver);
    }


    public void setEarnedIncome(boolean earnedIncome) {
        if (earnedIncome) {
            utility.click(receiveIncomeYes);
        }else{
            utility.click(receiveIncomeNo);
        }
    }

    public void setEarnedIncomeFamily(boolean earnedIncome) {
        if (earnedIncome) {
            //
        }else{
            Logger.info("Income Family None");
            utility.clickCheckbox(receiveIncomeAnyOneNoneInput,receiveIncomeAnyOneNoneLabel);
        }

    }
}
