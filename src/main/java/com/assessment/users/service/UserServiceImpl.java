package com.assessment.users.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.assessment.users.repository.UserInfoRepository;
import com.assessment.users.helper.CSVHelper;
import com.assessment.users.model.UserInfo;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserInfoRepository userInfoRepository;
  
  @Autowired
  MongoOperations mongoOperations;
 
  public List<UserInfo> getAllUsers(){
    return userInfoRepository.findAll();
  }
  
  public Optional<UserInfo> getById(String id){
    System.out.println("2"+id);
    return userInfoRepository.findById(id);
  }
  
  public Optional<UserInfo> getByEmail(String email){
    return userInfoRepository.findByEmail(email);
  }

  public void save(MultipartFile file) {
    try {
      List<UserInfo> users = CSVHelper.csvUserInfoToList(file.getInputStream());
      
      
      for(UserInfo user : users) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(user.getId()));
        UserInfo info = mongoOperations.findOne(query, UserInfo.class);
        if(info != null) {
          if(user.getUsername() == null) {
            info.setEmail(user.getEmail());
            info.setFirstName(user.getFirstName());
            info.setLastName(user.getLastName());
            userInfoRepository.save(info);
          } else if(user.getEmail() == null) {
            info.setUsername(user.getUsername());
            info.setFirstName(user.getFirstName());
            info.setLastName(user.getLastName());
            info.setOneTimePassword(user.getOneTimePassword());
            info.setRecoveryCode(user.getRecoveryCode());
            info.setDepartment(user.getDepartment());
            info.setLocation(user.getLocation());
            info.setEmail(info.getEmail());
            userInfoRepository.save(info);
          }
        } else {
          userInfoRepository.saveAll(users);
        }
      }
    } catch(Exception e) {
      throw new RuntimeException();
    }
  }
}

