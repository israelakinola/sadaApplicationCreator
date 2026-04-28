package org.sada.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.sada.data.ApplicantInfo;
import org.sada.util.Logger;

public class ChildrenInformation extends BasePage{
    public ChildrenInformation(WebDriver driver) {
        super(driver);
    }

    //Locators

    // Child 1
    private final By pageTitle = By.id("children-information.page.title");
    private final By child1Firstname = By.id("input-children-information.childFirstName-0");
    private final By child1Lastname = By.id("input-children-information.childLastName-0");
    private final By child1dobYearInput  = By.id("children-information-childDateOfBirth0YearInput");
    private final By child1dobMonthInput = By.id("children-information-childDateOfBirth0MonthInput");
    private final By child1dobDayInput   = By.id("children-information-childDateOfBirth0DayInput");
    private final By child1genderFemale   = By.id("children-information.childSexAtBirth-radio-button1-option-1");
    private final By child1statusInCanadaSelect = By.id("select-children-information.status.statusInCanada-1");
    private final By sinInputChild1  = By.id("input-children-information.status.sinNumber-0");
    private final By noHcnInputLabel = By.id("children-information.status.noHealthCardNumber-checkbox1-label1");
    // Continue button
    private final By continueButton = By.id("children-information-save-continue-button");
    //Actions
    // Child 1
    private void setChild1Info(ApplicantInfo applicantInfo){
        utility.clearAndType(child1Firstname, applicantInfo.firstNameChild1);
        utility.clearAndType(child1Lastname, applicantInfo.lastNameChild1);
        utility.clearAndType(child1dobYearInput, applicantInfo.DOBYearChild1);
        utility.clearAndType(child1dobMonthInput, applicantInfo.DOBMonthChild1);
        utility.clearAndType(child1dobDayInput, applicantInfo.DOBDayChild1);
        utility.click(child1genderFemale);
        //Status
        WebElement selectEl = utility.scrollIntoView(child1statusInCanadaSelect);
        new Select(selectEl).selectByVisibleText(applicantInfo.statusinCanadaSelect);
        utility.clearAndType(sinInputChild1, applicantInfo.SINChild1);
        utility.click(noHcnInputLabel);

    }

    public void complete(ApplicantInfo applicantInfo){
        if(!utility.isElementPresent(pageTitle)){
            Logger.info("Skipping : " + pageTitle.toString());
            return;
        }
        Logger.info("Filling : " + pageTitle.toString());
        setChild1Info(applicantInfo);
        utility.click(continueButton);
    }






}
