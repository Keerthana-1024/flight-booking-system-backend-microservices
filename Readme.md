# Flight Booking System

A **Java Spring Boot microservices-based flight booking backend** integrating the **Duffel API** for flight search and booking workflows.

## Architecture

- **Flight Service** — Flight search and Duffel API integration
- **User Service** — User management and authentication
- **Order Service** — Booking and order management
- **Payment Service** — Payment processing
- **API Gateway** — Central API entry point and request routing
- **Eureka Server** — Service discovery
- **Config Server** — Centralized configuration

## Tech Stack

**Java:** OOP, Collections, Generics, Streams, Lambdas, Exception Handling, Date/Time API

**Spring:** Spring Boot, Spring MVC, Spring Data JPA, Hibernate, Spring Cloud, Dependency Injection

**Microservices:** REST APIs, DTOs, inter-service communication, Eureka Service Discovery, Spring Cloud Gateway, Spring Cloud Config

**Data:** PostgreSQL, SQL, Redis

**API & JSON:** Duffel API, Jackson, JSON serialization/deserialization, REST clients

**Tools & Infrastructure:** Maven, Git, GitHub, Docker, Docker Compose

## Project Structure

```text
flight-booking-backend/
├── api-gateway/
├── config-server/
├── eureka-server/
├── flight-service/
├── user-service/
├── payment-service/
└── order-service/
```
## AI Agent Chat Interface
An **AI-agent-based chatbot** is an additional interface for interacting with backend services through APIs, enabling natural-language flight search and booking workflows.
