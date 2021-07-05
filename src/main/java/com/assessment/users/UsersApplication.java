package com.assessment.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.assessment.users.repository.UserInfoRepository;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = UserInfoRepository.class)
public class UsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersApplication.class, args);
	}

}
