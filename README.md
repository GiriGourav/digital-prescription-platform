# 🏥 Digital Healthcare Platform

A full-stack healthcare management system built using **Spring Boot**, **Spring Security**, **Thymeleaf**, **Hibernate/JPA**, and **MySQL**.

The platform enables patients to book appointments, doctors to manage prescriptions, and administrators to approve doctors before they can access the system.

---

## 🚀 Features

### 👤 Authentication & Authorization

* Secure Login & Registration
* Role-Based Access Control
* Admin, Doctor, and Patient Roles
* Password Encryption using BCrypt

### 👨‍⚕️ Doctor Features

* Create Digital Prescriptions
* Edit Prescriptions
* Delete Prescriptions
* View Appointment Requests
* Approve/Reject Appointments
* Search Prescriptions by Patient Name
* Download Prescriptions as PDF

### 🧑 Patient Features

* Register & Login
* Book Appointments
* Select Available Doctors
* View Appointment History
* View Prescription History
* Download Prescription PDFs

### 🛡️ Admin Features

* Admin Dashboard
* View All Registered Doctors
* Approve Doctor Accounts
* Remove Doctors
* Monitor Platform Activity

### 📄 Prescription Management

* Digital Prescription Creation
* PDF Generation & Download
* Patient Medical History Tracking

### 📅 Appointment Management

* Appointment Booking
* Doctor Selection
* Appointment Status Tracking
* Pending / Approved / Rejected Workflow

---

## 🏗️ Tech Stack

### Backend

* Java 17+
* Spring Boot
* Spring Security
* Spring Data JPA
* Hibernate

### Frontend

* Thymeleaf
* HTML5
* CSS3
* Bootstrap 5
* Bootstrap Icons

### Database

* MySQL

### Tools

* Maven
* IntelliJ IDEA / Eclipse
* Git & GitHub

---

## 📂 Project Structure

src/main/java
├── controller
├── entity
├── repository
├── service
├── config

src/main/resources
├── templates
├── static
│ ├── css
│ ├── js
│ └── images
└── application.properties

---

## ⚙️ Installation

### 1. Clone Repository

```bash
git clone https://github.com/your-username/digital-healthcare-platform.git
cd digital-healthcare-platform
```

### 2. Configure MySQL

Create a database:

```sql
CREATE DATABASE healthcare_db;
```

Update application.properties:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/healthcare_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3. Run Project

```bash
mvn spring-boot:run
```

Application runs on:

```text
http://localhost:8080
```

---

## 🔑 Default Admin Account

Create an admin account using CommandLineRunner:

```java
Email: admin@gmail.com
Password: admin123
```

---

## 📊 Database Entities

### User

* id
* name
* email
* password
* role
* approved

### Prescription

* id
* doctorName
* patientName
* patientEmail
* diagnosis
* medicines
* notes
* date

### Appointment

* id
* patientName
* patientEmail
* doctorName
* appointmentDate
* status

---

## 🔒 Security

* Spring Security Authentication
* BCrypt Password Hashing
* Role-Based Authorization
* Doctor Approval Workflow
* Protected Routes

---

## 🎯 Future Enhancements

* Email Notifications
* Appointment Reminders
* Doctor Profile Pictures
* Analytics Dashboard
* REST API Integration
* JWT Authentication
* Cloud Deployment
* Telemedicine Support
* Payment Gateway Integration

---

## 📸 Screenshots

Add screenshots of:

* Home Page
* Login Page
* Register Page
* Doctor Dashboard
* Patient Dashboard
* Admin Dashboard
* Appointment Booking
* Prescription Management

---

## 🌟 Key Highlights

✔ Role-Based Authentication

✔ Admin Approval for Doctors

✔ Appointment Booking System

✔ Prescription Management

✔ PDF Download Support

✔ Secure Password Encryption

✔ Responsive Bootstrap UI

✔ MySQL Database Integration

---

## 👨‍💻 Author

**Gourav Giri**

B.Tech CS Student | Java Backend Developer

* Java
* Spring Boot
* Hibernate
* MySQL
* Data Structures & Algorithms

---

⭐ If you found this project useful, consider giving it a star on GitHub.
