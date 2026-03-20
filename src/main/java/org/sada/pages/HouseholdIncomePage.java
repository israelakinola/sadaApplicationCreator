package org.sada.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sada.ApplicantInfo;
import org.sada.util.Logger;

import java.util.List;

public class HouseholdIncomePage extends BasePage {

    public HouseholdIncomePage(WebDriver driver) {
        super(driver);
    }

    private final By pageTitle = By.id("household-income.page.title");

    private final By saveAndContinueBtn = By.id("household-income-save-continue-button");

    /* -----------------------------
       Locators (class properties)
     ----------------------------- */

    // CPP Disability
    private final By cppDisabilityCheckbox =
            By.cssSelector("#CPPQPPPaymentPanel_DisabilityPayment00");

    // CPP Retirement
    private final By cppRetirementCheckbox =
            By.cssSelector("#CPPQPPPaymentPanel_RetirementPayment00");

    // CPP Surviving Spouse Pension
    private final By cppSurvivingSpouseCheckbox =
            By.cssSelector("#CPPQPPPaymentPanel_SurvivingSpousePensionPayment00");

    // WSIB Loss of Income
    private final By wsibLossOfIncomeCheckbox =
            By.cssSelector("#WSIBPaymentPanel_LossOfIncomePayment00");

    // WSIB Other
    private final By wsibOtherCheckbox =
            By.cssSelector("#WSIBPaymentPanel_OtherPayment00");

    // =========================
    // INSURANCE PAYMENTS
    // =========================

    // Insurance Loss of Income
    private final By insurancePaymentCheckbox =
            By.cssSelector("#InsurancePaymentPanel_InsurancePayment00");


    // =========================
    // GOVERNMENT PAYMENTS
    // =========================

    // Old Age Security (OAS)
    private final By oldAgeSecurityCheckbox =
            By.cssSelector("#GovernmentPaymentPanel_OldAgeSecurity00");

    // Guaranteed Income Supplement (GIS)
    private final By guaranteedIncomeSupplementCheckbox =
            By.cssSelector("#GovernmentPaymentPanel_GuaranteedIncomeSupplement00");

    // Spousal Allowance
    private final By spousalAllowanceCheckbox =
            By.cssSelector("#GovernmentPaymentPanel_SpousalAllowance00");

    // Allowance for the Survivor Program
    private final By survivorAllowanceCheckbox =
            By.cssSelector("#GovernmentPaymentPanel_SurvivorAllowanceProgram00");


    // =========================
    // GAINS
    // =========================

    // Guaranteed Annual Income System
    private final By gainsPaymentCheckbox =
            By.cssSelector("#GainsPaymentPanel_GainsPayment00");

    // =========================
    // EMPLOYMENT INSURANCE
    // =========================

    // Employment Insurance (EI)
    private final By employmentInsuranceCheckbox =
            By.cssSelector("#EIPaymentPanel_EIPayment00");


    // =========================
    // STUDENT LOANS
    // =========================

    // OSAP Living Allowance
    private final By osapLivingAllowanceCheckbox =
            By.cssSelector("#StudentLoanPaymentPanel_OSAPPayment00");

    // Other Student Loan (Living Allowance)
    private final By otherStudentLoanCheckbox =
            By.cssSelector("#StudentLoanPaymentPanel_OtherStudentLoanPayment00");

    // =========================
    // OTHER INCOME
    // =========================

    // Other Income Sources
    private final By otherIncomeCheckbox =
            By.cssSelector("#OtherIncomePanel_OtherIncome00");


    // =========================
    // NONE OF THE ABOVE
    // =========================

    // None of the above
    private final By noneOfTheAboveCheckbox =
            By.cssSelector("label[for='NoneOfAbove0']");





    // -----------------------------
    // Actions (public API)
    // -----------------------------

    private void setHHIncome(List<String> householdIncome) {
        if (householdIncome == null || householdIncome.isEmpty()) {
            utility.click(noneOfTheAboveCheckbox);
        }
    }


    public void complete(ApplicantInfo applicantInfo){
        if(!utility.isElementPresent(By.id("household-income.page.title"))) {
            Logger.info("Skipping : " + pageTitle.toString());
            return;
        }
        Logger.info("Filling : " + pageTitle.toString());
        //Is anyone included in the application eligible for or getting money from anywhere else, like the government, or a pension or investments?
        this.setHHIncome(applicantInfo.houseHoldIncome);
        utility.click(saveAndContinueBtn);
    }
}
