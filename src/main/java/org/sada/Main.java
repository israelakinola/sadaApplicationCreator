package org.sada;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");

        WebDriver driver = new ChromeDriver(options);
        Logger.info("Setting Up Chrome Driver and Scripts...");


        try {
            openEnvironment(driver, applicantInfo.ENV);
            executeFlow(driver, applicantInfo);

        } finally {
            Logger.info("Application Creation Done");
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

        if (info == null) {
            Logger.error("ApplicantInfo is null. Aborting execution.");
            return;
        }

        try {

            switch (info.applicationType) {

                case 1 -> {
                    Logger.info("Starting Single OW Application.");
                    SingleApplicant.runSingleApplicantOnw(driver, info);
                }

                case 2 -> {
                    Logger.info("Starting Single ODSP Application.");
                    SingleApplicant.runSingleApplicantOdsp(driver, info);
                }

                case 3 -> {
                    Logger.info("Starting Single MultiProgram Application.");
                    SingleApplicant.runSingleMultiProgram(driver, info);
                }

                case 4 -> Logger.info("Married Applicant flow not implemented yet.");

                case 5 -> Logger.info("Family Applicant flow not implemented yet.");

                default -> Logger.error("Invalid application type selected: " + info.applicationType);
            }

        } catch (Exception e) {
            Logger.error("Flow execution failed for type: " + info.applicationType);
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }



}