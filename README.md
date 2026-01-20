# Backend Developer Intern Assignment – Primetrade

This project demonstrates a secure and scalable backend system with JWT authentication,
role-based access, CRUD APIs, and a basic frontend UI for testing.

---

## Tech Stack
- Java 17
- Spring Boot
- Spring Security
- JWT (jjwt)
- MySQL
- Swagger (OpenAPI)
- HTML + JavaScript (basic frontend)

---

## Features Implemented

### Authentication & Security
- User registration and login
- Password hashing using BCrypt
- JWT-based authentication
- Role-based access control (USER / ADMIN)
- Stateless API security

### Task Management (CRUD)
- Create task
- View own tasks
- Update task
- Delete task
- User-specific data isolation

### API Documentation
- Swagger UI for testing APIs
- JWT authorization supported in Swagger

### Basic Frontend
- Simple HTML + JavaScript UI
- Register and login users
- Create and view tasks
- Displays success and error messages

---

## How to Run Backend

1. Configure database in `application.properties`
2. Run Spring Boot application
3. Backend runs at:
   http://localhost:8080

---

## Swagger API Documentation

Open in browser:
    http://localhost:8080/swagger-ui/index.html


Steps:
1. Register user
2. Login to get JWT token
3. Click **Authorize** and paste JWT token
4. Test secured APIs

---

## Frontend Usage

1. Start backend server
2. Open:
      frontend/index.html
3. Register → Login → Create tasks → View tasks

---

## Author
Yogesh Adhav




