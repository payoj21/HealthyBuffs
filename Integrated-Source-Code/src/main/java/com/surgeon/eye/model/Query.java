package com.surgeon.eye.model;
import java.util.List;
import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="queries")
public class Query {

	@Id
	String queryId;
	String patientId;
	String doctorId;
	String time;
	String query;
}
