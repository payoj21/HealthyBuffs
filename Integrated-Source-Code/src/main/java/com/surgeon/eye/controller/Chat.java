package com.healthybuffs.chatEngine;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.healthybuffs.login.UserValidationService;
@Controller
public class Chat {
	@Autowired
	UserValidationService check;
	
	@RequestMapping(value = "/chat-engine", method = RequestMethod.GET)
	public String showLoginPage(@RequestParam String key,HttpSession session,ModelMap model) {
		session.setAttribute("contact_id", key);
		double patient_id = (Double)session.getAttribute("login_id");
		double doctor_id = Double.parseDouble(key);
		Map<Date, String> chats = check.getChat(patient_id,doctor_id);
		model.put("Chat",chats);
		return "chat-engine";
	}
}
