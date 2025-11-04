Online Student Management System
Project Overview

The Online Student Management System (OSMS) is a mini-project developed using Java, Spring, and Hibernate. It allows administrators or staff to manage students, courses, and fee transactions. The system demonstrates core concepts such as:

Dependency Injection (DI) using Spring

CRUD operations with Hibernate ORM

Transaction management using @Transactional

Integration of Spring and Hibernate for real-world data management

This project provides a console-based menu interface for adding students, assigning courses, processing payments, issuing refunds, and viewing student information.

Features

Student-Course Management

Add new students

Assign courses to students

View student details

CRUD Operations

Create, Read, Update, Delete student and course records

Fee Management

Fee payment and refund

Ensures transactional consistency; any failure rolls back the operation

Spring + Hibernate Integration

DAO layer handles persistence via Hibernate

Service layer handles business logic with Spring transaction management

Java-based Spring configuration (@Configuration) replaces XML

Console Menu

Menu-driven interface for real-time interaction

Error handling and validations included
