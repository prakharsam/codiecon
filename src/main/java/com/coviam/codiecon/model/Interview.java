package com.coviam.codiecon.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;


@Document(collection = "interviewer")
public class Interview {

    @Id
    int interviewId;
    Date startDate;
    Date endDate;

    int interviewDays;
    int interviewDuration;

    int numberOfCandidates;
    List<Candidate> candidates;
    int numberOfInterviewers;
    List<Interviewer>  interviewers;

    public Interview(int interviewId, Date startDate, Date endDate, int interviewDays, int interviewDuration, int numberOfCandidates, List<Candidate> candidates, int numberOfInterviewers, List<Interviewer> interviewers) {
        this.interviewId = interviewId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.interviewDays = interviewDays;
        this.interviewDuration = interviewDuration;
        this.numberOfCandidates = numberOfCandidates;
        this.candidates = candidates;
        this.numberOfInterviewers = numberOfInterviewers;
        this.interviewers = interviewers;
    }

    public Interview() {
    }

    public int getInterviewId() {
        return interviewId;
    }

    public void setInterviewId(int interviewId) {
        this.interviewId = interviewId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getInterviewDays() {
        return interviewDays;
    }

    public void setInterviewDays(int interviewDays) {
        this.interviewDays = interviewDays;
    }

    public int getInterviewDuration() {
        return interviewDuration;
    }

    public void setInterviewDuration(int interviewDuration) {
        this.interviewDuration = interviewDuration;
    }

    public int getNumberOfCandidates() {
        return numberOfCandidates;
    }

    public void setNumberOfCandidates(int numberOfCandidates) {
        this.numberOfCandidates = numberOfCandidates;
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    public int getNumberOfInterviewers() {
        return numberOfInterviewers;
    }

    public void setNumberOfInterviewers(int numberOfInterviewers) {
        this.numberOfInterviewers = numberOfInterviewers;
    }

    public List<Interviewer> getInterviewers() {
        return interviewers;
    }

    public void setInterviewers(List<Interviewer> interviewers) {
        this.interviewers = interviewers;
    }
}
