package com.assessment.users.helper;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.web.multipart.MultipartFile;

import com.assessment.users.model.UserInfo;

public class CSVHelper {

  public static String TYPE = "text/csv";

  public static boolean isCSVFormat(MultipartFile file) {
    if (!TYPE.equals(file.getContentType())) {
      return false;
    }
    return true;
  }

  public static List<UserInfo> csvUserInfoToList(InputStream is) {
    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
          CSVParser csvParser = new CSVParser(fileReader,
                CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

      List<UserInfo> users = new ArrayList<UserInfo>();

      Iterable<CSVRecord> csvRecords = csvParser.getRecords();

      for (CSVRecord csvRecord : csvRecords) {
        if (csvRecord.size() == 4) {
          UserInfo user = new UserInfo(
                csvRecord.get("Identifier"),
                csvRecord.get("Login email"),
                csvRecord.get("First name"),
                csvRecord.get("Last name"));
          users.add(user);
        } else {
          UserInfo user = new UserInfo(
                csvRecord.get("Identifier"),
                csvRecord.get("Username"),
                csvRecord.get("First name"),
                csvRecord.get("Last name"),
                csvRecord.get("Department"),
                csvRecord.get("Location"),
                BCrypt.hashpw(csvRecord.get("One-time password"), BCrypt.gensalt()),
                BCrypt.hashpw(csvRecord.get("Recovery code"), BCrypt.gensalt()));
          users.add(user);
        }
      }
      return users;
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    }
  }
}
