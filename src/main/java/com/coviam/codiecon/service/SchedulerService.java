package com.coviam.codiecon.service;



import com.coviam.codiecon.dto.*;

import java.util.List;

public interface SchedulerService {

    List<AlgoInputObject> getAllAlgoinputObject(String email);

    AlgoInputObject getAlgoInputObjectById(String email,String index);

    Boolean isVisibleGenerate(String email,String index);

    Boolean isValidCandidate(CandidateDto candidateDto);

    Boolean createAdmin(AdminDto adminDto);

    Boolean checkAdmin(AdminDto adminDto);

    Boolean inputAll(InputAllObject inputAllObject);

    boolean candidatePreference(String email, CandidatePreferenceDto candidatePreferenceDto);

    boolean interviewerPreference(String email, List<String> preferenceDtos);

    String runPythonScript(String email);

    String checkCandidateAuthentication(String email, String pass);

    String checkInterviewerAuthentication(String email, String pass);

    Boolean createCandidate(CandidateDto candidateDto);

    Boolean createInterviewer(InterviewerDto interviewerDto);

    Boolean isValidInterviewer(InterviewerDto interviewerDto);

    Boolean basicScheduleDetails(String email,String startDate,String numberOfDays,String interviewDuration);

    void schedule();
}
