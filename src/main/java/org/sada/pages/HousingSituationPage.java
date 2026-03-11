package org.sada.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.sada.ApplicantInfo;

public class HousingSituationPage extends BasePage {


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
        if(utility.isElementPresent( By.id("housing-situation.page.title"))) {
            HousingSituationPage housingSituation = new HousingSituationPage(driver);
            this.setCurrentHousingSituation(applicantInfo.getHousingSituation());
            utility.click(By.id("housing-situation-save-continue-button"));
        }
    }
}
