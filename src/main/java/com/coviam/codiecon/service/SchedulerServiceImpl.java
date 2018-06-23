package com.coviam.codiecon.service;


import com.coviam.codiecon.dto.CandidatePreferenceDto;
import com.coviam.codiecon.dto.InterviewerPreferenceDto;
import com.coviam.codiecon.model.Candidate;
import com.coviam.codiecon.model.Interviewer;
import com.coviam.codiecon.repository.CandidateRepository;
import com.coviam.codiecon.repository.InterviewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchedulerServiceImpl implements SchedulerService{

    @Autowired
    CandidateRepository candidateRepository;
    @Autowired
    InterviewerRepository interviewerRepository;

    @Override
    public boolean candidatePreference(String email, CandidatePreferenceDto candidatePreferenceDto) {

        Candidate candidate = candidateRepository.findById(email).get();
        candidate.setDay(candidatePreferenceDto.getDay());
        String candidatePreference = String.valueOf(candidatePreferenceDto.getPreference());

        candidateRepository.deleteById(candidate.getEmail());

        candidateRepository.save(candidate);

        return false;
    }

    @Override
    public boolean interviewerPreference(String email, List<InterviewerPreferenceDto> preferenceDtos) {

        Interviewer interviewer = interviewerRepository.findById(email).get();
        String preference = "";
        for (InterviewerPreferenceDto interviewerPreferenceDto : preferenceDtos)
        {
            preference.concat(String.valueOf(interviewerPreferenceDto.getDay()));
            preference.concat(String.valueOf(interviewerPreferenceDto.getSlot()));

        }
        interviewer.setPreference(preference);

        return false;
    }

}
