package com.surgeon.eye.Repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.surgeon.eye.model.Query;

public interface QueryRepository extends MongoRepository<Query,String>{
	List<Query> findByDoctorId(String doctorId);
	List<Query> findByPatientId(String patientId);

}
