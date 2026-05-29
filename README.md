# 🏥 Digital Prescription Platform

A full-stack healthcare management system built using **Spring Boot**, **Spring Security**, **Thymeleaf**, **Hibernate/JPA**, and **PostgreSQL**.

🌐 Live Demo: https://digital-prescription-platform.onrender.com/

📂 GitHub Repository: https://github.com/GiriGourav/digital-prescription-platform

---

## 🚀 Features Implemented

### 👤 Authentication & Authorization
- User Registration & Login
- Role-Based Access Control
- Admin, Doctor, and Patient Roles
- Secure Password Encryption using BCrypt

### 👨‍⚕️ Doctor Features
- Create Digital Prescriptions
- Edit Prescriptions
- Delete Prescriptions
- View Appointment Requests
- Approve/Reject Appointments
- Search Prescriptions by Patient Name
- Download Prescriptions as PDF

### 🧑 Patient Features
- Register & Login
- Book Appointments
- Select Available Doctors
- View Appointment History
- View Prescription History
- Download Prescription PDFs

### 🛡️ Admin Features
- Admin Dashboard
- View All Registered Doctors
- Approve Doctor Accounts
- Remove Doctors
- Manage Platform Users

### 📄 Prescription Management
- Digital Prescription Creation
- Medical History Tracking
- PDF Export Functionality

### 📅 Appointment Management
- Appointment Booking
- Doctor Selection
- Appointment Status Tracking
- Pending / Approved / Rejected Workflow

---

# 🏗️ Tech Stack Used

## Backend
- Java 21
- Spring Boot 3
- Spring Security
- Spring Data JPA
- Hibernate

## Frontend
- Thymeleaf
- HTML5
- CSS3
- Bootstrap 5
- Bootstrap Icons

## Database
- PostgreSQL

## Deployment
- Render
- Render PostgreSQL

## Tools
- Maven
- Git
- GitHub
- IntelliJ IDEA

---

# 📂 Project Structure

```text
src/main/java
├── config
├── controller
├── entity
├── repository
├── service

src/main/resources
├── templates
├── static
│   ├── css
│   ├── js
│   └── images
└── application.properties
```

---

# ⚙️ Project Setup Instructions

## 1. Clone Repository

```bash
git clone https://github.com/GiriGourav/digital-prescription-platform.git
cd digital-prescription-platform
```

---

## 2. Configure Database

Create a PostgreSQL database and update:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/prescription_db
spring.datasource.username=postgres
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 3. Build Project

```bash
./mvnw clean install
```

---

## 4. Run Application

```bash
./mvnw spring-boot:run
```

Application will start at:

```text
http://localhost:8080
```

---

# ☁️ Deployment

This project is deployed on Render.

### Build Command

```bash
chmod +x mvnw && ./mvnw clean package -DskipTests
```

### Start Command

```bash
java -jar target/digital-prescription-platform-0.0.1-SNAPSHOT.jar
```

---

# 📊 Database Entities

## User
- id
- name
- email
- password
- role
- approved

## Prescription
- id
- doctorName
- patientName
- patientEmail
- diagnosis
- medicines
- notes
- date

## Appointment
- id
- patientName
- patientEmail
- doctorName
- appointmentDate
- status

---

# 🔒 Security Features

- Spring Security Authentication
- BCrypt Password Hashing
- Role-Based Authorization
- Doctor Approval Workflow
- Protected Routes

---

# 🎯 Future Enhancements

- Email Notifications
- Appointment Reminders
- REST API Support
- JWT Authentication
- Docker Deployment
- CI/CD Pipeline
- Analytics Dashboard
- Telemedicine Integration

---

# 🌟 Key Highlights

✅ Role-Based Authentication

✅ Doctor Approval System

✅ Appointment Booking Workflow

✅ Prescription Management

✅ PDF Generation

✅ PostgreSQL Integration

✅ Spring Security

✅ Cloud Deployment on Render

---

# 👨‍💻 Author

**Gourav Giri**

B.Tech Computer Science Engineering

Java Backend Developer

### Skills
- Java
- Spring Boot
- Hibernate
- PostgreSQL
- Data Structures & Algorithms

GitHub:
https://github.com/GiriGourav

LinkedIn:
https://www.linkedin.com/in/gourav-giri/

---

## ⭐ Support

If you found this project useful, please consider giving it a **Star ⭐** on GitHub.
