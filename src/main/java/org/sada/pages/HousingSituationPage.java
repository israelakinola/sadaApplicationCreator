package org.sada.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.sada.ApplicantInfo;
import org.sada.util.Logger;

public class HousingSituationPage extends BasePage {

    private  final By pageTitle = By.id("housing-situation.page.title");
    private  final By saveAndContinueBtn = By.id("housing-situation-save-continue-button");
    /* -----------------------------
       Locators (class properties)
     ----------------------------- */

    //What is your current housing situation?
    private final By currentHousingSituation = By.id("currentHousingSituation_select");

    public HousingSituationPage(WebDriver driver) {
        super(driver);
    }

    // -----------------------------
    // Actions (public API)
    // -----------------------------
    private void  setCurrentHousingSituation(String housingSituation){
        WebElement selectEl = utility.scrollIntoView(currentHousingSituation);
        new Select(selectEl).selectByVisibleText(housingSituation);
    }

    public void complete(ApplicantInfo applicantInfo){
        if(!utility.isElementPresent(pageTitle)) {
            Logger.info("Skipping : " + pageTitle.toString());
            return;
        }
        Logger.info("Filling : " + pageTitle.toString());
        this.setCurrentHousingSituation(applicantInfo.getHousingSituation());
        utility.click(saveAndContinueBtn);
    }
}
