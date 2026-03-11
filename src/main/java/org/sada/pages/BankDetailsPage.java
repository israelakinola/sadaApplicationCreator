package org.sada.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sada.ApplicantInfo;
import org.sada.util.Logger;

public class BankDetailsPage extends BasePage {

    public BankDetailsPage(WebDriver driver) {super(driver);}
    public void complete(ApplicantInfo applicantInfo){
        //Direct deposit details
        //Would you like to provide your banking details?
        if(utility.isElementPresent(By.id("bank-details.page.title"))) {
            utility.click(By.cssSelector("label[for='hasChequingAccounts-radio-button-option-1']"));
            utility.click(By.cssSelector("label[for='hasSavingsAccounts-radio-button-option-1']"));
            utility.click(By.id("bank-details-save-continue-button"));
        }
    }
}
