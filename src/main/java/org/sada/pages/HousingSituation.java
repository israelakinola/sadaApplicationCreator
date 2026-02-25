package org.sada.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.sada.util.Utility;

public class HousingSituation extends BasePage {


    /* -----------------------------
       Locators (class properties)
     ----------------------------- */

    //What is your current housing situation?
    private final By currentHousingSituation = By.id("currentHousingSituation_select");

    public HousingSituation(WebDriver driver) {
        super(driver);
    }

    // -----------------------------
    // Actions (public API)
    // -----------------------------
    public void  setCurrentHousingSituation(String housingSituation){
        WebElement selectEl = utility.scrollIntoView(currentHousingSituation);
        new Select(selectEl).selectByVisibleText(housingSituation);
    }
}
