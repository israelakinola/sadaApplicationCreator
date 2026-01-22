package org.sada.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Declaration extends BasePage{
    public final By pageTitle = By.id("consent.page.title");
    public Declaration(WebDriver driver) {
        super(driver);
    }

    public void createDeclaration(){
        System.out.println("Creating ConsentForm");
        if(applicantInfo.ODSP && !applicantInfo.multiProgram){
            utility.clickCheckbox(By.id("consent.declaration-checkbox-option1"), By.cssSelector("label[for='consent.declaration-checkbox-option1']"));
        }else{
            utility.click(By.cssSelector("label[for='consent.EoReferral.consent-checkbox-checkbox-option1']"));
            utility.click(By.cssSelector("label[for='consent.declaration-checkbox-option1']"));
        }
        utility.click(By.id("continue-button"));
        System.out.println("Created ConsentForm");
    }
}
