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

       setup();


    }

    private static void setup(){
        Scanner scanner = new Scanner(System.in);

        // -----------------------------
        // Ask user for environment
        // -----------------------------
        System.out.println("Select Environment:");
        System.out.println("1 - SFT3");
        System.out.println("2 - SFT2");
        System.out.print("Enter option: ");

        int envChoice = scanner.nextInt();

        String environmentUrl = switch (envChoice) {
            case 1 -> "https://test.sada.az.mcss.gov.on.ca/intake/home-page";
            case 2 -> "https://test2.sada.az.mcss.gov.on.ca/intake/home-page";
            default -> {
                System.out.println("Invalid option. Defaulting to SFT3.");
                yield "https://test.sada.az.mcss.gov.on.ca/intake/home-page";
            }
        };

        // -----------------------------
        // Ask user for application type
        // -----------------------------
        System.out.println("\nSelect Application Type:");
        System.out.println("1 - Single Applicant");
        System.out.println("2 - Married Applicant (Not Available)");
        System.out.println("3 - Family Applicant (Not Available)");
        System.out.print("Enter option: ");
        int applicantType = scanner.nextInt();

        // -----------------------------
        // Create Applicant Info
        // -----------------------------
        ApplicantInfo applicantInfo = new ApplicantInfo();

        //Ask User if Primary Applicant has a MyBenefit Account - Default is False
        applicantInfo.hasMyB = Utility.askUserYesNo(scanner, "Does Primary Applicant has a MyB account:");
        System.out.println("Has MyB Account: " + applicantInfo.hasMyB);

        //Ask User if this is a Multi Program Application
        applicantInfo.multiProgram = Utility.askUserYesNo(scanner, "Is this application a Multi Program?");
        System.out.println("Multi Program: " + applicantInfo.multiProgram);




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
                Logger.info("Started Single Application");
                new SingleApplicant(driver).createApplication(applicantInfo);
                break;

            case 2:
                Logger.info("Started Married Applicant Application");
                break;
            case 3:
                Logger.info("Started Family Applicant Application");

                break;

            default:
                System.out.println("Invalid application type selected.");
        }

        scanner.close();
    }


}