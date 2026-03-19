package org.sada.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sada.ApplicantInfo;
import org.sada.util.Logger;

public class BankDetailsPage extends BasePage {

    // -----------------------------
    // Locators
    // -----------------------------

    //Page Title
    private final By pageTitle = By.id("bank-details.page.title");
    
    private final By hasCheckingAccountNoRadio = By.cssSelector("label[for='hasChequingAccounts-radio-button-option-1']");
    private final By hasSavingsAccountNoRadio = By.cssSelector("label[for='hasSavingsAccounts-radio-button-option-1']");

    //Buttons
    private final By saveAndContinueBtn = By.id("bank-details-save-continue-button");
    private final By rightDiaLogBtn = By.id("right-dialog-button");

    public BankDetailsPage(WebDriver driver) {super(driver);}
    public void complete(ApplicantInfo applicantInfo){
        //Direct deposit details
        //Would you like to provide your banking details?
        if(!utility.isElementPresent(pageTitle)) {
            System.out.println("Skipping " + pageTitle.toString() );
            return;
        }
        Logger.info("Filling : " + pageTitle.toString());
        utility.click(hasCheckingAccountNoRadio);
        utility.click(hasSavingsAccountNoRadio);
        utility.click(saveAndContinueBtn);
        utility.click(rightDiaLogBtn);
    }
}
