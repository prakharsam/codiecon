package com.coviam.codiecon.controller;


import com.coviam.codiecon.dto.CandidateInterviewerMapDto;
import com.coviam.codiecon.dto.CandidatePreferenceDto;
import com.coviam.codiecon.dto.InterviewerPreferenceDto;
import com.coviam.codiecon.service.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("schedule")
public class SchedulerController {

    @Autowired
    SchedulerService schedulerService;

    @RequestMapping("/candidate-preference")
    public boolean candidate(@RequestParam String email,@RequestBody CandidatePreferenceDto candidatePreferenceDto) {
        return schedulerService.candidatePreference(email,candidatePreferenceDto);

    }

    @RequestMapping("/interviewer")
    public boolean interviewer(@RequestParam String email, List<String> preferenceDtos) {

        return schedulerService.interviewerPreference(email,preferenceDtos);

    }


    @RequestMapping("/interview-scheduling")
    public String interviewScheduling() {
        return schedulerService.runPythonScript();
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
