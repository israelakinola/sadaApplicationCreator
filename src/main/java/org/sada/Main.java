package org.sada;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sada.applications.SingleApplicant;
import org.sada.data.ApplicantInfo;
import org.sada.util.Logger;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        ApplicantInfo applicantInfo = new ApplicantInfo();

        Logger.info("Setting Up Chrome Driver and Scripts...");
        WebDriver driver = new ChromeDriver();

        try {
            openEnvironment(driver, applicantInfo.ENV);
            executeFlow(driver, applicantInfo);
        } finally {
//            driver.quit();
        }
    }



    private static void openEnvironment(WebDriver driver, String url) {
        Logger.info("Opening environment: " + url);
        driver.get(url);
    }

    // -----------------------------
    // Flow Execution
    // -----------------------------
    private static void executeFlow(WebDriver driver, ApplicantInfo info) {
        switch (info.applicationType) {
            case 1 :
                    Logger.info("Starting Single OW Application.");
                    SingleApplicant.runSingleApplicantOnw(driver, info);
            case 2 :
                    Logger.info("Starting Single ODSP Application.");
                    SingleApplicant.runSingleApplicantOdsp(driver, info);
            case 3 :
                    Logger.info("Starting Single MultiProgram Application.");
                    SingleApplicant.runSingleMultiProgram(driver, info);
            case 4 :
                    Logger.info("Married Applicant flow not implemented yet.");
            case 5 :
                    Logger.info("Family Applicant flow not implemented yet.");
            default :
                    System.out.println("Invalid application type selected.");
        }
    }



}