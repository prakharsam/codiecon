package com.coviam.codiecon.dto;

import java.util.List;

public class AlgoInputDto {

    int numberOfDays;
    int interviewDuration;
    int numberOfCandidates;
    List<String> candidatePreferences;
    int numberOfInterviewers;
    List<String> interviewerPreferences;

    public AlgoInputDto(int numberOfDays, int interviewDuration, int numberOfCandidates, List<String> candidatePreferences, int numberOfInterviewers, List<String> interviewerPreferences) {
        this.numberOfDays = numberOfDays;
        this.interviewDuration = interviewDuration;
        this.numberOfCandidates = numberOfCandidates;
        this.candidatePreferences = candidatePreferences;
        this.numberOfInterviewers = numberOfInterviewers;
        this.interviewerPreferences = interviewerPreferences;
    }

    public AlgoInputDto() {
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
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

    public List<String> getCandidatePreferences() {
        return candidatePreferences;
    }

    public void setCandidatePreferences(List<String> candidatePreferences) {
        this.candidatePreferences = candidatePreferences;
    }

    public int getNumberOfInterviewers() {
        return numberOfInterviewers;
    }

    public void setNumberOfInterviewers(int numberOfInterviewers) {
        this.numberOfInterviewers = numberOfInterviewers;
    }

    public List<String> getInterviewerPreferences() {
        return interviewerPreferences;
    }

    public void setInterviewerPreferences(List<String> interviewerPreferences) {
        this.interviewerPreferences = interviewerPreferences;
    }
}
