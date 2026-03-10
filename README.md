# Exercise1

## 📌 Project Overview

This project is a Spring Boot web application developed for the subject *Agile Techniques for Software Development*.

The application implements several mathematical functionalities following the MVC (Model-View-Controller) architectural pattern. Each functionality is fully tested (Service and Controller layers) and the application is dockerized.

---

## 🏗 Project Structure

The project has been reorganized into a modular structure to improve maintainability and separation of concerns.

```text
C:.
├───.devcontainer
├───.idea
└───p1-springboot-hello-world-app
├───.idea
├───src
│   ├───main
│   │   ├───java
│   │   │   └───demoapp
│   │   │       ├───controller
│   │   │       │   ├───calculator
│   │   │       │   ├───evennumber
│   │   │       │   ├───factorial
│   │   │       │   ├───palindrome
│   │   │       │   ├───saludo
│   │   │       │   └───square
│   │   │       └───service
│   │   │           ├───calculator
│   │   │           ├───evennumber
│   │   │           ├───factorial
│   │   │           ├───palindrome
│   │   │           ├───saludo
│   │   │           └───square
│   │   └───resources
│   │       └───templates
│   │           ├───calculator
│   │           ├───evennumber
│   │           ├───factorial
│   │           ├───palindrome
│   │           └───square
│   └───test
│       └───java
│           └───demoapp
│               ├───controller
│               └───service
└───target
├───classes
│   ├───demoapp
│   │   ├───controller
│   │   │   ├───calculator
│   │   │   ├───evennumber
│   │   │   ├───factorial
│   │   │   ├───palindrome
│   │   │   ├───saludo
│   │   │   └───square
│   │   └───service
│   │       ├───calculator
│   │       ├───evennumber
│   │       ├───factorial
│   │       ├───palindrome
│   │       ├───saludo
│   │       └───square
│   └───templates
│       ├───calculator
│       ├───evennumber
│       ├───factorial
│       ├───palindrome
│       └───square
├───generated-sources
│   └───annotations
├───generated-test-sources
│   └───test-annotations
├───maven-archiver
├───maven-status
│   └───maven-compiler-plugin
│       ├───compile
│       │   └───default-compile
│       └───testCompile
│           └───default-testCompile
├───surefire-reports
└───test-classes
└───demoapp
├───controller
└───service
```
### Structure explanation:
This structure was chosen to:

- Improve code organization
- Separate responsibilities clearly
- Follow clean architecture principles
- Facilitate testing
- Make the project scalable

Each functionality is isolated into its own package, following a feature-based organization approach.

---

## 🚀 Implemented Functionalities

### 1️⃣ Palindrome
Endpoint: http://localhost:8080/palindrome

Checks whether a word is a palindrome.

Includes:
- String processing
- Service and Controller tests

### 2️⃣ Even Number
Endpoint: http://localhost:8080/even

Determines whether a number is even.

Includes:
- Validation
- Unit testing

### 3️⃣ Square
Endpoint: http://localhost:8080/square

Checks whether the second number is the square of the first number.

Includes:
- Validation constraints
- Boolean result handling
- Service and Controller tests

### 4️⃣ Calculator
Endpoint: http://localhost:8080/calculator

Allows:
- Addition
- Subtraction
- Multiplication
- Division (with division-by-zero validation)

Includes:
- Input validation
- Exception handling
- Service tests
- Controller tests

### 5️⃣ Factorial Calculator (Additional Functionality)
Endpoint: http://localhost:8080/factorial

Calculates the factorial of a number between 0 and 20.

Implementation details:
- Iterative algorithm
- Validation constraints (`@Min`, `@Max`)
- Long return type
- Service tests
- Controller tests

---

## 🧪 Testing

The project includes:

- Unit tests for all Service classes
- Web layer tests using MockMvc
- Validation tests
- Exception handling tests

Total tests: 39+  
All tests pass successfully.

---

## 🐳 Dockerization

The application has been containerized using Docker.

DockerHub repository: https://hub.docker.com/r/ainhoaro/spring-boot-demoapp<br><br>

The uploaded image includes the _'final'_ label as indicated in the practice statement. <br><br>
_Build command used_:

``docker build -t ainhoaro/spring-boot-demoapp:final .``<br><br>
_Run command_:

``docker run -p 8080:8080 ainhoaro/spring-boot-demoapp:final``

---

## 📂 GitHub Repository

GitHub repository:

https://github.com/Ainhoa-Rodriguez25/Exercise1

---

## 🧠 Technologies Used

- Java 21
- Spring Boot 2.7.x
- Thymeleaf
- JUnit 5
- MockMvc
- Maven
- Docker

---

## 📌 Author

Ainhoa Rodríguez González

Student project for Agile Techniques Methodology subject.