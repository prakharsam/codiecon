package com.coviam.codiecon.controller;


import com.coviam.codiecon.dto.CandidateInterviewerMapDto;
import com.coviam.codiecon.dto.CandidatePreferenceDto;
import com.coviam.codiecon.dto.InterviewerPreferenceDto;
import com.coviam.codiecon.service.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @RequestMapping("/candidate-auth")
    public String candidateAuth( @RequestParam String firstName) {

        return("");

    }


    @RequestMapping("/interviewer-auth")
    public String interviweerAuth( @RequestParam String firstName) {

        return("");

    }

    @RequestMapping("/admin-auth")
    public String adminAuth( @RequestParam String firstName) {

        return("");

    }

    @RequestMapping("/admin-input")
    public String adminInput() {

        return("");

    }










}
