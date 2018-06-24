package com.coviam.codiecon.service;


import com.coviam.codiecon.dto.*;
import com.coviam.codiecon.model.Admin;
import com.coviam.codiecon.model.Candidate;
import com.coviam.codiecon.model.CandidateInterviewerMap;
import com.coviam.codiecon.model.Interviewer;
import com.coviam.codiecon.repository.AdminRepository;
import com.coviam.codiecon.repository.CandidateInterviewMapRepository;
import com.coviam.codiecon.repository.CandidateRepository;
import com.coviam.codiecon.repository.InterviewerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author: Sandeep Gupta
 * */
@Service
public class SchedulerServiceImpl implements SchedulerService{

    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private InterviewerRepository interviewerRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Boolean createAdmin(AdminDto adminDto) {
        Admin admin = new Admin();
        admin.setEmail(adminDto.getEmail());
        admin.setName(adminDto.getName());
        admin.setPassword(adminDto.getPassword());
        admin.setAlgoInputObjectList(null);
        admin.setAlgoOutputObjectList(null);
        if(!adminRepository.existsById(admin.getEmail())){
            adminRepository.save(admin);
            return true;
        }
        return false;
    }

    @Override
    public Boolean inputAll(InputAllObject inputAllObject) {
        if(adminRepository.existsById(inputAllObject.getEmail())){
            Admin admin = adminRepository.findById(inputAllObject.getEmail()).get();
            if(admin.getAlgoInputObjectList() == null){
                List<AlgoInputObject> algoInputObjectList = new ArrayList<>();
                algoInputObjectList.add(inputAllObject.getAlgoInputObject());
                admin.setAlgoInputObjectList(algoInputObjectList);
            }
            else{
                List<AlgoInputObject> algoInputObjectList = new ArrayList<>();
                algoInputObjectList.add(inputAllObject.getAlgoInputObject());
                admin.setAlgoInputObjectList(algoInputObjectList);
            }
            adminRepository.save(admin);
            return true;
        }
        return false;
    }

    @Override
    public boolean candidatePreference(String email, CandidatePreferenceDto candidatePreferenceDto) {

//        Candidate candidate = candidateRepository.findById(email).get();
//        candidate.setDay(candidatePreferenceDto.getDay());
//        String candidatePreference = String.valueOf(candidatePreferenceDto.getPreference());
//        candidate.setPreference(candidatePreference);
//        candidateRepository.save(candidate);
        return true;
    }

    @Override
    public boolean interviewerPreference(String email, List<String> preferenceDtos) {

        return false;
    }

    @Override
    public String runPythonScript(String email) {
        Boolean isCreatedInputFile = generateInputFile(email);
        if(isCreatedInputFile == true){
            String s = getOutput();
            return "True";
        }
        return "False";
    }

    public Boolean generateInputFile(String email){
        try {
            FileWriter fw = new FileWriter("/Users/sandeepgupta/Documents/codeicon/codiecon/src/main/resources/in");
            if(adminRepository.existsById(email)){
                Admin admin = adminRepository.findById(email).get();
                List<AlgoInputObject> algoInputObjectList = admin.getAlgoInputObjectList();
                if(algoInputObjectList != null) {
                    AlgoInputObject algoInputObject = algoInputObjectList.get(0);
                    fw.write(algoInputObject.getNumberOfDays().toString());
                    fw.write('\n');
                    fw.write(algoInputObject.getInterviewDuration().toString());
                    fw.write('\n');
                    fw.write(String.valueOf(algoInputObject.getCandidateDtoList().size()));
                    fw.write('\n');
                    for (int i = 0; i < algoInputObject.getCandidateDtoList().size(); i++) {
                        String preference = algoInputObject.getCandidateDtoList().get(i).getPreference();
                        fw.write(preference.charAt(0));
                        fw.write(' ');
                        fw.write(preference.charAt(1));
                        fw.write(' ');
                        fw.write(preference.charAt(2));
                        fw.write(' ');
                        fw.write(preference.charAt(3));
                        fw.write(' ');
                        fw.write(String.valueOf(algoInputObject.getNumberOfDays()));
                        fw.write('\n');
                    }
                    fw.write(String.valueOf(algoInputObject.getInterviewerDtoList().size()));
                    fw.write('\n');
                    for (int i = 0; i < algoInputObject.getInterviewerDtoList().size(); i++) {
                        fw.write(String.valueOf(algoInputObject.getInterviewerDtoList().get(i).getAvailablityOfInterviewer().size()));
                        fw.write(' ');
                        for (int j = 0; j < algoInputObject.getInterviewerDtoList().get(i).getAvailablityOfInterviewer().size(); j++) {
                            fw.write(algoInputObject.getInterviewerDtoList().get(i).getAvailablityOfInterviewer().get(j));
                            fw.write(' ');
                        }
                        fw.write('\n');
                    }
                    fw.close();
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public String getOutput() {
        String s = null;
        String outputString = null;
        try {

            Process p = Runtime.getRuntime().exec("python3 /Users/sandeepgupta/Documents/codeicon/codiecon/src/main/resources/interviewScheduling.py");
            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new
                    InputStreamReader(p.getErrorStream()));

            // read the output from the command
            System.out.println("Here is the standard output of the command:\n");
            while ((s = stdInput.readLine()) != null){
//              System.out.println(s);
                outputString += s;
            }
            // read any errors from the attempted command
            System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            System.out.println("exception happened - here's what I know: ");
            e.printStackTrace();
            System.exit(-1);
        }


        return outputString;
    }
    public void schedule() {

//        AlgoInputObject algoInputObject = new AlgoInputObject();
//        algoInputObject.setNumberOfInterviewers(((int) interviewerRepository.count()));
//        algoInputObject.setNumberOfCandidates((int) candidateRepository.count());
//
//        List<String> candidatePreferences = new ArrayList<>();
//        List<String> interviewerPreferences = new ArrayList<>();
//
//        List<Candidate> candidates = candidateRepository.findAll();
//        for( Candidate candidate : candidates){
//            candidatePreferences.add(candidate.getPreference());
//        }
//        algoInputObject.setCandidatePreferences(candidatePreferences);
//
//        List<Interviewer> interviewers = interviewerRepository.findAll();
//        for( Interviewer interviewer : interviewers){
//            interviewerPreferences.add(interviewer.getPreference());
//        }
//
//        algoInputObject.setNumberOfDays(NUMBER_OF_DAYS);
//        algoInputObject.setInterviewDuration(INTERVIEW_DURATION);
//
//        //call python function and get list of CandidateInterviewerMap
//
//        List<CandidateInterviewerMap> interviewList = new ArrayList<>();
//
//        for(CandidateInterviewerMap candidateInterviewerMap : interviewList){
//            candidateInterviewMapRepository.save(candidateInterviewerMap);
//        }


    }

    @Override
    public String checkCandidateAuthentication(String email, String pass) {
        Candidate  candidateDetails = candidateRepository.findByEmail(email);
        if(null != candidateDetails){
            if(pass.equals(candidateDetails.getPassword())) {
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
            if(pass.equals(interviewerDetails.getPassword())){
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
