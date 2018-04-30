package com.healthybuffs.login;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
public class LoginController {
	
	@Autowired
	UserValidationService check;
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleLoginRequest(@RequestParam String name, @RequestParam String password, ModelMap model,HttpSession session) {
		
		double id = check.isUservalid(name, password);
		if (id != 0) {
			session.setAttribute("login_id", id);
			model.put("name", name);
			model.put("password", password);
			model.put("id", id);
			HashMap<Double, String> doctors = check.getDoctorNames(id);
			model.put("docs", doctors);
			return "welcome";
		}
		
		else {
			model.put("error", "invalid User!!!");
			return "login";
		}
	}
}
