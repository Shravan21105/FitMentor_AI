# 🏋️‍♂️ FitMentor AI - Smart Fitness Tracking & Coaching Platform

[![Java Version](https://img.shields.io/badge/Java-21-orange.svg?style=for-the-badge&logo=openjdk)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen.svg?style=for-the-badge&logo=spring-boot)](https://spring.io/projects/spring-boot)
[![Security](https://img.shields.io/badge/Spring%20Security-6.x-green.svg?style=for-the-badge&logo=spring-security)](https://spring.io/projects/spring-security)
[![Database](https://img.shields.io/badge/MySQL-8.0-blue.svg?style=for-the-badge&logo=mysql)](https://www.mysql.com/)
[![Build Tool](https://img.shields.io/badge/Maven-3.x-red.svg?style=for-the-badge&logo=apache-maven)](https://maven.apache.org/)
[![Containerization](https://img.shields.io/badge/Docker-Enabled-blue.svg?style=for-the-badge&logo=docker)](https://www.docker.com/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg?style=for-the-badge)](https://opensource.org/licenses/MIT)

FitMentor AI is an advanced, enterprise-grade fitness tracking and coaching platform built using **Java 21**, **Spring Boot 3**, **MySQL**, and **JWT Authentication**. 

The goal of FitMentor AI is to provide users with a personalized fitness journey by tracking workouts, weight progress, fitness goals, streaks, diet recommendations, and health analytics. Built with clean architecture principles, it incorporates robust validation, global exception handling, interactive API documentation, and containerization.

---

## 📌 Table of Contents

- [✨ Features](#-features)
- [🛠️ Tech Stack](#️-tech-stack)
- [🏛️ Architecture Diagrams](#️-architecture-diagrams)
  - [System Architecture](#system-architecture)
  - [Authentication Flow](#authentication-flow)
  - [Request Execution Flow](#request-execution-flow)
- [📂 Project Folder Structure](#-project-folder-structure)
- [🌐 API Modules Table](#-api-modules-table)
- [🎯 Implemented vs Future Roadmap](#-implemented-vs-future-roadmap)
  - [Current Features](#current-features)
  - [Future Roadmap](#future-roadmap)
- [⚙️ Getting Started](#️-getting-started)
  - [Installation](#installation)
  - [Configuration](#configuration)
  - [Running the Project](#running-the-project)
- [🐳 Docker](#-docker)
- [📖 Swagger Documentation](#-swagger-documentation)
- [🔮 Project Vision](#-project-vision)
- [👨‍💻 Author](#-author)
- [📄 License](#-license)
- [🤝 Support](#-support)

---

## ✨ Features

### 🔐 Authentication & Security
- **Secure Registration & Login:** Password protection utilizing BCrypt password hashing.
- **JWT Authentication:** Stateless user sessions securing data transitions across endpoints.
- **Spring Security Integration:** Filters verify request tokens and secure specific REST boundaries.
- **Protected APIs:** Role and identity verified request interception.

### 👤 Profile & Assessment Management
- **Biological Profiling:** Setup user physical parameters (height, weight, age, gender).
- **Target Fitness Goals:** Tailored goals such as *Weight Loss*, *Muscle Gain*, *Maintenance*, and *Endurance*.
- **Activity Coefficient Evaluators:** Dynamic activity level indexes (Sedentary, Lightly Active, Active, Highly Active).
- **Workout Preference Configurations:** Tracking custom workout types.

### ⚖️ Weight Tracking
- **Bodyweight Logging:** Simple weight metric additions.
- **Weight History:** View historically recorded weight changes.
- **Latest Weight Extraction:** Instant query of most recent records.
- **Goal Target Monitoring:** Dynamic calculations of remaining weight targets.

### 🏋️ Workout Management
- **125+ Preloaded Exercises:** Inbuilt catalog mapping equipment, target muscles, and execution steps.
- **Workout Plan Constructor:** Build structured training routines.
- **Completion Tracker:** Track sets, reps, resistance weight, and duration metrics.
- **History Analytics:** Complete archive of past training volumes.

### 🔥 Streak System
- **Daily Continuity Engine:** Records consistent workout routines and logins.
- **Workout Milestones:** Track total workouts completed.
- **Motivation Prompts:** Helps keep users consistent.

### 📊 Dashboard & Progress Analytics
- **BMI Calculator:** Computes body mass indexes automatically from profile data.
- **Daily Calorie Threshold Estimates:** Evaluates daily active calorie demands.
- **Goal Completion Telemetry:** Calculates percent completion towards goals.
- **Metric Analytics:** Track progress patterns of weight and water intakes.

### 🥗 Diet Recommendation System
- **Diet Suggestion Engine:** Auto-recommends target calories and macronutrient splits (Proteins, Carbs, Fats).
- **Goal-Based Meal Planning:** Guides intake balances based on target outcomes.

### 💧 Hydration & Nutrition Tracker
- **Water Tracker:** Add water logs and track daily hydration goals.
- **Meal Logs:** Track daily food intake, meal times, and nutritional components.

### ✅ Validation & Error Handling
- **Constraint Validations:** Standard Jakarta request verification.
- **Global Exceptions Interceptor:** Uniform JSON formatted error responses.

---

## 🛠️ Tech Stack

| Domain | Technology | Description |
| :--- | :--- | :--- |
| **Backend Core** | Java 21 | Modern SDK support, virtual threads, record structures |
| **Framework** | Spring Boot 3 | API framework, auto-configurations |
| **Security** | Spring Security | Path authorization, CORS configuration |
| **Authentication** | JWT Authentication | Stateless access token generation and parsing |
| **ORM Database** | Hibernate / JPA | Object-Relational Mapping abstraction |
| **Database Engine** | MySQL 8.0 | Structured transactional storage |
| **API Docs** | Swagger / OpenAPI 3 | Interactive testing UI sandbox |
| **Utilities** | Lombok | Boilerplate elimination |
| **Validation** | Jakarta Validation | Request body constraint checks |
| **Build System** | Maven | Dependency management and packaging |
| **Deployment** | Docker | Containerization |

---

## 🏛️ Architecture Diagrams

### System Architecture
```text
                   Client
                      │
               HTTP / JSON (REST Requests)
                      │
                      ▼
         ┌──────────────────────────┐
         │  Spring Security Filter  │ <─── [ JWT Validation ]
         └────────────┬─────────────┘
                      │
                      ▼
         ┌──────────────────────────┐
         │ Spring Boot Controllers  │ <─── [ Jakarta Validation / DTOs ]
         └────────────┬─────────────┘
                      │
                      ▼
         ┌──────────────────────────┐
         │  Business Service Layer  │ <─── [ Calculators & Streaks ]
         └────────────┬─────────────┘
                      │
                      ▼
         ┌──────────────────────────┐
         │ Spring Data JPA Repos    │ <─── [ Database Abstraction ]
         └────────────┬─────────────┘
                      │
                      ▼
         ┌──────────────────────────┐
         │      MySQL Database      │ <─── [ Persistent Storage ]
         └──────────────────────────┘
```

### Authentication Flow
```text
┌──────────┐              ┌───────────────────────────┐             ┌──────────────────┐
│  Client  │              │  Spring Security Filters  │             │   Database /     │
│  (User)  │              │     & JWT Auth Filter     │             │ UserRepository   │
└────┬─────┘              └─────────────┬─────────────┘             └────────┬─────────┘
     │                                  │                                    │
     │ 1. POST /api/auth/login          │                                    │
     ├─────────────────────────────────>│                                    │
     │    (Username/Password)           │ 2. Load User Credentials           │
     │                                  ├───────────────────────────────────>│
     │                                  │                                    │
     │                                  │ 3. Database returns Hashed PW      │
     │                                  │<───────────────────────────────────┤
     │                                  │                                    │
     │                                  │ 4. Verify password & issue JWT     │
     │                                  ├──────────┐                         │
     │                                  │          │                         │
     │                                  │<─────────┘                         │
     │                                  │                                    │
     │ 5. Return JWT token in JSON      │                                    │
     │<─────────────────────────────────┤                                    │
     │                                  │                                    │
     │ 6. Request Protected API         │                                    │
     │    with "Bearer <JWT>" Header    │                                    │
     ├─────────────────────────────────>│                                    │
     │                                  │ 7. Parse & Validate Token Signature│
     │                                  ├──────────┐                         │
     │                                  │          │                         │
     │                                  │<─────────┘ (If Valid, set Context) │
     │                                  │                                    │
     │                                  │ 8. Forward request to Controller   │
     │                                  ├───────────────────────────────────>│ (Target Service)
     │                                  │                                    │
     │ 9. Return Requested Data (200 OK)│                                    │
     │<─────────────────────────────────┴────────────────────────────────────┤
     │                                  │                                    │
```

### Request Execution Flow
```text
┌────────┐       ┌─────────────────┐       ┌─────────────────┐       ┌─────────────────┐       ┌──────────┐
│ Client │ ───>  │ REST Controller │ ───>  │  Service Layer  │ ───>  │ JPA Repository  │ ───>  │ Database │
│        │ JSON  │ (Maps Request)  │ DTO   │ (Rules Engine & │ Entity│ (Query Builders │ SQL   │ (MySQL)  │
│        │ Request│ (Validates DTO) │       │ Model Mapping)  │       │ & Persistence)  │       │          │
│        │       │                 │       │                 │       │                 │       │          │
│        │ <───  │ (Returns DTO)   │ <───  │ (Maps to DTO)   │ <───  │ (Returns Entity)│ <───  │ (Data)   │
└────────┘ JSON  └─────────────────┘       └─────────────────┘       └─────────────────┘       └──────────┘
```

---

## 📂 Project Folder Structure

```text
FitMentor-AI-Backend/
├── .dockerignore
├── .gitignore
├── Dockerfile
├── pom.xml
├── README.md
└── src/
    └── main/
        ├── java/
        │   └── com/
        │       └── shravan/
        │           └── backend/
        │               ├── config/
        │               │   ├── SwaggerConfig.java
        │               │   └── WebConfig.java
        │               ├── controller/
        │               │   ├── AuthController.java
        │               │   ├── DashboardController.java
        │               │   ├── DietController.java
        │               │   ├── ExerciseController.java
        │               │   ├── MealLogController.java
        │               │   ├── ProfileController.java
        │               │   ├── ProgressController.java
        │               │   ├── StreakController.java
        │               │   ├── WaterLogController.java
        │               │   ├── WeightLogController.java
        │               │   └── WorkoutController.java
        │               ├── dto/
        │               │   ├── AuthRequest.java
        │               │   ├── AuthResponse.java
        │               │   ├── DashboardDTO.java
        │               │   ├── DietRecommendationDTO.java
        │               │   ├── ExerciseDTO.java
        │               │   ├── MealLogDTO.java
        │               │   ├── ProfileDTO.java
        │               │   ├── ProgressDTO.java
        │               │   ├── WaterLogDTO.java
        │               │   ├── WeightLogDTO.java
        │               │   └── WorkoutLogDTO.java
        │               ├── entity/
        │               │   ├── User.java
        │               │   ├── Profile.java
        │               │   ├── WeightLog.java
        │               │   ├── WaterLog.java
        │               │   ├── MealLog.java
        │               │   ├── Exercise.java
        │               │   ├── WorkoutPlan.java
        │               │   ├── WorkoutLog.java
        │               │   └── Streak.java
        │               ├── exception/
        │               │   ├── CustomException.java
        │               │   ├── ErrorResponse.java
        │               │   ├── GlobalExceptionHandler.java
        │               │   └── ResourceNotFoundException.java
        │               ├── repository/
        │               │   ├── UserRepository.java
        │               │   ├── ProfileRepository.java
        │               │   ├── WeightLogRepository.java
        │               │   ├── WaterLogRepository.java
        │               │   ├── MealLogRepository.java
        │               │   ├── ExerciseRepository.java
        │               │   ├── WorkoutRepository.java
        │               │   └── StreakRepository.java
        │               ├── security/
        │               │   ├── JwtAuthenticationFilter.java
        │               │   ├── JwtTokenProvider.java
        │               │   ├── SecurityConfig.java
        │               │   └── UserPrincipal.java
        │               ├── service/
        │               │   ├── AuthService.java
        │               │   ├── DashboardService.java
        │               │   ├── DietService.java
        │               │   ├── ExerciseService.java
        │               │   ├── ProfileService.java
        │               │   ├── ProgressService.java
        │               │   ├── StreakService.java
        │               │   ├── WaterLogService.java
        │               │   ├── WeightLogService.java
        │               │   ├── MealLogService.java
        │               │   └── WorkoutService.java
        │               └── util/
        │                   ├── BMIUtility.java
        │                   └── CalorieCalculator.java
        └── resources/
            ├── application.properties
            ├── data.sql
            └── schema.sql
```

---

## 🌐 API Modules Table

| Module | HTTP Method | Endpoint | Request Payload / Params | Protected (JWT) |
| :--- | :---: | :--- | :--- | :---: |
| **Authentication** | `POST` | `/api/auth/register` | `AuthRequest` (Registration) | ❌ |
| | `POST` | `/api/auth/login` | `AuthRequest` (Login) | ❌ |
| **Profile** | `POST` | `/api/profile` | `ProfileDTO` (Initial Setup) | ✔️ |
| | `GET` | `/api/profile` | None | ✔️ |
| | `PUT` | `/api/profile` | `ProfileDTO` (Updates) | ✔️ |
| **Dashboard** | `GET` | `/api/dashboard` | None | ✔️ |
| **Exercise** | `GET` | `/api/exercises` | Optional: `muscleGroup` | ✔️ |
| | `GET` | `/api/exercises/{id}` | Path variable: `id` | ✔️ |
| **Workout Recs** | `GET` | `/api/workouts/recommend` | None | ✔️ |
| **Workout Logs** | `POST` | `/api/workouts/log` | `WorkoutLogDTO` | ✔️ |
| | `GET` | `/api/workouts/history` | None | ✔️ |
| **Weight Logs** | `POST` | `/api/weights` | `WeightLogDTO` | ✔️ |
| | `GET` | `/api/weights` | None | ✔️ |
| | `GET` | `/api/weights/latest` | None | ✔️ |
| **Water Logs** | `POST` | `/api/water` | `WaterLogDTO` | ✔️ |
| | `GET` | `/api/water/daily` | None | ✔️ |
| **Meal Logs** | `POST` | `/api/meals` | `MealLogDTO` | ✔️ |
| | `GET` | `/api/meals/history` | None | ✔️ |
| **Diet Recs** | `GET` | `/api/diet` | None | ✔️ |
| **Progress** | `GET` | `/api/progress` | None | ✔️ |
| **Streak** | `GET` | `/api/streak` | None | ✔️ |

---

## 🎯 Implemented vs Future Roadmap

### Current Features
- [x] **Secure JWT Authorization:** Fully secured API access points.
- [x] **User Registration & Login:** Safe authentication process.
- [x] **Custom Biological Profiles:** Goal, activity level, and bio metrics tracking.
- [x] **Goal-Oriented Weight Logger:** Interactive weight changes history and tracker.
- [x] **Water Hydration Log:** Daily water volume logging.
- [x] **Meal Logging System:** Track daily caloric and macronutrient values.
- [x] **Calculators:** BMI computation, target daily energy expenditures (TDEE).
- [x] **Streaks engine:** Tracks consecutive workout completions.
- [x] **Preloaded Exercises:** 125+ database populated exercises.
- [x] **Exceptions Interception:** Custom global exception handler filters.
- [x] **Validations framework:** Standard DTO checking.

### Future Roadmap
```text
  ┌────────────────────────────────────────────────────────┐
  │ Phase 1: Engine Extensions                             │
  │  - Exercise Recommendation system optimization         │
  │  - Smart Fitness Goals and alerts                      │
  └───────────────────────────┬────────────────────────────┘
                              │
                              ▼
  ┌────────────────────────────────────────────────────────┐
  │ Phase 2: Artificial Intelligence Core                  │
  │  - LLM-Powered AI Workout Generator                    │
  │  - Dynamic AI Diet Planner & Macro Tracker             │
  │  - AI Progress Diagnostics & Analytics                 │
  └───────────────────────────┬────────────────────────────┘
                              │
                              ▼
  ┌────────────────────────────────────────────────────────┐
  │ Phase 3: Mobile Experience                             │
  │  - React Native Android & iOS Application              │
  │  - Push notifications & calendar synchronization      │
  │  - Production Deployment (Cloud Engine)                │
  └───────────────────────────┬────────────────────────────┘
                              │
                              ▼
  ┌────────────────────────────────────────────────────────┐
  │ Phase 4: Professional Features                         │
  │  - Unified Coach/Trainer Dashboard                    │
  │  - Social Community & Activity feeds                   │
  └────────────────────────────────────────────────────────┘
```

---

## ⚙️ Getting Started

### Installation
1. Clone the codebase locally:
   ```bash
   git clone https://github.com/Shravan21105/FitMentor_AI.git
   cd FitMentor_AI
   ```

2. Create the target schema in your MySQL environment:
   ```sql
   CREATE DATABASE fitmentor_ai;
   ```

### Configuration
Configure your application parameters in `src/main/resources/application.properties`:
```properties
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/fitmentor_ai?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=your_password

# JPA Settings
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=false
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# JWT Configurations
app.jwt.secret=9a67a86987635cda98e67a98e8790b8f72365c19736cda87bce97fae879a86b9
app.jwt.expiration-ms=86400000
```

### Running the Project
Compile and launch the application using the Maven wrapper:
```bash
./mvnw clean spring-boot:run
```
The application bootstrapper runs on port **8085**:
```text
http://localhost:8085
```

---

## 🐳 Docker

FitMentor AI comes containerized. To build and run the application using Docker:

### 1. Build the Docker Image
```bash
docker build -t fitmentor-ai:latest .
```

### 2. Run the Container
```bash
docker run -d -p 8085:8085 --name fitmentor-api \
  -e SPRING_DATASOURCE_URL=jdbc:mysql://host.docker.internal:3306/fitmentor_ai \
  -e SPRING_DATASOURCE_USERNAME=root \
  -e SPRING_DATASOURCE_PASSWORD=your_password \
  fitmentor-ai:latest
```

---

## 📖 Swagger Documentation

Interactive OpenAPI/Swagger user interfaces are available to easily test endpoint responses:

- **Swagger UI Interface:** [http://localhost:8085/swagger-ui/index.html](http://localhost:8085/swagger-ui/index.html)
- **JSON API Specs:** [http://localhost:8085/v3/api-docs](http://localhost:8085/v3/api-docs)

---

## 🔮 Project Vision

FitMentor AI aims to become a complete AI-powered fitness ecosystem that helps users:
* **Lose Weight** and optimize body compositions.
* **Gain Muscle** efficiently via calculated training volumes.
* **Track Progress** on multi-dimensional trackers (Weight, Nutrition, Water).
* **Build Healthy Habits** through systematic streak reminders.
* **Stay Consistent** and motivated with analytical health indices.

---

## 👨‍💻 Author

**Shravan**
* Computer Science Engineering Student
* Java Backend Developer
* [GitHub Profile](https://github.com/Shravan21105)

---

## 📄 License

This project is licensed under the **MIT License**. Check out the LICENSE file for parameters.

---

## 🤝 Support

If you found this project helpful, please consider giving it a **Star ⭐** on GitHub!
For issue reporting and troubleshooting, feel free to open a ticket in the repository.
