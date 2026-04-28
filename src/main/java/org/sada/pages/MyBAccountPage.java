package org.sada.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sada.data.ApplicantInfo;
import org.sada.util.Logger;
import org.sada.util.MailTmService;
import org.sada.util.Utility;

import java.time.Duration;

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

    //Verification
    private final By verifyInputBtn =
            By.xpath("//button[normalize-space()='Enter a verification code']");
    private final By verifyInput = By.id("credentials.passcode");
    private final By verifyBtn = By.xpath("//button[normalize-space()='Verify']");
    private final By skipEnteringEmailCode = By.xpath("//button[normalize-space()='Skip entering in the code']");


    // -----------------------------
    // Constructor
    // -----------------------------
    public MyBAccountPage(WebDriver driver) {
        super(driver);
    }

    // -----------------------------
    // Actions
    // -----------------------------
    private void createMyB(ApplicantInfo applicantInfo) {
        // Agree to MyB Terms
        utility.click(term);

        createAnAccount(applicantInfo.email, applicantInfo.password);
        Logger.info("Input the Code sent to the email (expires in 6min): " + applicantInfo.email);
        askVerificationCode();

    }

    private void createAnAccount(String emailAddress, String password) {
        utility.click(createAccountBtn);
        utility.click(enrollEl);
        utility.clearAndType(emailInputEnroll, emailAddress);
        utility.clearAndType(passwordInputEnroll, password);
        utility.click(termEnroll);
        utility.click(createBtn);
    }



    private void askVerificationCode() {
        utility.click(verifyInputBtn);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(360));

        WebElement input = wait.until(driver -> {
            WebElement el = driver.findElement(verifyInput);
            String value = el.getAttribute("value");
            return (value != null && !value.isEmpty()) ? el : null;
        });

        if (utility.isElementPresent(verifyBtn)) {
            utility.click(verifyBtn);
        }

        if (utility.isElementPresent(skipEnteringEmailCode)) {
            utility.click(skipEnteringEmailCode);
        }
    }

    public void complete(ApplicantInfo applicantInfo) {
        if (!utility.isElementPresent(pageTitle)) {
            Logger.info("Skipping : " + pageTitle.toString());
            return;
        }
        createMyB(applicantInfo);
        utility.click(saveContinueBtn);

    }
}