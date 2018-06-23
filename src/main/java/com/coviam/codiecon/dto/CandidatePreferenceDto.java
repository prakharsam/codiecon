package com.coviam.codiecon.dto;


public class CandidatePreferenceDto {

    int day;
    String preference;

    public CandidatePreferenceDto(int day, String preference) {
        this.day = day;
        this.preference = preference;
    }

    public CandidatePreferenceDto() {
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String  getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }
}
