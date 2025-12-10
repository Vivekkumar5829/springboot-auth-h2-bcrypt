# Auth Using H2 and BCrypt

A simple Spring Boot application for user authentication using H2 as an in-memory database and BCrypt for password encryption. This application is designed to provide user registration and login functionality, securely storing and validating user credentials.

## Features

- **User Registration**: Allows users to register with a username, password, and email.
- **User Authentication**: Validates user credentials during login using BCrypt for password hashing.
- **In-Memory Database (H2)**: Uses H2 as an in-memory database for quick and simple data storage.
- **Spring Security**: Integrates Spring Security for handling authentication and authorization.

## Technologies Used

- **Spring Boot**: The main framework for building the application.
- **Spring Security**: Used to handle user authentication and authorization.
- **Spring Data JPA**: Manages database interactions using JPA.
- **H2 Database**: In-memory database for easy, lightweight data storage during development.
- **BCrypt**: Used for securely hashing user passwords.
- **Lombok**: Reduces boilerplate code (getter, setter, constructor).
- **Maven**: Build tool used for project management and dependency management.

## Prerequisites

Before running the project, ensure you have the following installed:

- **Java 17** or higher
- **Maven** (for managing dependencies)
- **IDE (like IntelliJ IDEA or VS Code)** with Lombok plugin installed.

## Getting Started

Follow these instructions to get your project up and running locally.

### 1. Clone the Repository


git clone https://github.com/your-username/auth-using-h2-bcrypt.git
cd auth-using-h2-bcrypt
2. Install Dependencies
Run the following command to install the required dependencies:


mvn install
3. Run the Application
To run the Spring Boot application, use the following command:

mvn spring-boot:run
Alternatively, if you want to run the application as a packaged JAR, use:


mvn clean package
java -jar target/auth-using-h2-bcrypt-0.0.1-SNAPSHOT.jar
4. Access the H2 Console
Once the application is running, you can access the H2 Database Console in your browser at:


http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:testdb

Username: sa

Password: (blank)

5. Use the Application
User Registration: Send a POST request to /api/auth/register with the JSON body:

json

{
  "username": "your_username",
  "password": "your_password",
  "email": "your_email@example.com"
}
User Login: Send a POST request to /api/auth/login with the JSON body:

json

{
  "username": "your_username",
  "password": "your_password"
}
If the credentials are correct, you’ll receive an authentication token in the response.

Directory Structure
graphql

src/
 ├── main/
 │   ├── java/
 │   │   ├── com/
 │   │   │   ├── auth/
 │   │   │   │   ├── bycrp/
 │   │   │   │   │   ├── controller/          # Handles API endpoints
 │   │   │   │   │   ├── dto/                 # Data transfer objects (DTOs)
 │   │   │   │   │   ├── exception/           # Custom exceptions
 │   │   │   │   │   ├── model/               # Entity classes (User)
 │   │   │   │   │   ├── repository/          # JPA repository interfaces
 │   │   │   │   │   ├── service/             # Business logic and service layer
 │   │   │   │   │   └── AuthBycryptApplication.java  # Main entry point
 └── resources/
     ├── application.properties                # Configuration file
Configuration
application.properties


Server Port: Change the server port by setting server.port=8080.

Database Configuration: H2 is set up by default for an in-memory database. You can configure persistent H2 or switch to a different database if needed.

Example configuration:

properties

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
Security Notes
BCrypt is used to hash passwords. Passwords are never stored as plain text.

JWT or Session Management can be added in the future for better user session handling.

Running Tests
You can run the tests with:
mvn test

Contributing
Feel free to fork this repository, make changes, and submit a pull request. Contributions are welcome!

License
This project is licensed under the MIT License - see the LICENSE file for details.

Contact
Author: Vivek Kumar

Email: vivekaryan4236@gamil.com



### Key Sections of the README:

1. **Project Overview**: Describes what the application does and the main technologies used.
2. **Features**: Lists the core features of the application, such as registration, authentication, and database integration.
3. **Technologies Used**: Details the main frameworks and libraries used in the project.
4. **Installation and Setup**: Explains the steps to get the project up and running on your local machine.
5. **Directory Structure**: Provides an overview of the folder structure in the project.
6. **Configuration**: Includes configuration options such as database setup.
7. **Security Notes**: Explains how the application handles sensitive information like passwords.
8. **Running Tests**: Explains how to run the unit and integration tests.

### Tips:
- Replace placeholder texts like `Your Name`, `your-username`, and `your-email@example.com` with your actual information.
- Add a section for **License** if you're licensing your project (like MIT, Apache 2.0, etc.).
