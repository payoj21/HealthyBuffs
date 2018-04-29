package com.surgeon.eye.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.surgeon.eye.model.Patient;

public interface PatientRepository extends MongoRepository<Patient, String>{

}
