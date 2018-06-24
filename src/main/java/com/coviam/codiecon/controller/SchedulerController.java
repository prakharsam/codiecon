package com.coviam.codiecon.controller;

import com.coviam.codiecon.dto.*;
import com.coviam.codiecon.model.Candidate;
import com.coviam.codiecon.service.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

/**
 * @author: Sandeep Gupta
 * */
@CrossOrigin
@RestController
@RequestMapping("schedule")
public class SchedulerController {

    @Autowired
    SchedulerService schedulerService;

    /**
     *  to create the admin.
     * */
    @RequestMapping("/create-admin")
    public ResponseDto<?> adminAuth(@RequestBody AdminDto adminDto) {
        Boolean a = schedulerService.createAdmin(adminDto);
        return new ResponseDto<Boolean>(a);
    }

    @RequestMapping("input-all")
    public ResponseDto<?> inputAllCandidate(@RequestBody InputAllObject inputAllObject){
        Boolean a = schedulerService.inputAll(inputAllObject);
        return new ResponseDto<Boolean>(a);
    }

    @RequestMapping("/candidate-preference")
    public boolean candidate(@RequestParam String email,@RequestBody CandidatePreferenceDto candidatePreferenceDto) {
        return schedulerService.candidatePreference(email,candidatePreferenceDto);

    }

    @RequestMapping("/interviewer")
    public boolean interviewer(@RequestParam String email, List<String> preferenceDtos) {
        return schedulerService.interviewerPreference(email,preferenceDtos);
    }


    @RequestMapping("/interview-scheduling")
    public String interviewScheduling(@RequestParam String email){
        return schedulerService.runPythonScript(email);
    }

    @RequestMapping(value = "/candidate-auth", method = RequestMethod.POST)
    public ResponseDto<?> candidateAuth(@RequestBody Candidate candidate) {
        String result = schedulerService.checkCandidateAuthentication(candidate.getEmail() , candidate.getPassword());
        return new ResponseDto<String>(result);
    }


    @RequestMapping(value = "/interviewer-auth", method = RequestMethod.POST)
    public ResponseDto<?> interviweerAuth(@RequestBody InterviewerDto interview) {
        String result = schedulerService.checkInterviewerAuthentication(interview.getEmail(), interview.getPassword());
        return new ResponseDto<String>(result);
    }

    @RequestMapping("/admin-input")
    public String adminInput() {

        return("");

    }


    @RequestMapping(value = "/create-candidate", method = RequestMethod.POST)
    public ResponseEntity<?> createCandidate(@RequestBody CandidateDto candidateDto ) {
        String createCandidate = schedulerService.createCandidate(candidateDto);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/create-interviewer", method = RequestMethod.POST)
    public ResponseEntity<?> createInterviewer(@RequestBody  InterviewerDto interviewerDto){
        String createInterViewer = schedulerService.createInterviewer(interviewerDto);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

}
