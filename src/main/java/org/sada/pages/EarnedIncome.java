package org.sada.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EarnedIncome extends BasePage {

    public By pageTitle =  By.id("earned-income.page.title");

    //Will you receive income from a job, a training program, or self-employment in January 2026?
    private final By receiveIncomeYes = By.cssSelector("label[for='earned-income-applicant-receive-income-radio-button-option-0']");
    private final By receiveIncomeNo = By.cssSelector("label[for='earned-income-applicant-receive-income-radio-button-option-1']");

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
}
