package org.sada.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.sada.data.ApplicantInfo;
import org.sada.util.Logger;

public class DemographicInformationPage extends BasePage{

    private final By pageTitle = By.id("demographic-information.page.title");
    //Button
    private final By continueBtn = By.id("continue-button");
    /* -----------------------------
       Locators (class properties)
     ----------------------------- */
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
            //What gender do you identify as?
            WebElement selectElGender = utility.scrollIntoView(gender);
            new Select(selectElGender).selectByVisibleText(inputGender);

            //Do you identify as Indigenous?
            WebElement selectElIndigenous = utility.scrollIntoView(indigenous);
            new Select(selectElIndigenous).selectByVisibleText(inputIndigenous);

            //Which race category best describes you?
            WebElement selectElRace = utility.scrollIntoView(race);
            new Select(selectElRace).selectByVisibleText(inputRace);

            //Do you identify as a visible minority?
            WebElement selectElMinority = utility.scrollIntoView(minority);
            new Select(selectElMinority).selectByVisibleText(inputMinority);

            //What is your language of choice?
            WebElement selectElLanguage = utility.scrollIntoView(language);
            new Select(selectElLanguage).selectByVisibleText(inputLanguage);

            utility.click(continueBtn);
            utility.click(continueBtn);
        }
    }

    public void complete(ApplicantInfo applicantInfo){
        //Demographic
        if(!utility.isElementPresent10(pageTitle)) {
            Logger.info("Skipping : " + pageTitle.toString());
           return;
        }
        Logger.info("Filling : " + pageTitle.toString());
        utility.click(continueBtn);
        for(int i = 0; i < applicantInfo.applicationType; i++){
            this.setDemographicsInformation(applicantInfo.demograhicGender, applicantInfo.demograhicIndigenouse, applicantInfo.demograhicRace,
                    applicantInfo.demograhicVisibleMinority,  applicantInfo.demograhicLanguage);
        }
    }
}

