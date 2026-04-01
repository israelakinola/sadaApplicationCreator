package org.sada;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sada.applications.SingleApplicant;
import org.sada.util.Logger;
import org.sada.util.Utility;

import java.time.Duration;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            run(scanner);
        }
    }

    private static void run(Scanner scanner) {
        String environmentUrl = getEnvironment(scanner);
        int applicantType = getApplicantType(scanner);
        ApplicantInfo applicantInfo = buildApplicantInfo(scanner);

        WebDriver driver = createDriver();

        try {
            openEnvironment(driver, environmentUrl);
            executeFlow(driver, applicantType, applicantInfo);
        } finally {
//            driver.quit();
        }
    }

    // -----------------------------
    // Input Handlers
    // -----------------------------
    private static String getEnvironment(Scanner scanner) {
        System.out.println("Select Environment:");
        System.out.println("1 - SFT3");
        System.out.println("2 - SFT2");
        System.out.print("Enter option: ");

        int choice = scanner.nextInt();

        return switch (choice) {
            case 1 -> "https://test.sada.az.mcss.gov.on.ca/intake/home-page";
            case 2 -> "https://test2.sada.az.mcss.gov.on.ca/intake/home-page";
            default -> {
                System.out.println("Invalid option. Defaulting to SFT3.");
                yield "https://test.sada.az.mcss.gov.on.ca/intake/home-page";
            }
        };
    }

    private static int getApplicantType(Scanner scanner) {
        System.out.println("\nSelect Application Type:");
        System.out.println("1 - Single Applicant");
        System.out.println("2 - Married Applicant (Not Available)");
        System.out.println("3 - Family Applicant (Not Available)");
        System.out.print("Enter option: ");

        return scanner.nextInt();
    }

    private static ApplicantInfo buildApplicantInfo(Scanner scanner) {
        ApplicantInfo info = new ApplicantInfo();

//        info.hasMyB = Utility.askUserYesNo(scanner, "Does Primary Applicant have a MyB account:");
        info.multiProgram = Utility.askUserYesNo(scanner, "Is this a Multi Program application?");
        info.hasDisability = info.multiProgram;

        return info;
    }

    // -----------------------------
    // WebDriver Setup
    // -----------------------------
    private static WebDriver createDriver() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        return driver;
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
            case 1 -> runSingleApplicant(driver, info);
            case 2 -> Logger.info("Married Applicant flow not implemented yet.");
            case 3 -> Logger.info("Family Applicant flow not implemented yet.");
            default -> System.out.println("Invalid application type selected.");
        }
    }

    private static void runSingleApplicant(WebDriver driver, ApplicantInfo info) {
        Logger.info("Started Single Application");
        info.maritalStatus = "Single";
        new SingleApplicant(driver).createApplication(info);
    }
}