package com.surgeon.eye.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.surgeon.eye.model.Admin;

public interface AdminRepository extends MongoRepository<Admin, String>{

}

