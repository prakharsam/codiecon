package com.coviam.codiecon.repository;

import com.coviam.codiecon.model.Candidate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends CrudRepository<Candidate,String> {

}
