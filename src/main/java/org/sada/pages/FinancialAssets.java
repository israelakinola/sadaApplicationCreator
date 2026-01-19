package org.sada.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FinancialAssets extends BasePage {
    public final By pageTitle = By.id("financial-assets.page.title");
    public FinancialAssets(WebDriver driver) {
        super(driver);
    }

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


}
