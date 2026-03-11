package org.sada.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sada.ApplicantInfo;
import org.sada.util.Logger;

public class ReviewApplicationPage extends BasePage {

    public ReviewApplicationPage(WebDriver driver) {
        super(driver);
    }
    public void complete(ApplicantInfo applicantInfo){
        if(utility.isElementPresent(By.id("review.page.title"))) {
            utility.click(By.id("review-save-continue-button"));
        }
    }
}
