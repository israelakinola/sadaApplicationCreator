package org.sada;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.sada.applications.SingleApplicant;
import org.sada.util.Logger;
import org.sada.util.Utility;

import java.time.Duration;
import java.util.Scanner;

import static org.sada.applications.SingleApplicant.runSingleApplicantOdsp;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            run(scanner);
        }
    }

    private static void run(Scanner scanner) {
        int applicantType = getApplicantType(scanner);
        ApplicantInfo applicantInfo = new ApplicantInfo();

        WebDriver driver = new ChromeDriver();

        System.out.println("Welcome to the Single Application!");

        try {
            openEnvironment(driver, applicantInfo.ENV);
            executeFlow(driver, applicantType, applicantInfo);
        } finally {
//            driver.quit();
        }
    }

    // -----------------------------
    // Input Handlers
    // -----------------------------
    private static int getApplicantType(Scanner scanner) {
        System.out.println("\nSelect Application Type:");
        System.out.println("1 - Single Applicant - Ontario Works");
        System.out.println("2 - Single Applicant - ODSP");
        System.out.println("3 - Single Applicant - MultiProgram");
        System.out.println("4 - Married Applicant (Not Available)");
        System.out.println("5 - Family Applicant (Not Available)");
        System.out.print("Enter option: ");

        return scanner.nextInt();
    }




    private static void openEnvironment(WebDriver driver, String url) {
        Logger.info("Opening environment: " + url);
        driver.get(url);
    }

    // -----------------------------
    // Flow Execution
    // -----------------------------
    private static void executeFlow(WebDriver driver, int applicantType, ApplicantInfo info) {
        switch (applicantType) {
            case 1 -> SingleApplicant.runSingleApplicantOnw(driver, info);
            case 2 -> SingleApplicant.runSingleApplicantOdsp(driver, info);
            case 3 -> SingleApplicant.runSingleMultiProgram(driver, info);
            case 4 -> Logger.info("Married Applicant flow not implemented yet.");
            case 5 -> Logger.info("Family Applicant flow not implemented yet.");
            default -> System.out.println("Invalid application type selected.");
        }
    }



}