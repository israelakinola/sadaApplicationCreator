package org.sada;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sada.applications.MultipleApplicant;
import org.sada.applications.SingleApplicant;


public class Main {


    public static void main(String[] args) {
        String SFT3 = "https://test.sada.az.mcss.gov.on.ca/intake/home-page";
        String SFT2 = "https://test2.sada.az.mcss.gov.on.ca/intake/home-page";

        String applicantType = "single";

        CreateSADAApplication(SFT3, applicantType);

    }


    private static void CreateSADAApplication(String env, String applicantType) {
        WebDriver driver = new ChromeDriver();
        driver.get(env);
        if(applicantType.equalsIgnoreCase("single")){
            SingleApplicant single = new SingleApplicant(driver);
            single.createApplication();
        }else if(applicantType.equalsIgnoreCase("multiple")){
            MultipleApplicant multiple = new MultipleApplicant(driver);
            multiple.createApplication();
        }

    }

//
}
