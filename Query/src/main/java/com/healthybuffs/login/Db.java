package com.healthybuffs.login;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PreDestroy;

import org.bson.Document;
import org.bson.types.BSONTimestamp;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;

@Service
public class Db {
	MongoClient mongo;
	MongoCredential credential;
	MongoDatabase database;
	MongoCollection collection;
	public Db() {
		mongo = new MongoClient( "localhost" , 27017 ); 
	    credential = MongoCredential.createCredential("admin", "local","12345".toCharArray()); 
	    System.out.println("Connected to the database successfully");
	    database = mongo.getDatabase("patient");
	}
	
	public void setCollection(String Name) {
		collection = database.getCollection(Name);
	}
	
	public Document getDetailsByName(String name) {
		BasicDBObject whereQuery = new BasicDBObject();
	    whereQuery.put("Name", name);
	    FindIterable iterDoc = collection.find(whereQuery);  
	    Iterator<Document> it = iterDoc.iterator();
	    while(it.hasNext()) {
	    	return it.next();
	    }
	  return null;
	}
	
	public Document getDetailsById(double id) {
		BasicDBObject whereQuery = new BasicDBObject();
	    whereQuery.put("id", id);
	    FindIterable iterDoc = collection.find(whereQuery);  
	    Iterator<Document> it = iterDoc.iterator();
	    while(it.hasNext()) {
	    	return it.next();
	    }
	  return null;
	}
	
	
	public HashMap<Date,String> getChats(double sender, double reciever) {
		
		HashMap<Date,String> chat= new HashMap<Date,String>();
		FindIterable<Document> dbo = collection.find(Filters.and(Filters.eq("sender",sender),Filters.eq("reciever",reciever))).projection(Projections.include("time","msg"));
		Iterator<Document> it = dbo.iterator();
	    while(it.hasNext()) {
	    	Document temp = it.next();
	    	SimpleDateFormat format1 = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
	    	Date D = new Date();
	    	try {
				D = format1.parse(temp.getString("time"));
				chat.put(D, temp.getString("msg"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    }
		return chat;
	}
	
	@PreDestroy
	public void destroy() {
		mongo.close();
	}

	public boolean postComment(Double sender_id, Double reciever_id, String comments) {
		Date D = new Date();
		boolean success = false;
		try {
			Document doc = new Document("sender", sender_id).
                append("reciever", reciever_id).
                append("time", D.toString()).
                append("msg",comments);	
		collection.insertOne(doc);
		success = true;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			success = false;
		}
		return success;
	}
}
