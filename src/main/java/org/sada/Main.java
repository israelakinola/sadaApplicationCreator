package org.sada;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sada.applications.MultipleApplicant;
import org.sada.applications.SingleApplicant;
import org.sada.util.*;

import java.time.Duration;

public class Main {

    public static void main(String[] args) {
        //SADA Environments
        String SFT3 = "https://test.sada.az.mcss.gov.on.ca/intake/home-page";
        String SFT2 = "https://test2.sada.az.mcss.gov.on.ca/intake/home-page";

        //Create Applicant Info
        ApplicantInfo applicantInfo = createApplicantInfo();



        //Create SADA Application
        CreateSadaApplication(SFT2, applicantInfo);

    }

    /**
     *
     * Update Applican Info Here
     * @return
     */
    private static ApplicantInfo createApplicantInfo(){
        // Application Information
        String maritalStatus = "Single";
        boolean ODSP = true;
        boolean multiProgram = false;
        boolean hasMyB = true;
        String firstName = "Aliw";
        String lastName = "Nukepet";
        String SIN = "239 669 518";



        return new ApplicantInfo(maritalStatus, ODSP, multiProgram, hasMyB, firstName, lastName, SIN);
    }


    private static void CreateSadaApplication(String sadaEnv, ApplicantInfo applicantInfo) {
       //Set Chrome Driver

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.get(sadaEnv);
        Logger.info("Sada Application Creation Started");

        String applicantType =  applicantInfo.getMaritalStatus().toUpperCase();
        switch(applicantType){
            case "SINGLE":
                Logger.info("Started Single applicant");
                new SingleApplicant(driver).createApplication(applicantInfo);
                break;
            case "MARRIED":
                Logger.info("Started Married applicant");
                new MultipleApplicant(driver).createApplication(applicantInfo);
                break;
        }

    }


}
