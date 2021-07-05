package com.assessment.users.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;
import com.assessment.users.model.UserInfo;

public interface UserService {

  public List<UserInfo> getAllUsers();

  public Optional<UserInfo> getById(String id);

  public Optional<UserInfo> getByEmail(String email);

  public void save(MultipartFile file);
}
