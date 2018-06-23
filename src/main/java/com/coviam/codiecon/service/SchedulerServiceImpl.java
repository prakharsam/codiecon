package com.coviam.codiecon.service;

import com.coviam.codiecon.dto.AlgoInputDto;
import com.coviam.codiecon.dto.CandidatePreferenceDto;
import com.coviam.codiecon.model.Candidate;
import com.coviam.codiecon.model.CandidateInterviewerMap;
import com.coviam.codiecon.model.Interviewer;
import com.coviam.codiecon.repository.CandidateInterviewMapRepository;
import com.coviam.codiecon.repository.CandidateRepository;
import com.coviam.codiecon.repository.InterviewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchedulerServiceImpl implements SchedulerService{

    private static final int NUMBER_OF_DAYS = 10;
    private static final int INTERVIEW_DURATION = 1;


    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private InterviewerRepository interviewerRepository;
    @Autowired
    private CandidateInterviewMapRepository candidateInterviewMapRepository;

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
    public void schedule() {

        AlgoInputDto algoInputDto = new AlgoInputDto();
        algoInputDto.setNumberOfInterviewers(((int) interviewerRepository.count()));
        algoInputDto.setNumberOfCandidates((int) candidateRepository.count());

        List<String> candidatePreferences = new ArrayList<>();
        List<String> interviewerPreferences = new ArrayList<>();

        List<Candidate> candidates = candidateRepository.findAll();
        for( Candidate candidate : candidates){
            candidatePreferences.add(candidate.getPreference());
        }
        algoInputDto.setCandidatePreferences(candidatePreferences);

        List<Interviewer> interviewers = interviewerRepository.findAll();
        for( Interviewer interviewer : interviewers){
            interviewerPreferences.add(interviewer.getPreference());
        }

        algoInputDto.setNumberOfDays(NUMBER_OF_DAYS);
        algoInputDto.setInterviewDuration(INTERVIEW_DURATION);

        //call python function and get list of CandidateInterviewerMap

        List<CandidateInterviewerMap> interviewList = new ArrayList<>();

        for(CandidateInterviewerMap candidateInterviewerMap : interviewList){
            candidateInterviewMapRepository.save(candidateInterviewerMap);
        }


    }

}
