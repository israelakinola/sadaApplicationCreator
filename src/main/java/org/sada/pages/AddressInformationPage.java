package org.sada.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class AddressInformationPage extends BasePage {
    public AddressInformationPage(WebDriver driver) {
        super(driver);
    }
    // -----------------------------
    // Locators
    // -----------------------------


    private final By apartmentYesLabel = By.cssSelector("label[for='home-apartment-radio-button-option-0']");
    private final By apartmentNoLabel  = By.cssSelector("label[for='home-apartment-radio-button-option-1']");


    // Toggle to manual entry (link inside <p id="home-toggle-auto">)
    private final By enterAddressManuallyLink = By.cssSelector("#home-toggle-auto a.linkNoHref");

    //What type of address is your home address?
    private final By typeHomeAddress = By.cssSelector("#home-deliveryTypeSelect");

    //StreetNumber
    private final By homeStreetNumber = By.cssSelector("#home-streetNumberInput");

    //Street Name
    private final By steetName = By.cssSelector("#home-streetNameInput");

    //Street Address Type
    private final By streetType = By.cssSelector("#home-streetTypeSelect");

    //City or Town
    private final By city = By.cssSelector("#home-municipalityInput");

    //Postal Code
    private final By postalCode = By.cssSelector("#home-postalCodeInput");

    private final By streetAddressInput  = By.id("home-address-line1");

    // --- Checkbox: "My mailing address is the same as my home address." ---
    private final By mailingAddressCheckbox = By.id("mailingAddressCheckbox");
    private final By mailingAddressLabel    = By.cssSelector("label[for='mailingAddressCheckbox']");



    // -----------------------------
    // Actions (public API)
    // -----------------------------

    public void setIsHomeApartment(boolean isApartment) {
        utility.scrollIntoView(isApartment ? apartmentYesLabel : apartmentNoLabel);
        utility.click(isApartment ? apartmentYesLabel : apartmentNoLabel);
    }




    public void clickEnterAddressManually() {
        utility.scrollIntoView(enterAddressManuallyLink);
        utility.click(enterAddressManuallyLink);
    }

    public void inputAddress(String steetNUmber, String StreetName, String cityName, String postalCodeAddy){
        WebElement homeType = utility.scrollIntoView(typeHomeAddress);
        new Select(homeType).selectByVisibleText("Standard street address");
        utility.clearAndType(homeStreetNumber, steetNUmber);
        utility.clearAndType(steetName, StreetName);
        utility.clearAndType(streetType, "Street");
        utility.clearAndType(city, cityName);
        utility.clearAndType(postalCode, postalCodeAddy);

    }



    public void setMailingAddressSameAsHome(boolean same) {
        // If your Utility has setCheckbox(By, boolean), use that.
        utility.scrollIntoView(mailingAddressCheckbox);
        utility.setCheckbox(mailingAddressCheckbox, same);
        // Alternatively: click the label to toggle, then assert state (not shown because you asked to pass the value yourself).
    }




    public void createAddressInformation(
            boolean isApartment,
            String steetNUmber, String StreetName, String cityName, String postalCodeAddy) {

        this.setIsHomeApartment(isApartment);


        this.clickEnterAddressManually();

        this.inputAddress(steetNUmber, StreetName, cityName, postalCodeAddy);

        utility.click(By.id("address-information-continue-button"));
        if(utility.isElementPresent(By.id("address-review-title"))) {
            if (utility.isElementPresent(By.id("acceptSuggestedBtn"))) {
                utility.click(By.id("acceptSuggestedBtn"));
            }
        }
        if(utility.isElementPresent(By.id("address-summary-title"))){
            utility.click(By.id("confirm-address-save-continue-button"));
        }

    }

}
