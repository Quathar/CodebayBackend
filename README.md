# Codebay

Application developed with [Spring Boot](https://spring.io/projects/spring-boot) and structured with [Hexagonal Architecture](https://en.wikipedia.org/wiki/Hexagonal_architecture_(software)) made by [Quathar](https://github.com/Quathar).

In this application you will be able to simulate an e-commerce basic functionality and its management part.

## Index

- [Structure](#structure-hexagonal-architecture)
  - [Domain](#domain)
  - [Application](#application)
  - [Infrastructure](#infrastructure)

## Structure (Hexagonal Architecture)

**Hexagonal Architecture**, also known as **Ports and Adapters Architecture**, is a design pattern used to create loosely coupled application components. This architecture allows an application to be equally driven by users, programs, automated tests, or batch scripts, and to be developed and tested in isolation from its eventual runtime devices and databases.

To create this structure the SOLID principles are followed.

SOLID Principles:
- **Single Responsibility Principle:** A class should have only one reason to change.
- **Open/Closed Principle:** Software entities should be open for extension but closed for modification.
- **Liskov Substitution Principle:** Objects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program (Contract Design).
- **Interface Segregation Principle:** No client should be forced to depend on methods it does not use.
- **Dependency Inversion Principle:** High-level modules should not depend on low-level modules. Both should depend on abstractions.

### Domain

The Domain Layer is the core of the Architecture. It contains the business logic and rules of the application. This layer is independent of any external systems or frameworks, ensuring that the business logic remains decoupled from technical concerns.

Key components:

- **Entities:** Represent the core business objects of the application.
- **Value Objects:** Represent immutable objects that are distinguishable only by their attributes.
- **Aggregates:** Represent a cluster of associated objects that are treated as a single unit.
- **Repositories:** Define the interface for interacting with the data source (commonly a database).
- **Domain Services:** These are services that contain domain logic which doesn't naturally fit within an entity or value object.
- **Events:** Represent domain events that are raised by the domain layer and consumed by the application layer.

### Application

The Application Layer is responsible for orchestrating the business logic and coordinating the flow of data between the domain and the infrastructure layers. It contains application services, which are used to implement use cases and application-specific logic.

Key components:

- **Application Services:** These services contain the application-specific business logic and orchestrate the interaction between the domain and infrastructure layers.
- **DTOs (Data Transfer Objects):** These are simple objects used to transfer data between the application and other layers.
- **Mappers:** These are responsible for converting between domain objects and DTOs.

### Infrastructure

The Infrastructure Layer is responsible for providing technical capabilities to the application. It includes implementations for repositories, external services, and other technical concerns. This layer interacts with external systems such as databases, messaging systems, and other services.

Key components:

- **Adapters:** These are implementations of the interfaces defined in the domain layer. They handle the interaction with external systems.
- **Repositories:** These are concrete implementations of the repository interfaces defined in the domain layer.
- **Configuration:** This includes configuration classes and files for setting up the infrastructure components.
