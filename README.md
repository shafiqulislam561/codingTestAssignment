# codingTestAssignment

## Overview

`codingTestAssignment` is a Spring Boot application that provides a RESTful API for managing sales, wishlists, items, customers, and related data. This project demonstrates a test-driven development (TDD) approach to building an e-commerce application with various functionalities.

## Table of Contents

1. [Overview](#overview)
2. [Features](#features)
3. [Technology Stack](#technology-stack)
4. [Project Structure](#project-structure)
5. [API Endpoints](#api-endpoints)
    - [Sales](#sales)
    - [Wishlist](#wishlist)
    - [Items](#items)
    - [Customers](#customers)
6. [Contributing](#contributing)
7. [License](#license)
8. [Architecture](#architecture)

## Features

- Retrieve total sale amount by date
- Get the day with the maximum sale in a given date range
- List the top 5 selling items of all time
- List the top 5 selling items of the last month
- Get wishlist items for a specific customer
- Manage items and customers

## Technology Stack

- Java 17
- Spring Boot 3.3.1
- Spring Data JPA
- PostgreSQL
- JUnit 5
- Mockito
- Docker
- Gradle

## Architecture
This project follows a layered architecture:

- Controller Layer: Handles HTTP requests and responses.
- Service Layer: Contains business logic.
- Repository Layer: Handles data access and persistence.
- Model Layer: Defines the entities and data structures used in the application.
- Each layer is well-defined and serves a specific purpose, promoting separation of concerns and enhancing maintainability.

### Controllers
- CustomerController: Manages customer-related operations.
- ItemController: Manages item-related operations.
- SaleController: Manages sale-related operations.
- WishlistController: Manages wishlist-related operations.
### Models
- Customer: Represents a customer entity.
- Item: Represents an item entity.
- Sale: Represents a sale entity.
- Wishlist: Represents a wishlist entity.
### Repositories
- CustomerRepository: Manages customer data access.
- ItemRepository: Manages item data access.
- SaleRepository: Manages sale data access.
- WishlistRepository: Manages wishlist data access.
### Services
- CustomerService: Contains business logic for customers.
- ItemService: Contains business logic for items.
- SaleService: Contains business logic for sales.
- WishlistService: Contains business logic for wishlists.
### Data Loader
- DataLoader: Initializes the database with sample data.
By following this structure, the project maintains a clear separation of concerns, making it easier to manage and scale.

Feel free to contribute and provide feedback to help improve this project!

sql

This `README.md` now includes all the detailed information within the relevant sections as specified in the table of contents.

## Project Structure

```plaintext
codingTestAssignment
├── src
│   ├── main
│   │   ├── java
│   │   │   └── org
│   │   │       └── example
│   │   │           └── codingtestassignment
│   │   │               ├── Controller
│   │   │               │   ├── CustomerController.java
│   │   │               │   ├── ItemController.java
│   │   │               │   ├── SaleController.java
│   │   │               │   └── WishlistController.java
│   │   │               ├── Model
│   │   │               │   ├── Customer.java
│   │   │               │   ├── Item.java
│   │   │               │   ├── Sale.java
│   │   │               │   └── Wishlist.java
│   │   │               ├── Repository
│   │   │               │   ├── CustomerRepository.java
│   │   │               │   ├── ItemRepository.java
│   │   │               │   ├── SaleRepository.java
│   │   │               │   └── WishlistRepository.java
│   │   │               ├── Service
│   │   │               │   ├── CustomerService.java
│   │   │               │   ├── ItemService.java
│   │   │               │   ├── SaleService.java
│   │   │               │   └── WishlistService.java
│   │   │               ├── DataLoader.java
│   │   │               └── CodingTestAssignmentApplication.java
│   │   └── resources
│   │       ├── application.yaml
│   │       ├── data.sql
│   │       └── graphql-client
│   └── test
│       ├── java
│       │   └── org
│       │       └── example
│       │           └── codingtestassignment
│       │               ├── Controller
│       │               │   ├── CustomerControllerIntegrationTest.java
│       │               │   ├── ItemControllerIntegrationTest.java
│       │               │   ├── SaleControllerIntegrationTest.java
│       │               │   └── WishlistControllerIntegrationTest.java
│       │               ├── Model
│       │               │   ├── CustomerTest.java
│       │               │   ├── ItemTest.java
│       │               │   ├── SaleTest.java
│       │               │   └── WishlistTest.java
│       │               ├── Repository
│       │               │   ├── CustomerRepositoryTest.java
│       │               │   ├── ItemRepositoryTest.java
│       │               │   ├── SaleRepositoryTest.java
│       │               │   └── WishlistRepositoryTest.java
│       │               ├── Service
│       │               │   ├── CustomerServiceTest.java
│       │               │   ├── ItemServiceTest.java
│       │               │   ├── SaleServiceTest.java
│       │               │   └── WishlistServiceTest.java
│       │               └── CodingTestAssignmentApplicationTests.java
│       └── resources
│           └── application-test.properties
├── .gitignore
├── compose.yaml
├── Dockerfile
├── gradlew
├── gradlew.bat
├── README.md
├── settings.gradle
└── build.gradle
