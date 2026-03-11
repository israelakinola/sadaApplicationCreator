package org.sada.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sada.ApplicantInfo;
import org.sada.util.Logger;

public class SignaturePage extends BasePage {
   public SignaturePage(WebDriver driver) {super(driver);}
    public void complete(ApplicantInfo applicantInfo){
        //Signature
        if(utility.isElementPresent(By.id("eid-page.page.title"))) {
            utility.click(By.id("continue-button")); // Take me to sign Application
        }
    }
}
