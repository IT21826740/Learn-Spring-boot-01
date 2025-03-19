# 📚 Book Borrowing System

A Spring Boot application for managing a book borrowing system with features like adding books, borrowing books, and managing members. This system allows users to easily manage books, members, and borrow/return books.

## 📌 Features

- ✅ Add, update, and delete authors
- ✅ Add, update, and delete books
- ✅ Borrow books for members
- ✅ View borrowed books and their borrow dates
- ✅ Manage members (add, update, delete)
- ✅ RESTful API endpoints for all operations
- ✅ Uses Spring Boot, JPA, and MySQL Database
- ✅ Easy integration with Docker

## 🛠️ Technologies Used

- **Spring Boot** (Backend Framework)
- **Spring Data JPA** (ORM for database interaction)
- **MySQL** (Database)
- **Lombok** (Simplifies Java code)
- **Spring Web** (REST APIs)
- **Docker** (Containerization)
- **Postman** (API Testing)

## 🚀 Getting Started

1. **Clone the repository**  
   `git clone [<repository-url>](https://github.com/IT21826740/Learn-Spring-boot-01.git)`

2. **Set up MySQL Database**  
   You can use Docker to set up the MySQL container, or you can manually set up MySQL on your system.

   **Docker Example:**
   ```bash
   docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=book_borrowing -p 3307:3306 -d mysql:latest
   ```

3. **Update `application.properties` with database credentials**  
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3307/book_borrowing
   spring.datasource.username=root
   spring.datasource.password=root
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
   ```

4. **Run the Application**  
   Use the following command to run the Spring Boot application:
   ```bash
   mvn spring-boot:run
   ```

5. **Test APIs**  
   Use Postman or any other API testing tool to test the endpoints.

## 🔗 API Endpoints

- **/authors**  
  - GET: List all authors
  - POST: Add a new author

- **/books**  
  - GET: List all books
  - POST: Add a new book

- **/borrow-books**  
  - POST: Borrow a book for a member
  - GET: View all borrowed books

- **/members**  
  - GET: List all members
  - POST: Add a new member
  - DELETE: Delete a member by ID

---
