package com.coviam.codiecon.service;



import com.coviam.codiecon.dto.*;

import java.util.List;

public interface SchedulerService {

    Boolean createAdmin(AdminDto adminDto);

    Boolean inputAll(InputAllObject inputAllObject);

    boolean candidatePreference(String email, CandidatePreferenceDto candidatePreferenceDto);

    boolean interviewerPreference(String email, List<String> preferenceDtos);

    String runPythonScript(String email);

    String checkCandidateAuthentication(String email, String pass);

    String checkInterviewerAuthentication(String email, String pass);

    String createCandidate(CandidateDto candidateDto);

    String createInterviewer(InterviewerDto interviewerDto);

    void schedule();
}
