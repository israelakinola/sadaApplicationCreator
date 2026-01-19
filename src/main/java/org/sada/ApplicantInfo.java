package org.sada;

public class ApplicantInfo {
    //Application Information
    public boolean ODSP = true;
    public boolean hasMyB = false;

    //Person Information
    public String fitstName = "ewew".trim();
    public String lastName = "Duredsdlo".trim();
    public String SIN = "101 296 218";
    public String phoneNumber = "647 422 3333";


    //Spouce Information
    public String fitstNameSpouce = "Christian".trim();
    public String lastNameSpouce = this.lastName;
    public String SINSpouce = "228 723 953";


    public String emailSpouce = fitstNameSpouce + lastNameSpouce + "@yopmail.com";;
    public String DOBYearSpouce = "1970";
    public String DOBMonthSpouce = "01";
    public String DOBDaySpouce = "01";




    //Standard Information
    public String email =  fitstName + lastName + "@yopmail.com";
    public String password = "Password1++";
    public String streetNumber = "330";
    public String streetName = "Main Street East";
    public String city = "Hamilton";
    public  String postalCode = "L8N 3T9";
    public String maritalStatus = "Single";
    public String DOBYear = "1960";
    public String DOBMonth = "01";
    public String DOBDay = "01";
    public String statusinCanadaSelect = "Canadian citizen born in Canada";
    public String healthStatus = "Excellent";

    //What is your current housing situation?
    public String housingSituation = "I am staying in an emergency hostel or shelter";

    //Will you receive income from a job, a training program, or self-employment in January 2026?
    public boolean earnedIncome = false;
}

