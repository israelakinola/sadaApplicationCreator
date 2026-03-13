package org.sada;

public class ApplicantInfo {

    // Application Information
    public Boolean multiProgram = false;

    //Before you apply
    public Boolean isEmergency = false;
    public Boolean isGettingMoney = false;
    public Boolean isMoneyForImmediateNeed = false;
    public Boolean isReceivedSocialAssistanceInPast = false;
    public Boolean hasDisability = false;
    public Boolean releasedFromInstitution = false;
    public Boolean livingOnFirstNationsReserveLand = false;
    public Boolean applyingForYourself = true;


    //Personal Information
    private String maritalStatus = "Single";
    private String firstName = "Aliw";
    private String lastName = "Harskba";
    private String SIN = "275 736 544" ;
    private String phoneNumber = "647 422 2188";
    public boolean isGenderMale = true;
    public boolean hasChildren = false;

    //MyB Information
    private boolean hasMyB = false;
    private String email = (firstName + lastName + "@yopmail.com");

    // Address Information
    public String homeTypeValue = "Standard street address";
    public String mobileTypeValue = "Mobile";
    public boolean isApartment = false;
    public String streetNumber = "330";
    public String streetName = "Main Street East";
    public String streetType = "Street";
    public String city = "Hamilton";
    public String postalCode = "L8N 3T9";

    //Demographics Information
    public String demograhicGender = "Prefer not to say";
    public String demograhicIndigenouse = "Prefer not to say";
    public String demograhicRace = "Prefer not to say";
    public String demograhicVisibleMinority = "Prefer not to say";
    public String demograhicLanguage = "Prefer not to say";



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

    //Additional Information
    public boolean currentlyResidingInInstitution = false;
    public boolean accommodationServices = false;
    public boolean employmentServices = false;
    public boolean specialDietOrMedicalCondition = false;
    public boolean personWithDisability;
    public boolean additionalNutritionalNeeds = false;
    public boolean fullTimeStudent = false;
    public boolean caringForChild = false;

    //Additional Family Information
    public boolean receivedSocialAssistancePast = false;      // Has anyone received social assistance in the past?
    public boolean residingInInstitution = false;              // Living in an institution?
    public boolean currentlyIncarcerated = false;              // In jail/prison/detention?
    public boolean accommodationServicesNeeded = false;        // Need support accessing services?
    public boolean employmentServicesSupport = false;          // Getting job-program/service support?
    public boolean specialDietMedicalCondition = false;         // Need special diet due to medical condition?
    public boolean disabilityInFamily = true;                        // Person with disability in family?
    public boolean immediateNeedMoney = false;               // Need money for immediate needs?
    public boolean pregnantOrBreastfeeding = false;           // Pregnant or breastfeeding?
    public boolean additionalFamilyfullTimeStudent = false;                // Full-time student?
    public boolean additionalFamilyCaringForChild = false;                    // Caring for someone else’s child?


    //Other Info
    private String password = "Password1++";
    private String DOBYear = "1960";
    private String DOBMonth = "01";
    private String DOBDay = "01";
    public String statusinCanadaSelect = "Canadian citizen born in Canada";
    private String healthStatus = "Excellent";




    // ===== Getters and Setters =====

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }


    public boolean isHasMyB() {
        return hasMyB;
    }

    public void setHasMyB(boolean hasMyB) {
        this.hasMyB = hasMyB;
    }

    public boolean isODSP() {
        return hasDisability;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName.trim();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName.trim();
    }

    public String getSIN() {
        return SIN;
    }

    public void setSIN(String SIN) {
        this.SIN = SIN;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstNameSpouce() {
        return firstNameSpouce;
    }

    public void setFirstNameSpouce(String fitstNameSpouce) {
        this.firstNameSpouce = fitstNameSpouce;
    }

    public String getLastNameSpouce() {
        return lastNameSpouce;
    }

    public void setLastNameSpouce(String lastNameSpouce) {
        this.lastNameSpouce = lastNameSpouce;
    }

    public Boolean isMultiProgram(){
        return multiProgram;
    }
    public String getSINSpouce() {
        return SINSpouce;
    }

    public void setSINSpouce(String SINSpouce) {
        this.SINSpouce = SINSpouce;
    }

    public String getEmailSpouce() {
        return emailSpouce;
    }

    public void setEmailSpouce(String emailSpouce) {
        this.emailSpouce = emailSpouce;
    }

    public String getDOBYearSpouce() {
        return DOBYearSpouce;
    }

    public void setDOBYearSpouce(String DOBYearSpouce) {
        this.DOBYearSpouce = DOBYearSpouce;
    }

    public String getDOBMonthSpouce() {
        return DOBMonthSpouce;
    }

    public void setDOBMonthSpouce(String DOBMonthSpouce) {
        this.DOBMonthSpouce = DOBMonthSpouce;
    }

    public String getDOBDaySpouce() {
        return DOBDaySpouce;
    }

    public void setDOBDaySpouce(String DOBDaySpouce) {
        this.DOBDaySpouce = DOBDaySpouce;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getDOBYear() {
        return DOBYear;
    }

    public void setDOBYear(String DOBYear) {
        this.DOBYear = DOBYear;
    }

    public String getDOBMonth() {
        return DOBMonth;
    }

    public void setDOBMonth(String DOBMonth) {
        this.DOBMonth = DOBMonth;
    }

    public String getDOBDay() {
        return DOBDay;
    }

    public void setDOBDay(String DOBDay) {
        this.DOBDay = DOBDay;
    }

    public String getStatusinCanadaSelect() {
        return statusinCanadaSelect;
    }

    public void setStatusinCanadaSelect(String statusinCanadaSelect) {
        this.statusinCanadaSelect = statusinCanadaSelect;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    public String getHousingSituation() {
        return housingSituation;
    }

    public void setHousingSituation(String housingSituation) {
        this.housingSituation = housingSituation;
    }

    public boolean isEarnedIncome() {
        return earnedIncome;
    }

    public void setEarnedIncome(boolean earnedIncome) {
        this.earnedIncome = earnedIncome;
    }
}
