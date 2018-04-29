package com.surgeon.eye.controller;

import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.surgeon.eye.model.Patient;
import com.surgeon.eye.model.Prescription;
import com.surgeon.eye.services.impl.PatientServiceImpl;
import com.surgeon.eye.services.impl.QueryServiceImpl;
import com.surgeon.eye.model.Query;
@RestController
@RequestMapping("/query")
public class QueryController {
	@Autowired
	PatientServiceImpl patientServiceImpl;

	@Autowired
	QueryServiceImpl queryServiceImpl;
	
	@RequestMapping(value ="/askDoctor", method=RequestMethod.POST)
	public Patient askDoctor(@RequestBody Query query,@RequestParam("patientId") String patientId,
			@RequestParam("doctorId") String doctorId) {
		Patient patient = queryServiceImpl.askQuery(patientId, doctorId, query);
		return patient;
	}
	@RequestMapping(value="/viewPatientQueries", method=RequestMethod.GET)
	public List<Query> viewPatientQueries(@RequestParam("patientId") String patientId) {
		return queryServiceImpl.viewPatientQueries(patientId);
	}
	@RequestMapping(value="/viewDoctorQueries", method=RequestMethod.GET)
	public List<Query> viewDoctorQueries(@RequestParam("doctorId") String doctorId) {
		return queryServiceImpl.viewDoctorQueries(doctorId);
	}
}