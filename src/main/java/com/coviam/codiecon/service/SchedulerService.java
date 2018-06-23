package com.coviam.codiecon.service;


import com.coviam.codiecon.dto.CandidateDto;
import com.coviam.codiecon.dto.CandidateInterviewerMapDto;
import com.coviam.codiecon.dto.CandidatePreferenceDto;
import com.coviam.codiecon.dto.InterviewerDto;

import java.util.List;

public interface SchedulerService {

    boolean candidatePreference(String email, CandidatePreferenceDto candidatePreferenceDto);

    boolean interviewerPreference(String email, List<String> preferenceDtos);

    List<CandidateInterviewerMapDto> schedule();

    String checkCandidateAuthentication(String email, String pass);

    String checkInterviewerAuthentication(String email, String pass);

    String createCandidate(CandidateDto candidateDto);

    String createInterviewer(InterviewerDto interviewerDto);
}
