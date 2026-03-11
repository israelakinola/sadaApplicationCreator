package org.sada.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sada.ApplicantInfo;
import org.sada.util.Logger;

public class EidPage extends BasePage {

    public EidPage(WebDriver driver) {super(driver);}

    public void complete(ApplicantInfo applicantInfo){
        //Confirm Idenity
        if(utility.isElementPresent(By.id("eid-page.page.title"))) {
            utility.click(By.id("confirm-button"));
            if(utility.isElementPresent10(By.id("submit-button"))){
                utility.click(By.id("submit-button"));
            }

        }

    }
}
