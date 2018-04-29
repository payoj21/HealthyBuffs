package com.surgeon.eye.Repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.surgeon.eye.model.Pharmacist;
import com.surgeon.eye.model.PharmacistAppointmentDetails;

public interface PharmacistRepository extends MongoRepository<Pharmacist, String> {
	
	List<Pharmacist> findByName(String name);
	
	@Query("{ _id:?0, appointments.patientId:?1 }")
	Pharmacist findByPatientId(String id, String patientId);

}
