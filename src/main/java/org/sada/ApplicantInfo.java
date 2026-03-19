package org.sada;

public class ApplicantInfo {



    // Personal Information
    private String maritalStatus = "Single";
    private String firstName = "Alsssdisw";
    private String lastName = "Hsfsssba";
    private String SIN = "275 736 544";
    private String phoneNumber = "647 422 2188";
    public boolean isGenderMale = true;
    public boolean hasChildren = false;
    private String email = firstName + lastName + "@yopmail.com";


    // Before you apply
    public Boolean isEmergency = false;
    public Boolean isGettingMoney = false;
    public Boolean isMoneyForImmediateNeed = false;
    public Boolean isReceivedSocialAssistanceInPast = false;
    public Boolean hasDisability = false;
    public Boolean releasedFromInstitution = false;
    public Boolean livingOnFirstNationsReserveLand = false;
    public Boolean applyingForYourself = true;



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

    // Housing
    private String housingSituation = "I am staying in an emergency hostel or shelter";

    // Income
    private boolean earnedIncome = false;

    // Spouse Information
    private String firstNameSpouce = "Wife".trim();
    private String lastNameSpouce = this.lastName;
    private String SINSpouce = "114 455 447";
    private String emailSpouce = firstNameSpouce + lastNameSpouce + "@yopmail.com";
    private String DOBYearSpouce = "1970";
    private String DOBMonthSpouce = "01";
    private String DOBDaySpouce = "01";

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

    // Other Info
    private String password = "Password1++";
    private String DOBYear = "1960";
    private String DOBMonth = "01";
    private String DOBDay = "01";
    public String statusinCanadaSelect = "Canadian citizen born in Canada";
    private String healthStatus = "Excellent";

    // ===== Getters =====

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public boolean isHasMyB() {
        return hasMyB;
    }

    public boolean isODSP() {
        return hasDisability;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSIN() {
        return SIN;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFirstNameSpouce() {
        return firstNameSpouce;
    }

    public String getLastNameSpouce() {
        return lastNameSpouce;
    }

    public Boolean isMultiProgram() {
        return multiProgram;
    }

    public String getSINSpouce() {
        return SINSpouce;
    }

    public String getEmailSpouce() {
        return emailSpouce;
    }

    public String getDOBYearSpouce() {
        return DOBYearSpouce;
    }

    public String getDOBMonthSpouce() {
        return DOBMonthSpouce;
    }

    public String getDOBDaySpouce() {
        return DOBDaySpouce;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getDOBYear() {
        return DOBYear;
    }

    public String getDOBMonth() {
        return DOBMonth;
    }

    public String getDOBDay() {
        return DOBDay;
    }

    public String getStatusinCanadaSelect() {
        return statusinCanadaSelect;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public String getHousingSituation() {
        return housingSituation;
    }

    public boolean isEarnedIncome() {
        return earnedIncome;
    }

    // Application Information - Don't Change Here
    public Boolean multiProgram = false;

    // MyB Information - Don't Change Here
    public boolean hasMyB = false;
}