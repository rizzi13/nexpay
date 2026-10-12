# 💸 NexPay — High-Concurrency AI-Powered P2P Financial Platform

[![Java](https://img.shields.io/badge/Java-17%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16%2B-4169E1?style=for-the-badge&logo=postgresql&logoColor=white)](https://www.postgresql.org/)
[![Redis](https://img.shields.io/badge/Redis-Cache-DC382D?style=for-the-badge&logo=redis&logoColor=white)](https://redis.io/)
[![RabbitMQ](https://img.shields.io/badge/RabbitMQ-AMQP-FF6600?style=for-the-badge&logo=rabbitmq&logoColor=white)](https://www.rabbitmq.com/)
[![AWS](https://img.shields.io/badge/AWS-EC2%20%7C%20RDS%20%7C%20S3-232F3E?style=for-the-badge&logo=amazon-aws&logoColor=white)](https://aws.amazon.com/)
[![Docker](https://img.shields.io/badge/Docker-Containers-2496ED?style=for-the-badge&logo=docker&logoColor=white)](https://www.docker.com/)
[![Google Gemini](https://img.shields.io/badge/Google_Gemini-Multimodal_AI-8E75B2?style=for-the-badge&logo=google&logoColor=white)](https://deepmind.google/technologies/gemini/)

> **NexPay** is an enterprise-grade, high-concurrency Peer-to-Peer (P2P) payment and digital wallet platform built with **Spring Boot** and **React 18**. Designed to simulate production fintech architectures (Razorpay / Stripe / Google Pay), it guarantees zero financial drift through database row-level locking, event-driven asynchronous messaging, sub-5ms caching, multimodal AI receipt parsing, and containerized deployment on AWS.

---

## 🏛️ System Architecture

```
                                [ Client / React 18 UI ]
                                           │
                     HTTPS / REST API      │     WebSocket (STOMP Push Alerts)
                                           ▼
┌────────────────────────────────── Spring Boot 3 Core ──────────────────────────────────┐
│                                                                                        │
│   [ Security Filter Chain ] ──► [ DelegatingFilterProxy ] ──► [ JwtFilter (Bearer) ]    │
│                                                                      │                 │
│                                                                      ▼                 │
│   [ DispatcherServlet ] ──────► [ Controllers ] ────────────► [ Services ]             │
│                                                                      │                 │
│              ┌───────────────────────────────────────────────────────┼────────┐        │
│              ▼                                                       ▼        ▼        │
│    [ Pessimistic Locking ]                                        [ Redis ] [ RabbitMQ ]
│     SELECT FOR UPDATE                                            Sub-5ms     Payment   │
│     (Row-Level Lock)                                              Cache      Events    │
│              │                                                       │        │        │
└──────────────┼───────────────────────────────────────────────────────┼────────┼────────┘
               │                                                       │        │
               ▼                                                       ▼        ▼
       [ PostgreSQL DB ]                                            [ RAM ]   [ Async Workers ]
       (ACID Transactions)                                                    ├── Notifications
                                                                              ├── Audit Ledger
                                                                              └── AI Fraud Detection
```

---

## 🔥 Key Engineering Highlights

* **🛡️ Zero Double-Spending (Concurrency Safety):** Prevents race conditions during simultaneous transfer requests using database-level pessimistic write locking (`SELECT FOR UPDATE`) combined with ACID `@Transactional` boundaries.
* **🔁 Distributed Idempotency:** Guarantees safe client retries across unreliable mobile networks using unique `Idempotency-Key` headers, preventing duplicate debit transactions.
* **⚡ Sub-5ms Read Latency:** Offloads database read load using a **Redis Caching Layer** (`@Cacheable`) with automated event-driven cache eviction (`@CacheEvict`) upon balance mutations.
* **📬 Event-Driven Decoupling:** Uses **RabbitMQ** to publish payment events asynchronously. Long-running tasks (SMS, email alerts, PDF ledger generation) are processed by background consumers without blocking HTTP API threads.
* **🤖 Multimodal AI (Google Gemini):**
  * **NLP Payment Execution:** Parses natural human language prompts (e.g., *"Send ₹500 to Rahul for lunch"*) into structured financial transactions.
  * **Receipt Scanner:** Vision OCR extracts items, taxes, and totals from uploaded receipt photos and automatically splits the bill.
  * **Fraud Detection:** Heuristic and AI anomaly detection flags high-velocity, irregular transaction spikes.
* **☁️ 3-Tier Production Cloud on AWS:**
  * **AWS EC2:** Containerized application running via Docker Compose.
  * **AWS RDS (PostgreSQL):** Isolated in a private security group accessible only from EC2 on port `5432`.
  * **AWS S3:** Scalable cloud object storage for transaction receipt images.
* **🚀 Automated CI/CD:** GitHub Actions pipeline triggers on every push to `main` to run tests, build immutable Docker images, and auto-deploy to AWS EC2 over SSH.
* **🎨 Distinct Frontend UI:** Built with React 18, Tailwind CSS, Framer Motion (glassmorphism design, micro-animations, real-time WebSocket push updates, and Recharts financial analytics).

---

## 🛠️ Complete Tech Stack

| Layer | Technologies |
|---|---|
| **Language & Runtime** | Java 17, JVM (HotSpot) |
| **Backend Framework** | Spring Boot 3, Spring Security, Spring Data JPA, Spring WebSocket |
| **Security & Auth** | Stateless JWT (RFC 7519, HMAC-SHA256), BCrypt Password Hashing |
| **Database** | PostgreSQL 16+ (Local + AWS RDS), Hibernate ORM, HikariCP |
| **Caching** | Redis (Distributed In-Memory Cache) |
| **Message Broker** | RabbitMQ (AMQP 0-9-1 Protocol) |
| **Real-Time Push** | WebSockets with STOMP Protocol |
| **Artificial Intelligence** | Google Gemini API (NLP & Multimodal Vision) |
| **DevOps & Cloud** | Docker, Docker Compose, AWS (EC2, RDS, S3, IAM), GitHub Actions (CI/CD) |
| **Testing** | JUnit 5, Mockito, Testcontainers, Spring Boot Test |
| **Frontend** | React 18, Tailwind CSS, Framer Motion, Recharts, Axios, STOMP.js |

---

## 🗺️ 15-Day Production Roadmap

- [x] **Day 1: Project Setup & User Domain** — PostgreSQL connection, `User` entity, JPA Repository.
- [x] **Day 2: Secure Registration & BCrypt** — DTO input validation, BCrypt password hashing, Security filter rules.
- [ ] **Day 3: Stateless JWT Auth & Error Handling** — Token issuance (`POST /api/auth/login`), `JwtFilter`, `@RestControllerAdvice`.
- [ ] **Day 4: Wallet Engine & Balance Top-Up** — `@OneToOne` auto-provisioning, `BigDecimal` currency math.
- [ ] **Day 5: High-Concurrency Transfer Engine** — Pessimistic Locking (`SELECT FOR UPDATE`), ACID transactions.
- [ ] **Day 6: Idempotency Keys & Financial Safety** — Double-spending defense under high concurrent load.
- [ ] **Day 7: Double-Entry Ledger & History** — Audit trails, `Pageable` pagination, JPQL queries.
- [ ] **Day 8: Redis Caching & Invalidation** — Sub-5ms balance lookups, cache-aside pattern.
- [ ] **Day 9: RabbitMQ Event Broker** — Decoupled async event publishers and background consumers.
- [ ] **Day 10: Real-Time WebSockets** — STOMP bi-directional push alerts to client browsers.
- [ ] **Day 11: Google Gemini AI (Fraud & NLP)** — Anomaly detection & natural language payment parser.
- [ ] **Day 12: Multimodal AI Receipt Scanner & RBAC** — Receipt OCR bill splitting, Admin role security.
- [ ] **Day 13: Automated Testing & Swagger Docs** — Unit & integration testing with JUnit/Mockito, OpenAPI UI.
- [ ] **Day 14: Containerization & AWS Cloud** — Docker Compose, AWS EC2, AWS RDS, AWS S3, IAM.
- [ ] **Day 15: GitHub Actions CI/CD & React 18 UI** — Automated deployment pipeline, animated glassmorphism UI.

---

## 🚀 Getting Started Locally

### Prerequisites
* Java 17+
* PostgreSQL 16+ running locally on port `5432` (database: `nexpaydb`)
* Maven 3.8+ (or use included `./mvnw`)

### 1. Clone the Repository
```bash
git clone https://github.com/rizzi13/nexpay.git
cd nexpay
```

### 2. Configure Database Credentials
Edit `src/main/resources/application.yml` with your local PostgreSQL password:
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
The server will boot on `http://localhost:8080`.

---

## 📬 API Endpoints (Core Auth)

| Method | Endpoint | Description | Access |
|---|---|---|---|
| `POST` | `/api/auth/register` | Registers a new user with BCrypt password hashing | Public |
| `POST` | `/api/auth/login` | Authenticates user and returns JWT Bearer token | Public |

---

## 📄 License
This project is licensed under the MIT License.
