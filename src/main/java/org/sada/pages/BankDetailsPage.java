package org.sada.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sada.ApplicantInfo;
import org.sada.util.Logger;

public class BankDetailsPage extends BasePage {

    //Page Title
    private final By pageTitle = By.id("bank-details.page.title");
    
    private final By hasCheckingAccountNoRadio = By.cssSelector("label[for='hasChequingAccounts-radio-button-option-1']");
    private final By hasSavingsAccountNoRadio = By.cssSelector("label[for='hasSavingsAccounts-radio-button-option-1']");

    //Buttons
    private final By saveAndContinueBtn = By.id("bank-details-save-continue-button");

    public BankDetailsPage(WebDriver driver) {super(driver);}
    public void complete(ApplicantInfo applicantInfo){
        //Direct deposit details
        //Would you like to provide your banking details?
        if(!utility.isElementPresent(pageTitle)) {
            return;
        }
        utility.click(hasCheckingAccountNoRadio);
        utility.click(hasSavingsAccountNoRadio);
        utility.click(saveAndContinueBtn);
    }
}
