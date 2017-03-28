package com.example.bhavesh.imprime;

/**
 * Created by bhavesh on 3/26/2017.
 */

public class SignupDetails {

    public String name, dob, gender, location, email, password, cnfpassword;
    public String contact;

    public SignupDetails(){

    }

    public SignupDetails(String name, String dob, String gender, String location, String contact, String email, String password, String cnfpassword) {
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
