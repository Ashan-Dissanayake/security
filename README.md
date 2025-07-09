# Spring Security R&D Project

## Overvie
A research and development project exploring various Spring Security features and configurations, including authentication, authorization, session managementan and as well as jwt token managemetn

## Goals
- Explore multiple authentication mechanisms (e.g., Basic Auth, Form Login, JWT)
- Implement and compare role-based access control (RBAC)
- Evaluate stateless vs. stateful security configurations
- Customize user management using `UserDetailsService
  
## Project Structure
src/
┣ config/ # Spring Security configuration classes
┣ controller/ # REST controllers for test endpoints
┣ dto/ # Request/response payloads
┣ entity/ # Entity classes (User, Role, etc.)
┣ dao/ # JPA repositories
┣ security/ # JWT utils, filters, and security tools
┗ service/ # Business logic and user auth services

## Features Covered
- [x] Form-Based Login
- [x] HTTP Basic Authentication
- [x] Role-Based Access Control
- [x] Custom UserDetailsService
- [x] Password encoding strategies
- [x] JWT Authentication
- [ ] CSRF protection toggle
- [ ] OAuth2 with Google Login

## Test Credentials
| Username | Password  | Role         |
|----------|-----------|--------------|
| `navo`   | `123`     | `ROLE_ADMIN` |
| `user`   | `user123` | `ROLE_USER`  |

## Getting Started

### Prerequisites
- Java 17
- Maven 3.6+
- IDE (IntelliJ IDEA preferred)

### Running the Project
```bash
git clone https://github.com/Ashan-Dissanayake/security
cd security
./mvnw spring-boot:run
