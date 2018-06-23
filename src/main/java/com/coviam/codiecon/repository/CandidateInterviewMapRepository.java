package com.coviam.codiecon.repository;

import com.coviam.codiecon.model.CandidateInterviewerMap;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CandidateInterviewMapRepository extends MongoRepository<CandidateInterviewerMap,String> {


}
