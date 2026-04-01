package org.sada.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sada.ApplicantInfo;
import org.sada.util.Logger;

import java.util.List;

public class FinancialAssetsPage extends BasePage {

    // -----------------------------
    // Locators
    // -----------------------------
    private final By pageTitle = By.id("financial-assets.page.title");
    private final By saveAndContinueBtn = By.id("financial-assets-save-continue-button");

    private final By cryptocurrencyCheckbox = By.cssSelector("input#FACryptocurrency0");
    private final By cashCheckbox = By.cssSelector("input#FACash0");
    private final By registeredInvestmentsCheckbox = By.cssSelector("input#FARegisteredInv0");
    private final By bankAccountsCheckbox = By.cssSelector("input#FABankAccounts0");
    private final By investmentsCheckbox = By.cssSelector("input#FAInvestments0");
    private final By vehiclesCheckbox = By.cssSelector("input#FAVehicles0");
    private final By trustFundOpgtCheckbox = By.cssSelector("input#FATrustFundPanel_FATrustFundOPGT00");
    private final By trustFundOtherCheckbox = By.cssSelector("input#FATrustFundPanel_FATrustFundOther00");
    private final By otherAssetsCheckbox = By.cssSelector("input#FAOtherAssets0");

    private final By noneOfTheAboveCheckboxInput = By.id("FANoneOfAbove0");
    private final By noneOfTheAboveCheckboxLabel = By.cssSelector("label[for='FANoneOfAbove0']");

    private final By soldOrGivenAwayAssetsYesLabel =
            By.cssSelector("label[for='FASoldOrGiveAwayAssets-radio-button-option-0']");
    private final By soldOrGivenAwayAssetsNoLabel =
            By.cssSelector("label[for='FASoldOrGiveAwayAssets-radio-button-option-1']");

    // -----------------------------
    // Constructor
    // -----------------------------
    public FinancialAssetsPage(WebDriver driver) {
        super(driver);
    }

    // -----------------------------
    // Actions
    // -----------------------------
    protected void setGivenAwayAssets(boolean givenAwayAssets) {
        if (givenAwayAssets) {
            utility.click(soldOrGivenAwayAssetsYesLabel);
        } else {
            utility.click(soldOrGivenAwayAssetsNoLabel);
        }
    }



    protected void setAssets(List<String> assets) {
        if (assets == null || assets.isEmpty()) {
            utility.click(noneOfTheAboveCheckboxInput);
        }

    }
    public void complete(ApplicantInfo applicantInfo) {

        if (!utility.isElementPresent(pageTitle)) {
            Logger.info("Skipping : " + pageTitle.toString());
            return;
        }
        Logger.info("Filling : " + pageTitle.toString());
        //Does anyone included in the application, own items of value such as investments, a car or motorcycle?
        setAssets(applicantInfo.assets);

        //Has anyone included in the application sold or given away any assets or items of value in the last year?
        setGivenAwayAssets(applicantInfo.givenAwayAssets);
        utility.click(saveAndContinueBtn);
    }
}