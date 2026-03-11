package org.sada.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sada.ApplicantInfo;
import org.sada.util.Logger;
import org.sada.util.Utility;

public class MyBAccountPage extends BasePage {


    /* -----------------------------
       Locators (class properties)
     ----------------------------- */

    private final By pageTitle = By.id("create-account.page.title");

    //Term Element
    private final By term = By.cssSelector("input[id='create-account.termAndCondition-checkbox-option1']");

    private final By createAccountBtn = By.cssSelector("button[data-e2e='createAccountBtn']");
    private final By enrollEl =  By.cssSelector("button[data-se='enroll']");
    private final By emailInputEnroll =  By.cssSelector("input[id='userProfile.email']");
    private final By passwordInputEnroll =  By.cssSelector("input[data-se='credentials.passcode']");
    private final By createBtn =  By.cssSelector("button[data-se='save']");
    private final By termEnroll =  By.cssSelector("input[id='tos_checkbox']");

    private final By signInToAnAccountBtn =  By.cssSelector("button[data-e2e='signInBtn']");
    private final By emailInputSignin =  By.cssSelector("input[data-se='identifier']");
    private final By passwordInputSignin =  By.cssSelector("input[data-se='credentials.passcode']");
    private final By signInBtn =  By.cssSelector("button[data-se='save']");



    public MyBAccountPage(WebDriver driver) {
        super(driver);
    }

    // -----------------------------
    // Actions (public API)
    // -----------------------------

    private void createMyB(boolean asMyB, String emailAddress, String password){

        //Aggress to MyB Term
        utility.click(term);

        if (!asMyB){
            createAnAccount(emailAddress, password);
        }else{
            signInToAnAccount(emailAddress, password);
        }

        //Get Permission to continue, when my MYB is done
        String msg = Utility.askForInput("Click Enter to Continue (After MyB verification is completed?");

        By saveContinueBtn = By.id("personal-information-save-continue-button");
        if (utility.isElementPresent(saveContinueBtn)) {
            utility.clickButton(By.id("personal-information-save-continue-button"));
        }
    }


    private  void createAnAccount(String emailAddress, String password){
        utility.click(createAccountBtn);
        utility.click(enrollEl);
        utility.clearAndType(emailInputEnroll, emailAddress);
        utility.clearAndType(passwordInputEnroll, password);
        utility.click(termEnroll);
        utility.click(createBtn);
    }

    private  void signInToAnAccount(String emailAddress, String password){
        utility.click(signInToAnAccountBtn);
        utility.clearAndType(emailInputSignin, emailAddress);
        utility.clearAndType(passwordInputSignin, password);
        utility.click(signInBtn);
        By sendConfirmationEmail =  By.xpath("//button[normalize-space()='Send me an email']");;
        utility.click(sendConfirmationEmail);
    }

    public void complete(ApplicantInfo applicantInfo){
        //Setup MyB
        Utility.copyToClipboard(applicantInfo.getEmail());
        if(utility.isElementPresent(this.pageTitle)) {
            this.createMyB(applicantInfo.isHasMyB(), applicantInfo.getEmail(), applicantInfo.getPassword());
            Logger.info("Done with MYB");
        }
    }
}
