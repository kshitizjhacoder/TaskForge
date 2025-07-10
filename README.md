# TaskForge

🛠 TaskForge – Project Workflow
TaskForge is a modular and scalable task management system designed using Hexagonal Architecture. This structure enables clean separation of concerns, making the application highly testable, maintainable, and adaptable to change.

# Project Structure 
<pre><code>taskforge/
├── domain/
│   ├── model/                # Core business models (Entities)
│   ├── port/                 # Interfaces (Ports) for adapters to implement
│
├── adapter/
│   ├── persistence/          # JPA Entities, Mappers, and Repository implementations
│   ├── rest/                 # REST Controllers
│
├── application/
│   ├── dto/                  # Data Transfer Objects
│   ├── usecase/              # Application Services (Use Cases)
│
├── infrastructure/           # (Optional) Cross-cutting concerns (e.g., config, logging)
└── TaskForgeApplication.java # Main Spring Boot application entry
</code></pre>

# Workflow & Flow of Control

1. Domain Layer (Core Business Logic)

   Defines pure business models like Task, User, TaskComment, etc.

   Declares interfaces (ports) like TaskRepository, UserRepository, which abstract the core from implementation details.

3. Application Layer (Use Cases)

    Contains specific application services such as: CreateTaskUseCase, FindUserByEmailUseCase, GetTasksByPriorityUseCase

    Uses ports to interact with domain services and send/receive data through DTOs.

4. Adapter Layer (Implementations)

    Persistence Adapter: Implements JPA repositories using Spring Data.
    
    Converts between Entities ↔ Domain Models using Mappers. Example: TaskPersistenceAdapter implements TaskRepository
    
    REST Adapter: Exposes application use cases via HTTP endpoints.
    
    Maps HTTP requests to use cases and returns results as DTOs or ResponseEntities.

4. Entity-Mapper-Domain Flow
   <pre><code>
     Controller -> UseCase -> Domain Port -> Adapter (Persistence) -> Entity (JPA)
      ↑                                                          ↓
     ResponseEntity <--- DTO <--- UseCase Result <--- Domain Object
   </code></pre>

# Why Hexagonal architecture 

| Feature                   | Benefit                                                                        |
| ------------------------- | ------------------------------------------------------------------------------ |
| 🔌 Port & Adapter Pattern | Swappable interfaces — switch DB or API layers without touching business logic |
| 🔄 Testability            | Domain logic can be unit tested in isolation from Spring or JPA                |
| 📐 Separation of Concerns | Domain, Application, and Infrastructure responsibilities are clearly split     |
| 🔧 Maintainability        | Easy to update or extend individual layers                                     |
