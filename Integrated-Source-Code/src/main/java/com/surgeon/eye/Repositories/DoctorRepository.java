package com.surgeon.eye.Repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.surgeon.eye.model.Doctor;
import com.surgeon.eye.model.DoctorAppointmentDetails;

public interface DoctorRepository extends MongoRepository<Doctor, String> {
	
	List<Doctor> findBySpeciality(String speciality);
	
	@Query("{ _id:?0, appointments.patientId:?1 }")
	Doctor findByPatientId(String id, String patientId);

}
