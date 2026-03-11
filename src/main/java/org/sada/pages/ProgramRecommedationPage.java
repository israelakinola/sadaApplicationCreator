package org.sada.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sada.ApplicantInfo;
import org.sada.util.Logger;

public class ProgramRecommedationPage extends BasePage{
    public ProgramRecommedationPage(WebDriver driver) {super(driver);}
    public void complete(ApplicantInfo applicantInfo){
        //Program recommendation
        if(utility.isElementPresent(By.id("program-recommendation.page.title"))) {
            Logger.info("Creating program-recommendation");

            //Click On the Multi Program when  Applicant is eligible
            if(applicantInfo.isMultiProgram()){
                utility.click(By.id("onwods-radio-button-option-label"));
            }

            //Click On the Single Recommended Program
            utility.click(By.id("program-recommendation-save-continue-button"));

            //Confirmation Button
            utility.click(By.id("dialog-button"));

        }
    }
}
