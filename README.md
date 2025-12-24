# School Management System  
**Name:** Harsh  
**Student ID:** 12306216  

## Project Description
This project is a backend **School Management System** developed using **Spring Boot and Spring Data JPA**.  
It provides RESTful APIs to manage students, teachers, courses, and enrollments while maintaining proper database relationships and data integrity.

The system models real-world academic relationships such as student profiles, course enrollments, and teacher-course mappings.  
A dedicated **Enrollment** entity is used to handle the many-to-many relationship between students and courses, allowing additional attributes like grade, semester, and enrollment date.

The application follows a clean layered architecture (**Controller → Service → Repository**), supports multiple environments using **Spring Profiles**, and exposes health and monitoring endpoints using **Spring Boot Actuator**.

Key features include:
- Full CRUD operations via REST APIs  
- Proper JPA relationships (OneToOne, ManyToOne, ManyToMany via join entity)  
- Use of Enums and Embedded objects  
- Transaction management using `@Transactional`  
- Separate configurations for development (H2) and production (MySQL) environments  

This project demonstrates practical backend development concepts, database integrity enforcement, and clean API design using Spring Boot.
