package com.assessment.users.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.assessment.users.helper.CSVHelper;
import com.assessment.users.model.UserInfo;
import com.assessment.users.service.UserService;

@RestController
@RequestMapping(path = "/api/csv")
public class UserController {

  @Autowired
  private UserService userService;

  @RequestMapping(value = "/upload", method = RequestMethod.PUT)
  public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) {
    String message = "";
    if (CSVHelper.isCSVFormat(file)) {
      try {
        userService.save(file);
        message = "File uploaded Successfully " + file.getOriginalFilename();
        return ResponseEntity.status(HttpStatus.OK).body(message);
      } catch (Exception e) {
        message = "File upload unsuccessfull " + file.getOriginalFilename();
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
      }
    }
    message = "Please upload a file";
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
  }

  @RequestMapping(value = { "/user" }, method = RequestMethod.GET)
  public ResponseEntity<Optional<UserInfo>> getUserInfo(@RequestParam(required = false, name = "id") String id,
        @RequestParam(required = false, name = "email") String email) {
    if (id != null) {
      return ResponseEntity.status(HttpStatus.OK).body(userService.getById(id));
    } else if (email != null) {
      return ResponseEntity.status(HttpStatus.OK).body(userService.getByEmail(email));
    }
    return null;
  }

  @RequestMapping(value = "/users", method = RequestMethod.GET)
  public ResponseEntity<List<UserInfo>> getUsers() {
    return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
  }
}
