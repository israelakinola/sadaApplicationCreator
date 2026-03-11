package org.sada.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sada.ApplicantInfo;

public class FinancialAssetsPage extends BasePage {
    public final By pageTitle = By.id("financial-assets.page.title");
    public FinancialAssetsPage(WebDriver driver) {
        super(driver);
    }

    /* -----------------------------
       Locators (class properties)
     ----------------------------- */

    // Cryptocurrency
    private final By cryptocurrencyCheckbox =
            By.cssSelector("input#FACryptocurrency0");

    // Cash
    private final By cashCheckbox =
            By.cssSelector("input#FACash0");

    // Registered investments (TFSA, RRIF, RRSP)
    private final By registeredInvestmentsCheckbox =
            By.cssSelector("input#FARegisteredInv0");

    // Bank accounts
    private final By bankAccountsCheckbox =
            By.cssSelector("input#FABankAccounts0");

    // Investments (Bonds, GICs, mutual funds)
    private final By investmentsCheckbox =
            By.cssSelector("input#FAInvestments0");

    // Vehicles
    private final By vehiclesCheckbox =
            By.cssSelector("input#FAVehicles0");

    // Trust fund - OPGT
    private final By trustFundOpgtCheckbox =
            By.cssSelector("input#FATrustFundPanel_FATrustFundOPGT00");

    // Trust fund - Agency or private trust
    private final By trustFundOtherCheckbox =
            By.cssSelector("input#FATrustFundPanel_FATrustFundOther00");

    // Other assets
    private final By otherAssetsCheckbox =
            By.cssSelector("input#FAOtherAssets0");

    // None of the above
    private final By noneOfTheAboveCheckboxInput =
            By.id("FANoneOfAbove0");
    private final By noneOfTheAboveCheckboxLabel =
            By.cssSelector("label[for='FANoneOfAbove0']");

    // Has anyone sold or given away assets? - YES
    private final By soldOrGivenAwayAssetsYesLabel =
            By.cssSelector("label[for='FASoldOrGiveAwayAssets-radio-button-option-0']");

    // Has anyone sold or given away assets? - NO
    private final By soldOrGivenAwayAssetsNoLabel =
            By.cssSelector("label[for='FASoldOrGiveAwayAssets-radio-button-option-1']");

    // -----------------------------
    // Actions (public API)
    // -----------------------------

    public void setGivenAwayAssets(boolean givenAwayAssets){
        if(givenAwayAssets){
            utility.click(soldOrGivenAwayAssetsYesLabel);
        }else{
            utility.click(soldOrGivenAwayAssetsNoLabel);
        }
    }

    public void setNoneOfTheAboveCheckbox(){
        utility.clickCheckbox(noneOfTheAboveCheckboxInput, noneOfTheAboveCheckboxLabel);
    }

    public void complete(ApplicantInfo applicantInfo){
        if(utility.isElementPresent(By.id("financial-assets.page.title"))) {
            this.setNoneOfTheAboveCheckbox();
            this.setGivenAwayAssets(false);
            utility.click(By.id("financial-assets-save-continue-button"));
        }
    }

}
