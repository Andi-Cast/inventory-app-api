# Inventory Management API

This project is a backend API for managing inventory products. It provides endpoints for user authentication, product management, and role-based access control. The API is designed using Spring Boot and MongoDB.

## Project Overview

The Inventory Management API allows users to perform CRUD operations on products and manage user roles. The API supports JWT-based authentication and role-based access control, ensuring that only authorized users can access certain endpoints.

## Technologies Used

- **Java**: Programming language used for development.
- **Spring Boot**: Framework for building the backend application.
- **MongoDB**: NoSQL database used for storing data.
- **JWT (JSON Web Token)**: Used for secure authentication.
- **Maven**: Dependency management.

## Installation & Setup

1. **Clone the repository:**
    ```bash
    git clone https://github.com/yourusername/inventory-management-api.git
    cd inventory-management-api
    ```

2. **Configure the MongoDB database:**
    - Update the MongoDB connection settings in `application.properties` or `application.yml` based on your environment.

3. **Build the project:**
    ```bash
    mvn clean install
    ```

4. **Run the application:**
    ```bash
    mvn spring-boot:run
    ```

## API Endpoints

### Authentication
- **POST** `/login` - User login.
- **POST** `/register` - User registration.

### User Management
- **GET** `/api/users/all_users` - Retrieve all users (Admin only).
- **PUT** `/api/users/update/{id}` - Update user details (Admin and User).
- **DELETE** `/api/users/delete/{id}` - Delete a user (Admin only).

### Product Management
- **GET** `/api/products/getProducts` - Retrieve all products.
- **GET** `/api/products/category={category}` - Retrieve all products by category.
- **GET** `/api/products/createdBy={createdBy}` - Retrieve all products by creator.
- **POST** `/api/products/addProduct` - Create a new product.
- **PUT** `/api/products/update/{id}` - Update product details.
- **DELETE** `/api/products/delete/{id}` - Delete a product.

## Features

- **JWT Authentication**: Secures the API with token-based authentication.
- **Role-Based Access Control**: Restricts access to certain endpoints based on user roles.
- **CRUD Operations**: Full support for create, read, update, and delete operations on products.
