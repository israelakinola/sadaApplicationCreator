package org.sada.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sada.ApplicantInfo;
import org.sada.util.Logger;
import org.sada.util.Utility;

import java.time.Duration;

public class BasePage {
    WebDriver driver;
    Utility utility;
    protected ApplicantInfo applicantInfo;



    /**
     * Helper method for yes or no questions.
     * @param yes
     * @param yesLocator
     * @param noLocator
     */
    protected void selectYesNo(boolean yes, By yesLocator, By noLocator) {
        utility.click(yes ? yesLocator : noLocator);
    }

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        utility = new Utility(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }




}
