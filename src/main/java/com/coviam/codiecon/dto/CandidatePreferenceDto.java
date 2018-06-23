package com.coviam.codiecon.dto;


public class CandidatePreferenceDto {

    int day;
    char[] preference;

    public CandidatePreferenceDto(int day, char[] preference) {
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

    public char[] getPreference() {
        return preference;
    }

    public void setPreference(char[] preference) {
        this.preference = preference;
    }
}
