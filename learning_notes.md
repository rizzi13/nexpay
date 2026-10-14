# 📘 NexPay — Architecture Notes & Masterclass Guide (Up to Day 6)

> **Current Status:** Day 6 Complete (Registration, BCrypt Hashing, PostgreSQL Persistence).
> **Rule:** Every new line of code written in future days will be added here step-by-step with:
> 1. 🧠 **Core Concept & Internal Mechanics**
> 2. 🎯 **The Production Engineering Problem It Solves**
> 3. 🎤 **Real Senior/Staff Interview Questions & Punchy Verbal Answers**

---

# 📑 TABLE OF CONTENTS
- [Chapter 1: The Big Picture — What is NexPay?](#chapter-1-the-big-picture--what-is-nexpay)
- [Chapter 2: The Foundation Story (Days 5 & 6 Walkthrough)](#chapter-2-the-foundation-story-days-5--6-walkthrough)
- [Chapter 3: File-by-File Breakdown (Code Written So Far)](#chapter-3-file-by-file-breakdown-code-written-so-far)
  - [1. User.java (The Database Blueprint)](#1-userjava-the-database-blueprint)
  - [2. UserRepository.java (The Database Librarian)](#2-userrepositoryjava-the-database-librarian)
  - [3. RegisterRequest.java (The Sign-Up Slip / DTO)](#3-registerrequestjava-the-sign-up-slip--dto)
  - [4. SecurityConfig.java (The Password Encoder & Security Rules)](#4-securityconfigjava-the-password-encoder--security-rules)
  - [5. UserService.java (The Business Brain)](#5-userservicejava-the-business-brain)
  - [6. AuthController.java (The HTTP Endpoint)](#6-authcontrollerjava-the-http-endpoint)
- [Chapter 4: Core Concepts & Annotations Master Reference](#chapter-4-core-concepts--annotations-master-reference)
- [Chapter 5: Staff-Level Technical Deep-Dives](#chapter-5-staff-level-technical-deep-dives)
  - [1. JVM Memory Layout & BigDecimal](#1-jvm-memory-layout--bigdecimal)
  - [2. Spring Boot Core, IoC & Dependency Injection](#2-spring-boot-core-ioc--dependency-injection)
  - [3. BCrypt Hashing & Salt Theory](#3-bcrypt-hashing--salt-theory)
  - [4. PostgreSQL & Hibernate/JPA Persistence Lifecycle](#4-postgresql--hibernatejpa-persistence-lifecycle)
- [Chapter 6: 15-Day Master Roadmap](#chapter-6-15-day-master-roadmap)

---

# Chapter 1: The Big Picture — What is NexPay?

**NexPay** is a high-concurrency, secure **P2P Digital Payment Platform** (like Google Pay, PayPal, or PhonePe).

### What makes it different from a basic CRUD project?
1. **Financial Concurrency Safety:** Uses database row-level locking (`SELECT FOR UPDATE`) to prevent double-spending when multiple transfers happen at the same second.
2. **Stateless Security:** Uses BCrypt cryptographic hashing for passwords and JWT tokens for stateless authentication.
3. **High Performance:** Uses Redis caching for sub-5ms balance lookups and RabbitMQ for asynchronous event processing.
4. **AI-Powered:** Integrates Google Gemini AI for fraud detection and multimodal receipt scanning.
5. **Production Cloud:** Containerized with Docker and deployed to AWS (EC2, RDS, S3) with GitHub Actions CI/CD.

---

# Chapter 2: The Foundation Story (Days 5 & 6 Walkthrough)

Here is what happens when someone registers on NexPay right now:

```
[ POSTMAN (Client) ]
        │
        │  1. Sends JSON:
        │     {
        │       "fullName": "Rishi Kumar",
        │       "email": "rishi@gmail.com",
        │       "password": "secret123",
        │       "phone": "9876543210"
        │     }
        ▼
[ AuthController ] ──────────► Validates inputs via @Valid RegisterRequest (min 6 chars, email format)
        │
        │  2. Calls userService.registerUser(request)
        ▼
[ UserService ] ─────────────► 1. Checks DB: existsByEmail() -> false?
        │                      2. Checks DB: existsByPhone() -> false?
        │                      3. BCrypt encodes "secret123" -> "$2a$10$vI8a..."
        │                      4. Builds User object using User.builder()
        ▼
[ UserRepository ] ──────────► Calls save(user)
        │
        ▼
[ PostgreSQL (nexpaydb) ] ───► Executes: INSERT INTO users (...) VALUES (...)
        │                      Auto-generates Primary Key: id = 1
        ▼
[ AuthController Response ] ─► Returns HTTP 201 Created: "User registered successfully! ID: 1"
```

---

# Chapter 3: Architectural Masterclasses (Foundation Components)

## Component 1: `User.java` — JPA Entity Lifecycle, PostgreSQL BigSerial & Identity Mapping

### 1. 🧠 The Core Concept, Mathematics & Internal Mechanics
* **JPA Entity Mapping & Relational Calculus:** An `@Entity` defines an Object-Relational Mapping (ORM) bridge between a JVM heap object and a relational row in PostgreSQL.
* **Why Table Name Must Be `users` (`@Table(name = "users")`):** In ANSI SQL and specifically PostgreSQL, `USER` is a reserved system keyword referring to the currently connected database role. Naming a table `user` without double-quoting causes syntax parsing failures (`syntax error at or near "user"`).
* **Surrogate Key Generation (`GenerationType.IDENTITY`):** Delegates primary key minting to PostgreSQL's native `BIGSERIAL` sequence generator. The sequence produces monotonically increasing 64-bit signed integers ($1, 2, 3, \dots, 2^{63}-1$), preventing integer overflow on large-scale datasets.
* **`@PrePersist` Hook Execution:** Intercepted by Hibernate's entity state machine immediately prior to executing the SQL `INSERT` statement. Sets `createdAt = LocalDateTime.now()` in memory, guaranteeing tamper-proof audit timestamps.
* **Enum Storage Strategy (`EnumType.STRING`):** By default, JPA stores enums as integers (`EnumType.ORDINAL`, starting at $0$). If a developer later inserts an enum value at the top of the list, all existing integer references in the database point to the wrong business role! `EnumType.STRING` writes `"USER"` or `"ADMIN"` as varchar, ensuring 100% schema resilience.

### 2. 🎯 The Production Engineering Problem It Solves
* **Relational Impedance Mismatch & Schema Drift:** Rather than writing and synchronizing manual SQL `CREATE TABLE` and migration scripts, Hibernate derives the DDL schema directly from Java types. Constraints like `@Column(nullable = false, unique = true)` generate physical PostgreSQL `NOT NULL` and `UNIQUE INDEX` constraints, enforcing database-level data integrity against race conditions.
* **Zero Plaintext Password Exposure:** The entity explicitly defines `passwordHash` (a 60-character BCrypt string) rather than `password`, preventing accidental plaintext storage in databases or system logs.

### 3. 🎤 Real Senior/Staff Interview Questions & Punchy Verbal Answers
* **Q1: Why should you always use `EnumType.STRING` instead of the default `EnumType.ORDINAL` in JPA?**
  > *"The default `EnumType.ORDINAL` persists enum values as zero-indexed integers (0, 1, 2). If an engineer adds or reorders an enum constant in the codebase, all previously stored database rows immediately point to the wrong enum values, causing silent data corruption. `EnumType.STRING` writes the explicit string name (e.g. `'USER'`), ensuring long-term database schema safety."*
* **Q2: Why is `Long` (wrapper) preferred over `long` (primitive) for the `@Id` field in JPA entities?**
  > *"A primitive `long` defaults to `0`, which makes it ambiguous whether an entity is new or already persisted. A wrapper `Long` defaults to `null`. Hibernate uses `id == null` to determine whether an entity is in the **Transient** state (requiring an SQL `INSERT`) or the **Detached/Managed** state (requiring an SQL `UPDATE`)."*
* **Q3: What are the risks of using Lombok's `@Data` on JPA Entities, and how is it addressed in production?**
  > *"Lombok's `@Data` generates `equals()` and `hashCode()` using all fields. If an entity is stored in a `HashSet` before being saved, its `id` is `null`. Once saved, the `id` is populated, altering its `hashCode()` and corrupting the set. Additionally, bi-directional relationships in generated `toString()` trigger `StackOverflowError`. In strict production environments, senior teams use `@Getter`, `@Setter`, `@NoArgsConstructor` and manually implement `equals()` and `hashCode()` based strictly on business keys."*

### 🔍 Line-by-Line Code Breakdown of `User.java`
```java
// Line 1: Package location inside model
package com.example.nexpay.user.model;

// Jakarta Persistence imports (JPA 3.1 standard)
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity                                                 // 1. Registers this class as a managed JPA Entity table
@Table(name = "users")                                  // 2. Names table 'users' to prevent colliding with PostgreSQL's reserved 'user' keyword
@Data                                                   // 3. Lombok: generates getters, setters, toString(), equals(), hashCode()
@NoArgsConstructor                                      // 4. Default no-arg constructor required by Hibernate reflection proxies
@AllArgsConstructor                                     // 5. Full parameter constructor for testing and builder support
@Builder                                                // 6. Enables fluent Builder pattern: User.builder().email("...").build()
public class User {

    @Id                                                 // 7. Marks the Primary Key column
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 8. PostgreSQL BIGSERIAL auto-increment sequence (1, 2, 3...)
    private Long id;

    @Column(nullable = false)                           // 9. DDL constraint: NOT NULL
    private String fullName;

    @Column(nullable = false, unique = true)            // 10. DDL constraint: NOT NULL + UNIQUE B-Tree Index
    private String email;

    @Column(nullable = false)                           // 11. Stores 60-character BCrypt hash ($2a$10$...), NEVER plain text!
    private String passwordHash;

    @Column(nullable = false, unique = true)            // 12. Unique constraint prevents duplicate phone registrations
    private String phone;

    @Enumerated(EnumType.STRING)                        // 13. Persists "USER" / "ADMIN" as string varchar, preventing ORDINAL corruption
    private Role role;

    private LocalDateTime createdAt;                    // 14. Timestamp record creation audit column

    @PrePersist                                         // 15. Lifecycle callback triggered by EntityManager before SQL INSERT
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();           // 16. Sets creation timestamp in JVM RAM
    }

    public enum Role {                                  // 17. Security authority roles
        USER, ADMIN
    }
}
```

---

## Component 2: `UserRepository.java` — Dynamic Proxies, Query Derivation & Connection Pools

### 1. 🧠 The Core Concept, Mathematics & Internal Mechanics
* **Dynamic Proxy Synthesis at Boot Time:** `UserRepository` is an `interface` without an implementation class. During Spring Boot application startup, Spring Data JPA uses Java's `java.lang.reflect.Proxy` to generate a dynamic runtime proxy class implementing `UserRepository` and wrapping the underlying Hibernate `EntityManager`.
* **Query Derivation Grammars:** Spring Data parses method names (`findByEmail`, `existsByEmail`) using a formal grammar parser:
  * `findByEmail(String email)` $\rightarrow$ JPQL: `SELECT u FROM User u WHERE u.email = :email`
  * `existsByEmail(String email)` $\rightarrow$ JPQL: `SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.email = :email`
* **`Optional<T>` Monad Pattern:** Returning `Optional<User>` forces caller methods to explicitly handle presence or absence via functional combinators (`.orElseThrow()`, `.map()`), eliminating runtime `NullPointerException`s.

### 2. 🎯 The Production Engineering Problem It Solves
* **SQL Injection Neutralization:** Traditional JDBC string concatenation (`"SELECT * FROM users WHERE email = '" + email + "'"` ) is vulnerable to SQL injection. Spring Data JPA automatically enforces parameterized prepared statements (`WHERE email = ?`), separating SQL instructions from untrusted data parameters.
* **HikariCP Connection Pool Efficiency:** Manual JDBC connections require fragile `try-finally` blocks to return connections to the pool. Spring Data abstracts connection acquisition and release through transaction-scoped sessions, preventing connection leakage.

### 3. 🎤 Real Senior/Staff Interview Questions & Punchy Verbal Answers
* **Q1: Why should you use `existsByEmail()` instead of `findByEmail().isPresent()` when validating duplicate accounts?**
  > *"`findByEmail()` generates `SELECT * FROM users WHERE email = ?`, which loads the entire entity into memory, allocates heap objects, and populates the Hibernate First-Level Cache. In contrast, `existsByEmail()` executes an optimized `SELECT 1 FROM users WHERE email = ? LIMIT 1` (or `COUNT(1)`), executing in a fraction of the time with near-zero JVM memory allocation."*
* **Q2: How does Spring Data JPA implement repository interfaces without any written classes?**
  > *"At startup, Spring Data inspects interfaces extending `Repository`, interprets their method signatures, and creates a JDK Dynamic Proxy (`java.lang.reflect.Proxy`) backed by `SimpleJpaRepository` which delegates database calls to Hibernate's `EntityManager`."*

### 🔍 Line-by-Line Code Breakdown of `UserRepository.java`
```java
package com.example.nexpay.user.repository;

import com.example.nexpay.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository                                             // 1. Spring stereotype marking this interface as a Data Access Object (DAO)
public interface UserRepository extends JpaRepository<User, Long> {

    // 2. Generates: SELECT * FROM users WHERE email = ?
    // Returns Optional<User> to prevent NullPointerException
    Optional<User> findByEmail(String email);

    // 3. Generates: SELECT * FROM users WHERE phone = ?
    Optional<User> findByPhone(String phone);

    // 4. Generates: SELECT count(*) > 0 FROM users WHERE email = ?
    // Highly optimized boolean query for duplicate validation
    boolean existsByEmail(String email);

    // 5. Optimized boolean existence check for phone number
    boolean existsByPhone(String phone);
}
```

---

## Component 3: `RegisterRequest.java` — Input Boundary DTO & Fail-Fast Validation

### 1. 🧠 The Core Concept, Mathematics & Internal Mechanics
* **DTO Boundary Isolation:** Isolates public untrusted HTTP inputs from the internal domain model.
* **JSR-380 Bean Validation Mechanics:** Annotated fields (`@NotBlank`, `@Email`, `@Size`) are evaluated by Hibernate Validator before the controller method executes.
* **Password Length Entropy:** `@Size(min = 6)` enforces minimal password entropy:
  $$E = L \times \log_2(R) = 6 \times \log_2(94) \approx 39.3 \text{ bits of entropy}$$
  This prevents trivial 1-character passwords before the computationally expensive BCrypt encoder runs.

### 2. 🎯 The Production Engineering Problem It Solves
* **Denial of Service (DoS) Defense via CPU Throttling Protection:** BCrypt hashing intentionally consumes $\approx 60\text{ms}$ of CPU time. If an attacker spams thousands of requests with empty passwords, fail-fast DTO validation rejects the requests in $0.02\text{ms}$ in-memory, shielding server CPU cores from denial-of-service exhaustion.

### 3. 🎤 Real Senior/Staff Interview Questions & Punchy Verbal Answers
* **Q1: What happens under the hood when a `@Valid` annotation fails on a DTO?**
  > *"Spring Boot's `MethodValidationPostProcessor` intercepts the method argument. If any constraints fail, it throws a `MethodArgumentNotValidException` containing a `BindingResult` with all field errors. If not caught by a `@RestControllerAdvice`, Spring returns a default HTTP 400 Bad Request."*

### 🔍 Line-by-Line Code Breakdown of `RegisterRequest.java`
```java
package com.example.nexpay.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data                                                   // Generates getters, setters, toString(), equals(), hashCode()
public class RegisterRequest {

    @NotBlank(message = "Full name is required")        // Rejects null, "", and whitespace "   "
    private String fullName;

    @NotBlank(message = "Email is required")
    @Email(message = "Please enter a valid email")      // Evaluates RFC 5322 regex automaton
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters") // Enforces minimal entropy
    private String password;

    @NotBlank(message = "Phone is required")
    private String phone;
}
```

---

## Component 4: `SecurityConfig.java` — Filter Chain Architecture, CSRF Theory & BCrypt Hashing

### 1. 🧠 The Core Concept, Mathematics & Internal Mechanics
* **Spring Security 6+ Component Model:** Replaced inheritance (`WebSecurityConfigurerAdapter`) with pure functional `@Bean SecurityFilterChain` configuration.
* **Why CSRF is Disabled (`csrf.disable()`):** CSRF attacks rely on browsers automatically attaching session cookies to cross-origin requests. Because NexPay uses stateless bearer tokens (`Authorization: Bearer <token>`) passed via HTTP headers, browsers never send them automatically on cross-origin form submissions, rendering CSRF protection unnecessary.
* **BCrypt Hashing Cost Factor:** `BCryptPasswordEncoder` defaults to strength 10, executing $2^{10} = 1024$ key expansion rounds, forcing a $\approx 60\text{ms}$ delay per hash evaluation.

### 2. 🎯 The Production Engineering Problem It Solves
* **Centralized Authorization Policy:** Defines public permit-all entry points (`/api/auth/**`) and secures all future endpoints (`.anyRequest().authenticated()`) in a single declarative location.

### 3. 🎤 Real Senior/Staff Interview Questions & Punchy Verbal Answers
* **Q1: Why is CSRF protection disabled in stateless REST APIs using JWTs?**
  > *"CSRF vulnerabilities occur when an evil website triggers an authenticated request using ambient credentials stored in browser cookies. In stateless REST APIs, clients store JWTs in memory or local storage and explicitly send them via the `Authorization: Bearer` header. Browsers cannot automatically attach custom headers to cross-origin form submissions, so CSRF attacks are mathematically impossible."*

### 🔍 Line-by-Line Code Breakdown of `SecurityConfig.java`
```java
package com.example.nexpay.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration                                          // 1. Declares this class as a Spring configuration bean factory
@EnableWebSecurity                                     // 2. Activates Spring Security's web filter pipeline
public class SecurityConfig {

    @Bean                                               // 3. Exposes BCryptPasswordEncoder as an injectable Spring bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();             // Cost factor 10 (1024 rounds)
    }

    @Bean                                               // 4. Defines the HTTP Security Filter Chain
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())               // 5. Safe for stateless header-based JWT APIs
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/**").permitAll() // 6. Permits public registration and login
                .anyRequest().authenticated()           // 7. Enforces authentication on all other endpoints
            );
        return http.build();                            // 8. Compiles and returns the SecurityFilterChain bean
    }
}
```

---

## Component 5: `UserService.java` — Service Boundary, Constructor Injection & Business Rules

### 1. 🧠 The Core Concept, Mathematics & Internal Mechanics
* **Service Layer Boundary:** Encapsulates business logic, enforces business invariants (duplicate checks), and coordinates repository persistence.
* **Constructor Dependency Injection via `@RequiredArgsConstructor`:** Injects dependencies into `final` fields at instantiation time, enforcing immutability and preventing circular dependencies.
* **BCrypt Hashing Pipeline:** Encodes the plaintext password into a 60-character cryptographic salt-hash before building the `User` entity.

### 2. 🎯 The Production Engineering Problem It Solves
* **Defense-in-Depth Duplicate Verification:** Performs in-memory database queries (`existsByEmail`, `existsByPhone`) before persistence, providing clean business exception messages before falling back to PostgreSQL unique constraint violations.

### 3. 🎤 Real Senior/Staff Interview Questions & Punchy Verbal Answers
* **Q1: Why is Constructor Injection superior to `@Autowired` field injection in Spring?**
  > *"Constructor injection provides three major advantages: First, it allows dependencies to be marked `final`, ensuring thread-safe immutability. Second, it prevents partial object construction (the object cannot exist without its dependencies). Third, it enables effortless unit testing with Mockito without needing reflection or Spring container startup."*

### 🔍 Line-by-Line Code Breakdown of `UserService.java`
```java
package com.example.nexpay.user.service;

import com.example.nexpay.user.dto.RegisterRequest;
import com.example.nexpay.user.model.User;
import com.example.nexpay.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service                                                // 1. Marks this class as a Spring business service bean
@RequiredArgsConstructor                                // 2. Generates constructor for all 'final' fields (Constructor DI)
public class UserService {

    private final UserRepository userRepository;         // 3. Injected database repository
    private final PasswordEncoder passwordEncoder;       // 4. Injected BCrypt encoder

    public User registerUser(RegisterRequest request) {

        // 5. Enforce uniqueness: duplicate email check
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email is already registered!");
        }

        // 6. Enforce uniqueness: duplicate phone check
        if (userRepository.existsByPhone(request.getPhone())) {
            throw new RuntimeException("Phone number is already registered!");
        }

        // 7. Hash password and build immutable entity via Builder pattern
        User user = User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .passwordHash(passwordEncoder.encode(request.getPassword()))
                .phone(request.getPhone())
                .role(User.Role.USER)
                .build();

        // 8. Persist to PostgreSQL and return saved entity with generated ID
        return userRepository.save(user);
    }
}
```

---

## Component 6: `AuthController.java` — REST Dispatch, HTTP Semantics & `@Valid`

### 1. 🧠 The Core Concept, Mathematics & Internal Mechanics
* **Spring MVC `DispatcherServlet` Dispatch:** The front controller routes incoming HTTP `POST /api/auth/register` to `register()` using `RequestMappingHandlerMapping`.
* **`@RestController` = `@Controller` + `@ResponseBody`:** Automatically serializes returned objects into JSON using Jackson and writes directly to the HTTP response stream.
* **HTTP 201 Created Semantics:** Returns `HttpStatus.CREATED` (201) to denote successful creation of a new database entity.

### 2. 🎯 The Production Engineering Problem It Solves
* **Separation of Web Layer from Domain Logic:** Controllers strictly translate HTTP requests to Java objects and return HTTP status codes, never containing business calculations or database queries.

### 3. 🎤 Real Senior/Staff Interview Questions & Punchy Verbal Answers
* **Q1: What is the architectural difference between `@Controller` and `@RestController`?**
  > *"`@Controller` is designed for traditional Spring MVC server-side rendered web pages returning view template names (e.g., Thymeleaf/JSP). `@RestController` is a convenience meta-annotation that includes `@Controller` and `@ResponseBody`, ensuring that method return values are automatically serialized into JSON/XML and written directly to the HTTP response body."*

### 🔍 Line-by-Line Code Breakdown of `AuthController.java`
```java
package com.example.nexpay.user.controller;

import com.example.nexpay.user.dto.RegisterRequest;
import com.example.nexpay.user.model.User;
import com.example.nexpay.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController                                         // 1. Stereotype marking class as REST API controller returning JSON
@RequestMapping("/api/auth")                            // 2. Base URL routing prefix
@RequiredArgsConstructor                                // 3. Constructor injection for UserService
public class AuthController {

    private final UserService userService;              // 4. Injected business service

    @PostMapping("/register")                           // 5. Maps HTTP POST /api/auth/register
    public ResponseEntity<String> register(@Valid @RequestBody RegisterRequest request) {
        // 6. @Valid triggers Bean Validation; @RequestBody deserializes JSON
        User registeredUser = userService.registerUser(request);
        
        // 7. Returns HTTP 201 Created with confirmation payload
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("User registered successfully! ID: " + registeredUser.getId());
    }
}
```

---

# Chapter 4: Core Concepts & Annotations Master Reference

| Annotation / Keyword | What It Does | Real-World Analogy |
|---|---|---|
| `@Entity` | Declares class as a database table. | An official government registration form. |
| `@Id` + `@GeneratedValue` | Auto-generates unique primary key in PostgreSQL. | An auto-incrementing serial number stamped on a passport. |
| `@Repository` | Marks class as a data-access object talking to DB. | A librarian who fetches books from the shelves. |
| `@Service` | Marks class as a business-logic service. | The manager who reviews rules and makes decisions. |
| `@RestController` | Handles HTTP requests and serializes output directly to JSON. | A front-desk receptionist speaking in digital data. |
| `@Valid` | Activates validation rules (`@NotBlank`, `@Email`, `@Size`) on the incoming DTO. | A security inspector checking your form before letting you submit it. |
| `@RequestBody` | Converts incoming JSON payload into a Java object using Jackson. | A translator converting written text into spoken words. |
| `ResponseEntity` | Controls the entire HTTP response (Status code: 200, 201, 400 + headers + body). | A sealed official delivery envelope with custom postal stamps. |
| `@RequiredArgsConstructor` | Lombok generates constructor for all `final` fields, enabling Constructor Dependency Injection. | An assistant handing tools directly to a surgeon so they don't have to build their own. |
| `@Bean` | Tells Spring: "Create and manage this object in the ApplicationContext for other beans to use." | A pre-installed shared oven in a professional kitchen. |

---

# Chapter 5: Staff-Level Technical Deep-Dives

### 1. JVM Memory Layout & BigDecimal
- **Stack:** Thread-private memory storing primitive local variables, method call stacks, and 64-bit object references.
- **Heap:** Shared memory storing all object instances. Managed by the Garbage Collector (Young Gen Eden $\rightarrow$ Survivor S0/S1 $\rightarrow$ Old Gen Tenured).
- **Why `BigDecimal` for Money?** Binary floating point (`float`/`double`) uses base-2 scientific notation (IEEE 754), which cannot represent fractions like 0.1 exactly ($0.1 + 0.2 = 0.30000000000000004$). `BigDecimal` uses an arbitrary-precision integer unscaled value + a 32-bit scale, guaranteeing exact base-10 math and zero monetary drift.

### 2. Spring Boot Core, IoC & Dependency Injection
- Spring inverts control: rather than classes calling `new UserRepository()`, the Spring `ApplicationContext` instantiates beans, resolves their Directed Acyclic Graph (DAG) dependencies, and injects them via constructors.
- Constructor injection enforces immutability via `final` fields, prevents partial initialization bugs, and allows pure POJO unit testing with Mockito.

### 3. BCrypt Hashing & Salt Theory
- One-way cryptographic trapdoor function based on the Blowfish cipher.
- Structure: `$2a$10$vI8aWBnW3fID.ZQ4/zo1G.q1lRps.9cGLcZEiGDMVr5yUP1KUOYTa` (Algorithm + $2^{\text{cost}}$ rounds + 128-bit salt + 184-bit checksum).
- Defeats **Rainbow Table attacks** because the 128-bit salt expands the hash space by $2^{128}$.
- Defeats **GPU brute-force attacks** because the work factor forces intentional CPU/memory latency ($\approx 60\text{ms}$ per hash evaluation).

### 4. PostgreSQL & Hibernate/JPA Persistence Lifecycle
- Managed entities exist in 4 states:
  1. **Transient:** `new User()` — unmanaged, no database ID.
  2. **Managed:** Tracked by `EntityManager` session First-Level Cache. Field changes are automatically synchronized via **Dirty Checking** at flush time.
  3. **Detached:** Transaction committed and session closed.
  4. **Removed:** Scheduled for SQL `DELETE`.
- `GenerationType.IDENTITY` delegates ID generation to PostgreSQL `BIGSERIAL` sequence on row insertion.

### 5. Modern Java Features (Java 10 → 17 → 21/24)
- **`var` (Java 10):** Compile-time local variable type inference (`var token = new UsernamePasswordAuthenticationToken(...)`). Java remains 100% statically typed; `javac` writes the full concrete type into the `.class` bytecode.
- **Text Blocks `""" ... """` (Java 15):** Multi-line strings for SQL, JSON, and AI prompts that strip incidental indentation at compile-time without `\"` or `\n` clutter.
- **`record` (Java 16):** Immutable data carrier (`public record AuthResponse(String token, String email) {}`). Generates `private final` fields, canonical constructor, and `invokedynamic`-backed `equals()`, `hashCode()`, and `toString()`.
- **Pattern Matching & Exhaustive `switch` (Java 17/21):** Allows `if (obj instanceof String s)` without manual casting, and arrow `switch` expressions (`case USER -> ...`) that enforce compile-time exhaustiveness checking with no `break;` fall-through bugs.
- **`sealed` Classes/Interfaces (Java 17):** Restricts inheritance via `permits` (`public sealed interface PaymentResult permits Success, Failure`), verified by the JVM classloader via the `PermittedSubclasses` bytecode attribute.
- **Virtual Threads — Project Loom (Java 21):** Lightweight JVM-managed threads ($\approx 1\text{KB}$ RAM vs. $1\text{MB}$ OS thread). When a virtual thread hits blocking PostgreSQL or HTTP I/O, the JVM unmounts its stack continuation onto the Heap, preventing OS thread starvation and enabling $50{,}000+$ concurrent requests.

---

# Chapter 6: Day 1 — JWT Authentication & Global Error Handling (From Scratch)

## Step 1: JWT Architecture, Maven Runtime Scopes (`pom.xml`) & 256-Bit Key Sizing (`application.yml`)

### 1. 🧠 The Core Concept, Mathematics & Internal Mechanics
* **Why Stateful Sessions Fail at Scale vs. Stateless JWT (RFC 7519):**
  * *Stateful Sessions:* Server generates a random `JSESSIONID`, stores user data in server RAM, and gives the browser a cookie.
  * *Stateless JWT:* Server stores **zero** session data in RAM. Instead, it embeds the user identity inside a JSON payload and signs it mathematically with a secret key:
    $$\text{JWT} = \underbrace{\text{Base64URL}(\text{Header})}_{\text{Algorithm: HS256}} \,.\, \underbrace{\text{Base64URL}(\text{Payload})}_{\text{sub, iat, exp}} \,.\, \underbrace{\text{Base64URL}\Big(\text{HMAC-SHA256}(\text{Header.Payload}, \text{SecretKey})\Big)}_{\text{256-bit Cryptographic Signature}}$$
* **Why `jjwt` is Split into 3 Maven Dependencies (`pom.xml`):**
  1. `jjwt-api` (Compile Scope): Contains only the public Java interfaces (`Jwts`, `Claims`). Your code compiles strictly against these interfaces.
  2. `jjwt-impl` (`<scope>runtime</scope>`): Contains the internal cryptographic engine. Marked `runtime` so application code cannot accidentally import internal implementation classes (enforcing strict encapsulation).
  3. `jjwt-jackson` (`<scope>runtime</scope>`): Bridges JJWT with Spring Boot's Jackson JSON parser to serialize/deserialize the JWT payload.
* **Why the Secret Key in `application.yml` Must Be $\ge 256$ Bits ($32$ ASCII characters):**
  * HMAC-SHA256 produces a $256$-bit ($32$-byte) digest. By RFC 7518 (JWA Specification Section 3.2), the secret key used with `HS256` **must be at least $256$ bits ($32$ bytes/characters) long**. If you provide a shorter key (e.g. `"mysecret"` = $64$ bits), JJWT immediately throws `WeakKeyException` at runtime to prevent brute-force key recovery!

### 2. 🎯 The Production Engineering Problem It Solves
* **Horizontal Auto-Scaling Without Sticky Sessions:** In AWS production with 10 EC2 instances behind a Load Balancer, stateful sessions fail when Request 1 hits Server A (login) and Request 2 hits Server B (transfer), because Server B does not have Server A's RAM. With JWT, any of the 10 EC2 servers can independently verify the HMAC-SHA256 signature in $0.1\text{ms}$ with zero shared memory or database lookups.
* **Zero-Recompile Environment Promotion (12-Factor App Config):** Storing `jwt.secret` and `jwt.expiration` ($86{,}400{,}000\text{ms} = 24\text{h}$) in `application.yml` separates configuration from code. In AWS production, we override `JWT_SECRET` via environment variables without touching or recompiling a single line of Java.

### 3. 🎤 Real Senior/Staff Interview Questions & Punchy Verbal Answers
* **Q1: Why is `jjwt-impl` marked with `<scope>runtime</scope>` in Maven `pom.xml`?**
  > *"Marking `jjwt-impl` and `jjwt-jackson` with `runtime` scope enforces strict API-to-Implementation decoupling at compile time. Our Java source code can only import interfaces from `jjwt-api` during compilation, preventing developers from coupling business code to internal library implementation classes, while the JVM classloader still loads the implementation JARs at runtime via ServiceLoader."*
* **Q2: What happens if you configure an HS256 JWT secret key that is only 10 characters long?**
  > *"10 ASCII characters equal only 80 bits of entropy. RFC 7518 mandates that HMAC-SHA256 keys must be at least 256 bits (32 bytes) to match the 256-bit output block size of SHA-256. Compliant libraries like JJWT enforce this specification by throwing a `WeakKeyException` immediately, preventing the server from signing tokens with a brute-forceable key."*

---

## Step 2: `LoginRequest.java` — DTO Deserialization, Lombok AST & Fail-Fast Validation

### 1. 🧠 The Core Concept, Mathematics & Internal Mechanics
* **DTO (Data Transfer Object) Boundary Contract:** An isolated data carrier with zero business logic or persistence mappings that defines the strict input contract between untrusted HTTP JSON bytes and JVM memory.
* **Jackson Deserialization Mechanics (`MappingJackson2HttpMessageConverter`):**
  1. Reads raw UTF-8 bytes (`{"email":"rishi@gmail.com","password":"secret123"}`) from the Tomcat socket stream via `JsonParser`.
  2. Allocates a new instance on the JVM Young Generation (Eden) Heap via the no-arg constructor `new LoginRequest()`.
  3. Matches JSON field keys to Java setter methods (`setEmail()`, `setPassword()`) and populates the private fields.
* **Compile-Time AST Manipulation (`@Data`):** Lombok hooks into `javac` via the **JSR-269 Pluggable Annotation Processing API**, injecting getters, setters, `equals()`, `hashCode()`, and `toString()` directly into the Abstract Syntax Tree (AST) before `.class` bytecode is emitted. Zero runtime reflection overhead.
* **JSR-380 Bean Validation Mechanics (`HibernateValidator`):**
  * `@NotNull`: Checks $x \neq \text{null}$ (passes `""` and `"   "`).
  * `@NotEmpty`: Checks $x \neq \text{null} \land \text{length}(x) > 0$ (passes `"   "`).
  * `@NotBlank`: Checks $x \neq \text{null} \land \text{length}(\text{trim}(x)) > 0$.
  * `@Email`: Evaluates a compiled Deterministic Finite Automaton (Regex state machine) verifying RFC 5322 syntax (`local-part@domain`).

### 2. 🎯 The Production Engineering Problem It Solves
* **Mass Assignment / Privilege Escalation Prevention:** Binding JSON directly to `@Entity User` allows attackers to pass `"role": "ADMIN"` or `"id": 1` in the JSON body, overwriting sensitive database columns. `LoginRequest` physically lacks `setRole()` or `setId()`, neutralizing Mass Assignment attacks.
* **HikariCP Connection Pool Protection (Fail-Fast):** In-memory DTO validation executes in $\approx 0.02\text{ms}$ on the CPU. Without it, malformed bot traffic ($5{,}000$ empty requests/sec) travels to `UserRepository`, acquiring scarce database connections ($\approx 15\text{ms}$ network I/O) and starving the entire payment platform.

### 3. 🎤 Real Senior/Staff Interview Questions & Punchy Verbal Answers
* **Q1: Why should you never expose or accept JPA `@Entity` classes directly in `@RestController` endpoints?**
  > *"Exposing JPA entities directly creates three severe production risks: First, **Mass Assignment vulnerabilities**, where attackers inject fields like `role: ADMIN` into JSON payloads. Second, tight coupling between the database schema and public API contract, where renaming a column breaks client apps. Third, `LazyInitializationException` or N+1 query explosions when Jackson attempts to serialize lazy-loaded collections outside the transaction boundary."*
* **Q2: What is the difference between `@NotNull`, `@NotEmpty`, and `@NotBlank`?**
  > *"`@NotNull` only checks reference inequality with null, allowing empty strings `""`. `@NotEmpty` checks that length is greater than zero, which still allows whitespace-only strings `"   "`. `@NotBlank` trims leading and trailing whitespace before checking that length is greater than zero, making it mandatory for user text inputs like emails and passwords."*
* **Q3: Does Lombok's `@Data` degrade runtime performance via reflection?**
  > *"No. Lombok operates exclusively at compile-time using the JSR-269 Annotation Processing API to modify the Java Abstract Syntax Tree and emit standard bytecode methods. At runtime, there is zero reflection and zero performance penalty compared to hand-written getters and setters."*
* **Q4: When should you use Modern Java `record`s (Java 16+) vs. Lombok `@Data` classes in Spring Boot?**
  > *"We use Java `record`s for **DTOs and event payloads** because they are natively immutable (`private final` fields), thread-safe, and deserialized by Jackson via their canonical constructor without needing Lombok. However, **JPA `@Entity` classes must remain standard `class`es**, because Hibernate requires non-final classes, a no-arg constructor, and mutable state for dirty checking and ByteBuddy proxy generation."*
* **Q5: How do Java 21+ Virtual Threads (`spring.threads.virtual.enabled=true`) improve Spring Boot throughput?**
  > *"Traditional Tomcat worker threads map 1:1 to OS kernel threads (1MB stack each), blocking the OS thread during synchronous DB or HTTP calls. Virtual threads are lightweight JVM-managed continuations (~1KB RAM). When a virtual thread hits blocking I/O, the JVM unmounts it from the OS carrier thread immediately, enabling tens of thousands of concurrent requests with simple synchronous code."*

---

## Step 3: `AuthResponse.java` — Outbound Serialization & Sensitive Credential Shielding

### 1. 🧠 The Core Concept, Mathematics & Internal Mechanics
* **Outbound DTO Boundary Contract:** A dedicated response container carrying only safe, client-facing fields (`token`, `email`, `fullName`) returned upon successful authentication.
* **Jackson Serialization Mechanics (`MappingJackson2HttpMessageConverter`):**
  1. The Controller returns `ResponseEntity.ok(new AuthResponse(token, email, fullName))`.
  2. Spring's `RequestResponseBodyMethodProcessor` delegates serialization to Jackson.
  3. Jackson invokes getter methods (`getToken()`, `getEmail()`, `getFullName()`) generated by Lombok `@Data`.
  4. Jackson's `JsonGenerator` formats the key-value pairs into a UTF-8 encoded byte stream and writes directly to Tomcat's HTTP socket response buffer:
     $$\text{Heap Object} \xrightarrow{\text{Getters}} \text{Jackson JsonGenerator} \xrightarrow{\text{UTF-8}} \text{TCP Socket Buffer}$$
* **Compile-Time Constructor Generation (`@AllArgsConstructor`):**
  * Generates an all-arguments constructor `public AuthResponse(String token, String email, String fullName)` directly in bytecode via JSR-269 annotation processing. Allows `UserService` to cleanly instantiate the response in one line without boilerplate constructors.

### 2. 🎯 The Production Engineering Problem It Solves
* **Accidental Credential Exfiltration (CWE-200):** If an endpoint returns the database entity `User` directly, Jackson will serialize every column unless manually hidden. Even if `@JsonIgnore` is placed on `password`, developers frequently forget this on new columns (e.g. `failedLoginAttempts`, `salt`, `mfaSecret`). Returning an explicit `AuthResponse` guarantees zero database columns leak over the wire.
* **Lazy Loading Failures & Infinite Serialization Loops:** Returning JPA entities with relational associations (e.g., `User` $\leftrightarrow$ `Wallet`) outside transaction boundaries causes Jackson to trigger `LazyInitializationException`, or infinite cyclic recursion causing `StackOverflowError` and thread termination.

### 3. 🎤 Real Senior/Staff Interview Questions & Punchy Verbal Answers
* **Q1: Why should you never return a JPA `@Entity` directly from a `@RestController`?**
  > *"Returning JPA entities directly introduces two catastrophic production risks: First, security exfiltration—sensitive database fields like password hashes or internal status flags can easily leak to API clients. Second, runtime crashes—Jackson attempting to serialize lazy-loaded ORM relationships outside active Hibernate sessions triggers `LazyInitializationException`, or enters recursive serialization loops resulting in `StackOverflowError`."*
* **Q2: What is the difference between `@NoArgsConstructor`, `@RequiredArgsConstructor`, and `@AllArgsConstructor` in Lombok?**
  > *"`@NoArgsConstructor` generates an empty parameterless constructor, required by frameworks like Hibernate and Jackson for reflective instantiation. `@RequiredArgsConstructor` generates a constructor only for `final` fields and `@NonNull` fields, which is the industry standard for Spring Dependency Injection in `@Service` classes. `@AllArgsConstructor` generates a constructor accepting every declared field, ideal for outbound DTOs."*
* **Q3: What HTTP status code should be returned with `AuthResponse` upon successful login?**
  > *"HTTP `200 OK` should be returned. Unlike user creation which returns `201 Created` because a new resource URI was minted in the database, login is an idempotent query/session-creation operation returning an access token, so `200 OK` conforms to REST conventions."*

---

## Step 4: `JwtService.java` — HMAC-SHA256 Token Mint, Claims Cryptography & JJWT 0.12 Mechanics

### 1. 🧠 The Core Concept, Mathematics & Internal Mechanics
* **Cryptographic Signing via HMAC-SHA256 (RFC 2104 / RFC 7518):**
  * HMAC combines a secret cryptographic key $K$ with token data $m = \text{Header} \parallel \text{\".\"} \parallel \text{Payload}$:
    $$\text{HMAC}(K, m) = H\Big((K' \oplus \text{opad}) \parallel H\big((K' \oplus \text{ipad}) \parallel m\big)\Big)$$
    Where $\text{ipad} = 0\times36$, $\text{opad} = 0\times5c$, and $H$ is the SHA-256 compression function.
  * **The Avalanche Effect:** Altering even 1 single character or bit in the payload (e.g. changing an email or expiry) causes more than 50% of the signature bits to change unpredictably, causing instant mathematical rejection on signature verification.
* **JCA (Java Cryptography Architecture) Key Specification:**
  * Raw bytes from `application.yml` (`jwt.secret`) are transformed into a cryptographically secure `javax.crypto.SecretKey` using `Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8))`. JJWT enforces that this byte array is at least 32 bytes (256 bits).
* **JJWT 0.12.x Architecture:**
  * JJWT 0.12 modernizes the parser API:
    * Replaced deprecated `Jwts.parserBuilder()` with `Jwts.parser()`.
    * Replaced deprecated `.setSigningKey(key)` with type-safe `.verifyWith(SecretKey)`.
    * Replaced deprecated `.getBody()` with `.getPayload()` returning immutable `Claims`.
  * Claims parsing automatically verifies:
    1. Signature validity (throws `SecurityException` / `SignatureException` on tampering).
    2. Expiration timestamp (throws `ExpiredJwtException` if `exp < currentTimeMillis`).
    3. Structural validity (throws `MalformedJwtException` if not 3 base64url segments).

### 2. 🎯 The Production Engineering Problem It Solves
* **Horizontal Scalability (Zero-Session Clustering):** In traditional stateful architectures, 10 Spring Boot instances behind an AWS Load Balancer require sticky sessions or distributed Redis clustering to share session data. With stateless JWTs, any server instance can cryptographically verify the token in $<0.05\text{ms}$ on local CPU cores with zero network calls and zero database queries.
* **PostgreSQL Connection Pool Conservation:** A fintech platform handling 20,000 req/sec would exhaust its database connection pool if every incoming request required querying a `sessions` table. JWT verification happens entirely in JVM RAM, saving tens of millions of database reads per hour.

### 3. 🎤 Real Senior/Staff Interview Questions & Punchy Verbal Answers
* **Q1: What is the computational complexity and performance footprint of verifying a JWT vs querying a session in Redis?**
  > *"JWT verification is an in-memory CPU cryptographic hash check (HMAC-SHA256 over ~200 bytes) taking 10–50 microseconds on the local JVM thread with zero network I/O. A Redis session check requires socket serialization, TCP round-trip latency (0.5ms–2ms), and Redis thread pool resources. At 50,000 requests/sec, stateless JWT eliminates 50,000 network round-trips per second and avoids Redis cluster bottlenecking."*
* **Q2: If JWTs are completely stateless, how do you handle immediate token revocation (logout, password reset, compromised tokens)?**
  > *"We utilize three production strategies: First, **Short-Lived Access Tokens (15 min) + Refresh Tokens (7 days)** stored in httpOnly cookies; revocation occurs at the refresh boundary. Second, **Redis Blacklist with TTL**: On logout, save the token's unique `jti` (JWT ID) in Redis with TTL equal to the token's remaining lifespan, checking it during the filter chain. Third, **User Token Versioning**: Store an integer `token_version` on the `User` entity and inside the JWT claims; incrementing the version in the DB immediately invalidates all active tokens issued under the prior version."*
* **Q3: What exceptions are thrown by JJWT when validating tokens in production?**
  > *"`Jwts.parser().verifyWith(key).build().parseSignedClaims(token)` throws four primary runtime exceptions: `ExpiredJwtException` when past expiration, `SignatureException` when the HMAC signature is forged or tampered with, `MalformedJwtException` when the token structure is corrupted, and `IllegalArgumentException` when the token string is null or whitespace."*
* **Q4: Why does JJWT 0.12 use `verifyWith()` and `getPayload()` instead of deprecated `setSigningKey()` and `getBody()`?**
  > *"JJWT 0.12 completely segregated signed tokens (JWS) from encrypted tokens (JWE). `verifyWith()` accepts a type-safe `SecretKey` or `PublicKey` to eliminate ambiguous key-type bugs, and `getPayload()` explicitly indicates payload claims retrieval rather than generic body data."*

### 🔍 Line-by-Line Code Breakdown of `JwtService.java`

```java
// Line 1: Package location inside security
package com.example.nexpay.security;

// Line 3-5: JJWT 0.12 imports for claims parsing and cryptographic key builder
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

// Line 7-8: Spring Framework imports for DI and reading configuration properties
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

// Line 10-12: Java standard cryptography, charset, and date imports
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

// Line 14: Marks this class as a Spring-managed Service bean registered in the ApplicationContext
@Service
public class JwtService {

    // Line 17-18: Injects the 256-bit secret string from application.yml (jwt.secret)
    @Value("${jwt.secret}")
    private String secret;

    // Line 20-21: Injects the token expiration time in ms (86400000 = 24 hours) from application.yml
    @Value("${jwt.expiration}")
    private long expiration;

    // Line 23-26: Transforms the secret string into a JCA-compliant HMAC-SHA SecretKey
    private SecretKey getSigningKey() {
        byte[] keyBytes = secret.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // Line 28-36: Mints a new signed JWT containing email as the subject, iat, and exp
    public String generateToken(String email) {
        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSigningKey())
                .compact();
    }

    // Line 38-45: Parses and validates the cryptographic signature, returning the Claims payload
    public Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    // Line 47-49: Extracts the subject (user's email) from the token claims
    public String extractEmail(String token) {
        return extractAllClaims(token).getSubject();
    }

    // Line 51-53: Extracts the token expiration Date
    public Date extractExpiration(String token) {
        return extractAllClaims(token).getExpiration();
    }

    // Line 55-57: Verifies whether the expiration timestamp has passed
    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // Line 59-63: Verifies that the email matches and the token is not expired
    public boolean isTokenValid(String token, String userEmail) {
        final String email = extractEmail(token);
        return (email.equals(userEmail) && !isTokenExpired(token));
    }
}
```

---

## Step 5: `JwtFilter.java` & Updating `SecurityConfig.java` — Request Interception, ThreadLocal Security Context & Stateless Filter Chain

### 1. 🧠 The Core Concept, Mathematics & Internal Mechanics
* **Servlet Filter Pipeline & `OncePerRequestFilter` Guarantee:**
  * In the Java Servlet specification, a standard `Filter` can be invoked multiple times for a single HTTP request during internal server dispatches (such as `FORWARD`, `INCLUDE`, or asynchronous processing via `ASYNC`).
  * Spring's `OncePerRequestFilter` abstract class provides an idempotent execution guarantee: it checks an internal request attribute `alreadyFilteredAttribute` to guarantee that its `doFilterInternal()` logic runs **exactly once per incoming HTTP request**.
* **RFC 6750 Bearer Token Header Parsing:**
  * HTTP standard: `Authorization: Bearer <base64url-token>`.
  * The filter parses the header, checks `startsWith("Bearer ")`, and performs an $O(1)$ substring operation from index 7 to extract the raw token string.
* **`SecurityContextHolder` & `ThreadLocal` Memory Architecture:**
  * Spring Security binds authentication state to the active Java worker thread using `ThreadLocal<SecurityContext>`.
  * Structure:
    $$\text{Tomcat Worker Thread} \longrightarrow \text{ThreadLocalMap} \longrightarrow \text{SecurityContext} \longrightarrow \text{Authentication (Principal, Authorities)}$$
  * When `jwtService.isTokenValid()` returns `true`, the filter builds an authenticated `UsernamePasswordAuthenticationToken` and assigns it to `SecurityContextHolder.getContext().setAuthentication(authToken)`. All downstream filters, interceptors, and `@RestController` endpoints can now access the logged-in user without re-verifying the token!
* **Stateless Session Policy (`SessionCreationPolicy.STATELESS`):**
  * Tells Spring Security: **never** allocate an `HttpSession` in Tomcat RAM and **never** emit a `Set-Cookie: JSESSIONID` header. Every incoming request must provide its own credentials via the `Authorization` header.
* **Filter Ordering (`.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)`):**
  * Spring Security organizes security checks into an ordered list called the `SecurityFilterChain`. By injecting `JwtFilter` *before* `UsernamePasswordAuthenticationFilter`, our token validator inspects every incoming request before default form/session mechanisms execute.

### 2. 🎯 The Production Engineering Problem It Solves
* **ThreadLocal Leakage & Context Pollution in Thread Pools:**
  * High-concurrency servers like Tomcat reuse worker threads from an executor pool (`200` default threads). If authentication state is not properly managed, Request B on a recycled thread could inherit the security context left behind by Request A. `OncePerRequestFilter` combined with Spring Security's `SecurityContextPersistenceFilter` (or modern `SecurityContextHolderFilter`) guarantees the `SecurityContext` is cleanly populated per request and wiped at the end of the HTTP response lifecycle.
* **Downstream CPU & Database Load Protection:**
  * If an invalid or expired token is passed, the filter aborts authentication immediately. Downstream services and database transactions are never invoked for unauthenticated requests.

### 3. 🎤 Real Senior/Staff Interview Questions & Punchy Verbal Answers
* **Q1: Why does `JwtFilter` extend `OncePerRequestFilter` instead of implementing `jakarta.servlet.Filter` directly?**
  > *"`OncePerRequestFilter` provides an idempotent execution guarantee across different servlet containers and request dispatch types (e.g., `REQUEST`, `FORWARD`, `INCLUDE`, `ASYNC`). A raw `Filter` can be invoked multiple times for a single HTTP request during internal servlet forwarding, resulting in duplicate token parsing, redundant database calls, and wasted CPU cycles."*
* **Q2: How does `SecurityContextHolder` store the authenticated user in JVM memory, and why must the filter check if authentication is already present?**
  > *"`SecurityContextHolder` uses a `ThreadLocal` by default, binding the `SecurityContext` directly to the active worker thread. We check `SecurityContextHolder.getContext().getAuthentication() == null` before validating to avoid redundant JWT verification if an upstream filter already established authentication, and to ensure we do not overwrite an existing security context unnecessarily."*
* **Q3: Why do we pass `null` as the credentials in `UsernamePasswordAuthenticationToken` when setting the security context after JWT verification?**
  > *"Once the cryptographic signature and expiration of the JWT are verified, the user is already authenticated. Keeping raw credentials or tokens in the `Authentication` object inside `SecurityContextHolder` creates an unnecessary memory footprint and security risk if the context is logged or inspected by third-party libraries. In modern security patterns, credentials are cleared immediately post-authentication."*
* **Q4: Why must `SessionCreationPolicy.STATELESS` be explicitly configured in `SecurityConfig`?**
  > *"By default, Spring Security creates stateful `HttpSession`s in Tomcat's memory and tracks users using `JSESSIONID` cookies. Setting `SessionCreationPolicy.STATELESS` instructs Spring Security to never create or query an `HttpSession`, ensuring the application remains 100% stateless across horizontal cluster nodes."*

### 🔍 Line-by-Line Code Breakdown of `JwtFilter.java`

```java
// Line 1: Package location inside security
package com.example.nexpay.security;

// Jakarta Servlet standard filter imports (Tomcat 10+ / Spring Boot 3+)
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Lombok constructor injection
import lombok.RequiredArgsConstructor;

// Spring Security authentication and ThreadLocal context imports
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

// Marks as a Spring Component bean so SecurityConfig can inject it
@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    // Injected Token Mint service
    private final JwtService jwtService;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        // 1. Read the HTTP Authorization header
        final String authHeader = request.getHeader("Authorization");

        // 2. If no Bearer token, pass request downstream (public endpoints like /register and /login will pass through)
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        // 3. Extract the 3-part JWT string after "Bearer " (index 7)
        final String jwt = authHeader.substring(7);
        final String userEmail;

        try {
            userEmail = jwtService.extractEmail(jwt);
        } catch (Exception e) {
            // Catches ExpiredJwtException, SignatureException, MalformedJwtException
            filterChain.doFilter(request, response);
            return;
        }

        // 4. If email is present and thread is not yet authenticated
        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            // 5. Verify email match and token timestamp expiration
            if (jwtService.isTokenValid(jwt, userEmail)) {

                // 6. Build a lightweight UserDetails principal for the SecurityContext
                UserDetails userDetails = User.builder()
                        .username(userEmail)
                        .password("") // Credentials erased post-authentication
                        .authorities(Collections.emptyList())
                        .build();

                // 7. Create authenticated token representation
                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.getAuthorities()
                        );

                // 8. Attach client network details (IP address, session ID)
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                // 9. Store authentication in ThreadLocal memory for downstream controllers
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        // 10. Pass request to next filter in the chain
        filterChain.doFilter(request, response);
    }
}
```

---

### 🔍 Line-by-Line Code Breakdown of Updated `SecurityConfig.java`

```java
package com.example.nexpay.config;

import com.example.nexpay.security.JwtFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    // 1. Injected JwtFilter gatekeeper
    private final JwtFilter jwtFilter;

    // 2. BCrypt password hashing bean (Cost factor 10)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 3. Exposes AuthenticationManager bean for verifying credentials in UserService
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    // 4. Defines the HTTP Security Filter Chain
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // 5. Disable CSRF (safe for stateless header-based JWT tokens)
            .csrf(csrf -> csrf.disable())
            // 6. Enforce 100% stateless session policy (no HttpSessions created in Tomcat RAM)
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            // 7. Authorization rule matching
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/**").permitAll() // Open login and registration
                .anyRequest().authenticated()               // Secure all other endpoints
            )
            // 8. Position JwtFilter BEFORE UsernamePasswordAuthenticationFilter in the chain
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
```

---

## Step 6: `UserService.java` Login, `AuthController.java` Endpoint & `GlobalExceptionHandler.java` (RFC 7807)

### 1. 🧠 The Core Concept, Mathematics & Internal Mechanics
* **BCrypt Password Verification (`passwordEncoder.matches`):**
  * BCrypt is a one-way trapdoor function; hashes cannot be decrypted.
  * When verifying:
    1. Extracts the 128-bit salt and cost factor $2^{\text{cost}}$ directly from the stored `$2a$10$...` hash string.
    2. Runs the candidate raw password through the exact same key derivation algorithm.
    3. Performs a **Constant-Time String Comparison** (`MessageDigest.isEqual`) on the resulting checksums. Constant-time comparison ensures that comparison time is independent of how many characters match, mathematically neutralizing **Timing Attacks**.
* **Spring AOP Exception Interception (`@RestControllerAdvice`):**
  * A specialization of `@Component` that acts as a global interceptor across all `@RestController` beans via Spring's `HandlerExceptionResolver` pipeline.
  * When an exception propagates past the controller layer, Spring intercepts it, scans the advice bean for a matching `@ExceptionHandler(ExceptionType.class)`, and executes the designated handler method.
* **RFC 7807 / Standardized Error Schema:**
  * Defines a uniform contract for HTTP error payloads (`timestamp`, `status`, `error`, `message`, `path`). Clients and frontends receive consistent JSON error payloads regardless of whether the error originated from validation, security, or business logic.

### 2. 🎯 The Production Engineering Problem It Solves
* **User Enumeration Defense:**
  * If a system returns *"Email not found"* when an email is unregistered, and *"Incorrect password"* when the password is wrong, attackers can scrape thousands of email addresses to discover which ones have accounts on the platform.
  * By returning a unified `"Invalid email or password"` with consistent response timing, user enumeration is completely defeated.
* **Stack Trace Information Leakage (CWE-209):**
  * Default Spring Boot behavior returns the Whitelabel Error Page, exposing internal Java class names, database table names, SQL queries, and library versions in production. Attackers weaponize stack traces for reconnaissance.
  * `@RestControllerAdvice` guarantees that internal stack traces are captured in server logs for engineers while the client receives only safe, sanitized JSON.

### 3. 🎤 Real Senior/Staff Interview Questions & Punchy Verbal Answers
* **Q1: Why should you never return "User not found" vs "Wrong password" during authentication?**
  > *"Distinguishing between 'user not found' and 'incorrect password' introduces a **User Enumeration vulnerability**. Attackers can automate dictionary attacks against the `/login` endpoint to discover which email addresses correspond to real user accounts. Returning a generic 'Invalid email or password' message with consistent latency protects user privacy and stops credential harvesting."*
* **Q2: How does `passwordEncoder.matches()` verify a password without decrypting the stored hash?**
  > *"BCrypt is a one-way cryptographic hash function and cannot be decrypted. Instead, `matches()` reads the 128-bit salt and cost factor embedded directly in the stored hash string, computes a fresh hash on the incoming candidate password using that exact salt and cost, and verifies equality using constant-time comparison."*
* **Q3: What is the difference between `@ControllerAdvice` and `@RestControllerAdvice`?**
  > *"`@RestControllerAdvice` is a meta-annotation composed of `@ControllerAdvice` and `@ResponseBody`. It automatically serializes the returned error response object directly into JSON and writes it to the HTTP response stream, whereas `@ControllerAdvice` requires manual `@ResponseBody` annotations on each exception handler method."*
* **Q4: How do you extract and format Bean Validation field errors in `@RestControllerAdvice`?**
  > *"When validation fails on `@Valid` parameters, Spring throws `MethodArgumentNotValidException`. In the handler method, we invoke `ex.getBindingResult().getFieldErrors()`, iterate over the collection, and collect `fieldError.getField()` and `fieldError.getDefaultMessage()` into a structured `Map<String, String>` returned with HTTP 400 Bad Request."*

### 🔍 Line-by-Line Code Breakdown of `UserService.java` (Login Method)

```java
// Method inside UserService.java
public AuthResponse login(LoginRequest request) {

    // 1. Fetch user from PostgreSQL by email
    // If not found, throws RuntimeException with generic message to prevent user enumeration
    User user = userRepository.findByEmail(request.getEmail())
            .orElseThrow(() -> new RuntimeException("Invalid email or password"));

    // 2. Constant-time BCrypt hash comparison
    // Extracts salt & rounds from user.getPasswordHash() and verifies candidate request.getPassword()
    if (!passwordEncoder.matches(request.getPassword(), user.getPasswordHash())) {
        throw new RuntimeException("Invalid email or password");
    }

    // 3. Mints an HMAC-SHA256 cryptographically signed JWT token embedding the user's email
    String token = jwtService.generateToken(user.getEmail());

    // 4. Returns outbound DTO carrying token and public profile details
    return new AuthResponse(token, user.getEmail(), user.getFullName());
}
```

---

### 🔍 Line-by-Line Code Breakdown of `AuthController.java` (Login Endpoint)

```java
// Endpoint inside AuthController.java
// Maps HTTP POST requests to /api/auth/login
@PostMapping("/login")
public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
    // 1. @Valid triggers Bean Validation on email and password in memory
    // 2. @RequestBody deserializes incoming JSON stream into LoginRequest instance
    AuthResponse response = userService.login(request);
    
    // 3. Returns HTTP 200 OK with the AuthResponse JSON payload
    return ResponseEntity.ok(response);
}
```

---

### 🔍 Line-by-Line Code Breakdown of `GlobalExceptionHandler.java`

```java
package com.example.nexpay.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

// 1. Spring AOP advice interceptor wrapping all @RestController executions
@RestControllerAdvice
public class GlobalExceptionHandler {

    // 2. Catches JSR-380 validation failures (@NotBlank, @Email, @Size)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> fieldErrors = new HashMap<>();
        // 3. Iterates over all field errors and formats field -> message mappings
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            fieldErrors.put(error.getField(), error.getDefaultMessage());
        }

        // 4. RFC 7807 structured problem details payload
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.BAD_REQUEST.value()); // HTTP 400
        response.put("error", "Validation Failed");
        response.put("errors", fieldErrors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    // 5. Catches business logic exceptions ("Invalid email or password", duplicate emails)
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> handleRuntimeException(RuntimeException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("error", "Bad Request");
        response.put("message", ex.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    // 6. Global fallback safety net to shield internal stack traces from leaking
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGenericException(Exception ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value()); // HTTP 500
        response.put("error", "Internal Server Error");
        response.put("message", "An unexpected error occurred. Please try again later.");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
```

---

# Chapter 7: 15-Day Master Roadmap

| Day | Module / Architecture Focus | Deliverable | Status |
|:---:|:---|:---|:---:|
| **Day 1** *(Today)* | **JWT Auth & Global Error Handling** | `POST /api/auth/login` + `GlobalExceptionHandler` | ✅ Completed |
| **Day 2** | **Wallet Engine** | Auto-create wallet on signup, Balance lookup, Top-up (`@OneToOne`, `BigDecimal`) | ⬜ |
| **Day 3** | **P2P Transfer Engine** | Pessimistic Locking (`SELECT FOR UPDATE`), ACID `@Transactional` | ⬜ |
| **Day 4** | **Idempotency & Concurrency Safety** | Idempotency key headers to prevent double-spending | ⬜ |
| **Day 5** | **Ledger & Audit Trail** | Paginated transaction history (`Pageable`, JPQL `@Query`), Double-Entry Ledger | ⬜ |
| **Day 6** | **Redis Caching Layer** | Sub-5ms wallet balance lookup (`@Cacheable`, `@CacheEvict`) | ⬜ |
| **Day 7** | **RabbitMQ Message Broker** | Async payment events, Queues, Exchanges, Notification workers | ⬜ |
| **Day 8** | **Live WebSockets** | STOMP WebSocket push alerts to user browser in real-time | ⬜ |
| **Day 9** | **Gemini AI (Fraud & NLP)** | Fraud analysis + NLP payment parsing ("Send ₹500 to Amit") | ⬜ |
| **Day 10** | **Gemini AI (Receipt Scanner) & RBAC** | Multimodal Vision OCR bill splitting + Admin roles (`@PreAuthorize`) | ⬜ |
| **Day 11** | **Testing & Swagger Docs** | 15+ JUnit & Mockito unit/integration tests + Interactive Swagger UI | ⬜ |
| **Day 12** | **Docker Containerization** | Multi-container `docker-compose.yml` (App, PostgreSQL, Redis, RabbitMQ) | ⬜ |
| **Day 13** | **Cloud Deployment (AWS)** | Deploy on **AWS EC2**, PostgreSQL on **AWS RDS**, Receipts on **AWS S3** | ⬜ |
| **Day 14** | **Production CI/CD Pipeline** | GitHub Actions workflow: auto-test, build Docker, auto-deploy to EC2 | ⬜ |
| **Day 15** | **Animated React 18 Frontend** | Bespoke financial UI, Framer Motion, Recharts, Confetti 🎉 | ⬜ |

---

# Chapter 8: Production Engineering Practices, DevOps & Code Standards

## 1. Clean Code Standards: Why We Strip Tutorial Comments
* **The Industry Clean Code Rule (Uncle Bob / Martin Fowler):** Good code is self-documenting. Comments should only explain the **WHY** (non-obvious architectural invariants, security threat models, or complex algorithms), never the **WHAT** (syntax mechanics that the language or framework already communicates).
* **The Hiring Manager Red Flag:** Inline comments like `// Lombok: Auto-creates getters` or `// Line 1: Package location` immediately signal to interviewers and Staff Engineers that the code was copied line-by-line from a beginner tutorial.
* **Production Transformation Example:**
  * ❌ *Junior/Tutorial Style:*
    ```java
    // Spring Data JPA automatically writes the SQL:
    // "SELECT * FROM users WHERE email = ?"
    Optional<User> findByEmail(String email);
    ```
  * ✅ *Senior Enterprise Style:*
    ```java
    Optional<User> findByEmail(String email);
    ```
  * Method names, types, and annotations speak for themselves without noise.

---

## 2. Lombok `@Builder.Default` Internal Bytecode Mechanics
* **The Compilation Problem:**
  ```java
  @Builder
  public class User {
      private Role role = Role.USER; // Ignored by Builder!
  }
  ```
  `javac` emits a compiler warning: `@Builder will ignore the initializing expression entirely`.
* **Why Lombok Ignores Defaults:** When Lombok generates the builder static inner class (`UserBuilder`), it creates private fields corresponding to the entity's fields and initializes them to Java's default zero-values (`null`, `0`, `false`). When calling `User.builder().build()`, it invokes the package-private all-arguments constructor with these zero-values, overriding your field initializer with `null`!
* **The Fix (`@Builder.Default`):**
  ```java
  @Builder.Default
  private Role role = Role.USER;
  ```
  Instructs the Lombok annotation processor to generate the initializer expression inside the `UserBuilder` field declaration, guaranteeing that `role` defaults to `Role.USER` even when omitted from builder calls.

---

## 3. Database Crash Recovery & Lock Files (`postmaster.pid`)
* **What is `postmaster.pid`?**
  * PostgreSQL uses a file-based mutual exclusion lock located at `data/postmaster.pid` to prevent split-brain corruption (where two server processes concurrently write to the same physical data directory).
  * The file contains: PID, data directory path, cluster start timestamp, port number (5432), and socket status.
* **Crash Sequence & Dead Lock Recovery:**
  * An abrupt system shutdown (or process termination) kills the PostgreSQL daemon before it can delete `postmaster.pid`.
  * On restart, if the PID in `postmaster.pid` is not running, the lock file must be purged before starting `postgres.exe`.
* **Automated WAL Recovery (Write-Ahead Logging):**
  * When restarted cleanly, PostgreSQL reads the WAL log sequence:
    1. `redo starts at 0/1CC5BB8`: Replays recorded transactions from WAL into shared buffer pages.
    2. `redo done`: All dirty pages are restored to a crash-consistent state.
    3. `checkpoint starting / checkpoint complete`: Flushes recovered buffers to persistent tables.
    4. `database system is ready to accept connections`: Port 5432 opens for TCP traffic.

---

## 4. Git Architecture, Timezones & GitHub Contribution Graphs
* **The UTC Timestamp Boundary:**
  * Git stores commit timestamps with timezone offsets: `Wed Oct 14 01:54:36 2026 +0530`.
  * GitHub's contribution grid evaluates commits against **UTC (Coordinated Universal Time)** by default.
  * In India (IST = UTC $+05:30$):
    $$\text{IST 01:54 AM (Oct 14)} - 05:30 = \text{UTC 20:24 PM (Oct 13)}$$
    GitHub calculates the contribution square on **October 13th**. Once UTC midnight arrives ($05:30\text{ AM IST}$), commits reflect on October 14th.
* **Author Email Verification:**
  * GitHub only awards contribution credit if the commit's `Author: <email>` (`git config user.email`) matches an email verified under your GitHub account (`Settings -> Emails`).
* **Atomic Commits vs. Monolithic Dumps:**
  * Professional backend engineers practice **Atomic Commits**: committing single, coherent architectural units (`feat(auth): ...`, `fix(wallet): ...`) multiple times a day.
  * This builds a natural, credible GitHub history showing steady engineering discipline rather than suspicious 1-commit-per-month dumps.
* **"Private Contributions" Setting:**
  * Enabling *Private contributions* in GitHub settings surfaces all corporate repository commits without revealing proprietary company source code.

---

## 5. Jackson JSON Deserialization: Trailing Token Failures (`FAIL_ON_TRAILING_TOKENS`)
* **RFC 8259 Standard:** An HTTP JSON body must represent **exactly one** root JSON entity (one JSON Object `{...}` or one JSON Array `[...]`).
* **The Error:**
  `Trailing token (JsonToken.START_OBJECT) found after value: not allowed as per DeserializationFeature.FAIL_ON_TRAILING_TOKENS`
* **Under the Hood:**
  * Happens when a user pastes duplicate JSON blocks in Postman:
    ```json
    { "email": "rishi@gmail.com" }
    { ... } // 👈 Jackson finished reading the first object, and hit a second opening brace!
    ```
  * Jackson's parser encounters an extra `JsonToken.START_OBJECT` (`{`) after completing deserialization into the Java DTO, throwing `MismatchedInputException`.
  * Our `GlobalExceptionHandler` intercepts this and cleanly returns `HTTP 400 Bad Request` with structured JSON, preventing an unhandled server crash!


