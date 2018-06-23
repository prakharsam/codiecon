package com.coviam.codiecon.controller;



import com.coviam.codiecon.dto.*;
import com.coviam.codiecon.model.Candidate;
import com.coviam.codiecon.service.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.coviam.codiecon.dto.CandidateInterviewerMapDto;
import com.coviam.codiecon.dto.CandidatePreferenceDto;
import com.coviam.codiecon.service.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("schedule")
public class SchedulerController {

    @Autowired
    SchedulerService schedulerService;



    @RequestMapping("/candidate-preference")
    public boolean candidate(@RequestParam String email,@RequestBody CandidatePreferenceDto candidatePreferenceDto)
    {
        return schedulerService.candidatePreference(email,candidatePreferenceDto);

    }

    @RequestMapping("/interviewer")
    public boolean interviewer(@RequestParam String email, List<String> preferenceDtos) {

        return schedulerService.interviewerPreference(email,preferenceDtos);

    }


    @RequestMapping("/interview-scheduling")
    public boolean interviewScheduling(@RequestBody CandidateInterviewerMapDto candidateInterviewerMapDto) {

        return false;

    }

    @RequestMapping(value = "/candidate-auth", method = RequestMethod.POST)
    public ResponseDto<?> candidateAuth(@RequestBody Candidate candidate) {
        String result = schedulerService.checkCandidateAuthentication(candidate.getEmail() , candidate.getPass());
        return new ResponseDto<String>(result);
    }


    @RequestMapping(value = "/interviewer-auth", method = RequestMethod.POST)
    public ResponseDto<?> interviweerAuth(@RequestBody InterviewerDto interview) {
        String result = schedulerService.checkInterviewerAuthentication(interview.getEmail(), interview.getPass());
        return new ResponseDto<String>(result);
    }

    @RequestMapping("/admin-auth")
    public String adminAuth( @RequestParam String firstName) {

        return("");

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
