package com.healthybuffs.post;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.healthybuffs.login.UserValidationService;

@Controller
public class FinalPost {
	@Autowired
	UserValidationService service;
	@RequestMapping(value="/post-comment",method=RequestMethod.POST)
	public String returnSuccess(@RequestParam String comments,HttpSession session,ModelMap model) {
		Double reciever_id = Double.parseDouble(session.getAttribute("contact_id").toString());
		Double sender_id = Double.parseDouble(session.getAttribute("login_id").toString());
		boolean success =  service.postComment(sender_id,reciever_id,comments);
		model.put("success", success);
		return "postSuccess";
	}
}
