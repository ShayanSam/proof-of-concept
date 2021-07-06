package com.proofofconcept.dao;

import com.proofofconcept.entities.RequestForSickLeave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "requests")
public interface SickLeaveRepository extends JpaRepository<RequestForSickLeave, Long> {
}
