package com.example.bhavesh.imprime;

/**
 * Created by bhavesh on 3/26/2017.
 */

public class SignupDetails {

    public String userid;
    public String name, dob, gender, location, email, password, cnfpassword;
    public String contact;

    public SignupDetails(){

    }

    public SignupDetails(String userid, String name, String dob, String gender, String location, String contact, String email, String password, String cnfpassword) {
        this.userid = userid;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.location = location;
        this.email = email;
        this.password = password;
        this.cnfpassword = cnfpassword;
        this.contact = contact;
    }
}
