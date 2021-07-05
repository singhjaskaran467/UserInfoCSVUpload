package com.assessment.users.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.assessment.users.model.UserEmailPassword;

@Repository
public interface UserEmailPasswordRepository extends MongoRepository<UserEmailPassword, String>{

}
