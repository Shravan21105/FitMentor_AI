# FitMentor AI 🏋️‍♂️

FitMentor AI is a fitness tracking and coaching platform built using **Spring Boot**, **Java 21**, **MySQL**, and **JWT Authentication**.

The goal of FitMentor AI is to provide users with a personalized fitness journey by tracking workouts, weight progress, fitness goals, streaks, diet recommendations, and health analytics.

---

## 🚀 Features

### 🔐 Authentication & Security
- User Registration
- User Login
- JWT Authentication
- Spring Security Integration
- Protected APIs

### 👤 Profile Management
- Create Profile
- Update Profile
- View Profile
- Fitness Goal Selection
- Activity Level Tracking
- Workout Type Selection

### ⚖️ Weight Tracking
- Add Weight Logs
- View Weight History
- Latest Weight Tracking
- Progress Monitoring

### 🏋️ Workout Management
- Workout Plans
- Workout Exercises
- Workout Completion Tracking
- Workout History

### 🔥 Streak System
- Daily Workout Streak Tracking
- Total Workouts Completed
- Consistency Monitoring

### 📊 Dashboard & Progress Analytics
- BMI Calculation
- Daily Calorie Estimation
- Goal Completion Percentage
- Weight Lost
- Remaining Weight
- Current Streak
- Workout Statistics

### 🥗 Diet Recommendation System
- Personalized Diet Suggestions
- Goal-Based Diet Planning
- Activity-Based Recommendations

### ✅ Validation & Error Handling
- Request Validation
- Global Exception Handling
- Clean API Error Responses

---

## 🛠️ Tech Stack

### Backend
- Java 21
- Spring Boot 3
- Spring Security
- Spring Data JPA
- Hibernate
- JWT Authentication
- Maven

### Database
- MySQL

### Utilities
- Lombok
- Jakarta Validation

---

## 📂 Project Structure

```text
src/main/java/com/shravan/backend

├── controller
├── service
├── repository
├── entity
├── dto
├── security
├── config
├── exception
└── util
```

---

## 🌐 API Modules

### Authentication
```http
POST /api/auth/register
POST /api/auth/login
```

### Profile
```http
POST /api/profile
GET  /api/profile
PUT  /api/profile
```

### Weight Logs
```http
POST /api/weights
GET  /api/weights
GET  /api/weights/latest
```

### Dashboard
```http
GET /api/dashboard
```

### Progress
```http
GET /api/progress
```

### Diet Recommendations
```http
GET /api/diet
```

### Streak Tracking
```http
GET /api/streak
```

---

## 🎯 Current Implemented Modules

- ✅ Authentication & Authorization
- ✅ JWT Security
- ✅ Profile Management
- ✅ Weight Logging
- ✅ Workout Plans
- ✅ Workout Logs
- ✅ Streak Tracking
- ✅ Progress Analytics
- ✅ Dashboard Metrics
- ✅ Diet Recommendations
- ✅ Request Validation
- ✅ Global Exception Handling

---

## 🚧 Future Roadmap

### Phase 1
- Workout Recommendation Engine
- Daily Fitness Goals
- Smart Progress Insights
- Exercise Recommendation System

### Phase 2
- AI Fitness Coach
- AI Diet Planner
- AI Workout Generator
- AI Progress Analysis

### Phase 3
- React Native Mobile Application
- Push Notifications
- Subscription System
- Play Store Release

### Phase 4
- Trainer Dashboard
- Community Challenges
- Social Features
- Advanced Analytics

---

## 🎯 Vision

FitMentor AI aims to become a complete AI-powered fitness ecosystem that helps users:

- Lose Weight
- Gain Muscle
- Track Progress
- Build Healthy Habits
- Stay Consistent
- Achieve Long-Term Fitness Goals

---

## ⚙️ Getting Started

### Clone Repository

```bash
git clone https://github.com/YOUR_USERNAME/FitMentor_AI.git
cd FitMentor_AI
```

### Configure Database

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/fitmentor_ai
spring.datasource.username=root
spring.datasource.password=your_password
```

### Run Application

```bash
mvn spring-boot:run
```

Application will start at:

```text
http://localhost:8085
```

---

## 👨‍💻 Author

**Shravan**

Computer Science Engineering Student  
Java Backend Developer

---

⭐ If you found this project useful, consider giving it a star.
