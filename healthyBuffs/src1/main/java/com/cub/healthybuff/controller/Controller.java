package com.cub.healthybuff.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cub.healthybuff.model.Welcome;
import com.cub.healthybuff.model.*;

@RestController
public class Controller {

	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	public @ResponseBody Welcome displayStartPage() {
		return Welcome.builder().message("Welcome to healthy buffs").build();
	}

	@RequestMapping(value = "/ping2", method = RequestMethod.GET)
	public @ResponseBody Patient displayPatientDetails() {
		return Patient.builder().patient_id(102).build();
	}
}
