package org.sada.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Confirmation extends BasePage {
    public Confirmation(WebDriver driver) {
        super(driver);
    }

    private final By refCode = By.id("ref-code");

    public String getRefCode(){
        return driver.findElement(refCode).getText();
    }

}
