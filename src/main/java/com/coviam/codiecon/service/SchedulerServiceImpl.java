package com.coviam.codiecon.service;


import com.coviam.codiecon.dto.CandidateInterviewerMapDto;
import com.coviam.codiecon.dto.CandidatePreferenceDto;
import com.coviam.codiecon.model.Candidate;
import com.coviam.codiecon.model.Interview;
import com.coviam.codiecon.model.Interviewer;
import com.coviam.codiecon.repository.CandidateRepository;
import com.coviam.codiecon.repository.InterviewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    public String runPythonScript() {
        String s = getOutput();
        return s;
    }

    public String getOutput(){
        String s = null;
        String outputString = null;
        try{

            Process p = Runtime.getRuntime().exec("python3 /Users/sandeepgupta/Documents/codeicon/codiecon/src/main/resources/interviewScheduling.py");
            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new
                    InputStreamReader(p.getErrorStream()));

            // read the output from the command
            System.out.println("Here is the standard output of the command:\n");
            while ((s = stdInput.readLine()) != null) {
//                System.out.println(s);
                outputString += s;
            }
            // read any errors from the attempted command
            System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
        }
        catch (IOException e) {
            System.out.println("exception happened - here's what I know: ");
            e.printStackTrace();
            System.exit(-1);
        }



        return outputString;
    }


}
