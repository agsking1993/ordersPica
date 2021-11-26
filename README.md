# Toures Balón Authentication Microservice (Java/Spring Boot)

This is a Java/Spring Boot microservice to managment orders and endpoints for Toures Balón App. 

# Repository Structure

The main files in this repository are:

* `Dockerfile` specifies how the application is built and packaged
* `src/` contains the actual Java application

# Usage

* To run this service locally :
  * mvn spring-boot:run
  * Build a local dev environment: "docker build -t touresbalon:authentication" 
  * Run "docker docker run -p 8100:8100 -t touresbalon-authentication"
