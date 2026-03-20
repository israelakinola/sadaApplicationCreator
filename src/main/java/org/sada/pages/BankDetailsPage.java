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

    private final By hasCheckingAccountYesRadio = By.cssSelector("label[for='hasChequingAccounts-radio-button-option-0']");
    private final By hasCheckingAccountNoRadio = By.cssSelector("label[for='hasChequingAccounts-radio-button-option-1']");

    private final By hasSavingsAccountYesRadio = By.cssSelector("label[for='hasSavingsAccounts-radio-button-option-0']");
    private final By hasSavingsAccountNoRadio = By.cssSelector("label[for='hasSavingsAccounts-radio-button-option-1']");

    //Buttons
    private final By saveAndContinueBtn = By.id("bank-details-save-continue-button");
    private final By rightDiaLogBtn = By.id("right-dialog-button");

    public BankDetailsPage(WebDriver driver) {super(driver);}

    protected void setChequingAcct(boolean hasChequingAcct){
        if(hasChequingAcct){
            utility.click(hasCheckingAccountYesRadio);
        }else{
            utility.click(hasCheckingAccountNoRadio);
        }
    }

    protected void setSavingsAcct(boolean hasSavingsAcct){
        if(hasSavingsAcct){
            utility.click(hasSavingsAccountYesRadio);
        }else{
            utility.click(hasSavingsAccountNoRadio);
        }
    }

    public void complete(ApplicantInfo applicantInfo){
        //Direct deposit details
        //Would you like to provide your banking details?
        if(!utility.isElementPresent(pageTitle)) {
            System.out.println("Skipping " + pageTitle.toString() );
            return;
        }
        Logger.info("Filling : " + pageTitle.toString());
        //Do you have a checquing account?
        setChequingAcct(applicantInfo.hasChecquingAcct);

        //Do you have a savings account?
        setSavingsAcct(applicantInfo.hasSavingsAcct);

        utility.click(saveAndContinueBtn);
        //Confirm I have no back Account
        utility.click(rightDiaLogBtn);
    }
}
