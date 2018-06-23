package com.coviam.codiecon.dto;

public class InterviewerDto {
    String name;
    String email;
    String pass;
    String preference;
    int slotsAvailable;


    public InterviewerDto(String name, String email, String pass, String preference, int slotsAvailable) {
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.preference = preference;
        this.slotsAvailable = slotsAvailable;
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

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    public int getSlotsAvailable() {
        return slotsAvailable;
    }

    public void setSlotsAvailable(int slotsAvailable) {
        this.slotsAvailable = slotsAvailable;
    }

    public InterviewerDto() {
    }
}
