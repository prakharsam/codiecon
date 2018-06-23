package com.coviam.codiecon.dto;


public class CandidateDto {

    String name;
    String email;
    String pass;
    int day;
    String preference;

    public CandidateDto() {
    }

    public CandidateDto(String name, String email, String pass, int day, String preference) {
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.day = -1;
        this.preference = "MAEN";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }
}
