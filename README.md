# world-cup-spring-boot
World Cup 2026 Fan Website (Unofficial). A full-stack web application built as a learning project for tracking the 2026 World Cup, with REST API backend(Spring Boot), and JWT authentication.

## Technologies
- **Backend:** Java, Spring Boot, Spring Security, Spring Data JPA
- **Database:** MySQL
- **Authentication:** JWT (JSON Web Token), stateless
- **Frontend:** HTML, CSS, JavaScript

## Features
- Browse teams, players, and games (publicly available, no login required)
- User registration and login
- Add/delete/edit teams, players, or games (only as ADMIN)
- Role-based access control (USER/ADMIN)

## Getting Started

### Prerequisites

- Java 25+
- Maven
- MySQL server (default configured on `localhost:3309`)

### Database Setup

Create the database:

```sql
CREATE DATABASE world_cup;
```

Configure the connection in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3309/world_cup
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
```

### Running the Application

```bash
dev.bat
```

This application runs on `http://localhost:8080`

### Creating the First ADMIN Account

New registrations are always assigned the `USER` role. To promote a user to `ADMIN`, register via `/register`, then manually update the role in the database:

```sql
UPDATE app_user SET role = 'ADMIN' WHERE username = 'your_username';
```


## Project Structure

```
src/main/java/rs/ac/singidunum/world_cup/
├── controller/     # REST controllers (Game, Player, Team, Auth)
├── entity/         # JPA entities (Game, Player, Team, User)
├── repository/     # Spring Data JPA repositories
├── service/        # Business logic
├── security/       # Spring Security configuration, JWT service and filter
└── dto/            # Data Transfer Objects for auth requests/responses
```