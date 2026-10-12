# 💸 NexPay — P2P Digital Payment Platform

[![Java](https://img.shields.io/badge/Java-17%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16%2B-4169E1?style=for-the-badge&logo=postgresql&logoColor=white)](https://www.postgresql.org/)
[![Status](https://img.shields.io/badge/Status-Under_Active_Development-orange?style=for-the-badge)]()

> **NexPay** is a Peer-to-Peer (P2P) payment and digital wallet platform built with **Spring Boot** and **PostgreSQL**. The platform is designed to provide secure, high-concurrency financial transfers, stateless authentication, and real-time transaction processing.

---

## 🟢 Currently Live in Codebase

### 1. User Domain & Data Persistence
* **PostgreSQL Integration:** Configured database connection using HikariCP connection pooling.
* **User Entity:** Normalized database mapping with unique constraints on `email` and `phone`, timestamp tracking via `@PrePersist`, and role-based permissions (`USER`, `ADMIN`).
* **JPA Repository:** Spring Data JPA interface generating type-safe derived SQL queries (`findByEmail`, `existsByEmail`, `existsByPhone`).

### 2. Secure Registration Pipeline
* **Input Validation (DTO):** `RegisterRequest` enforces strict field validation using Jakarta Validation (`@NotBlank`, `@Email`, `@Size`).
* **Cryptographic Password Protection:** Passwords are cryptographically hashed using **BCrypt** (`BCryptPasswordEncoder`) with a configurable work factor and 128-bit salt before being persisted.
* **Duplicate Prevention:** Business logic verifies uniqueness of email and phone number, throwing domain exceptions for collisions.
* **REST Registration Endpoint:** `POST /api/auth/register` accepts validated registration requests and returns `HTTP 201 Created`.

---

## 🚧 Currently Being Implemented
* **Stateless JWT Authentication:** Generating signed HMAC-SHA256 tokens upon login (`POST /api/auth/login`) and validating them per-request via a custom `OncePerRequestFilter`.
* **Global Error Handling:** Centralized `@RestControllerAdvice` converting application exceptions and validation rejections into structured JSON responses.

---

## 🛠️ Current Tech Stack

| Component | Technology |
|---|---|
| **Language** | Java 17 |
| **Framework** | Spring Boot 3.x (Spring Web, Spring Security, Spring Data JPA) |
| **Database** | PostgreSQL 16+ |
| **Security** | BCrypt Password Hashing |
| **Persistence** | Hibernate ORM, HikariCP |
| **Validation** | Jakarta Bean Validation (Hibernate Validator) |
| **Boilerplate** | Project Lombok |

---

## 🚀 Getting Started Locally

### Prerequisites
* Java 17 or higher
* PostgreSQL running locally on port `5432` with a database named `nexpaydb`

### 1. Clone the Repository
```bash
git clone https://github.com/rizzi13/nexpay.git
cd nexpay
```

### 2. Configure Database
Ensure your PostgreSQL credentials in `src/main/resources/application.yml` match your local environment:
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/nexpaydb
    username: postgres
    password: YOUR_PASSWORD
```

### 3. Run the Application
```bash
./mvnw spring-boot:run
```
The server will start on `http://localhost:8080`.

---

## 📬 Live API Endpoints

| Method | Endpoint | Description | Status |
|---|---|---|---|
| `POST` | `/api/auth/register` | Registers a new user with BCrypt password hashing | 🟢 Live |
| `POST` | `/api/auth/login` | Authenticates user and returns JWT token | 🚧 In Progress |

---

## 📄 License
This project is licensed under the MIT License.
