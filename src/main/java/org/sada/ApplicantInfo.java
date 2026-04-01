package org.sada;

import java.util.ArrayList;
import java.util.List;

public class ApplicantInfo {


    // Personal Information
    public Boolean hasDisability = true;
    public String firstName = "Betty";
    public String lastName = "ha";
    public String SIN = "575 250 832";
    public String phoneNumber = "647 422 2251";
    public boolean isGenderMale = true;
    public boolean hasChildren = false;
    public String email = firstName + lastName + "@yopmail.com";
    public Boolean isLanguageEnglish = true;
    public Boolean isNoLangHelp = true;
    public String DOBYear = "1960";
    public String DOBMonth = "01";
    public String DOBDay = "01";


    // Before you apply
    public Boolean isEmergency = false;
    public Boolean isGettingMoney = false;
    public Boolean isMoneyForImmediateNeed = false;
    public Boolean isReceivedSocialAssistanceInPast = false;
    public Boolean releasedFromInstitution = false;
    public Boolean livingOnFirstNationsReserveLand = false;
    public Boolean applyingForYourself = true;




    // Spouse Information - IF THERE IS A SPOUCE
    public String firstNameSpouce = "Wife".trim();
    public String lastNameSpouce = this.lastName;
    public String SINSpouce = "114 455 447";
    public String emailSpouce = firstNameSpouce + lastNameSpouce + "@yopmail.com";
    public String DOBYearSpouce = "1970";
    public String DOBMonthSpouce = "01";
    public String DOBDaySpouce = "01";
    public String healthStatusSpouce = "Excellent";

    // Additional Information
    public boolean currentlyResidingInInstitution = false;
    public boolean accommodationServices = false;
    public boolean employmentServices = false;
    public boolean specialDietOrMedicalCondition = false;
    public boolean personWithDisability;
    public boolean additionalNutritionalNeeds = false;
    public boolean fullTimeStudent = false;
    public boolean caringForChild = false;

    // Additional Family Information
    public boolean receivedSocialAssistancePast = false;
    public boolean residingInInstitution = false;
    public boolean currentlyIncarcerated = false;
    public boolean accommodationServicesNeeded = false;
    public boolean employmentServicesSupport = false;
    public boolean specialDietMedicalCondition = false;
    public boolean disabilityInFamily = true;
    public boolean immediateNeedMoney = false;
    public boolean pregnantOrBreastfeeding = false;
    public boolean additionalFamilyfullTimeStudent = false;
    public boolean additionalFamilyCaringForChild = false;

    // Address Information
    public String homeTypeValue = "Standard street address";
    public String mobileTypeValue = "Mobile";
    public boolean isApartment = false;
    public String streetNumber = "330";
    public String streetName = "Main Street East";
    public String streetType = "Street";
    public String city = "Hamilton";
    public String postalCode = "L8N 3T9";

    // Demographics Information
    public String demograhicGender = "Prefer not to say";
    public String demograhicIndigenouse = "Prefer not to say";
    public String demograhicRace = "Prefer not to say";
    public String demograhicVisibleMinority = "Prefer not to say";
    public String demograhicLanguage = "English";

    // Housing Situation
    public String housingSituation = "I am staying in an emergency hostel or shelter";

    // Earned Income
    public boolean earnedIncome = false;

    //Household Incomes
    public List<String> houseHoldIncome = new ArrayList<>();

    //Financial Assets
    public List<String> assets = new ArrayList<>();
    public boolean givenAwayAssets = false;

    //Bank Details
    public  boolean hasChecquingAcct = false;
    public  boolean hasSavingsAcct = false;

    // Other Info
    public String password = "Password1++";
    public String statusinCanadaSelect = "Canadian citizen born in Canada";
    public String healthStatus = "Excellent";



    // Application Information - Don't Change Here
    public Boolean multiProgram = false;

    // MyB Information - Don't Change Here
    public boolean hasMyB = false;
    public String maritalStatus = "Single";
}