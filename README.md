# Inventory Order Management System

# Design Overview:

To address the Automobile Repair Shop’s Inventory and Order Management requirements, implemented a simple microservices-based solution using Spring Boot with in-memory database (H2). 
The solution based on the following key principles:

## Microservice Architecture:

Separate concerns into distinct microservices (Inventory and Order services).

Persistence Layer: Use an in-memory database (H2) to persist data for audit purposes.

Order Automation: Automatic creation of orders based on inventory thresholds and time constraints.

Simple REST API: Expose REST endpoints for managing inventory and orders.

Code Modularity and Design: Use the SOLID principles, separation of concerns, and simple but effective design patterns.

## High-Level Architecture

### Inventory Service:

Manages parts and tracks available quantities.
Includes logic to add and update parts.
Provides endpoints for viewing and modifying part details (threshold limit, available quantity, and supplier).

### Order Service:

Creates orders based on inventory checks and automated rules.
Tracks orders placed to suppliers based on inventory levels.
Automated order placement when stock goes below threshold.
Logic to check the current time and ensure that orders to Supplier are only placed during the discount window
![InventoryStockOrderMgntSystem](https://github.com/user-attachments/assets/77d6d320-1225-4ff3-8418-8f120b4e3dd5)

![Invertory_Order_APIs_Detils](https://github.com/user-attachments/assets/7b3b669d-dcd6-4262-81f5-303e9d7d226e)

### Technical Components:

Spring Boot: The application framework.

Spring Data JPA: To interact with the in-memory H2 database.

H2 Database: In-memory database for simple persistence during development.

Spring Web: To expose REST APIs for inventory and order management.

Service Layer: Contains business logic for managing inventory and orders.


