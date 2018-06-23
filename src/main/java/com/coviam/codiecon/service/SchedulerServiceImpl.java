package com.coviam.codiecon.service;


import com.coviam.codiecon.dto.CandidateDto;
import com.coviam.codiecon.dto.CandidateInterviewerMapDto;
import com.coviam.codiecon.dto.CandidatePreferenceDto;
import com.coviam.codiecon.dto.InterviewerDto;
import com.coviam.codiecon.model.Candidate;
import com.coviam.codiecon.model.Interview;
import com.coviam.codiecon.model.Interviewer;
import com.coviam.codiecon.repository.CandidateRepository;
import com.coviam.codiecon.repository.InterviewerRepository;
import org.springframework.beans.BeanUtils;
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
        candidate.setPreference(candidatePreference);
        candidateRepository.save(candidate);

        return true;
    }

    @Override
    public boolean interviewerPreference(String email, List<String> preferenceDtos) {

        Interviewer interviewer = interviewerRepository.findById(email).get();
        String preference = "";
        for (String preferenceUnit : preferenceDtos)
        {
            preference.concat(String.valueOf(preferenceUnit.charAt(0)));
            preference.concat(String.valueOf(preferenceUnit.charAt(1)));

        }
        interviewer.setPreference(preference);
        interviewer.setSlotsAvailable(preference.length()/2);

        return false;
    }

    @Override
    public List<CandidateInterviewerMapDto> schedule() {

        Interview interview = new Interview();


        return null;
    }

    @Override
    public String checkCandidateAuthentication(String email, String pass) {
        Candidate  candidateDetails = candidateRepository.findByEmail(email);
        if(null != candidateDetails){
            if(pass.equals(candidateDetails.getPass())) {
                return email;
            }else{
                return "User Not Found";
            }
        }
        return "User Not Found";
    }

    @Override
    public String checkInterviewerAuthentication(String email, String pass) {
        Interviewer interviewerDetails = interviewerRepository.findById(email).get();
        if (null != interviewerDetails){
            if(pass.equals(interviewerDetails.getPass())){
                return email;
            }else{
                return "User Not Found";
            }
        }
        return "User Not Found";
    }

    @Override
    public String createCandidate(CandidateDto candidateDto) {
        Candidate candidate = new Candidate();
        BeanUtils.copyProperties(candidateDto, candidate);
        candidateRepository.save(candidate);
        return "Success";
    }

    @Override
    public String createInterviewer(InterviewerDto interviewerDto){
        Interviewer interviewer = new Interviewer();
        BeanUtils.copyProperties(interviewerDto, interviewer);
        interviewerRepository.save(interviewer);
        return "Success";
    }

}
