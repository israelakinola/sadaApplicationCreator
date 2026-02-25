package org.sada;

public class ApplicantInfo {

    // Application Information
    private String maritalStatus = "Single";
    private boolean ODSP = false;
    private boolean multiProgram = false;
    private boolean hasMyB = false;
    // Person Information
    private String firstName;
    private String lastName;
    private String SIN;
    private String phoneNumber = "647 422 2188";
    private String email;

    // Spouse Information
    private String firstNameSpouce = "Wife".trim();
    private String lastNameSpouce = this.lastName;
    private String SINSpouce = "114 455 447";
    private String emailSpouce = firstNameSpouce + lastNameSpouce + "@yopmail.com";
    private String DOBYearSpouce = "1970";
    private String DOBMonthSpouce = "01";
    private String DOBDaySpouce = "01";

    // Standard Information
    private String password = "Password1++";
    private String streetNumber = "330";
    private String streetName = "Main Street East";
    private String city = "Hamilton";
    private String postalCode = "L8N 3T9";
    private String DOBYear = "1960";
    private String DOBMonth = "01";
    private String DOBDay = "01";
    private String statusinCanadaSelect = "Canadian citizen born in Canada";
    private String healthStatus = "Excellent";


    // Housing
    private String housingSituation = "I am staying in an emergency hostel or shelter";

    // Income
    private boolean earnedIncome = false;

    public ApplicantInfo(String maritalStatus, boolean isODSP,
                         boolean isMultiProgram, boolean hasMyB, String primaryName, String primaryLastname,String SIN){
        setMaritalStatus(maritalStatus);
        setODSP(isODSP);
        setMultiProgram(isMultiProgram);
        setHasMyB(hasMyB);
        setFirstName(primaryName);
        setLastName(primaryLastname);
        setSIN(SIN);
        setEmail(firstName + lastName + "@yopmail.com");
    }
    // ===== Getters and Setters =====

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public boolean isMultiProgram() {
        return multiProgram;
    }

    public void setMultiProgram(boolean multiProgram) {
        this.multiProgram = multiProgram;
    }

    public boolean isHasMyB() {
        return hasMyB;
    }

    public void setHasMyB(boolean hasMyB) {
        this.hasMyB = hasMyB;
    }

    public boolean isODSP() {
        return ODSP;
    }

    public void setODSP(boolean ODSP) {
        this.ODSP = ODSP;
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
