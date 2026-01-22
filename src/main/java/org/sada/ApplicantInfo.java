package org.sada;

public class ApplicantInfo {
    //Application Information
    public boolean ODSP = true;
    public boolean multiProgram = true;
    public boolean hasMyB = false;

    public String maritalStatus = "Single"; //Options : Single,Married

    //Person Information
    public String fitstName = "JohnBalo".trim();
    public String lastName = "Teeru".trim();
    public String SIN = "926 398 488";
    public String phoneNumber = "647 422 2188";



    //Spouce Information
    public String fitstNameSpouce = "Wife".trim();
    public String lastNameSpouce = this.lastName;
    public String SINSpouce = "114 455 447";


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

