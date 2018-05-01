package com.healthybuffs.login;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.bson.Document;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Service
@SessionAttributes("patient_id")
public class UserValidationService {
	Db details;
	public UserValidationService() {
		super();
		this.details = new Db();
	}
	public double isUservalid(String user,String pass) {
		// Creating a Mongo client 
		details.setCollection("details");
	      Document user_doc = details.getDetailsByName(user);
	      System.out.println(user_doc);
	      if(user_doc == null) {
	    	  return 0;
	      }
	      return user_doc.getDouble("id");
	}
	
	public HashMap<Double, String> getDoctorNames(double id){
		
		//Db details = new Db();
		HashMap<Double, String> hmap = new HashMap<Double, String>();
		//List<String> names = new ArrayList<String>();
	    Document user_1 = details.getDetailsById(id);
	    if(user_1 == null) {
	    	return null;
	    }
	    List<Double> docs = (List<Double>) user_1.get("contact");
	    for (Double doc : docs) {
	    	System.out.println(details.getDetailsById(doc));
	    	Document doctor = details.getDetailsById(doc);
	    	System.out.println(doctor.getString("Name"));
	    	//names.add(doctor.getString("Name"));
	    	hmap.put(doc, doctor.getString("Name"));
	    }
	    return hmap;
	}
	public Map<Date, String> getChat(double patient_id, double doctor_id) {
		details.setCollection("chats");
		HashMap<Date,String> senderInfo = details.getChats(patient_id,doctor_id);
		HashMap<Date,String> recieverInfo = details.getChats(doctor_id,patient_id);
		HashMap<Date,String> combined = new HashMap<Date,String>();
		combined.putAll(senderInfo);
		combined.putAll(recieverInfo);
		Map<Date, String> tmap = new TreeMap(combined);
		return tmap;
	}
	public boolean postComment(Double sender_id, Double reciever_id, String comments) {
		details.setCollection("chats");
		boolean success = details.postComment(sender_id, reciever_id, comments);
		return success;
	}
}
