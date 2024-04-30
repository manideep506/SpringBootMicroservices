# Online Shopping Application

## Overview
This project is a collection of three microservices developed using Spring Boot: OrderService, ProductService, and ServerRegistry. Each microservice serves a specific purpose in the system, collectively providing functionality for managing orders, products, and server connectivity.

## Architecture
The project follows a microservices architecture, where each microservice is independently deployable and communicates with others through well-defined interfaces.

### Components
- **OrderService**: Handles order-related operations such as creation, retrieval, updating, and deletion.
- **ProductService**: Manages the product list using CRUD operations.
- **ServerRegistry**: Facilitates server connectivity and registration.

### Communication
The microservices communicate with each other via RESTful APIs.

## Installation
To run the project locally, follow these steps:

### Prerequisites
- Java JDK (version 17)
- Maven


### Installation Steps
1. Clone the repository.
2. Navigate to each microservice directory (orderservice, productservice, serverregistry) and run `mvn spring-boot:run`.


## Usage
Each microservice exposes its APIs for interaction. Here are the main endpoints:

### OrderService
- **Endpoint**: `/orders`
- **Operations**: 
  - `GET /orders`: Retrieve all orders.
  - `POST /orders`: Create a new order.
  - `GET /orders/{orderId}`: Retrieve a specific order by ID.
  - `PUT /orders/{orderId}`: Update an existing order.
  - `DELETE /orders/{orderId}`: Delete an order.

### ProductService
- **Endpoint**: `/products`
- **Operations**: 
  - `GET /products`: Retrieve all products.
  - `POST /products`: Create a new product.
  - `GET /products/{productId}`: Retrieve a specific product by ID.
  - `PUT /products/{productId}`: Update an existing product.
  - `DELETE /products/{productId}`: Delete a product.

### ServerRegistry
- **Endpoint**: `/register`
- **Operations**: 
  - `POST /register`: Register server.

## Deployment
For deployment to a production environment, consider the following options:


## Monitoring and Logging
Monitoring and logging solutions such as Log4j2 can be integrated into the project for tracking performance metrics and analyzing logs.

