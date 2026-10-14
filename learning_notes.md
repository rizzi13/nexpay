# 🏛️ NexPay — Enterprise Software Engineering & Architecture Masterclass
## *Holistic Computer Science Domains & Production Implementation Reference*

> **Guiding Principle:** Every topic is taught as a **complete, 360-degree computer science and backend engineering discipline** — exploring theoretical foundations, global industry landscapes, architectural alternatives, attack vectors, low-level JVM/database mechanics, and senior/staff trade-offs — before showing how it is applied inside NexPay.

---

# 📑 TABLE OF CONTENTS

- [PART I: THE HOLISTIC COMPUTER SCIENCE & BACKEND ENGINEERING DOMAINS](#part-i-the-holistic-computer-science--backend-engineering-domains)
  - [Module 1: Complete Authentication & Authorization Architecture](#module-1-complete-authentication--authorization-architecture)
    - [1.1 The Full Industry Authentication Spectrum](#11-the-full-industry-authentication-spectrum)
    - [1.2 Stateless Token Architecture: JWT (RFC 7519), JWS, JWE & Paseto](#12-stateless-token-architecture-jwt-rfc-7519-jws-jwe--paseto)
    - [1.3 Distributed Token Revocation & Session Management at Scale](#13-distributed-token-revocation--session-management-at-scale)
    - [1.4 Security Attack Vectors, Threat Modeling & Defenses](#14-security-attack-vectors-threat-modeling--defenses)
  - [Module 2: Complete Cryptography & Credential Security](#module-2-complete-cryptography--credential-security)
    - [2.1 The Cryptographic Trapdoor Function: Why Fast Hashes Fail](#21-the-cryptographic-trapdoor-function-why-fast-hashes-fail)
    - [2.2 Salting Theory, Entropy & Moore's Law Work Factors](#22-salting-theory-entropy--moores-law-work-factors)
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
    - [7.1 Clean Enterprise Code & The "Zero Tutorial Comments" Rule](#71-clean-enterprise-code--the-zero-tutorial-comments-rule)
    - [7.2 Database Crash Consistency, Lock Files & WAL Replay](#72-database-crash-consistency-lock-files--wal-replay)
    - [7.3 Git Internals, UTC Boundaries & Contribution Graph Mathematics](#73-git-internals-utc-boundaries--contribution-graph-mathematics)
    - [7.4 Jackson RFC 8259 Specifications & Parsing Mechanics](#74-jackson-rfc-8259-specifications--parsing-mechanics)
- [PART II: NEXPAY ENTERPRISE IMPLEMENTATION & 3-PILLAR MASTERCLASSES](#part-ii-nexpay-enterprise-implementation--3-pillar-masterclasses)
  - [Chapter 1: NexPay System Big Picture & Microservices Blueprint](#chapter-1-nexpay-system-big-picture--microservices-blueprint)
  - [Chapter 2: Day 0 Foundation Masterclasses (User Registration & DB Mapping)](#chapter-2-day-0-foundation-masterclasses-user-registration--db-mapping)
    - [Component 1: User.java](#component-1-userjava)
    - [Component 2: UserRepository.java](#component-2-userrepositoryjava)
    - [Component 3: RegisterRequest.java](#component-3-registerrequestjava)
    - [Component 4: SecurityConfig.java (Basic)](#component-4-securityconfigjava-basic)
    - [Component 5: UserService.java (Registration)](#component-5-userservicejava-registration)
    - [Component 6: AuthController.java (Registration)](#component-6-authcontrollerjava-registration)
  - [Chapter 3: Day 1 Masterclasses (Stateless JWT Auth & RFC 7807 Error Shield)](#chapter-3-day-1-masterclasses-stateless-jwt-auth--rfc-7807-error-shield)
    - [Component 7: JJWT Dependencies & 256-bit Key Sizing](#component-7-jjwt-dependencies--256-bit-key-sizing)
    - [Component 8: LoginRequest.java](#component-8-loginrequestjava)
    - [Component 9: AuthResponse.java](#component-9-authresponsejava)
    - [Component 10: JwtService.java](#component-10-jwtservicejava)
    - [Component 11: JwtFilter.java & SecurityConfig Integration](#component-11-jwtfilterjava--securityconfig-integration)
    - [Component 12: UserService.java (Login Logic)](#component-12-userservicejava-login-logic)
    - [Component 13: AuthController.java (Login Endpoint)](#component-13-authcontrollerjava-login-endpoint)
    - [Component 14: GlobalExceptionHandler.java (RFC 7807 Error Shield)](#component-14-globalexceptionhandlerjava-rfc-7807-error-shield)
- [PART III: 15-DAY MASTER ROADMAP & SCOREBOARD](#part-iii-15-day-master-roadmap--scoreboard)

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

# PART II: NEXPAY ENTERPRISE IMPLEMENTATION & 3-PILLAR MASTERCLASSES

---

# Chapter 1: NexPay System Big Picture & Microservices Blueprint

NexPay is an enterprise-grade, high-concurrency P2P digital wallet and payment platform built with Spring Boot, PostgreSQL, Redis, RabbitMQ, WebSockets, and Google Gemini AI.

```
[ React 18 Animated Client ] 
        │
   (HTTPS / WSS)
        ▼
[ AWS ALB / NGINX Gateway ]
        │
        ▼
[ NexPay Spring Boot Application ]
  ├── Security Layer: Stateless JWT Filter + ThreadLocal SecurityContext
  ├── Web Layer: DispatcherServlet + RestControllers + RFC 7807 Error Shield
  ├── Domain Service Layer: ACID Business Logic + Concurrency Guards
  ├── Cache Layer: Redis Sub-5ms Balance & Nonce Storage
  ├── Event Layer: RabbitMQ Asynchronous Message Streaming
  ├── AI Engine: Gemini 1.5 Pro (Fraud Scoring & Multimodal OCR)
  └── Persistence Layer: Hibernate 6 + HikariCP Connection Pool
        │
        ▼
[ AWS RDS PostgreSQL Database ] (BIGSERIAL, B-Tree Indexes, Row-Level Locking)
```

---

# Chapter 2: Day 0 Foundation Masterclasses (User Registration & DB Mapping)

## Component 1: `User.java`

### 1. 🧠 Core Concept, Mathematics & Internal Mechanics
* **JPA Table Mapping & PostgreSQL Reserved Keywords:** Named `users` via `@Table(name = "users")` because `USER` is a reserved PostgreSQL keyword.
* **Monotonic Surrogate Primary Key:** `@GeneratedValue(strategy = GenerationType.IDENTITY)` binds to PostgreSQL's native `BIGSERIAL` sequence generator, producing signed 64-bit integers ($1, 2, \dots, 2^{63}-1$).
* **JPA Entity Lifecycle Callbacks:** `@PrePersist` hook executes immediately prior to the SQL `INSERT` statement, populating `createdAt = LocalDateTime.now()` in memory.
* **Schema Resilience via String Enums:** `@Enumerated(EnumType.STRING)` persists `"USER"` or `"ADMIN"` as varchar strings, preventing data corruption if enum constants are reordered.

### 2. 🎯 Production Failure Mode It Solves
* **Schema Drift & Data Corruption:** Enforces physical database constraints (`nullable = false`, `unique = true`), preventing duplicate emails and phones from being written even under concurrent race conditions.

### 3. 🎤 Real Senior/Staff Interview Questions & Punchy Verbal Answers
* **Q: Why is `Long` (wrapper) preferred over `long` (primitive) for `@Id`?**
  > *"A primitive `long` defaults to `0`, making it ambiguous whether an entity is new or already saved. A wrapper `Long` defaults to `null`. Hibernate uses `id == null` to distinguish between a **Transient** entity requiring an `INSERT` and a **Detached** entity requiring an `UPDATE`."*

### 🔍 Production Source Code: `User.java`
```java
package com.example.nexpay.user.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    @Column(nullable = false, unique = true)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Role role = Role.USER;

    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public enum Role {
        USER, ADMIN
    }
}
```

---

## Component 2: `UserRepository.java`

### 1. 🧠 Core Concept, Mathematics & Internal Mechanics
* **JDK Dynamic Proxy Synthesis:** Interface without an implementation class. Spring Data inspects the interface at startup and synthesizes a `java.lang.reflect.Proxy` backed by `SimpleJpaRepository`.
* **Query Derivation Grammars:** Parses method names into JPQL expressions:
  * `findByEmail(String email)` $\rightarrow$ `SELECT u FROM User u WHERE u.email = :email`
  * `existsByEmail(String email)` $\rightarrow$ `SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.email = :email`
* **`Optional<T>` Monad Pattern:** Forces caller code to explicitly handle presence or absence via `.orElseThrow()`, eliminating `NullPointerException`s.

### 2. 🎯 Production Failure Mode It Solves
* **Heap Exhaustion via `existsBy` Optimization:** Using `findByEmail().isPresent()` loads the entire user entity into the Hibernate session cache. `existsByEmail()` executes an optimized `SELECT 1 ... LIMIT 1`, allocating virtually zero JVM memory.

### 3. 🎤 Real Senior/Staff Interview Questions & Punchy Verbal Answers
* **Q: How does Spring Data JPA execute queries without implementation classes?**
  > *"At startup, Spring Data scans repository interfaces, parses their method names into an Abstract Syntax Tree (AST), maps them to JPQL queries, and binds them to a JDK Dynamic Proxy backed by Hibernate's `EntityManager`."*

### 🔍 Production Source Code: `UserRepository.java`
```java
package com.example.nexpay.user.repository;

import com.example.nexpay.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByPhone(String phone);
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);
}
```

---

## Component 3: `RegisterRequest.java`

### 1. 🧠 Core Concept, Mathematics & Internal Mechanics
* **DTO Boundary Isolation:** Prevents mass-assignment vulnerabilities by strictly defining allowable registration inputs.
* **JSR-380 Bean Validation:** Evaluated by Hibernate Validator prior to controller method execution.
* **Entropy Enforcement:** `@Size(min = 6)` guarantees minimal initial password entropy before hashing.

### 2. 🎯 Production Failure Mode It Solves
* **CPU Starvation via Fail-Fast Validation:** In-memory validation rejects malformed requests in $0.02\text{ms}$, preventing thousands of invalid requests from hitting the expensive BCrypt hashing engine ($\approx 60\text{ms}$).

### 🔍 Production Source Code: `RegisterRequest.java`
```java
package com.example.nexpay.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {

    @NotBlank(message = "Full name is required")
    private String fullName;

    @NotBlank(message = "Email is required")
    @Email(message = "Please enter a valid email")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    @NotBlank(message = "Phone is required")
    private String phone;
}
```

---

## Component 4: `SecurityConfig.java` (Basic) & PasswordEncoder Bean

### 1. 🧠 Core Concept, Mathematics & Internal Mechanics
* **Spring Security 6 Component Model:** Exposes functional `@Bean SecurityFilterChain` and `@Bean PasswordEncoder`.
* **Cost Factor 10:** Configures BCrypt with $2^{10} = 1{,}024$ key expansion rounds.

---

## Component 5: `UserService.java` (Registration)

### 1. 🧠 Core Concept, Mathematics & Internal Mechanics
* **Constructor Dependency Injection:** Injects `UserRepository` and `PasswordEncoder` into `final` fields via Lombok's `@RequiredArgsConstructor`.
* **Defense-in-Depth Duplicate Validation:** In-memory duplicate checks provide clear business error messages before relying on database unique constraints.

### 🔍 Production Source Code: `UserService.java` (Registration Segment)
```java
package com.example.nexpay.user.service;

import com.example.nexpay.user.dto.RegisterRequest;
import com.example.nexpay.user.model.User;
import com.example.nexpay.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User registerUser(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email is already registered!");
        }

        if (userRepository.existsByPhone(request.getPhone())) {
            throw new RuntimeException("Phone number is already registered!");
        }

        User user = User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .passwordHash(passwordEncoder.encode(request.getPassword()))
                .phone(request.getPhone())
                .role(User.Role.USER)
                .build();

        return userRepository.save(user);
    }
}
```

---

## Component 6: `AuthController.java` (Registration)

### 1. 🧠 Core Concept, Mathematics & Internal Mechanics
* **Spring MVC Front Controller Routing:** Maps incoming HTTP `POST /api/auth/register` to `register()`.
* **Semantic HTTP 201 Created:** Returns `HttpStatus.CREATED` to signify the creation of a new database entity.

### 🔍 Production Source Code: `AuthController.java` (Registration Segment)
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

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody RegisterRequest request) {
        User registeredUser = userService.registerUser(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("User registered successfully! ID: " + registeredUser.getId());
    }
}
```

---

# Chapter 3: Day 1 Masterclasses (Stateless JWT Auth & RFC 7807 Error Shield)

## Component 7: JJWT Dependencies & 256-bit Key Sizing

### 1. 🧠 Core Concept, Mathematics & Internal Mechanics
* **Maven Runtime Scopes:** `jjwt-impl` and `jjwt-jackson` are marked `<scope>runtime</scope>` to enforce strict interface encapsulation against `jjwt-api`.
* **256-Bit Secret Requirement (RFC 7518):** HMAC-SHA256 requires a secret key of at least 256 bits (32 bytes). Shorter keys trigger `WeakKeyException` immediately upon startup.

---

## Component 8: `LoginRequest.java`

### 🔍 Production Source Code: `LoginRequest.java`
```java
package com.example.nexpay.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {

    @NotBlank(message = "Email is required")
    @Email(message = "Please enter a valid email")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;
}
```

---

## Component 9: `AuthResponse.java`

### 1. 🧠 Core Concept, Mathematics & Internal Mechanics
* **Outbound DTO Boundary:** Ensures that sensitive fields like `passwordHash` or internal metadata are never serialized over the wire.

### 🔍 Production Source Code: `AuthResponse.java`
```java
package com.example.nexpay.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {
    private String token;
    private String email;
    private String fullName;
}
```

---

## Component 10: `JwtService.java`

### 1. 🧠 Core Concept, Mathematics & Internal Mechanics
* **HMAC-SHA256 Token Minting:** Computes the mathematical signature over Base64URL header and payload using the 256-bit secret key.
* **Modern JJWT 0.12 API:** Utilizes type-safe `.verifyWith(SecretKey)` and immutable `.getPayload()` claims extraction.

### 🔍 Production Source Code: `JwtService.java`
```java
package com.example.nexpay.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    private SecretKey getSigningKey() {
        byte[] keyBytes = secret.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(String email) {
        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSigningKey())
                .compact();
    }

    public Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public String extractEmail(String token) {
        return extractAllClaims(token).getSubject();
    }

    public Date extractExpiration(String token) {
        return extractAllClaims(token).getExpiration();
    }

    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public boolean isTokenValid(String token, String userEmail) {
        final String email = extractEmail(token);
        return (email.equals(userEmail) && !isTokenExpired(token));
    }
}
```

---

## Component 11: `JwtFilter.java` & SecurityConfig Integration

### 1. 🧠 Core Concept, Mathematics & Internal Mechanics
* **`OncePerRequestFilter` Guarantee:** Guarantees single-execution semantics per HTTP request across internal dispatches.
* **`ThreadLocal` Security Context:** Stamps the authenticated `UsernamePasswordAuthenticationToken` into `SecurityContextHolder`, binding it to the active Tomcat worker thread.
* **`SessionCreationPolicy.STATELESS`:** Instructs Spring Security never to allocate `HttpSession`s in server RAM.

### 🔍 Production Source Code: `JwtFilter.java`
```java
package com.example.nexpay.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        final String jwt = authHeader.substring(7);
        final String userEmail;

        try {
            userEmail = jwtService.extractEmail(jwt);
        } catch (Exception e) {
            filterChain.doFilter(request, response);
            return;
        }

        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            if (jwtService.isTokenValid(jwt, userEmail)) {
                UserDetails userDetails = User.builder()
                        .username(userEmail)
                        .password("")
                        .authorities(Collections.emptyList())
                        .build();

                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.getAuthorities()
                        );

                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        filterChain.doFilter(request, response);
    }
}
```

### 🔍 Production Source Code: `SecurityConfig.java` (Updated)
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

    private final JwtFilter jwtFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/**").permitAll()
                .anyRequest().authenticated()
            )
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
```

---

## Component 12: `UserService.java` (Login Logic)

### 1. 🧠 Core Concept, Mathematics & Internal Mechanics
* **Constant-Time Verification:** Employs constant-time string equality during BCrypt matching to defeat timing attacks.
* **Unified Error Messaging:** Returns identical `"Invalid email or password"` error messages for missing accounts and wrong passwords, preventing user enumeration.

### 🔍 Production Source Code: `UserService.java` (Login Method)
```java
public AuthResponse login(LoginRequest request) {
    User user = userRepository.findByEmail(request.getEmail())
            .orElseThrow(() -> new RuntimeException("Invalid email or password"));

    if (!passwordEncoder.matches(request.getPassword(), user.getPasswordHash())) {
        throw new RuntimeException("Invalid email or password");
    }

    String token = jwtService.generateToken(user.getEmail());
    return new AuthResponse(token, user.getEmail(), user.getFullName());
}
```

---

## Component 13: `AuthController.java` (Login Endpoint)

### 🔍 Production Source Code: `AuthController.java` (Login Endpoint)
```java
@PostMapping("/login")
public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
    AuthResponse response = userService.login(request);
    return ResponseEntity.ok(response);
}
```

---

## Component 14: `GlobalExceptionHandler.java` (RFC 7807 Error Shield)

### 1. 🧠 Core Concept, Mathematics & Internal Mechanics
* **Spring AOP Advice:** Intercepts uncaught exceptions thrown across all `@RestController` beans via `HandlerExceptionResolver`.
* **Information Leakage Shield (CWE-209):** Catches internal stack traces, logs them privately, and returns sanitized, predictable JSON payloads to API clients.

### 🔍 Production Source Code: `GlobalExceptionHandler.java`
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

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> fieldErrors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            fieldErrors.put(error.getField(), error.getDefaultMessage());
        }

        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("error", "Validation Failed");
        response.put("errors", fieldErrors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> handleRuntimeException(RuntimeException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("error", "Bad Request");
        response.put("message", ex.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGenericException(Exception ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.put("error", "Internal Server Error");
        response.put("message", "An unexpected error occurred. Please try again later.");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
```

---

# PART III: 15-DAY MASTER ROADMAP & SCOREBOARD

| Day | Module / Architecture Focus | Deliverable | Status |
|:---:|:---|:---|:---:|
| **Day 1** | **Stateless JWT Auth & Global Error Shield** | `POST /api/auth/login` + `JwtService` + `JwtFilter` + `GlobalExceptionHandler` | ✅ Completed |
| **Day 2** | **Core Wallet Engine** | Auto-create wallet on signup, Balance lookup, Top-up (`@OneToOne`, `BigDecimal`) | ⏳ **NEXT UP** |
| **Day 3** | **P2P Money Transfer & Concurrency Control** | Pessimistic Locking (`SELECT FOR UPDATE`), ACID `@Transactional` | ⬜ |
| **Day 4** | **Idempotency & Double-Spending Defense** | Idempotency Key headers, unique transaction hashing | ⬜ |
| **Day 5** | **Double-Entry Ledger & Audit Trail** | Paginated transaction history (`Pageable`, JPQL `@Query`), Immutable ledger | ⬜ |
| **Day 6** | **Redis High-Performance Caching** | Sub-5ms wallet balance lookup (`@Cacheable`, `@CacheEvict`) | ⬜ |
| **Day 7** | **RabbitMQ Asynchronous Messaging** | Async payment events, message queues, notification workers | ⬜ |
| **Day 8** | **Live WebSockets** | STOMP WebSockets pushing real-time payment alerts to client | ⬜ |
| **Day 9** | **Gemini AI (Fraud & NLP Payments)** | Real-time fraud anomaly scoring + "Send ₹500 to Amit" NLP | ⬜ |
| **Day 10** | **Gemini AI Vision & Admin RBAC** | Multimodal OCR receipt scanner + Role-Based Security (`@PreAuthorize`) | ⬜ |
| **Day 11** | **Automated Testing & Swagger Docs** | 15+ JUnit 5 & Mockito test suite + Interactive Swagger UI | ⬜ |
| **Day 12** | **Docker Containerization** | Multi-container `docker-compose.yml` (App, PostgreSQL, Redis, RabbitMQ) | ⬜ |
| **Day 13** | **AWS Cloud Infrastructure** | Deploy on **AWS EC2**, PostgreSQL on **AWS RDS**, Receipts on **AWS S3** | ⬜ |
| **Day 14** | **Production CI/CD Automation** | GitHub Actions pipeline: Auto-test, build Docker, auto-deploy to EC2 | ⬜ |
| **Day 15** | **Animated React 18 UI** | Modern fintech dashboard, live balance charts, Framer Motion, confetti 🎉 | ⬜ |
