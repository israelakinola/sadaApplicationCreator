package org.sada.applications;

import org.openqa.selenium.WebDriver;
import org.sada.util.Utility;

public class Application {
    WebDriver driver;
    Utility utility;

    public Application(WebDriver driver) {
        this.driver = driver;
        this.utility = new Utility(driver);
    }





}
