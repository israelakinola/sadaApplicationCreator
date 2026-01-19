package org.sada.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sada.ApplicantInfo;
import org.sada.util.Utility;

import java.time.Duration;

public class BasePage {
    WebDriver driver;
    Utility utility;
    By newApplication = By.id("continue-button");
    protected ApplicantInfo applicantInfo;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        utility = new Utility(driver);
        applicantInfo = new ApplicantInfo();
    }
    public void startNewApplication(){
       driver.findElement(newApplication).click();
    }

}
