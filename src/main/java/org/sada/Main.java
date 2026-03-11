package org.sada;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sada.applications.SingleApplicant;
import org.sada.util.Logger;

import java.time.Duration;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // -----------------------------
        // Ask user for environment
        // -----------------------------
        System.out.println("Select Environment:");
        System.out.println("1 - SFT3");
        System.out.println("2 - SFT2");
        System.out.print("Enter option: ");

        int envChoice = scanner.nextInt();

        String environmentUrl;

        switch (envChoice) {
            case 1:
                environmentUrl = "https://test.sada.az.mcss.gov.on.ca/intake/home-page";
                break;
            case 2:
                environmentUrl = "https://test2.sada.az.mcss.gov.on.ca/intake/home-page";
                break;
            default:
                System.out.println("Invalid option. Defaulting to SFT3.");
                environmentUrl = "https://test.sada.az.mcss.gov.on.ca/intake/home-page";
        }

        // -----------------------------
        // Ask user for application type
        // -----------------------------
        System.out.println("\nSelect Application Type:");
        System.out.println("1 - Single Applicant (OWN)");
        System.out.println("2 - Married Applicant");
        System.out.print("Enter option: ");

        int applicantType = scanner.nextInt();

        // -----------------------------
        // Create Applicant Info
        // -----------------------------
        ApplicantInfo applicantInfo = new ApplicantInfo();

        // -----------------------------
        // Start WebDriver
        // -----------------------------
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        Logger.info("Opening environment: " + environmentUrl);
        driver.get(environmentUrl);

        // -----------------------------
        // Run Application Flow
        // -----------------------------
        switch (applicantType) {

            case 1:
                Logger.info("Started Single OWN Application");
                new SingleApplicant(driver).createApplication(applicantInfo);
                break;

            case 2:
                Logger.info("Started Married Applicant Application");
                // new MultipleApplicant(driver).createApplication(applicantInfo);
                break;

            default:
                System.out.println("Invalid application type selected.");
        }

        scanner.close();
    }
}