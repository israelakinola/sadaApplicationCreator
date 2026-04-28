package org.sada;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.sada.applications.FamilyApplicant;
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

                case 4 -> {
                    Logger.info("Starting Family OW Application.");
                    FamilyApplicant.runFamilyApplicantOnw(driver, info);
                }

                case 5 -> {
                    Logger.info("Starting Family ODSP Application.");
                    FamilyApplicant.runFamilyApplicantOdsp(driver, info);
                }

                case 6 -> {
                    Logger.info("Starting Family MultiProgram Application.");
                    FamilyApplicant.runFamilyApplicantMultiProgram(driver, info);
                }



                default -> Logger.error("Invalid application type selected: " + info.applicationType);
            }

        } catch (Exception e) {
            Logger.error("Flow execution failed for type: " + info.applicationType);
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }



}