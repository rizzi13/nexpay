# 🏛️ NexPay — Enterprise Software Engineering & Architecture Masterclass
## *Holistic Computer Science Domains & Production Implementation Reference*

> **Guiding Principle:** Every topic is taught as a **complete, 360-degree computer science and backend engineering discipline** — exploring theoretical foundations, global industry landscapes, architectural alternatives, attack vectors, low-level JVM/database mechanics, and senior/staff trade-offs — before showing how it is applied inside NexPay.

---

# 📑 MASTER TABLE OF CONTENTS

- **PART I: THE HOLISTIC COMPUTER SCIENCE & BACKEND ENGINEERING DOMAINS**
  - [Module 1: Complete Authentication & Authorization Architecture](#module-1-complete-authentication--authorization-architecture)
    - [1.1 The Full Industry Authentication Spectrum](#11-the-full-industry-authentication-spectrum)
    - [1.2 Stateless Token Architecture: JWT (RFC 7519), JWS, JWE & Paseto](#12-stateless-token-architecture-jwt-rfc-7519-jws-jwe--paseto)
    - [1.3 Distributed Token Revocation & Session Management at Scale](#13-distributed-token-revocation--session-management-at-scale)
    - [1.4 Security Attack Vectors, Threat Modeling & Defenses](#14-security-attack-vectors-threat-modeling--defenses)
  - [Module 2: Complete Cryptography & Credential Security](#module-2-complete-cryptography--credential-security)
    - [2.1 The Cryptographic Trapdoor Function: Why Fast Hashes Fail](#21-the-cryptographic-trapdoor-function-why-fast-hashes-fail)
    - [2.2 Salting Theory, Entropy & Moore\'s Law Work Factors](#22-salting-theory-entropy--moores-law-work-factors)
    - [2.3 Modern Password Hashing Taxonomy: PBKDF2 vs BCrypt vs Scrypt vs Argon2](#23-modern-password-hashing-taxonomy-pbkdf2-vs-bcrypt-vs-scrypt-vs-argon2)
    - [2.4 BCrypt Deep Dive, Blowfish Cipher & The 72-Byte Truncation Quirk](#24-bcrypt-deep-dive-blowfish-cipher--the-72-byte-truncation-quirk)
  - [Module 3: Complete Persistence, ORM & Relational Database Architecture](#module-3-complete-persistence-orm--relational-database-architecture)
    - [3.1 The Data Access Continuum: JDBC to Full ORM](#31-the-data-access-continuum-jdbc-to-full-orm)
    - [3.2 The Object-Relational Impedance Mismatch](#32-the-object-relational-impedance-mismatch)
    - [3.3 Primary Key Architecture & Index Clustering](#33-primary-key-architecture--index-clustering)
    - [3.4 Connection Pooling Engineering: HikariCP Internals & Sizing Math](#34-connection-pooling-engineering-hikaricp-internals--sizing-math)
    - [3.5 Hibernate Entity Lifecycle & Persistence Context Mechanics](#35-hibernate-entity-lifecycle--persistence-context-mechanics)
    - [3.6 The N+1 Query Problem & Fetch Optimization](#36-the-n1-query-problem--fetch-optimization)
    - [3.7 Database Transactions, ACID Guarantees & Isolation Levels](#37-database-transactions-acid-guarantees--isolation-levels)
  - [Module 4: Complete Inversion of Control (IoC) & Spring Framework Architecture](#module-4-complete-inversion-of-control-ioc--spring-framework-architecture)
    - [4.1 The Hollywood Principle & Inversion of Control](#41-the-hollywood-principle--inversion-of-control)
    - [4.2 Dependency Injection Flavors & Staff-Level Conventions](#42-dependency-injection-flavors--staff-level-conventions)
    - [4.3 Spring Container Architecture: BeanFactory vs ApplicationContext](#43-spring-container-architecture-beanfactory-vs-applicationcontext)
    - [4.4 The Full Spring Bean Lifecycle](#44-the-full-spring-bean-lifecycle)
    - [4.5 Spring AOP & Dynamic Proxies (The Self-Invocation Trap)](#45-spring-aop--dynamic-proxies-the-self-invocation-trap)
  - [Module 5: Complete HTTP API Design & Enterprise Error Architecture](#module-5-complete-http-api-design--enterprise-error-architecture)
    - [5.1 Richardson Maturity Model & HTTP Protocol Invariants](#51-richardson-maturity-model--http-protocol-invariants)
    - [5.2 HTTP Status Code Taxonomy & Semantic Accuracy](#52-http-status-code-taxonomy--semantic-accuracy)
    - [5.3 Standardized Problem Details (RFC 7807 & RFC 9457)](#53-standardized-problem-details-rfc-7807--rfc-9457)
    - [5.4 Spring MVC DispatcherServlet Pipeline & Global Exception Handling](#54-spring-mvc-dispatcherservlet-pipeline--global-exception-handling)
  - [Module 6: Modern Java Evolution & High-Concurrency Systems](#module-6-modern-java-evolution--high-concurrency-systems)
    - [6.1 Modern Java Language Evolution (Java 8 → 17 → 21/24)](#61-modern-java-language-evolution-java-8--17--2124)
    - [6.2 Concurrency Paradigms: OS Threads vs Reactive vs Virtual Threads](#62-concurrency-paradigms-os-threads-vs-reactive-vs-virtual-threads)
  - [Module 7: DevOps, Cloud, Clean Code & Software Engineering Standards](#module-7-devops-cloud-clean-code--software-engineering-standards)
    - [7.1 Clean Enterprise Code & The \'Zero Tutorial Comments\' Rule](#71-clean-enterprise-code--the-zero-tutorial-comments-rule)
    - [7.2 Database Crash Consistency, Lock Files & WAL Replay](#72-database-crash-consistency-lock-files--wal-replay)
    - [7.3 Git Internals, UTC Boundaries & Contribution Graph Mathematics](#73-git-internals-utc-boundaries--contribution-graph-mathematics)
    - [7.4 Jackson RFC 8259 Specifications & Parsing Mechanics](#74-jackson-rfc-8259-specifications--parsing-mechanics)
- **PART II: NEXPAY ARCHITECTURE, IMPLEMENTATION & 3-PILLAR MASTERCLASSES**
  - [Chapter 1: The Big Picture — What is NexPay?](#chapter-1-the-big-picture--what-is-nexpay)
  - [Chapter 2: The Foundation Story (Days 5 & 6 Walkthrough)](#chapter-2-the-foundation-story-days-5--6-walkthrough)
  - [Chapter 3: Architectural Masterclasses (Foundation Components)](#chapter-3-architectural-masterclasses-foundation-components)
    - [Component 1: User.java](#component-1-userjava--jpa-entity-lifecycle-postgresql-bigserial--identity-mapping)
    - [Component 2: UserRepository.java](#component-2-userrepositoryjava--dynamic-proxies-query-derivation--connection-pools)
    - [Component 3: RegisterRequest.java](#component-3-registerrequestjava--input-boundary-dto--fail-fast-validation)
    - [Component 4: SecurityConfig.java](#component-4-securityconfigjava--filter-chain-architecture-csrf-theory--bcrypt-hashing)
    - [Component 5: UserService.java](#component-5-userservicejava--service-boundary-constructor-injection--business-rules)
    - [Component 6: AuthController.java](#component-6-authcontrollerjava--rest-dispatch-http-semantics--valid)
  - [Chapter 4: Core Concepts & Annotations Master Reference](#chapter-4-core-concepts--annotations-master-reference)
  - [Chapter 5: Staff-Level Technical Deep-Dives](#chapter-5-staff-level-technical-deep-dives)
  - [Chapter 6: Day 1 — JWT Authentication & Global Error Handling (From Scratch)](#chapter-6-day-1--jwt-authentication--global-error-handling-from-scratch)
    - [Step 1: JWT Architecture & Key Sizing](#step-1-jwt-architecture-maven-runtime-scopes-pomxml--256-bit-key-sizing-applicationyml)
    - [Step 2: LoginRequest.java](#step-2-loginrequestjava--dto-deserialization-lombok-ast--fail-fast-validation)
    - [Step 3: AuthResponse.java](#step-3-authresponsejava--outbound-serialization--sensitive-credential-shielding)
    - [Step 4: JwtService.java](#step-4-jwtservicejava--hmac-sha256-token-mint-claims-cryptography--jjwt-012-mechanics)
    - [Step 5: JwtFilter.java & SecurityConfig.java](#step-5-jwtfilterjava--updating-securityconfigjava--request-interception-threadlocal-security-context--stateless-filter-chain)
    - [Step 6: Login Endpoint & GlobalExceptionHandler.java (RFC 7807)](#step-6-userservicejava-login-authcontrollerjava-endpoint--globalexceptionhandlerjava-rfc-7807)
  - [Chapter 7: 15-Day Master Roadmap](#chapter-7-15-day-master-roadmap)
  - [Chapter 8: Production Engineering Practices, DevOps & Code Standards](#chapter-8-production-engineering-practices-devops--code-standards)
  - [Chapter 9: Day 2 — The Core Wallet Engine & Financial Precision Architecture](#chapter-9-day-2--the-core-wallet-engine--financial-precision-architecture)
    - [1. Holistic Domain: Financial Data Modeling & Monetary Precision](#1-holistic-domain-masterclass-financial-data-modeling--monetary-precision)
    - [2. Component 1: Wallet.java](#2-component-1-walletjava--relational-mapping-constraints--precision-math)
    - [3. Component 2: WalletRepository.java](#3-component-2-walletrepositoryjava--dynamic-proxies-property-expression-grammar--the-optional-monad)
    - [4. Component 3: Updating UserService.java](#4-component-3-updating-userservicejava--multi-entity-orchestration--transactional-atomicity)
    - [5. Component 4: WalletService.java, DTOs & WalletController.java](#5-component-4-walletservicejava-dtos--walletcontrollerjava--financial-endpoints--idor-defense)
    - [6. Architectural Deep Dive: Why Layered Architecture & Package-by-Feature?](#6-architectural-deep-dive-why-layered-architecture--package-by-feature)
    - [7. PostgreSQL Engineering Deep Dive: What PostgreSQL Actually Does Under Hibernate's Hood](#7-postgresql-engineering-deep-dive-what-postgresql-actually-does-under-hibernates-hood)

---

# PART I: THE HOLISTIC COMPUTER SCIENCE & BACKEND ENGINEERING DOMAINS

---

# Module 1: Complete Authentication & Authorization Architecture

## 1.1 The Full Industry Authentication Spectrum

In distributed computer systems, answering *"Who is this user?"* (Authentication) and *"What are they allowed to do?"* (Authorization) spans several paradigms. Choosing the right mechanism requires balancing latency, scalability, security perimeter, and client capability.

```
┌────────────────────────────────────────────────────────────────────────────────────────────────────────┐
│                                 THE AUTHENTICATION LANDSCAPE                                           │
└────────────────────────────────────────────────────────────────────────────────────────────────────────┘
          │
          ├── 1. Stateful Sessions (Cookie / JSESSIONID) ────────► Traditional Monoliths, Banking Portals
          ├── 2. Stateless Bearer Tokens (JWT / Paseto) ─────────► Modern REST APIs, SPAs, Mobile Apps
          ├── 3. Delegated Authorization (OAuth 2.0 / OIDC) ────► Social Login, Third-Party Integrations
          ├── 4. Zero-Trust Mutual TLS (mTLS / x509) ──────────► Microservice-to-Microservice Mesh
          ├── 5. Cryptographic Request Signing (HMAC / SigV4) ──► Payment Gateways, Cloud APIs (AWS)
          └── 6. Static API Keys ───────────────────────────────► Machine-to-Machine Background Workers
```

### 1. Stateful Server-Side Sessions (Cookie-Based)
* **How it works:**
  1. Client sends credentials via `POST /login`.
  2. Server verifies credentials, allocates an in-memory session object (`HttpSession`), generates a cryptographically random 128-bit session ID, and stores it in server RAM (or an external store like Redis).
  3. Server returns the ID via a response header: `Set-Cookie: JSESSIONID=abc123xyz; HttpOnly; Secure; SameSite=Strict`.
  4. On subsequent requests, the browser automatically attaches the cookie to the `Cookie` header.
  5. The server looks up `JSESSIONID` in its internal session table to retrieve the authenticated user profile.
* **Advantages:**
  * **Instant Revocation:** Killing a session is instantaneous ($O(1)$) by deleting the key from the session store.
  * **Small Over-the-Wire Footprint:** Only a short cookie identifier is transmitted with each HTTP request.
* **Disadvantages & Production Bottlenecks:**
  * **Horizontal Scalability Barrier:** If a cluster has 10 server nodes behind an AWS Application Load Balancer, Request 1 lands on Node A (session created in Node A's RAM). Request 2 lands on Node B (Node B has no knowledge of the session $\rightarrow$ user is forcibly logged out).
  * **Sticky Session Pitfalls:** Configuring the load balancer for "sticky sessions" (routing a user's IP to the same server node) causes uneven load distribution, hotspot crashes, and session loss during rolling deployments.
  * **External Session Store Latency:** Storing sessions in a shared Redis cluster resolves the sticky session problem, but adds 1–3ms of network I/O and Redis connection overhead to **every single incoming HTTP request**.
  * **Cross-Site Request Forgery (CSRF):** Because browsers automatically append cookies to cross-origin requests, stateful cookie-based systems are vulnerable to CSRF attacks unless guarded with CSRF anti-forgery tokens.

---

### 2. Stateless Bearer Tokens (JWT / RFC 7519)
* **How it works:**
  1. Client sends credentials via `POST /login`.
  2. Server verifies credentials, serializes user identity and claims into JSON, and cryptographically signs it with a private key or shared secret.
  3. Server stores **zero bytes** in memory or database; it sends the signed token string directly to the client.
  4. Client stores the token (in memory or secure storage) and manually passes it in the standard HTTP header:
     `Authorization: Bearer <token>`
  5. Any server in the cluster validates the mathematical signature locally using its CPU. If the signature is valid and the expiration timestamp hasn't passed, the user is authenticated.
* **Advantages:**
  * **Infinite Horizontal Scalability:** 100 microservice nodes can verify requests independently with zero shared cache, zero database queries, and zero inter-node communication.
  * **Immune to CSRF:** Browsers **never** automatically attach custom `Authorization: Bearer` headers to cross-origin form submissions or link clicks.
  * **Cross-Domain & Mobile-Native:** Seamlessly works across mobile apps (iOS/Android), single-page apps (React/Vue), and different domains without third-party cookie restrictions.
* **Disadvantages & Trade-offs:**
  * **Revocation Complexity:** Once signed, a token remains valid until it expires. Revoking an active token before expiration requires distributed blacklisting mechanisms.
  * **Payload Size:** JWTs contain base64-encoded headers and claims, typically 300–800 bytes, which are transmitted on every request.

---

### 3. Delegated Authorization: OAuth 2.0 & OpenID Connect (OIDC)
* **What is OAuth 2.0 (RFC 6749)?**
  * A framework for **delegated authorization** ("Allow Spotify to access my Google contacts without giving Spotify my Google password").
  * Core actors: **Resource Owner** (User), **Client** (Application), **Authorization Server** (e.g., Okta, Auth0, Keycloak), and **Resource Server** (API).
* **What is OpenID Connect (OIDC)?**
  * An identity layer built directly on top of OAuth 2.0 to provide **authentication**.
  * Whereas OAuth 2.0 returns an `access_token` (for calling APIs), OIDC adds an `id_token` (a JWT containing user profile claims: name, email, avatar).
* **Grant Types / Flows:**
  * **Authorization Code Flow with PKCE (Proof Key for Code Exchange - RFC 7636):** The gold standard for SPAs and mobile apps. Replaces static client secrets with dynamic cryptographic code verifiers and challenges, preventing code interception attacks.
  * **Client Credentials Grant:** Machine-to-machine authentication where a backend microservice requests an access token using its own credentials (`client_id` + `client_secret`) without a user present.
  * **Device Authorization Flow (RFC 8628):** Used on input-constrained devices (Smart TVs, gaming consoles) where the user scans a QR code or opens a URL on their phone.
  * **Deprecated Flows (Security Risks):** *Implicit Flow* (tokens exposed in browser URL hash fragments) and *Resource Owner Password Credentials Grant* (user hands raw password to third-party app) are formally prohibited in modern OAuth 2.1 specifications.

---

### 4. Mutual TLS (mTLS / Zero-Trust Architecture)
* **How it works:**
  * In standard TLS (HTTPS), only the server presents an x509 digital certificate to prove its identity to the client.
  * In **Mutual TLS (mTLS)**, during the TLS handshake, the server also requests a certificate from the client. Both parties verify each other's certificate against a trusted internal Certificate Authority (CA).
* **Production Application:**
  * Service meshes (Istio, Linkerd) in Kubernetes clusters use mTLS for zero-trust service-to-service communication. If an attacker breaches the network perimeter, they cannot spoof internal microservices without valid client certificates.

---

### 5. Cryptographic Request Signing (HMAC / AWS SigV4)
* **How it works:**
  * The client calculates an HMAC digest over the HTTP method, request path, timestamp, and request body using a shared secret key.
  * The signature is transmitted in headers (e.g., `X-Signature: ...`).
  * The server recalculates the signature over the received payload.
* **Production Application:**
  * AWS API requests (Signature Version 4), payment gateway webhooks (Stripe, Razorpay). Protects against payload tampering in transit and provides non-repudiation.

---

## 1.2 Stateless Token Architecture: JWT (RFC 7519), JWS, JWE & Paseto

### Structural Anatomy of a JSON Web Token
A JWT consists of three separate components concatenated by periods (`.`):

$$\text{JWT} = \text{Base64URL}(\text{Header}) \,.\, \text{Base64URL}(\text{Payload}) \,.\, \text{Base64URL}(\text{Signature})$$

```
eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9 . eyJzdWIiOiJyaXNoaUBnbWFpbC5jb20iLCJpYXQiOjE3... . D0xHqY...
└───────────────┬──────────────────┘   └──────────────────────┬──────────────────────┘   └────────┬────────┘
             HEADER                                        PAYLOAD                            SIGNATURE
   Algorithm & Token Type                      Claims (Subject, Expiration, Roles)       Cryptographic Seal
```

1. **Header:** Identifies the token type (`typ: "JWT"`) and the cryptographic algorithm used (`alg: "HS256"` or `"RS256"`).
2. **Payload (Claims):** Contains statements about the entity and additional metadata:
   * **Registered Claims (RFC 7519 standard):**
     * `sub` (Subject): The principal identifier (e.g., user email or UUID).
     * `iat` (Issued At): Unix timestamp of token minting.
     * `exp` (Expiration Time): Unix timestamp after which the token is invalid.
     * `iss` (Issuer): URL or name of the issuing authority.
     * `aud` (Audience): Intended recipients of the token.
     * `jti` (JWT ID): Unique identifier for one-time use or blacklisting.
   * **Public / Private Claims:** Custom business attributes (e.g., `role: "USER"`, `tier: "PREMIUM"`).
3. **Signature:** The mathematical seal generated by feeding the base64-encoded header and payload into a cryptographic hash function with a secret key:

$$\text{Signature} = \text{HMAC-SHA256}\Big(\text{Base64URL}(\text{Header}) \parallel \text{"."} \parallel \text{Base64URL}(\text{Payload}), \; \text{SecretKey}\Big)$$

> [!IMPORTANT]
> **Base64URL is NOT Encryption:** Base64URL is a reversible encoding scheme designed to safely transmit binary data through URL query parameters and HTTP headers without character escaping. Anyone can decode the header and payload instantly using `jwt.io` or `base64 -d`. **Never store confidential secrets, passwords, or unencrypted Social Security Numbers inside JWT claims!**

### JWS vs. JWE
* **JWS (JSON Web Signature - RFC 7515):** The payload is visible (encoded in Base64URL) but tamper-proof thanks to the signature. (This is the standard JWT format used in 95% of web architectures, including NexPay).
* **JWE (JSON Web Encryption - RFC 7516):** The payload is mathematically encrypted using algorithms like AES-GCM. Third parties cannot read the claims. Used in healthcare and financial banking when sensitive claims must travel over untrusted clients.

### Paseto (Platform-Agnostic Security Tokens)
* Designed as an alternative to JWT to eliminate algorithm agility vulnerabilities. In JWT, the token header dictates which algorithm the server should use to verify it (`alg: HS256`, `alg: none`), which historically led to severe implementation exploits. Paseto fixes the cipher suite version in advance (e.g., `v4.local` uses XChaCha20-Poly1305), eliminating configuration errors.

---

## 1.3 Distributed Token Revocation & Session Management at Scale

The primary architectural paradox of stateless tokens: **If the server stores zero state, how do you forcibly log out a user or revoke a stolen token before its expiration timestamp?**

In enterprise engineering, four primary patterns solve this:

```
┌────────────────────────────────────────────────────────────────────────────────────────────────────────┐
│                              TOKEN REVOCATION PATTERNS AT SCALE                                        │
├──────────────────────────────┬───────────────────────────────┬─────────────────────────────────────────┤
│ Pattern                      │ Mechanics                     │ Trade-off                               │
├──────────────────────────────┼───────────────────────────────┼─────────────────────────────────────────┤
│ 1. Short-Lived Access +      │ Access token = 15 mins.       │ Refresh endpoint requires secure        │
│    Refresh Token Rotation    │ Refresh token = 7 days stored │ storage (HttpOnly cookie) and DB/cache. │
│                              │ in DB/Redis with RTR check.   │                                         │
├──────────────────────────────┼───────────────────────────────┼─────────────────────────────────────────┤
│ 2. Redis Blacklist with TTL  │ On logout, write token `jti`  │ Turns every request into a Redis check, │
│                              │ to Redis with TTL = remaining │ re-introducing cache dependencies.      │
│                              │ token lifespan.               │                                         │
├──────────────────────────────┼───────────────────────────────┼─────────────────────────────────────────┤
│ 3. Token Versioning          │ Store `token_version: int` in │ Invalidates all user devices at once;   │
│    (`token_version` column)  │ User DB row & JWT claims.     │ requires DB read on requests unless     │
│                              │ Incrementing drops old tokens.│ cached in Redis.                        │
├──────────────────────────────┼───────────────────────────────┼─────────────────────────────────────────┤
│ 4. Distributed Event Blast   │ Publish `UserLoggedOutEvent`  │ High complexity; eventually consistent  │
│    (Kafka / RabbitMQ)        │ to all microservice local RAM │ propagation window.                     │
│                              │ cache instances.              │                                         │
└──────────────────────────────┴───────────────────────────────┴─────────────────────────────────────────┘
```

### Pattern 1: Short-Lived Access Tokens + Refresh Token Rotation (RTR)
* The client receives two tokens:
  1. **Access Token (JWT):** Lifespan = 10 to 15 minutes. Stored in browser JavaScript memory. Passed in `Authorization: Bearer`.
  2. **Refresh Token (Opaque UUID or Signed Token):** Lifespan = 7 to 30 days. Stored inside a secure `HttpOnly; Secure; SameSite=Strict` cookie, shielded from JavaScript XSS attacks.
* When the access token expires, the client calls `/api/auth/refresh`. The server checks the refresh token in PostgreSQL/Redis, issues a new access token, **and issues a new refresh token while revoking the old one (Rotation)**.
* **Reuse Detection:** If an attacker intercepts a refresh token and uses it *after* the legitimate user has already rotated it, the server detects token reuse, recognizes that a breach occurred, and immediately invalidates the entire token family, forcing a re-login on all devices!

---

## 1.4 Security Attack Vectors, Threat Modeling & Defenses

### 1. Algorithm Confusion Attacks (`alg: "none"` and HMAC vs. RSA)
* **The "None" Algorithm Flaw:** Early JWT implementations permitted `{"alg": "none"}` in the header. Attackers modified claims (e.g. changing `"role": "USER"` to `"role": "ADMIN"`), deleted the signature, and sent the token. Vulnerable libraries accepted the token without verification!
  * *Defense:* Modern libraries like JJWT 0.12 explicitly reject `alg: none` unless explicitly and insecurely configured.
* **Key Confusion Attack (HMAC vs. RSA):** If a server expects an asymmetric key (RSA `RS256`), it verifies signatures using a public key. Attackers would change the header to symmetric `HS256` and sign the token using the server's publicly accessible RSA public key as the HMAC secret! The server, reading `HS256`, used the public key with HMAC-SHA256, and the signature matched!
  * *Defense:* JJWT 0.12 uses `.verifyWith(SecretKey)` or `.verifyWith(PublicKey)` to enforce strict cryptographic key type checking at the type system level.

### 2. Timing Attacks on Cryptographic Signatures
* When verifying signatures, standard string equality (`strA.equals(strB)`) compares characters sequentially from left to right and returns `false` as soon as the first mismatch occurs:

```
Candidate: A  B  C  D  E  F
Expected:  A  B  C  X  Y  Z
           ── ── ── ✕  (Aborts in 3 nanoseconds)

Candidate: A  B  C  X  E  F
Expected:  A  B  C  D  Y  Z
           ── ── ── ✕  (Aborts in 3 nanoseconds)

Candidate: A  B  C  D  Y  F
Expected:  A  B  C  D  E  Z
           ── ── ── ── ✕ (Aborts in 4 nanoseconds)
```

* An attacker with high-resolution network timers can measure subtle microsecond differences to deduce characters one by one.
* *Defense:* **Constant-Time Comparison** (`MessageDigest.isEqual()`). It iterates through every single byte regardless of where mismatches occur, executing in constant time $O(N)$ and eliminating timing side-channels.

---

# Module 2: Complete Cryptography & Credential Security

## 2.1 The Cryptographic Trapdoor Function: Why Fast Hashes Fail

A cryptographic hash function is a deterministic mathematical procedure that transforms arbitrary-sized input data into a fixed-size bit string:

$$H: \{0, 1\}^* \longrightarrow \{0, 1\}^n$$

It is a **one-way trapdoor function**: computing $y = H(x)$ is easy, but finding $x$ given $y$ is computationally infeasible.

```
┌────────────────────────────────────────────────────────────────────────────────────────────────────────┐
│                              THE CRYPTOGRAPHIC HASH EVOLUTION                                          │
└────────────────────────────────────────────────────────────────────────────────────────────────────────┘
  1990s: Plaintext / ROT13     ──► Catastrophic DB leak = complete breach
  1995:  MD5 (Broken)          ──► Fast general-purpose hash; collision attacks (Wang et al. 2004)
  2001:  SHA-1 (Broken)        ──► SHAttered collision attack (Google 2017)
  2002:  SHA-256 / SHA-512     ──► Cryptographically secure for data integrity, FATALLY FLAWED for passwords!
  Modern: Adaptive Slow Hashes ──► PBKDF2, BCrypt, Scrypt, Argon2 (Designed specifically for credentials)
```

### Why SHA-256 is Fatally Flawed for Passwords
General-purpose cryptographic hash functions (SHA-256, SHA-3, BLAKE3) were engineered for **maximum throughput and speed** to verify file integrity and network packets.
* Modern GPUs (NVIDIA RTX 4090) can compute over **$25{,}000{,}000{,}000$ (25 Billion) SHA-256 hashes per second**.
* If a database leaking SHA-256 hashes is breached, an attacker with a commodity mining rig can crack an 8-character password across the entire keyspace in under 1 hour.
* **The Rule of Password Security:** Password storage requires **slow, computationally expensive, memory-hard adaptive hashing algorithms**.

---

## 2.2 Salting Theory, Entropy & Moore's Law Work Factors

### The Rainbow Table Attack
A Rainbow Table is a precomputed lookup table of plaintext passwords and their corresponding hash outputs.
* Without a salt: if 10,000 users have the password `"password123"`, their hash in the database is identical. An attacker cracks that single hash and compromises 10,000 accounts simultaneously.

### The Salt Solution
A **Cryptographic Salt** is a sequence of cryptographically secure random bytes generated uniquely for every user during registration and prepended to the password before hashing:

$$H_{\text{stored}} = \text{Hash}(\text{Salt} \parallel \text{Password})$$

* With a 128-bit salt, there are $2^{128} \approx 3.4 \times 10^{38}$ possible salt variations.
* Precomputing a rainbow table for $2^{128}$ combinations requires more storage than all physical matter in the universe. The attacker is forced into brute-forcing each individual account separately.

### Moore's Law & Adaptive Work Factors
As hardware computing power doubles every 18–24 months (Moore's Law), an algorithm fixed in speed becomes easier to crack over time.
* Adaptive hashing algorithms incorporate a **Work Factor (Cost Parameter)**.
* In BCrypt, the cost factor $C$ defines $2^C$ internal hashing iterations.
  * Cost $10 = 2^{10} = 1{,}024$ rounds ($\approx 60\text{ms}$ on modern server CPUs).
  * Cost $12 = 2^{12} = 4{,}096$ rounds ($\approx 250\text{ms}$).
* As server hardware speeds up in future years, engineers simply increment the work factor in configuration without changing the algorithm or invalidating existing hashes.

---

## 2.3 Modern Password Hashing Taxonomy: PBKDF2 vs BCrypt vs Scrypt vs Argon2

| Property | PBKDF2 (RFC 2898) | BCrypt | Scrypt (RFC 7914) | Argon2 (RFC 9106) |
|---|---|---|---|---|
| **Base Algorithm** | HMAC (SHA-256) | Modified Blowfish (Eksblowfish) | PBKDF2 + Salsa20/8 | Blake2b + Custom DAG |
| **Primary Defense** | CPU Iterations | CPU Time + 4KB S-Boxes | CPU + Memory Hardness | CPU + Memory + Parallelism |
| **GPU / ASIC Resistance** | ❌ Weak (Easily parallelized) | ⚠️ Moderate (L1 Cache bound) | ✅ Strong (Large RAM footprint) | 🏆 Maximum (Winner of PHC) |
| **Side-Channel Defense** | ⚠️ Susceptible to cache timing | ⚠️ Susceptible to cache timing | ⚠️ Weak against cache timing | ✅ Argon2id immune to side-channels |
| **Standard / Compliance** | NIST / FIPS-140 Approved | De-facto Web Standard (Spring) | IETF RFC 7914 | Password Hashing Competition Winner |

* **Argon2 Variants:**
  * **Argon2d:** Maximizes resistance to GPU cracking using data-dependent memory access (ideal for cryptocurrencies).
  * **Argon2i:** Uses data-independent memory access to prevent side-channel cache-timing attacks (ideal for password authentication).
  * **Argon2id:** A hybrid combining both: first half operates as Argon2i, second half as Argon2d. **The gold standard recommendation for modern systems**.

---

## 2.4 BCrypt Deep Dive, Blowfish Cipher & The 72-Byte Truncation Quirk

BCrypt was published in 1999 by Niels Provos and David Mazières, built on the Blowfish symmetric cipher.

### Stored Hash Structure
A BCrypt hash is encoded into a 60-character ASCII string formatted into four distinct segments:

```
$2a$10$vI8aWBnW3fID.ZQ4/zo1G.q1lRps.9cGLcZEiGDMVr5yUP1KUOYTa
──┬─ ─┬─ ──────────────┬────────────── ──────────────┬─────────────
  │   │                │                             │
 Alg Cost           128-bit Salt               184-bit Checksum
      (1024 rds)   (22 base64 chars)           (31 base64 chars)
```

1. **Identifier (`$2a$`):** Denotes the BCrypt algorithm revision.
2. **Cost (`$10$`):** Logarithmic work factor ($2^{10} = 1024$ key expansion rounds).
3. **Salt (22 characters):** 128-bit random salt encoded using a custom BCrypt Base64 alphabet.
4. **Checksum (31 characters):** 184-bit output derived from encrypting the string `"OrpheanBeholderScryDoubt"` 64 times using the key derived from the password and salt.

### The 72-Byte Password Truncation Quirk
Because BCrypt's underlying Blowfish cipher uses a maximum key length of 448 bits (56 bytes) and pads to 72 bytes, **BCrypt silently truncates passwords longer than 72 bytes!**
* If a user sets a password with 100 characters, any input matching the first 72 bytes will successfully authenticate.
* *Enterprise Defense:* In high-security systems, inputs are pre-hashed using SHA-256 before being passed to BCrypt:

$$\text{BCrypt}\Big(\text{Base64}\big(\text{SHA-256}(\text{password})\big)\Big)$$

Since SHA-256 always produces a fixed 32-byte digest, it never exceeds the 72-byte threshold while retaining full entropy.

---

# Module 3: Complete Persistence, ORM & Relational Database Architecture

## 3.1 The Data Access Continuum: JDBC to Full ORM

Software engineering provides a spectrum of data access abstractions. No single abstraction is universally superior; each solves a specific balance of developer velocity versus fine-grained database optimization.

```
Raw JDBC  ────────► Spring JdbcTemplate ────────► SQL Mappers (jOOQ/MyBatis) ────────► Full ORM (JPA/Hibernate)
[Zero Abstraction]                                                                     [Complete Object Graph]
[Max Control / High Boilerplate]                                                       [Rapid CRUD / High Magic]
```

1. **Raw JDBC (Java Database Connectivity):**
   * Direct interaction with database drivers via TCP sockets.
   * Requires manual connection management, statement creation, SQL string construction, and iterating over `ResultSet` rows.
   * *Where used:* Extreme low-latency financial systems; custom framework development.
2. **Spring `JdbcTemplate`:**
   * Removes repetitive connection lifecycle boilerplate and exception translation (`SQLException` $\rightarrow$ Spring `DataAccessException`).
   * Developers write explicit SQL statements and map columns via `RowMapper<T>`.
   * *Where used:* Batch processing, bulk analytical imports, high-performance reporting.
3. **SQL Mappers (jOOQ / MyBatis):**
   * jOOQ generates type-safe Java code directly from your database schema. Queries are written in fluent Java DSL that mimics SQL precisely (`create.selectFrom(USERS).where(...)`).
   * *Where used:* Complex reporting, dynamic multi-table joins, subqueries, and window functions where ORMs produce suboptimal SQL.
4. **Full ORM (JPA / Hibernate):**
   * Maps Java classes to database tables and object references to foreign keys.
   * Manages entity state machines, dirty checking, first-level session caches, and write-behind persistence.
   * *Where used:* Domain-driven transaction processing (OLTP), enterprise web backends, rapid CRUD application development.

---

## 3.2 The Object-Relational Impedance Mismatch

Relational databases and Object-Oriented Programming (OOP) are built on fundamentally contradictory mathematical paradigms:
* **Relational Model:** Founded on **Relational Calculus and Set Theory** (Edgar F. Codd). Data is flat, normalized into tuples (rows) and relations (tables), without identity distinct from primary keys.
* **OOP Model:** Founded on **Graph Theory and Encapsulation**. Objects have state, behavior, inheritance hierarchies, and unique heap memory identity independent of their field values.

### The Five Core Mismatch Dimensions
1. **Granularity:** Relational databases have two levels of data structure: tables and columns. Java allows arbitrary levels of nested custom value types (e.g., an `Address` embedded inside a `User`).
2. **Subtypes (Inheritance):** Java features polymorphism and class inheritance (`class CreditCardPayment extends Payment`). Relational databases have no native concept of inheritance. (Hibernate must bridge this via strategies like `SINGLE_TABLE`, `JOINED`, or `TABLE_PER_CLASS`).
3. **Identity:**
   * In Java: Equality can be memory identity (`==`) or logical equality (`equals()`).
   * In Relational DBs: Identity is determined strictly by the Primary Key column.
4. **Associations:**
   * In Java: Directed references (`user.getWallets()`). Bi-directional navigation requires manual pointer synchronization on both objects.
   * In Relational DBs: Foreign keys are inherently non-directional. A foreign key in `wallets.user_id` allows querying users from wallets or wallets from users using `JOIN`.
5. **Data Navigation:**
   * In Java: Traversing a graph (`order.getCustomer().getAddress().getCity()`) by dereferencing pointers in memory.
   * In Relational DBs: Every dereference can trigger a separate network round-trip SQL query if not properly batched, leading directly to the **N+1 Query Problem**.

---

## 3.3 Primary Key Architecture & Index Clustering

The choice of primary key directly dictates physical storage, index fragmentation, and cluster insert throughput inside PostgreSQL's B-Tree storage engine.

```
┌────────────────────────────────────────────────────────────────────────────────────────────────────────┐
│                              PRIMARY KEY STRATEGIES COMPARISON                                         │
├───────────────────┬──────────────┬───────────────┬───────────────────────────────┬─────────────────────┤
│ Strategy          │ Space (Bytes)│ Order         │ B-Tree Page Impact            │ Batch Insert Safety │
├───────────────────┼──────────────┼───────────────┼───────────────────────────────┼─────────────────────┤
│ BIGSERIAL         │ 8 bytes      │ Monotonic     │ Perfect locality (Appends)    │ ❌ Disabled in JPA  │
│ (IDENTITY)        │ (64-bit int) │ Increasing    │ Zero page splits              │ (requires DB round) │
├───────────────────┼──────────────┼───────────────┼───────────────────────────────┼─────────────────────┤
│ DB SEQUENCE       │ 8 bytes      │ Monotonic     │ Perfect locality (Appends)    │ ✅ Enabled via      │
│ (HiLo Allocation) │ (64-bit int) │ Increasing    │ Zero page splits              │ allocationSize      │
├───────────────────┼──────────────┼───────────────┼───────────────────────────────┼─────────────────────┤
│ UUID v4 (Random)  │ 16 bytes     │ Completely    │ Catastrophic B-Tree Page      │ ✅ Generated in JVM │
│                   │ (128-bit)    │ Random        │ Splits & Cache Eviction       │                     │
├───────────────────┼──────────────┼───────────────┼───────────────────────────────┼─────────────────────┤
│ UUID v7 / TSID /  │ 16 / 8 bytes │ Time-Ordered  │ High locality (Append-mostly) │ ✅ Generated in JVM │
│ Snowflake         │              │ Monotonic     │ Minimal page splits           │ (Fast & distributed)│
└───────────────────┴──────────────┴───────────────┴───────────────────────────────┴─────────────────────┘
```

### Why `GenerationType.IDENTITY` Disables Hibernate Batch Inserts
* To track an entity in its First-Level Cache, Hibernate **must know its Primary Key immediately upon `persist()`**.
* With `GenerationType.IDENTITY`, the ID is generated by PostgreSQL's `BIGSERIAL` sequence **only when the physical SQL `INSERT` statement is executed**.
* Therefore, Hibernate cannot delay inserts into a batch; it is forced to execute an immediate SQL `INSERT` for every single entity, destroying JDBC batching performance ($10{,}000$ inserts = $10{,}000$ sequential database network calls).
* *Enterprise Fix:* Use `GenerationType.SEQUENCE` with an `allocationSize = 50` (HiLo algorithm), or generate time-ordered identifiers (UUIDv7 / TSID) in the application layer.

### B-Tree Index Fragmentation with Random UUIDv4
* Relational database tables cluster rows physically on disk ordered by the primary key B-Tree index.
* When using random UUIDv4, new keys land at random positions across the entire B-Tree index pages.
* Once the table exceeds available RAM, every insert requires reading a random page from SSD, modifying it, and writing it back. Pages become fragmented, fill factors drop to 50%, and disk I/O spikes exponentially.
* **UUIDv7 solves this:** It embeds a 48-bit Unix epoch millisecond timestamp in the high-order bits, ensuring new keys are monotonically increasing and append cleanly to the end of B-Tree pages like a sequence.

---

## 3.4 Connection Pooling Engineering: HikariCP Internals & Sizing Math

Opening a physical database connection is an expensive operation:
1. OS TCP 3-way handshake.
2. TLS cryptographic negotiation.
3. PostgreSQL forks a dedicated backend worker process and allocates memory buffers (`work_mem`, `maintenance_work_mem`).
4. Authentication handshake and session state initialization.

A Connection Pool maintains a pre-warmed set of physical connections, loaning them to application threads for the duration of a transaction and reclaiming them upon completion.

### Why HikariCP Dominates the Java Ecosystem
HikariCP is the default connection pool in Spring Boot due to its zero-overhead design:
* **Bytecode-level Micro-optimizations:** Strips down delegates and inlines methods.
* **`FastList` Implementation:** Replaces Java's `ArrayList` for tracking open statements. When closing a connection, `FastList` scans from the tail ($O(1)$) rather than the head ($O(N)$), because statements are closed in LIFO order.
* **Lock-Free Concurrency (`ConcurrentBag`):** Eliminates thread contention on borrowing connections using ThreadLocal caching and lock-free handoffs.

### The PostgreSQL Connection Pool Sizing Formula
A common junior mistake is setting connection pool sizes to massive numbers (e.g., 200–500 connections). In reality, oversized pools degrade throughput due to CPU context switching and disk spindle saturation.

The PostgreSQL and HikariCP engineering formula:

$$\text{Pool Size} = T_n \times (C_m - 1) + 1 \quad \text{or} \quad \text{connections} = \Big(\text{core\_count} \times 2\Big) + \text{effective\_spindle\_count}$$

* On an 8-core server with an NVMe SSD ($\text{effective\_spindle\_count} \approx 1$):
  $$\text{Optimal Pool Size} = (8 \times 2) + 1 = 17 \text{ connections}$$
* 17 properly utilized connections will deliver higher transaction throughput than 200 connections competing for CPU execution time!

---

## 3.5 Hibernate Entity Lifecycle & Persistence Context Mechanics

Every entity instance within Hibernate exists within a formal state machine governed by the `EntityManager` Persistence Context.

```
                  ┌──────────────────────┐
                  │      TRANSIENT       │ (new User())
                  └──────────┬───────────┘
                             │
                      persist() / save()
                             │
                             ▼
 ┌──────────┐     ┌──────────────────────┐     evict() / clear()     ┌──────────┐
 │ REMOVED  │◄────┤       MANAGED        ├──────────────────────────►│ DETACHED │
 └──────────┘     └──────────┬───────────┘                           └──────────┘
  (delete)                   │                                        (session closed)
                             │ Transaction Commit
                             ▼
                    [ PostgreSQL Database ]
```

### The 4 JPA Entity States
1. **Transient (New):**
   * The object was instantiated with `new User()`.
   * Has no database identity (`id == null`) and is not tracked by any Hibernate `EntityManager`.
2. **Managed (Persistent):**
   * Associated with an active Persistence Context.
   * Possesses a database primary key.
   * **Automatic Dirty Checking:** Hibernate takes an in-memory snapshot of the entity when it enters the context. When the transaction commits, Hibernate compares the current entity state against the snapshot. Any modified fields trigger an automatic SQL `UPDATE` statement without the developer ever calling `save()`!
3. **Detached:**
   * The entity possesses a database ID, but its associated Hibernate session was closed (e.g., after the `@Transactional` boundary finishes).
   * Changes made to a detached entity are not tracked and will not update the database unless re-attached via `entityManager.merge()`.
   * Accessing uninitialized lazy associations on a detached entity triggers the infamous `LazyInitializationException`.
4. **Removed:**
   * Entity was scheduled for deletion via `entityManager.remove()`. The corresponding SQL `DELETE` is executed during transaction flush.

---

## 3.6 The N+1 Query Problem & Fetch Optimization

The N+1 Query Problem is the most common cause of database performance failure in enterprise ORM applications.

### How It Occurs
Consider an entity relationship where `User` has a `@OneToMany` collection of `Wallet`s:
```java
List<User> users = userRepository.findAll(); // Query 1: SELECT * FROM users (fetches 100 users)
for (User u : users) {
    System.out.println(u.getWallets().size()); // Query 2..101: SELECT * FROM wallets WHERE user_id = ?
}
```
* **Query 1:** Loads the $N$ parent records ($1$ query).
* **Queries 2 to $N+1$:** For each parent record, Hibernate executes a separate sequential query to fetch its child records ($N$ additional queries).
* For 1,000 users, this executes **1,001 database queries**, destroying database throughput.

### The Three Production Solutions
1. **JPQL `JOIN FETCH`:**
   ```java
   @Query("SELECT u FROM User u JOIN FETCH u.wallets")
   List<User> findAllWithWallets();
   ```
   Forces Hibernate to perform an inner or left join in the primary SQL statement, loading parents and children in a single round-trip query.
2. **Entity Graphs (`@EntityGraph`):**
   ```java
   @EntityGraph(attributePaths = {"wallets"})
   List<User> findAll();
   ```
   Declaratively overrides fetch plans at runtime without rewriting query strings.
3. **DTO Projections (The Senior Staff Pattern):**
   Instead of loading heavy managed entities, query only the required fields directly into an immutable Java Record or DTO:
   ```java
   @Query("SELECT new com.example.nexpay.dto.UserWalletSummary(u.id, u.email, w.balance) " +
          "FROM User u JOIN u.wallets w")
   List<UserWalletSummary> findSummaries();
   ```
   Zero entity tracking, zero snapshot memory overhead, zero N+1 queries.

---

## 3.7 Database Transactions, ACID Guarantees & Isolation Levels

A database transaction is a sequence of read and write operations executed as a single logical unit of work.

### ACID Properties
* **Atomicity:** All-or-nothing. If a step fails in a multi-step financial transfer, all previous operations are rolled back using the database's Write-Ahead Log (WAL) and undo buffers.
* **Consistency:** A transaction transitions the database from one valid state to another, strictly maintaining all schema constraints, foreign keys, and unique checks.
* **Isolation:** Uncommitted modifications made by one transaction are invisible to concurrent transactions based on the configured isolation level.
* **Durability:** Once committed, changes are permanently written to non-volatile storage (WAL fsync) and survive power loss or system crashes.

### Concurrency Anomalies & Isolation Levels

```
┌────────────────────────────────────────────────────────────────────────────────────────────────────────┐
│                                 CONCURRENCY ANOMALIES MATRIX                                           │
├────────────────────┬────────────┬──────────────────────┬──────────────┬────────────────────────────────┤
│ Isolation Level    │ Dirty Read │ Non-Repeatable Read  │ Phantom Read │ Lost Update                    │
├────────────────────┼────────────┼──────────────────────┼──────────────┼────────────────────────────────┤
│ Read Uncommitted   │ ❌ Allowed │ ❌ Allowed           │ ❌ Allowed   │ ❌ Allowed                     │
│ Read Committed     │ 🛡️ Safe   │ ❌ Allowed           │ ❌ Allowed   │ ❌ Allowed                     │
│ Repeatable Read    │ 🛡️ Safe   │ 🛡️ Safe             │ ⚠️ Engine-dep│ 🛡️ Safe in Postgres (MVCC)     │
│ Serializable       │ 🛡️ Safe   │ 🛡️ Safe             │ 🛡️ Safe     │ 🛡️ Safe                        │
└────────────────────┴────────────┴──────────────────────┴──────────────┴────────────────────────────────┘
```

1. **Dirty Read:** Transaction A modifies a row without committing. Transaction B reads the uncommitted value. Transaction A rolls back. Transaction B acted on data that never officially existed!
2. **Non-Repeatable Read:** Transaction A reads a row. Transaction B updates the row and commits. Transaction A reads the row again and sees different data.
3. **Phantom Read:** Transaction A queries rows matching a condition (`balance > 1000`). Transaction B inserts a new row matching that condition and commits. Transaction A re-runs the query and sees a new "phantom" row.
4. **Lost Update:** Transaction A and Transaction B read balance ₹1,000 simultaneously. Both deduct ₹200 in memory and write ₹800 back to the DB. One deduction is completely lost!

---

# Module 4: Complete Inversion of Control (IoC) & Spring Framework Architecture

## 4.1 The Hollywood Principle & Inversion of Control

In traditional procedural programming, application code controls the execution flow:
```java
// Traditional: Direct instantiation and tight coupling
public class UserService {
    private UserRepository repo = new PostgresUserRepository(); // Hard-coded dependency
}
```
* **Inversion of Control (IoC):** Inverts this flow of control, adhering to the **Hollywood Principle: *"Don't call us, we'll call you."***
* A framework container manages object instantiation, lifecycle, configuration, and dependency assembly. The class merely declares what it needs; the container supplies it.

```
TRADITIONAL ARCHITECTURE:
UserService ─────────────► creates ─────────────► PostgresUserRepository (Tight Coupling)

SPRING IoC ARCHITECTURE:
ApplicationContext ───────► instantiates ───────► PostgresUserRepository
         │
         └───────────────► injects into ───────► UserService (Decoupled Interface)
```

---

## 4.2 Dependency Injection Flavors & Staff-Level Conventions

```
┌────────────────────────────────────────────────────────────────────────────────────────────────────────┐
│                               DEPENDENCY INJECTION FLAVORS                                             │
├───────────────────┬───────────────────────────────────────────┬────────────────────────────────────────┤
│ Pattern           │ Syntax                                    │ Assessment                             │
├───────────────────┼───────────────────────────────────────────┼────────────────────────────────────────┤
│ Field Injection   │ @Autowired private UserService svc;       │ ❌ Anti-Pattern (Hidden dependencies,   │
│                   │                                           │ impossible pure POJO unit testing)     │
├───────────────────┼───────────────────────────────────────────┼────────────────────────────────────────┤
│ Setter Injection  │ @Autowired public void setSvc(...)        │ ⚠️ Discouraged (Mutable state,          │
│                   │                                           │ permits partial initialization bugs)   │
├───────────────────┼───────────────────────────────────────────┼────────────────────────────────────────┤
│ Constructor       │ public MyClass(UserService svc) { ... }   │ 🏆 Staff Industry Standard (Immutable, │
│ Injection         │ (or Lombok @RequiredArgsConstructor)      │ fail-fast, pure Mockito unit testing)  │
└───────────────────┴───────────────────────────────────────────┴────────────────────────────────────────┘
```

### Why Constructor Injection is the Non-Negotiable Standard
1. **Thread-Safe Immutability:** Dependencies are declared as `private final`, ensuring they are assigned once during JVM object construction and cannot be mutated afterwards.
2. **Elimination of Partial Construction:** An object cannot be instantiated in an invalid state. If a required dependency is missing, construction fails at compile time or application startup.
3. **Effortless Unit Testing:** You can test the service in a standard JUnit test (`new UserService(mockRepo)`) without booting up Spring, without reflection hacks, and without slow container startup times.
4. **Circular Dependency Detection:** If Class A requires Class B, and Class B requires Class A, Constructor Injection causes Spring to fail immediately at startup with `BeanCurrentlyInCreationException`, exposing architectural flaws early.

---

## 4.3 Spring Container Architecture: BeanFactory vs ApplicationContext

Spring provides two tiers of IoC containers:
1. **`BeanFactory`:**
   * The basic IoC container (`org.springframework.beans.factory.BeanFactory`).
   * Provides lazy initialization: beans are instantiated only when explicitly requested via `getBean()`.
   * Minimal memory footprint; used in resource-constrained embedded systems.
2. **`ApplicationContext`:**
   * A full enterprise superset of `BeanFactory` (`org.springframework.context.ApplicationContext`).
   * Features: Eager bean pre-instantiation, declarative AOP proxies, event publication/listening (`ApplicationEvent`), message internationalization (`MessageSource`), and environment property management.
   * Standard in all Spring Boot web and enterprise applications.

---

## 4.4 The Full Spring Bean Lifecycle

Understanding the exact sequence of bean instantiation is essential for debugging `@PostConstruct`, AOP proxies, and bean configuration hooks.

```
1. Classloading & Bean Definition Resolution (from @Component, @Service, @Bean)
         │
2. Heap Memory Allocation & Constructor Invocation
         │
3. Dependency Injection (Populating @Autowired / constructor fields)
         │
4. Aware Interfaces Callback (BeanNameAware, BeanFactoryAware, ApplicationContextAware)
         │
5. BeanPostProcessor: postProcessBeforeInitialization()
         │
6. Initialization Hooks: @PostConstruct ──► InitializingBean.afterPropertiesSet() ──► custom initMethod()
         │
7. BeanPostProcessor: postProcessAfterInitialization() ──► (AOP PROXIES CREATED HERE!)
         │
8. Bean is READY FOR USE in ApplicationContext
         │
   [Application Shutdown Initiated]
         │
9. Destruction Hooks: @PreDestroy ──► DisposableBean.destroy() ──► custom destroyMethod()
```

---

## 4.5 Spring AOP & Dynamic Proxies (The Self-Invocation Trap)

Spring implements cross-cutting concerns (`@Transactional`, `@Async`, `@Cacheable`, `@PreAuthorize`) using **Aspect-Oriented Programming (AOP)** backed by runtime dynamic proxies.

### The Two Proxy Mechanisms
1. **JDK Dynamic Proxies (`java.lang.reflect.Proxy`):**
   * Used when the target class implements an interface.
   * Creates a dynamic class implementing the interface that intercepts method calls and delegates to an `InvocationHandler`.
2. **CGLIB / ByteBuddy Proxies:**
   * Used when the target class does not implement an interface.
   * Generates a dynamic subclass of the target class at runtime, overriding public methods to inject interceptor advice. (Default in Spring Boot).

### The Infamous "Self-Invocation" Bug
Because Spring intercepts calls via the outer proxy wrapper, **invoking an annotated method from within the same class bypasses the proxy entirely!**

```java
@Service
public class PaymentService {

    public void process() {
        // Direct method call on 'this' pointer!
        // Bypasses the Spring CGLIB Proxy!
        // @Transactional is SILENTLY IGNORED!
        this.executeTransfer(); 
    }

    @Transactional
    public void executeTransfer() {
        // DB operations execute WITHOUT a transaction!
    }
}
```

* **Why it fails:** Inside `process()`, calling `this.executeTransfer()` invokes the method on the raw JVM instance pointer (`this`), not on the Spring proxy wrapper. The transactional interceptor advice is never triggered.
* *Enterprise Fix:* Move `executeTransfer()` into a separate service bean, or inject the bean into itself via `ObjectProvider<PaymentService>`.

---

# Module 5: Complete HTTP API Design & Enterprise Error Architecture

## 5.1 Richardson Maturity Model & HTTP Protocol Invariants

Developed by Leonard Richardson, this model grades APIs on their adherence to RESTful principles:

```
Level 3: Hypermedia Controls (HATEOAS - RFC 5988 links guiding next actions)
         ▲
Level 2: HTTP Verbs & Status Codes (GET, POST, PUT, DELETE + 200, 201, 400, 404)
         ▲
Level 1: Resources (Individual URIs: /api/users/1, /api/wallets/5)
         ▲
Level 0: The Swamp of POX (Single URI like /endpoint, HTTP POST only, RPC style)
```

### HTTP Method Invariants: Safety & Idempotency
* **Safety:** An HTTP method is safe if it does not alter server state.
  * *Safe:* `GET`, `HEAD`, `OPTIONS`.
  * *Unsafe:* `POST`, `PUT`, `PATCH`, `DELETE`.
* **Idempotency:** An HTTP method is idempotent if executing it multiple times yields the exact same server state as executing it once:

$$f(f(x)) = f(x)$$

  * `GET /api/wallet/1` $\rightarrow$ Idempotent (state never changes).
  * `DELETE /api/wallet/1` $\rightarrow$ Idempotent (row is deleted; subsequent calls find it already absent).
  * `PUT /api/wallet/1` (replace) $\rightarrow$ Idempotent (setting balance to ₹500 repeatedly leaves it at ₹500).
  * `POST /api/wallet/top-up` $\rightarrow$ **NOT Idempotent** (calling it 3 times tops up money 3 times!).

---

## 5.2 HTTP Status Code Taxonomy & Semantic Accuracy

```
┌────────────────────────────────────────────────────────────────────────────────────────────────────────┐
│                                HTTP STATUS CODE MASTER TAXONOMY                                        │
├───────┬──────────────────────┬─────────────────────────────────────────────────────────────────────────┤
│ Range │ Category             │ Common Enterprise Codes                                                 │
├───────┼──────────────────────┼─────────────────────────────────────────────────────────────────────────┤
│ 1xx   │ Informational        │ 101 Switching Protocols (WebSockets upgrade)                            │
│ 2xx   │ Success              │ 200 OK (Read/Update), 201 Created (POST insert), 204 No Content (DELETE)│
│ 3xx   │ Redirection          │ 301 Moved Permanently, 304 Not Modified (HTTP Caching)                  │
│ 4xx   │ Client Errors        │ 400 Bad Request (Validation), 401 Unauthorized (No token),              │
│       │                      │ 403 Forbidden (RBAC denied), 404 Not Found, 409 Conflict (Duplicate),   │
│       │                      │ 422 Unprocessable Entity, 429 Too Many Requests (Rate limit)            │
│ 5xx   │ Server Errors        │ 500 Internal Server Error, 502 Bad Gateway, 503 Service Unavailable     │
└───────┴──────────────────────┴─────────────────────────────────────────────────────────────────────────┘
```

> [!TIP]
> **401 Unauthorized vs. 403 Forbidden:**
> * `401 Unauthorized` means **Unauthenticated**: "I don't know who you are. Provide a valid Bearer token."
> * `403 Forbidden` means **Unauthorized**: "I know who you are, but you do not possess the required `ADMIN` permission to access this resource."

---

## 5.3 Standardized Problem Details (RFC 7807 & RFC 9457)

In primitive APIs, error payloads are chaotic: some return strings (`"Error occurred"`), some return HTML stack traces, and others return custom JSON structures.

**RFC 7807 (updated by RFC 9457)** defines the universal internet standard for HTTP API problem details:
```json
{
  "type": "https://api.nexpay.com/errors/insufficient-funds",
  "title": "Insufficient Funds",
  "status": 400,
  "detail": "Your wallet balance (₹250.00) is insufficient for this transfer of ₹500.00.",
  "instance": "/api/transfers/tx_987654",
  "timestamp": "2026-10-15T02:30:00Z"
}
```

---

## 5.4 Spring MVC DispatcherServlet Pipeline & Global Exception Handling

When an HTTP request enters Tomcat, it navigates through Spring's web pipeline:

```
[ HTTP Request ]
       │
       ▼
[ Servlet Filter Chain ] (JwtFilter executes here)
       │
       ▼
[ DispatcherServlet ] (Front Controller)
       │
       ▼
[ HandlerMapping ] ──► Resolves target @RestController & Method
       │
       ▼
[ HandlerAdapter ] ──► Evaluates @Valid on DTOs via MethodValidationPostProcessor
       │
       ▼
[ Controller Method ] ──► Throws Exception (e.g. RuntimeException("User not found"))
       │
       ▼
[ HandlerExceptionResolverComposite ]
       │
       ▼
[ @RestControllerAdvice ] (GlobalExceptionHandler catches exception & serializes RFC JSON)
       │
       ▼
[ HTTP 400/500 JSON Response Stream ]
```

---

# Module 6: Modern Java Evolution & High-Concurrency Systems

## 6.1 Modern Java Language Evolution (Java 8 → 17 → 21/24)

Modern Java is expressive, type-safe, and highly performant:
* **Java 10 `var`:** Compile-time local variable type inference. Eliminates repetitive type declarations without sacrificing static typing.
* **Java 15 Text Blocks (`"""`):** Multi-line string literals that preserve formatting without `\n` and string concatenation. Ideal for SQL queries, JSON payloads, and AI prompts.
* **Java 16 `record`:** Pure immutable data carriers. Generates `private final` fields, canonical constructors, getters, `equals()`, `hashCode()`, and `toString()` in bytecode.
* **Java 17 Pattern Matching & Exhaustive Switch Expressions:**
  ```java
  return switch (status) {
      case SUCCESS -> handleSuccess();
      case PENDING -> handlePending();
      case FAILED  -> handleFailure();
  };
  ```
  Compiler enforces exhaustiveness; adding a new enum without updating the switch produces a compile-time error.
* **Java 17 `sealed` Classes:** Restricts subclassing to a permitted whitelist (`public sealed interface Payment permits UpiPayment, CardPayment`).

---

## 6.2 Concurrency Paradigms: OS Threads vs Reactive vs Virtual Threads

```
┌────────────────────────────────────────────────────────────────────────────────────────────────────────┐
│                                CONCURRENCY PARADIGMS COMPARISON                                        │
├──────────────────────┬─────────────────────────────┬───────────────────────────┬───────────────────────┤
│ Dimension            │ Platform (OS) Threads       │ Reactive (WebFlux/Reactor)│ Virtual Threads (Loom)│
├──────────────────────┼─────────────────────────────┼───────────────────────────┼───────────────────────┤
│ Thread Mapping       │ 1:1 with OS Kernel Thread   │ N:M Event Loop            │ M:N JVM Continuations │
│ Memory Stack Size    │ ~1MB per thread             │ ~Few KB per task          │ ~1KB per thread       │
│ Max Concurrency      │ ~2,000 threads per JVM      │ 50,000+ per JVM           │ 1,000,000+ per JVM    │
│ Blocking I/O Impact  │ Blocks OS kernel thread     │ Prohibited (Starves loop) │ Unmounts continuation │
│ Code Style           │ Simple Synchronous          │ Complex Functional/Monads │ Simple Synchronous    │
│ Stack Traces         │ Clear, sequential           │ Fragmented, asynchronous  │ Clear, sequential     │
└──────────────────────┴─────────────────────────────┴───────────────────────────┴───────────────────────┘
```

### Virtual Threads in Spring Boot (Project Loom)
In Spring Boot 3.2+ with Java 21+, enabling virtual threads is a single configuration property:
```yaml
spring:
  threads:
    virtual:
      enabled: true
```
Tomcat no longer limits throughput to its 200-thread pool. When a virtual thread executes a blocking JDBC database call or HTTP request, the JVM unmounts its stack frame from the OS carrier thread and parks it in heap memory, allowing the carrier thread to process other requests.

---

# Module 7: DevOps, Cloud, Clean Code & Software Engineering Standards

## 7.1 Clean Enterprise Code & The "Zero Tutorial Comments" Rule
* **Self-Documenting Code:** Method signatures, meaningful variable names, and precise domain types explain **what** code does.
* **When to Comment:** Comments in production code should strictly explain **business invariants**, **cryptographic threat models**, or **non-obvious algorithmic trade-offs**.
* **Junior vs. Senior Code Signal:**
  * ❌ *Junior Copy-Paste:* `// Lombok generates getters and setters`
  * ✅ *Senior Enterprise:* `// Constant-time hash verification to neutralize timing side-channel attacks`

---

## 7.2 Database Crash Consistency, Lock Files & WAL Replay
* **`postmaster.pid`:** PostgreSQL's file-based mutex lock preventing multiple server daemons from concurrently writing to the same physical disk partition.
* **Write-Ahead Logging (WAL):** PostgreSQL logs all transaction changes to sequential disk storage *before* applying them to data pages. During an unexpected power loss:
  1. PostgreSQL detects dirty state on boot.
  2. WAL replay (`redo starts at ... redo done`) reads committed transactions and reapplies them to shared buffer tables.
  3. The database transitions to a crash-consistent state without data loss.

---

## 7.3 Git Internals, UTC Boundaries & Contribution Graph Mathematics
* **UTC Boundary Evaluation:** GitHub calculates contribution squares against **UTC (Coordinated Universal Time)**.
  * Late-night commits made in India (IST = UTC $+05:30$) before 05:30 AM IST are evaluated under the previous day's UTC date.
* **Atomic Commit Discipline:** Commits should represent single, logically indivisible architectural units with conventional commit messages (`feat(auth): ...`, `fix(wallet): ...`).

---

## 7.4 Jackson RFC 8259 Specifications & Parsing Mechanics
* **Single Root Token Requirement:** RFC 8259 mandates that an HTTP JSON payload contains exactly one root entity.
* **`FAIL_ON_TRAILING_TOKENS`:** Jackson throws a deserialization error if extra characters or duplicate JSON objects are detected after the closing brace. Our global exception handler intercepts this cleanly, returning HTTP 400.

---

---

---

# PART II: NEXPAY ARCHITECTURE, IMPLEMENTATION & 3-PILLAR MASTERCLASSES

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

---

# Chapter 9: Day 2 — The Core Wallet Engine & Financial Precision Architecture

## 1. Holistic Domain Masterclass: Financial Data Modeling & Monetary Precision

In financial technology and high-concurrency banking systems, handling money is fundamentally different from handling standard application state. A floating-point rounding error of $0.00000001 can trigger regulatory audits, financial loss, or catastrophic balance drift over millions of transactions.

```
┌────────────────────────────────────────────────────────────────────────────────────────────────────────┐
│                              THE MONETARY DATA MODELING SPECTRUM                                       │
├──────────────────────────────┬───────────────────────────────┬─────────────────────────────────────────┤
│ Paradigm                     │ Mechanics                     │ Industry Application                    │
├──────────────────────────────┼───────────────────────────────┼─────────────────────────────────────────┤
│ 1. IEEE 754 Floating-Point   │ Binary base-2 representation  │ ❌ STRICTLY FORBIDDEN IN BANKING        │
│    (float / double)          │ Causes precision drift        │ (Permitted only in 3D graphics/physics) │
├──────────────────────────────┼───────────────────────────────┼─────────────────────────────────────────┤
│ 2. Arbitrary-Precision       │ Unscaled BigInteger + 32-bit  │ 🏆 Global Banking Standard              │
│    Decimals (BigDecimal)     │ scale. Exact base-10 math.    │ (NexPay, PayPal, Wall Street trading)   │
├──────────────────────────────┼───────────────────────────────┼─────────────────────────────────────────┤
│ 3. Minor Currency Units      │ Fixed-point integer math      │ 🏆 Modern Developer APIs                │
│    (Integer Cents / Paise)   │ Stored as signed 64-bit Long  │ (Stripe, Adyen, Razorpay)               │
└──────────────────────────────┴───────────────────────────────┴─────────────────────────────────────────┘
```

### Why Binary Floating-Point (`double` / `float`) is Strictly Forbidden in Banking
Computers operate in binary (base-2: powers of $\frac{1}{2}, \frac{1}{4}, \frac{1}{8}, \dots$). Just as the fraction $\frac{1}{3}$ cannot be represented in a finite number of base-10 decimal digits ($0.333333\dots$), standard decimal fractions like $0.1$ ($\frac{1}{10}$) and $0.2$ ($\frac{1}{5}$) **cannot be represented exactly in binary floating-point (IEEE 754)**!

```java
// What happens in Java if you use double:
double a = 0.1;
double b = 0.2;
System.out.println(a + b); 
// Outputs: 0.30000000000000004  <-- THE 4 CENTS ERROR THAT DESTROYS BANKS!
```

If a payment platform processes $100{,}000{,}000$ transactions a day using `double`, accumulated rounding drift results in hundreds of thousands of dollars vanishing or appearing out of thin air (the classic *Superman III / Office Space* "Salami Slicing" anomaly).

### How Java's `BigDecimal` Works Internally
`BigDecimal` solves this by representing a number as an arbitrary-precision integer unscaled value combined with a 32-bit integer scale:

$$\text{Value} = \text{unscaledValue} \times 10^{-\text{scale}}$$

* For `new BigDecimal("100.5000")`:
  * $\text{unscaledValue} = 1005000$ (stored in a Java `BigInteger`)
  * $\text{scale} = 4$
  * Every arithmetic operation (`add`, `subtract`, `multiply`) executes pure base-10 integer arithmetic with mathematical bounds checking, guaranteeing **zero precision loss**.

---

## 2. Component 1: `Wallet.java` — Relational Mapping, Constraints & Precision Math

### 1. 🧠 The Core Concept, Mathematics & Internal Mechanics
* **Surrogate Key Generation (`GenerationType.IDENTITY`):** Binds to PostgreSQL's `BIGSERIAL` sequence generator, producing unique 64-bit primary keys ($1, 2, 3, \dots$).
* **`@OneToOne` Relational Architecture:**
  * Establishes a 1-to-1 relational mapping between a `User` and their financial `Wallet`.
  * `@JoinColumn(name = "user_id", nullable = false, unique = true)`:
    * `nullable = false`: Guarantees no wallet can exist without an owning user (enforcing domain validity).
    * `unique = true`: Enforces a physical PostgreSQL `UNIQUE INDEX` on `user_id`. Even under high-concurrency race conditions, PostgreSQL will reject duplicate wallet creation for the same user.
* **Precision & Scale Configuration (`NUMERIC(19, 4)`):**
  * `@Column(nullable = false, precision = 19, scale = 4)`
  * `precision = 19`: Total number of significant digits (supports balances up to $999{,}999{,}999{,}999{,}999.9999$).
  * `scale = 4`: Stores 4 decimal places. While currencies display 2 decimal places ($₹10.50$), financial engines require 4 decimal places ($₹10.5025$) to accurately calculate interest, micro-fees, and exchange rates without premature rounding truncation.
* **Audit Lifecycle Hooks (`@PrePersist` & `@PreUpdate`):**
  * `@PrePersist`: Automatically stamps `createdAt` and `updatedAt` with the current system time before the initial SQL `INSERT`.
  * `@PreUpdate`: Automatically updates `updatedAt` with `LocalDateTime.now()` before any SQL `UPDATE` statement executes, providing tamper-proof audit trails.

### 2. 🎯 The Production Engineering Problem It Solves
* **Negative Balance & Balance Drift Protection:**
  * Coupled with a database-level `CHECK (balance >= 0)` constraint, using `BigDecimal` guarantees that balance subtractions never produce floating-point underflow or phantom negative numbers.
* **Multi-Wallet Concurrency Invariant:**
  * In distributed systems, if two registration requests for the same user trigger concurrently, the application-level check might pass on both threads. The physical `UNIQUE (user_id)` constraint forces PostgreSQL to abort the second transaction, preserving the strict 1:1 business invariant.

### 3. 🎤 Real Senior/Staff Interview Questions & Punchy Verbal Answers
* **Q1: Why should you never use `new BigDecimal(double val)` and always use `new BigDecimal(String val)` or `BigDecimal.valueOf(double val)`?**
  > *"The `BigDecimal(double)` constructor passes the binary floating-point approximation into `BigDecimal`. For example, `new BigDecimal(0.1)` produces `0.1000000000000000055511151231257827021181583404541015625` because `0.1` cannot be represented exactly in binary. In contrast, `new BigDecimal("0.1")` or `BigDecimal.valueOf(0.1)` parses the exact base-10 decimal representation, preserving complete precision."*
* **Q2: Why is precision 19 and scale 4 standard for fintech database schemas instead of scale 2?**
  > *"While consumer UI displays 2 decimal places (cents/paise), intermediate financial calculations—such as percentage fees (e.g. 1.75%), interest compounding, currency conversion, and tax withholding—frequently yield fractions of a cent. Storing 4 decimal places prevents cumulative rounding truncation errors across ledger transactions before final settlement."*
* **Q3: What is the architectural difference between `@OneToOne` with `@JoinColumn` vs `@MapsId` (Shared Primary Key)?**
  > *"With `@JoinColumn(name = "user_id")`, the child table (`wallets`) maintains its own independent primary key sequence (`id`) and a foreign key pointing to `users(id)`. With `@MapsId`, the child table shares the primary key of the parent (`wallets.id == users.id`), eliminating the extra surrogate sequence and foreign key index, but coupling their lifecycle identities tightly. In enterprise microservice migrations, independent surrogate keys with unique foreign key constraints offer superior schema evolution flexibility."*

### 🔍 Line-by-Line Code Breakdown of `Wallet.java`
```java
package com.example.nexpay.wallet.model;

import com.example.nexpay.user.model.User;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity                                                 // 1. Registers this class as a managed JPA Entity table
@Table(name = "wallets")                               // 2. Physical database table name: wallets
@Data                                                   // 3. Lombok: generates getters, setters, toString(), equals(), hashCode()
@NoArgsConstructor                                      // 4. Required by Hibernate reflection proxies
@AllArgsConstructor                                     // 5. Full-parameter constructor for builders and testing
@Builder                                                // 6. Enables fluent builder: Wallet.builder().balance(...).build()
public class Wallet {

    @Id                                                 // 7. Marks Primary Key column
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 8. PostgreSQL BIGSERIAL auto-increment sequence (1, 2, 3...)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)                   // 9. 1-to-1 relationship with User; lazy-loaded on demand
    @JoinColumn(name = "user_id", nullable = false, unique = true) // 10. Foreign key column with UNIQUE constraint
    private User user;

    @Column(nullable = false, precision = 19, scale = 4) // 11. Arbitrary precision: 15 whole digits, 4 decimal places
    @Builder.Default
    private BigDecimal balance = BigDecimal.ZERO;       // 12. Defaults balance to exact 0.0000

    @Column(nullable = false, length = 3)               // 13. ISO 4217 currency code (e.g., "INR", "USD", "EUR")
    @Builder.Default
    private String currency = "INR";

    private LocalDateTime createdAt;                    // 14. Immutable creation audit timestamp
    private LocalDateTime updatedAt;                    // 15. Dynamic modification audit timestamp

    @PrePersist                                         // 16. Lifecycle callback executed prior to SQL INSERT
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate                                          // 17. Lifecycle callback executed prior to SQL UPDATE
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
```


---

## 3. Component 2: `WalletRepository.java` — Dynamic Proxies, Property Expression Grammar & The Optional Monad

```
┌────────────────────────────────────────────────────────────────────────────────────────────────────────┐
│                          SPRING DATA JPA QUERY DERIVATION GRAMMAR                                      │
└────────────────────────────────────────────────────────────────────────────────────────────────────────┘
          find  +  By  +  User  +  Id  (Long userId)
            │       │       │       │
          Action  WHERE   Entity  Field
            │       │       │       │
            ▼       ▼       ▼       ▼
    SELECT * FROM wallets WHERE user_id = ?
```

### 1. 🧠 The Core Concept, Mathematics & Low-Level Mechanics
* **Dynamic Property Traversal & AST Grammars:**
  * When declaring `Optional<Wallet> findByUserId(Long userId);`, the `Wallet` entity does not contain a raw scalar property named `userId`; it contains an object reference: `private User user;`.
  * Spring Data JPA's property parser uses a camel-case tokenization algorithm:
    1. Checks if `Wallet` has a property named `userId` $\rightarrow$ False.
    2. Splits from the right at camel-case boundaries: `User` and `Id`.
    3. Verifies that `Wallet` possesses property `user` of type `User`, and `User` possesses property `id` of type `Long`.
    4. Compiles this property path into a JPQL query tree:
       $$\text{JPQL: } \texttt{SELECT w FROM Wallet w WHERE w.user.id = :userId}$$
       $$\text{SQL: } \texttt{SELECT * FROM wallets WHERE user_id = ?}$$
  * This allows direct querying against the foreign key column `user_id` without requiring an explicit SQL `JOIN` or loading the `User` entity into the JVM heap!
* **Dynamic Proxy Synthesis:** At boot time, Spring Data synthesizes a `java.lang.reflect.Proxy` implementing `WalletRepository` backed by `SimpleJpaRepository`, translating the method call into a prepared statement executed via HikariCP.

---

### 2. 🎯 The Optional Monad: Killing `if-else` Boilerplate & Defeating `NullPointerException`

The `NullPointerException` (NPE) is historically the number one source of production crashes in enterprise Java applications. 

#### The Traditional `if-else` Vulnerability (Pre-Java 8):
```java
// ❌ Dangerous & Boilerplate-Heavy
Wallet wallet = walletRepository.findByUserId(userId);

if (wallet != null) {
    return wallet.getBalance();
} else {
    throw new RuntimeException("Wallet not found!");
}
```
* **The Failure Mode:** If an engineer forgets to write the `if (wallet != null)` guard, the JVM throws an uncaught `NullPointerException` at runtime, causing unhandled HTTP 500 server crashes.

#### How `Optional<T>` Eliminates `if-else` Statements:
`Optional<T>` is a monadic container type: it represents an immutable box that either contains an active reference (`Optional.of(val)`) or is empty (`Optional.empty()`). 

Java physically prevents you from accessing the inner object without unwrapping the box, replacing procedural `if-else` checks with declarative functional combinators:

```
┌────────────────────────────────────────────────────────────────────────────────────────────────────────┐
│                              THE OPTIONAL FUNCTIONAL COMBINATOR MATRIX                                 │
├──────────────────────────┬───────────────────────────────────────────┬─────────────────────────────────┤
│ Desired Behavior         │ Modern Functional Syntax (Zero if-else!)  │ What Happens Under The Hood     │
├──────────────────────────┼───────────────────────────────────────────┼─────────────────────────────────┤
│ 1. Throw error on absent │ walletRepository.findByUserId(id)         │ If empty, halts flow and throws │
│                          │     .orElseThrow(() -> new NotFound());   │ sanitized business exception.   │
├──────────────────────────┼───────────────────────────────────────────┼─────────────────────────────────┤
│ 2. Return safe fallback  │ walletRepository.findByUserId(id)         │ If empty, returns default value │
│    default value         │     .map(Wallet::getBalance)             │ (e.g. BigDecimal.ZERO) with     │
│                          │     .orElse(BigDecimal.ZERO);             │ zero null pointer risk.         │
├──────────────────────────┼───────────────────────────────────────────┼─────────────────────────────────┤
│ 3. Execute conditional   │ walletRepository.findByUserId(id)         │ Runs lambda strictly when       │
│    side-effect action    │     .ifPresent(w -> notify(w));           │ entity exists; no-op if empty.  │
└──────────────────────────┴───────────────────────────────────────────┴─────────────────────────────────┘
```

> [!WARNING]
> **The `Optional.isPresent()` Anti-Pattern:**
> Calling `if (walletOpt.isPresent()) { Wallet w = walletOpt.get(); } else { ... }` is considered a junior anti-pattern because it replicates traditional `if-else` null checks. Modern Spring Boot services use `.orElseThrow()` or `.map()` pipelines exclusively.

---

### 3. 🎤 Real Senior/Staff Interview Questions & Punchy Verbal Answers
* **Q1: How does Spring Data JPA resolve `findByUserId` when the entity property is named `user`?**
  > *"Spring Data's property parser tokenizes the method name by camel-case boundaries. When resolving `UserId`, it detects that `Wallet` has no direct field named `userId`, so it splits it into `User` and `Id`. It navigates from `Wallet.user` to `User.id` and generates a parameterized SQL predicate `WHERE user_id = ?`, querying the foreign key directly without loading the User entity."*
* **Q2: Why should repository methods return `Optional<T>` instead of raw entity references or null?**
  > *"Returning `Optional<T>` eliminates runtime `NullPointerException`s by turning the possibility of absence into a type-level contract. It forces caller services to explicitly handle missing records using functional combinators like `.orElseThrow()`, preventing silent null propagation through the domain layer."*
* **Q3: Is it acceptable to use `Optional` as a method parameter or entity field?**
  > *"No. `Optional` is not `Serializable`, making it unsuitable for JPA entity fields or session storage. It also introduces extra heap allocation overhead. In production Java, `Optional` is strictly designed as a method return type to represent absent query results."*

---

### 🔍 Line-by-Line Code Breakdown of `WalletRepository.java`
```java
package com.example.nexpay.wallet.repository;

import com.example.nexpay.wallet.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository                                             // 1. Stereotype marking interface as a Spring Data DAO bean
public interface WalletRepository extends JpaRepository<Wallet, Long> {

    // 2. Traverses Wallet.user.id foreign key: SELECT * FROM wallets WHERE user_id = ?
    // Returns Optional<Wallet> monad to force safe, functional absence handling
    Optional<Wallet> findByUserId(Long userId);
}
```


---

## 4. Component 3: Updating `UserService.java` — Multi-Entity Orchestration & `@Transactional` Atomicity

```
[ POST /api/auth/register ]
            │
            ▼
┌────────────────────────────────────────────────────────┐
│             @Transactional Boundary (Proxy)            │
│  Connection.setAutoCommit(false);                      │
│                                                        │
│  1. userRepository.save(user)     ──► INSERT users     │
│  2. walletRepository.save(wallet) ──► INSERT wallets   │
│                                                        │
│  Connection.commit(); (Both succeed or both rollback!) │
└────────────────────────────────────────────────────────┘
```

### 1. 🧠 The Core Concept, Mathematics & Low-Level Mechanics
* **Service Layer Multi-Entity Coordination:** `UserService` coordinates writes across two separate repositories (`UserRepository` and `WalletRepository`) to maintain the business invariant that every user owns a provisioned wallet.
* **`@Transactional` Spring AOP Interception:**
  * When entering `registerUser()`, Spring's CGLIB proxy intercepts execution, obtains a JDBC `Connection` from HikariCP, and calls `connection.setAutoCommit(false)`.
  * Both SQL `INSERT` statements execute under the same transaction ID in PostgreSQL.
  * If an unhandled `RuntimeException` propagates, the proxy catches it and invokes `connection.rollback()`, ensuring atomicity.

---

### 2. 🎯 The Production Engineering Problem It Solves
* **The "Ghost User / Orphan Account" Anomaly:**
  * Without `@Transactional`: If saving the user succeeds but the server crashes before the wallet is persisted, the user exists in PostgreSQL without a wallet. Future logins or payment transfers immediately crash with `WalletNotFoundException`.
  * With `@Transactional`: Guarantees $All \lor Nothing$. A user never exists without a wallet.

---

### 3. 🎤 Real Senior/Staff Interview Questions & Punchy Verbal Answers
* **Q1: What exceptions trigger an automatic rollback in Spring's `@Transactional` by default?**
  > *"By default, Spring's `@Transactional` only triggers rollback on **unchecked exceptions** (`RuntimeException` and `Error`). It does **not** roll back on checked exceptions (`java.lang.Exception`). If rollback is required for checked exceptions, it must be explicitly configured via `@Transactional(rollbackFor = Exception.class)`."*
* **Q2: Why should wallet provisioning happen in the same transaction as user registration rather than an asynchronous event?**
  > *"Because a wallet is a core domain invariant for a fintech user. If wallet provisioning were deferred to an asynchronous event queue (e.g. RabbitMQ/Kafka), a race condition could occur where the user completes registration, logs in immediately via JWT, and attempts an API call before the background worker finishes creating their wallet, resulting in 404 errors."*

---

### 🔍 Line-by-Line Code Breakdown of Updated `UserService.java`
```java
package com.example.nexpay.user.service;

import com.example.nexpay.security.JwtService;
import com.example.nexpay.user.dto.AuthResponse;
import com.example.nexpay.user.dto.LoginRequest;
import com.example.nexpay.user.dto.RegisterRequest;
import com.example.nexpay.user.model.User;
import com.example.nexpay.user.repository.UserRepository;
import com.example.nexpay.wallet.model.Wallet;
import com.example.nexpay.wallet.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final WalletRepository walletRepository;     // 1. Injected Wallet DAO
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Transactional                                      // 2. ACID Atomic Transaction: both User & Wallet commit together!
    public User registerUser(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email is already registered!");
        }

        if (userRepository.existsByPhone(request.getPhone())) {
            throw new RuntimeException("Phone number is already registered!");
        }

        // 3. Build & save the user
        User user = User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .passwordHash(passwordEncoder.encode(request.getPassword()))
                .phone(request.getPhone())
                .role(User.Role.USER)
                .build();

        User savedUser = userRepository.save(user);

        // 4. Auto-provision a digital wallet with ₹1,000.00 welcome bonus!
        Wallet wallet = Wallet.builder()
                .user(savedUser)
                .balance(new BigDecimal("1000.0000"))   // Exact base-10 monetary math
                .currency("INR")
                .build();

        walletRepository.save(wallet);                  // 5. Persisted in the exact same DB transaction

        return savedUser;
    }

    public AuthResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPasswordHash())) {
            throw new RuntimeException("Invalid email or password");
        }

        String token = jwtService.generateToken(user.getEmail());
        return new AuthResponse(token, user.getEmail(), user.getFullName());
    }
}
```


---

### 5. Architectural Deep Dive: The CGLIB Transaction Proxy & Low-Level JDBC Mechanics

```
[ AuthController ]
        │
        │ Calls: userService.registerUser(request)
        ▼
┌────────────────────────────────────────────────────────┐
│              THE SPRING CGLIB PROXY (The Bodyguard)    │
│                                                        │
│  1. Borrows physical TCP connection from HikariCP pool │
│  2. Calls: connection.setAutoCommit(false);            │
│  3. Starts try-catch block                             │
│                                                        │
│         │ (Delegates call)                             │
│         ▼                                              │
│     [ YOUR ACTUAL UserService.registerUser() ]         │
│       • userRepository.save(user)                      │
│       • walletRepository.save(wallet)                  │
│         │                                              │
│         ▼                                              │
│  4. Did an exception happen?                           │
│     ├── NO  ──► Calls: connection.commit();            │
│     └── YES ──► Calls: connection.rollback();          │
│                                                        │
│  5. Returns connection back to HikariCP pool           │
└────────────────────────────────────────────────────────┘
```

#### The Real-World Analogy: Booking a Flight + Hotel
* **The Scenario:** You book a flight ticket (₹5,000) and a hotel room (₹10,000).
* **Without a Transaction:** The flight succeeds, but the hotel is sold out. Your money is deducted for the flight, but you have no place to stay. The system state is corrupted.
* **With a Transaction (Atomicity):** The booking agent cancels the flight and refunds your money. **Either BOTH succeed, or NEITHER happens.**
  * In NexPay: Flight = `userRepository.save(user)`, Hotel = `walletRepository.save(wallet)`.

#### What `connection.setAutoCommit(false)` Actually Does
By default, relational databases operate in **Auto-Commit Mode**: every SQL statement is committed to disk immediately upon execution.
* When Spring sets `setAutoCommit(false)`, it instructs PostgreSQL:
  > *"Hold on! Do not permanently write these rows to disk yet. Stage them in undo/WAL buffers. Wait until I explicitly send the `commit()` command."*
* If any error occurs prior to `commit()`, PostgreSQL executes `ROLLBACK`, purging all staged writes and preserving 100% database consistency.

#### What `@Transactional` Generates Behind the Scenes (In Pure Java/JDBC)
If Spring's `@Transactional` annotation did not exist, engineers would be forced to write this repetitive boilerplate manually on every service method:

```java
// What Spring's CGLIB Proxy generates in bytecode:
Connection connection = hikariDataSource.getConnection(); // 1. Borrow from pool

try {
    connection.setAutoCommit(false); // 2. Begin transaction!

    // --- YOUR DOMAIN CODE EXECUTES HERE ---
    User user = userRepository.save(newUser);
    Wallet wallet = walletRepository.save(newWallet);
    // -------------------------------------

    connection.commit(); // 3. Both succeeded! Atomically persist to disk!
} catch (RuntimeException ex) {
    connection.rollback(); // 4. Failure! Wipe out all partial inserts!
    throw ex;              // Re-throw so GlobalExceptionHandler can format RFC 7807 JSON
} finally {
    connection.setAutoCommit(true);
    connection.close();    // 5. Return connection back to HikariCP pool
}
```


---

## 5. Component 4: `WalletService.java`, DTOs & `WalletController.java` — Financial Endpoints & IDOR Defense

```
[ POSTMAN (Client with Bearer JWT) ]
                 │
                 │  GET /api/wallet/balance (No userId in URL!)
                 ▼
[ JwtFilter ] ──────────────────► Validates token & extracts email -> "rishi@gmail.com"
                 │                Binds to SecurityContextHolder.getContext().setAuthentication(auth)
                 ▼
[ WalletController ] ───────────► Reads principal: authentication.getName() (IDOR Immune!)
                 │
                 │  Calls: walletService.getBalance("rishi@gmail.com")
                 ▼
[ WalletService ] ──────────────► 1. userRepository.findByEmail("rishi@gmail.com")
                 │                2. walletRepository.findByUserId(user.getId())
                 ▼
[ Response ] ───────────────────► Returns HTTP 200 OK:
                                  {
                                    "balance": 1000.0000,
                                    "currency": "INR",
                                    "updatedAt": "2026-10-19T00:40:00"
                                  }
```

### 1. 🧠 The Core Concept, Mathematics & Low-Level Mechanics
* **IDOR (Insecure Direct Object Reference) Elimination:**
  * Client never passes `userId` in parameters (`?userId=123`).
  * Email is retrieved directly from the cryptographically verified JWT in `SecurityContextHolder` (`authentication.getName()`). A user can *only* query their own balance.
* **`BigDecimal` Immutability in JVM Heap:**
  * In Java, `BigDecimal` objects are immutable. Calling `wallet.getBalance().add(amount)` allocates a brand new `BigDecimal` on the heap without mutating the original reference. Reassignment (`wallet.setBalance(...)`) is mandatory.
* **JSR-380 `@DecimalMin` Boundary Validation:**
  * `@DecimalMin(value = "1.0000")` guarantees top-up amounts are positive numbers, shielding the financial engine from zero or negative balance exploits in $0.02\text{ms}$ at the controller boundary.

---

### 2. 🎯 Production Failure Mode It Solves
* **Negative Balance / Drain Exploit:** Without validation, malicious users could submit `{"amount": -500.00}` to convert a deposit endpoint into an illegal withdrawal.
* **Horizontal Privilege Escalation:** An authenticated user tampering with client state cannot inspect or manipulate other users' wallets because the identity is anchored to the server-verified JWT signature.

---

### 3. 🎤 Real Senior/Staff Interview Questions & Punchy Verbal Answers
* **Q1: Why should you never accept `userId` as a request parameter in balance or payment endpoints?**
  > *"Exposing `userId` in client request bodies or query parameters creates an **Insecure Direct Object Reference (IDOR)** vulnerability (OWASP Top 10). Attackers can iterate IDs to inspect or drain other users' funds. The user identity must always be resolved server-side from the verified authentication token."*
* **Q2: Why does calling `balance.add(amount)` without variable reassignment fail?**
  > *"`BigDecimal` is an immutable class designed for precision and thread-safety. Methods like `add()` return a new instance holding the calculated result. Without reassigning `wallet.setBalance(...)`, the calculation is discarded and the original balance remains unchanged."*

---

### 🔍 Production Source Code Breakdown

#### `WalletResponse.java` (DTO)
```java
package com.example.nexpay.wallet.dto;

import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WalletResponse {
    private BigDecimal balance;
    private String currency;
    private LocalDateTime updatedAt;
}
```

#### `TopUpRequest.java` (DTO)
```java
package com.example.nexpay.wallet.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class TopUpRequest {
    @NotNull(message = "Top-up amount is required")
    @DecimalMin(value = "1.0000", message = "Top-up amount must be at least ₹1.00")
    private BigDecimal amount;
}
```

#### `WalletService.java`
```java
package com.example.nexpay.wallet.service;

import com.example.nexpay.user.model.User;
import com.example.nexpay.user.repository.UserRepository;
import com.example.nexpay.wallet.dto.WalletResponse;
import com.example.nexpay.wallet.model.Wallet;
import com.example.nexpay.wallet.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class WalletService {

    private final WalletRepository walletRepository;
    private final UserRepository userRepository;

    public WalletResponse getBalance(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found!"));

        Wallet wallet = walletRepository.findByUserId(user.getId())
                .orElseThrow(() -> new RuntimeException("Wallet not found!"));

        return WalletResponse.builder()
                .balance(wallet.getBalance())
                .currency(wallet.getCurrency())
                .updatedAt(wallet.getUpdatedAt())
                .build();
    }

    @Transactional
    public WalletResponse topUp(String email, BigDecimal amount) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found!"));

        Wallet wallet = walletRepository.findByUserId(user.getId())
                .orElseThrow(() -> new RuntimeException("Wallet not found!"));

        wallet.setBalance(wallet.getBalance().add(amount));
        Wallet savedWallet = walletRepository.save(wallet);

        return WalletResponse.builder()
                .balance(savedWallet.getBalance())
                .currency(savedWallet.getCurrency())
                .updatedAt(savedWallet.getUpdatedAt())
                .build();
    }
}
```

#### `WalletController.java`
```java
package com.example.nexpay.wallet.controller;

import com.example.nexpay.wallet.dto.TopUpRequest;
import com.example.nexpay.wallet.dto.WalletResponse;
import com.example.nexpay.wallet.service.WalletService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wallet")
@RequiredArgsConstructor
public class WalletController {

    private final WalletService walletService;

    @GetMapping("/balance")
    public ResponseEntity<WalletResponse> getBalance(Authentication authentication) {
        String email = authentication.getName();
        return ResponseEntity.ok(walletService.getBalance(email));
    }

    @PostMapping("/top-up")
    public ResponseEntity<WalletResponse> topUp(
            Authentication authentication,
            @Valid @RequestBody TopUpRequest request
    ) {
        String email = authentication.getName();
        return ResponseEntity.ok(walletService.topUp(email, request.getAmount()));
    }
}
```


---

## 6. Architectural Deep Dive: Why Layered Architecture & Package-by-Feature?

```
┌────────────────────────────────────────────────────────────────────────────────────────────────────────┐
│                          THE 5-TIER LAYERED ENTERPRISE ARCHITECTURE                                    │
└────────────────────────────────────────────────────────────────────────────────────────────────────────┘
          [ Client / Postman (Customer) ]
                        │
                        │ 1. Transmits Order Slip (Inbound DTO)
                        ▼
          [ CONTROLLER (The Waiter / Cashier) ]
            • Intercepts HTTP request, validates Bearer JWT authentication.
            • Does NOT cook! Does NOT talk to the database!
            • Hands payload over to the Service layer.
                        │
                        ▼
          [ DTO - Data Transfer Object (The Paper Slip / Receipt) ]
            • Boundary contract: TopUpRequest & WalletResponse.
            • Customer never touches or sees the internal database columns!
                        │
                        ▼
          [ SERVICE (The Head Chef / The Business Brain) ]
            • Executes business invariants: "Does user exist? Is amount valid?"
            • Performs mathematical operations: balance.add(amount).
            • Orchestrates @Transactional ACID boundaries.
                        │
                        ▼
          [ REPOSITORY (The Storekeeper / Librarian) ]
            • The only component allowed to enter the database storehouse!
            • Translates domain intentions into optimized SQL queries.
                        │
                        ▼
          [ MODEL (The Pantry / Storage Vault) ]
            • Physical database table blueprint (@Entity @Table(name = "wallets")).
```

### 1. Why Not Put All Code in One File or One Folder? (Separation of Concerns)
In beginner scripts, developers frequently bundle HTTP endpoints, validation logic, business math, and raw SQL queries into a single monolithic class. 

In enterprise fintech handling billions of dollars, this produces catastrophic failure modes:
1. **Security Exfiltration (CWE-200):** If controllers talk directly to database entities, internal columns (`passwordHash`, `salt`, `internalRiskScore`) leak over HTTP JSON.
2. **Untestable Code:** You cannot unit-test business math (e.g., wallet top-up logic) without booting up a web server or database connection.
3. **High Coupling:** Altering an HTTP parameter breaks database schemas, and altering a database column breaks mobile apps.

### 2. Package-by-Layer vs. Package-by-Feature: Why Big Tech Groups by Domain
* **Package-by-Layer (Junior / Tutorial Style):**
  * One giant `controllers/` folder with 50 controllers.
  * One giant `services/` folder with 50 services.
  * One giant `models/` folder with 50 models.
  * *The Problem:* To understand how "Wallets" work, an engineer must jump across 5 completely separate folders across the project tree.
* **Package-by-Feature (Senior / Big Tech Style — Used in NexPay):**
  * `com.example.nexpay.user` $ightarrow$ Everything related to identity and login.
  * `com.example.nexpay.wallet` $ightarrow$ Everything related to money, balances, and top-ups.
  * *The Advantages:*
    1. **High Cohesion & Low Coupling:** The Wallet team works exclusively inside `wallet/` without risking merge conflicts or regressions in `user/`.
    2. **Zero-Friction Microservices Extraction:** When NexPay scales to 10 million users, the `wallet` package can be extracted into an independent Spring Boot microservice repo in minutes with zero refactoring.


---

## 7. PostgreSQL Engineering Deep Dive: What PostgreSQL Actually Does Under Hibernate's Hood

A common question junior and mid-level backend developers ask:
> *"Because Hibernate automatically generates queries and manages schemas, am I actually learning PostgreSQL, or am I just learning Java annotations?"*

In high-concurrency production engineering, **nobody writes raw SQL by hand in terminal**. The true mark of a Senior/Staff Engineer is understanding **how PostgreSQL physically executes and stores data on disk beneath ORM abstractions**.

```
┌────────────────────────────────────────────────────────────────────────────────────────────────────────┐
│                          JAVA ANNOTATION TO POSTGRESQL ENGINE BEHAVIOR                                 │
├───────────────────────────────────────┬────────────────────────────────────────────────────────────────┤
│ What You Wrote in Java                │ What PostgreSQL Did Physically in Memory & Disk Pages          │
├───────────────────────────────────────┼────────────────────────────────────────────────────────────────┤
│ @Table(name = "users")                │ Escaped PostgreSQL's reserved system catalog keyword "USER"    │
│                                       │ (avoiding internal database role syntax collisions).           │
├───────────────────────────────────────┼────────────────────────────────────────────────────────────────┤
│ @GeneratedValue(                      │ Bound to PostgreSQL's native BIGSERIAL sequence generator      │
│   strategy = GenerationType.IDENTITY) │ (users_id_seq) producing signed 64-bit integers (up to 2^63-1).│
├───────────────────────────────────────┼────────────────────────────────────────────────────────────────┤
│ @Column(unique = true)                │ Allocated a physical PostgreSQL B-Tree Unique Index file       │
│                                       │ on disk, guaranteeing O(log N) duplicate rejection.            │
├───────────────────────────────────────┼────────────────────────────────────────────────────────────────┤
│ BigDecimal (precision=19, scale=4)    │ Mapped to PostgreSQL's native NUMERIC(19, 4) type             │
│                                       │ for exact base-10 arbitrary-precision monetary disk storage.   │
├───────────────────────────────────────┼────────────────────────────────────────────────────────────────┤
│ @JoinColumn(name = "user_id")         │ Created a physical FOREIGN KEY constraint pointing to          │
│                                       │ users(id), enforcing referential integrity at the engine level.│
├───────────────────────────────────────┼────────────────────────────────────────────────────────────────┤
│ @Transactional                        │ Managed PostgreSQL's Write-Ahead Log (WAL) undo buffers        │
│                                       │ via connection.setAutoCommit(false) -> BEGIN / COMMIT.         │
└───────────────────────────────────────┴────────────────────────────────────────────────────────────────┘
```

### 1. The PostgreSQL CLI Inspection Toolkit (`psql`)
To verify what PostgreSQL physically built, developers inspect the database engine directly:

```powershell
# 1. Inspect physical tables in nexpaydb:
psql -U postgres -d nexpaydb -c "\dt"

# 2. Inspect physical column types, indexes, and foreign keys on wallets:
psql -U postgres -d nexpaydb -c "\d wallets"

# 3. Query physical disk rows directly:
psql -U postgres -d nexpaydb -c "SELECT * FROM wallets;"
```

### 2. What's Coming in Day 3: Native PostgreSQL Concurrency & Row-Level Locking
On Day 3, our PostgreSQL knowledge transitions into high-concurrency database internals:
* **`SELECT ... FOR UPDATE`:** Utilizing PostgreSQL's Lock Manager (`pg_locks`) to place exclusive row-level locks on disk tuples, preventing concurrent double-spending race conditions.
* **MVCC (Multi-Version Concurrency Control):** How PostgreSQL isolates concurrent read/write operations without table-level blocking using hidden system header columns (`xmin` and `xmax`).
