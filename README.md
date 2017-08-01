# Phone-book (Spring Boot Web application)

# Build and run
  Configurations

Open the application.properties file and set your own configurations.

YOU CAN CHOOSE KIND OF STORAGE:
(Comment or uncomment the appropriate line)

Example: In order to select mysql database comment json

spring.profiles.active=mysql or spring.profiles.active=json

Open the application-mysql.properties file and set your own mysql database configurations.

# Prerequisites

    Java 8
    Maven > 3.0


# From terminal

Go on the project's root folder, then type:

$ mvn spring-boot:run

# From Eclipse (Spring Tool Suite)

Import as Existing Maven Project and run it as Spring Boot App.

# Usage

Run the application and go on http://localhost:8080/

# SQL query to create all necessary tables
https://github.com/lioigor/Phone-book/blob/beta/SQL%20query

# Additional Information
You can simply create an empty database and specify URL, username, password - tables will be created automatically. Json files will be automatically created too.

For quick Log In, if you used prepared SQL query - you can input: 
  
  username - igor
  
  password - qwerty
    
