package com.coviam.codiecon.model;


import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "candidate-interviewer-map")
public class CandidateInterviewerMap {

    private String candidate;

    private String interviewer;

    private int timeslot;

    private int day;

    public CandidateInterviewerMap(String candidate, String interviewer, int timeslot, int day) {
        this.candidate = candidate;
        this.interviewer = interviewer;
        this.timeslot = timeslot;
        this.day = day;
    }

    public String getCandidate() {
        return candidate;
    }

    public void setCandidate(String candidate) {
        this.candidate = candidate;
    }

    public String getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(String interviewer) {
        this.interviewer = interviewer;
    }

    public int getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(int timeslot) {
        this.timeslot = timeslot;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
