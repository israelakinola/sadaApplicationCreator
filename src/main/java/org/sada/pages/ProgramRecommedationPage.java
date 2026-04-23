package org.sada.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sada.data.ApplicantInfo;
import org.sada.util.Logger;

public class ProgramRecommedationPage extends BasePage{
    private final By pageTitle = By.id("program-recommendation.page.title");
    // Dialog
    private final By dialogButton = By.id("dialog-button");

    // Radio button option
    private final By onwodsRadioButtonOptionLabel = By.id("onwods-radio-button-option-label");

    // Save and continue
    private final By programRecommendationSaveContinueBtn = By.id("program-recommendation-save-continue-button");

    public ProgramRecommedationPage(WebDriver driver) {super(driver);}
    public void complete(ApplicantInfo applicantInfo){
        //Program recommendation
        if(!utility.isElementPresent(pageTitle)) {
            Logger.info("Skipping : " + pageTitle.toString());
            return;
        }
        Logger.info("Filling : " + pageTitle.toString());

        //Click On the Multi Program when  Applicant is eligible
        if(applicantInfo.multiProgram){
            utility.click(onwodsRadioButtonOptionLabel);
        }

        //Click On the Single Recommended Program
        utility.click(programRecommendationSaveContinueBtn );

        //Confirmation Button
        utility.click(dialogButton);
    }
}
