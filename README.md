**About The Project**

UserInfoCSVUpload is an application in which one can upload multiple CSV files with different columns into MongoDB and retrieve data by Id and Email.

**Built With**

•	Spring Boot
•	MongoDB

**Getting Started**
        Prerequisites
              •	Java
              •	MongoDB
              •	Postman (To test the API’s)
              •	CSV files (email.csv, username-password-recovery-code.csv)  
 
          Installation
              1.  Clone the repo.
                  a.  git clone git@github.com:singhjaskaran467/UserInfoCSVUpload.git
                  b.  Git pull origin master 
              2.  Open the project in Eclipse.
                  a.  Select option “Run as Spring Boot Application”.

          Assumptions
              1.  One time Password: 
                  a.  The access is write-only.
                  b.  Should be secure, so it is saved in DB after encrypting with BCrypt.
                  c.  Cannot be displayed using Get routes by using @JsonIgnore
              2.  Recovery Code:
                  a.  Should be secure, so it is saved in DB after encrypting with BCrypt.
                  b.  Cannot be displayed using Get routes by using @JsonIgnore
**Usage**
There are 3 main APIs in this application:

1.  Get All Users
    a.	URL: localhost:8080/api/csv/upload
    b.	Response: Gives a list of all the Users.
2.  Get User by id or email
    a.	URL: localhost:8080/api/csv/user
    b.	Parameters: id/email (Eg: id : 5079/ email : jamie@example.com)
    c.	Response: Responds with a JSON object having User’s info.
3.  Upload a file
    a.	URL: localhost:8080/api/csv/upload
    b.	Parameter: file (.csv file)
    c.	Response: Message if File was uploaded successfully or not.



