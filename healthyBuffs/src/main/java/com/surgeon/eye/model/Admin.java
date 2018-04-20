package com.surgeon.eye.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="admin")
public class Admin {
	
	@Id
	private String id;
	private String name;

}

