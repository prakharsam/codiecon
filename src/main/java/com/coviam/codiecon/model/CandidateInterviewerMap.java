package com.coviam.codiecon.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity

@Table(name = "candidate-interviwer-map")
public class CandidateInterviewerMap {

    @Column(name = "candidate")
    private String candidate;

    @Column(name = "interviewer")
    private String interviewer;

    @Column(name = "timeslot")
    private int timeslot;

    @Column(name = "day")
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
