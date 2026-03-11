package org.sada.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.sada.ApplicantInfo;
import org.sada.util.Logger;

public class DemographicInformationPage extends BasePage{

    /* -----------------------------
       Locators (class properties)
     ----------------------------- */
    public final By pageTitle = By.cssSelector("h1[data-e2e='pageTitle']");
    //What is your current housing situation?
    private final By gender = By.id("select-demographic-information.genderIdentity");

    //Do you identify as Indigenous?
    private final By indigenous = By.id("select-demographic-information.indigenousIdentity");

    //Which race category best describes you
    private final By race = By.id("select-demographic-information.racialIdentity");

    //Do you identify as a visible minority
    private final By minority = By.id("select-demographic-information.visibleMinority");

    //What is your language of choice
    private final By language = By.id("select-demographic-information.language");


    // -----------------------------
    // Actions (public API)
    // -----------------------------

    public DemographicInformationPage(WebDriver driver) {
        super(driver);
    }


    public void  setDemographicsInformation(String inputGender, String inputIndigenous, String inputRace, String inputMinority, String inputLanguage){
        if(utility.isElementPresent(gender)){
            WebElement selectElGender = utility.scrollIntoView(gender);
            new Select(selectElGender).selectByVisibleText(inputGender);

            WebElement selectElIndigenous = utility.scrollIntoView(indigenous);
            new Select(selectElIndigenous).selectByVisibleText(inputIndigenous);

            WebElement selectElRace = utility.scrollIntoView(race);
            new Select(selectElRace).selectByVisibleText(inputRace);

            WebElement selectElMinority = utility.scrollIntoView(minority);
            new Select(selectElMinority).selectByVisibleText(inputMinority);

            WebElement selectElLanguage = utility.scrollIntoView(language);
            new Select(selectElLanguage).selectByVisibleText(inputLanguage);

            utility.click(By.id("continue-button"));
            utility.click(By.id("continue-button"));
        }
    }

    public void complete(ApplicantInfo applicantInfo){
        //Demographic
        if(utility.isElementPresent10(By.id("demographic-information.page.title"))) {//Wait for 10second when checking element
            utility.click(By.id("continue-button"));
            this.setDemographicsInformation(applicantInfo.demograhicGender, applicantInfo.demograhicIndigenouse, applicantInfo.demograhicRace,
                    applicantInfo.demograhicVisibleMinority,  applicantInfo.demograhicLanguage);

        }
    }
}

