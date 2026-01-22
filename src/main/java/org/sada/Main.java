package org.sada;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sada.applications.MultipleApplicant;
import org.sada.applications.SingleApplicant;


public class Main {


    public static void main(String[] args) {
        String SFT3 = "https://test.sada.az.mcss.gov.on.ca/intake/home-page";
        String SFT2 = "https://test2.sada.az.mcss.gov.on.ca/intake/home-page";
        ApplicantInfo applicantInfo = new ApplicantInfo();
        CreateSADAApplication(SFT3, applicantInfo);

    }


    private static void CreateSADAApplication(String env, ApplicantInfo applicantInfo) {
        WebDriver driver = new ChromeDriver();
        driver.get(env);
        String applicantType =  applicantInfo.maritalStatus;
        if(applicantType.equalsIgnoreCase("single")){
            SingleApplicant single = new SingleApplicant(driver, applicantInfo);
            single.createApplication();
        }else if(applicantType.equalsIgnoreCase("married")){
            MultipleApplicant multiple = new MultipleApplicant(driver, applicantInfo);
            multiple.createApplication();
        }

    }

//
}
