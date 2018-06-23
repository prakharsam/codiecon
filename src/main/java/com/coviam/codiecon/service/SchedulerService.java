package com.coviam.codiecon.service;


import com.coviam.codiecon.dto.CandidatePreferenceDto;

import java.util.List;

public interface SchedulerService {

    boolean candidatePreference(String email, CandidatePreferenceDto candidatePreferenceDto);

    boolean interviewerPreference(String email, List<String> preferenceDtos);

    void schedule();
}
