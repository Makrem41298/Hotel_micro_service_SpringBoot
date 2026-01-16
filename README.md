# Hotel Microservices Project

This project is a Hotel Management System built using a **Microservices Architecture** with **Spring Boot** and **Spring Cloud**. It handles clients, rooms, and reservations, utilizing distinct services for each domain. The services communicate via REST (OpenFeign) and asynchronous messaging (Kafka).

## 🏗 Architecture

The system consists of the following components:

* **Discovery Service (Eureka):** Service registry for dynamic service discovery.
* **Config Service:** Centralized configuration server using the native filesystem.
* **Gateway Service:** API Gateway acting as a single entry point, routing requests to specific microservices.
* **Client Service:** Manages hotel client information.
* **Room Service:** Manages room inventory and status updates.
* **Reservation Service:** Handles booking logic, validates data with other services, and produces events.

### Communication Flow
* **Synchronous:** `Reservation Service` uses **OpenFeign** to fetch Client and Room details from `Client Service` and `Room Service` respectively during booking validation.
* **Asynchronous:** When a reservation is successfully created, the `Reservation Service` publishes an event to a **Kafka** topic (`reservation-topic`). The `Room Service` consumes this event to automatically update the room's status to `BOOKED`.

## 🛠 Technologies Used

* **Java:** 17
* **Spring Boot:** 3.5.9
* **Spring Cloud:** 2025.0.1 (Eureka, Config, Gateway, OpenFeign, Stream Kafka)
* **Database:** MySQL
* **Messaging:** Apache Kafka
* **Build Tool:** Maven

## 📦 Microservices Overview

| Service Name | Port | Description |
| :--- | :--- | :--- |
| **Discovery Service** | `8761` | Eureka Server dashboard and registry. |
| **Config Service** | `9999` | Centralized configuration server. |
| **Gateway Service** | `8888` | Entry point. Routes e.g., `/api/clients/**` to Client Service. |
| **Client Service** | `8081` | CRUD for Clients. DB: `bd_client_hotel`. |
| **Room Service** | `8082` | CRUD for Rooms. Listens to Kafka events. DB: `bd_room_hotel`. |
| **Reservation Service** | `8083` | Process Reservations. Publishes Kafka events. DB: `bd_reservation_hotel`. |

## ⚙️ Prerequisites

Before running the application, ensure you have the following installed:

1.  **Java JDK 17+**
2.  **Maven 3.9+**
3.  **MySQL Server** (Running on port `3306`)
4.  **Apache Kafka & Zookeeper** (Running locally, broker on `localhost:9092`)

## 🚀 Setup & Installation

### 1. Database Configuration
Ensure your MySQL server is running. The services are configured to create databases automatically if they don't exist (`createDatabaseIfNotExist=true`).
* **Username:** `YourUserName`
* **Password:** `YourPassword`

*(Note: You can change these credentials in `config-service/src/main/resources/configurations/*.properties` if needed).*

### 2. Kafka Configuration
Start your Zookeeper and Kafka server. The default configuration expects the broker at `localhost:9092`.


