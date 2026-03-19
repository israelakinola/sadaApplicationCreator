package org.sada.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sada.ApplicantInfo;
import org.sada.util.Logger;
import org.sada.util.Utility;

public class MyBAccountPage extends BasePage {

    // -----------------------------
    // Locators
    // -----------------------------
    private final By pageTitle = By.id("create-account.page.title");

    private final By sendConfirmationEmail = By.xpath("//button[normalize-space()='Send me an email']");
    private final By saveContinueBtn = By.id("personal-information-save-continue-button");

    // Term & Condition
    private final By term = By.cssSelector("input[id='create-account.termAndCondition-checkbox-option1']");

    // Create Account elements
    private final By createAccountBtn = By.cssSelector("button[data-e2e='createAccountBtn']");
    private final By enrollEl = By.cssSelector("button[data-se='enroll']");
    private final By emailInputEnroll = By.cssSelector("input[id='userProfile.email']");
    private final By passwordInputEnroll = By.cssSelector("input[data-se='credentials.passcode']");
    private final By createBtn = By.cssSelector("button[data-se='save']");
    private final By termEnroll = By.cssSelector("input[id='tos_checkbox']");

    // Sign In elements
    private final By signInToAnAccountBtn = By.cssSelector("button[data-e2e='signInBtn']");
    private final By emailInputSignin = By.cssSelector("input[data-se='identifier']");
    private final By passwordInputSignin = By.cssSelector("input[data-se='credentials.passcode']");
    private final By signInBtn = By.cssSelector("button[data-se='save']");

    // -----------------------------
    // Constructor
    // -----------------------------
    public MyBAccountPage(WebDriver driver) {
        super(driver);
    }

    // -----------------------------
    // Actions
    // -----------------------------
    private void createMyB(boolean asMyB, String emailAddress, String password) {

        // Agree to MyB Terms
        utility.click(term);

        if (!asMyB) {
            createAnAccount(emailAddress, password);
        } else {
            signInToAnAccount(emailAddress, password);
        }

        // Prompt user to complete MyB verification
        Logger.info("Done with MyB verification");
        System.out.println("\nComplete the rest of MyB verification until you return to the application page.");
        Utility.askForInput("Press 'Enter' to continue after MyB verification is completed: ");

        // Continue application
        if (utility.isElementPresent(saveContinueBtn)) {
            utility.clickButton(saveContinueBtn);
        }
    }

    private void createAnAccount(String emailAddress, String password) {
        utility.click(createAccountBtn);
        utility.click(enrollEl);
        utility.clearAndType(emailInputEnroll, emailAddress);
        utility.clearAndType(passwordInputEnroll, password);
        utility.click(termEnroll);
        utility.click(createBtn);
    }

    private void signInToAnAccount(String emailAddress, String password) {
        utility.click(signInToAnAccountBtn);
        utility.clearAndType(emailInputSignin, emailAddress);
        utility.clearAndType(passwordInputSignin, password);
        utility.click(signInBtn);
        utility.click(sendConfirmationEmail);
    }

    public void complete(ApplicantInfo applicantInfo) {
        Utility.copyToClipboard(applicantInfo.getEmail());

        if (!utility.isElementPresent(pageTitle)) {
            Logger.info("Skipping : " + pageTitle.toString());
            return;
        }
        Logger.info("Filling : " + pageTitle.toString());
        createMyB(applicantInfo.isHasMyB(), applicantInfo.getEmail(), applicantInfo.getPassword());

    }
}