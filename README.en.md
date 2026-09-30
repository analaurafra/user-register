# User Register Service 🚀

A Spring Boot application for managing user registrations with complete CRUD operations.

## 📋 Description

**User Register** is a REST API service developed with **Java 21** and **Spring Boot 3.3.4**. It provides basic user-management operations, including creating, reading, updating, and deleting users.

## 🛠️ Technologies

- **Java** 21
- **Spring Boot** 3.3.4
- **Spring Data JPA** for data persistence
- **H2 Database** as an in-memory database
- **Lombok** to reduce boilerplate code
- **Maven** for dependency management
- **JUnit 5** for testing

## 🚀 Running the Application

### Prerequisites

- JDK 21 or later
- Maven 3.6 or later

### Steps

1. Clone the repository:

   ```bash
   git clone https://github.com/analaurafra/user-register.git
   cd user-register
   ```

2. Build the project:

   ```bash
   mvn clean install
   ```

3. Start the application:

   ```bash
   mvn spring-boot:run
   ```

4. The application will be available at:
   - **API:** `http://localhost:8081`
   - **H2 Console:** `http://localhost:8081/h2-console`

## 📊 H2 Console

The H2 Console allows you to view and manage the in-memory database:

1. Open [http://localhost:8081/h2-console](http://localhost:8081/h2-console).
2. Use the following credentials:
   - **JDBC URL:** `jdbc:h2:mem:usuarios`
   - **Username:** `sa`
   - **Password:** leave blank
3. Click **Connect**.

## 🔌 API Endpoints

### Create a User

```http
POST http://localhost:8081/usuario
Content-Type: application/json
```

```json
{
  "nome": "John Silva",
  "email": "john@example.com"
}
```

Returns `200 OK` when the user is created successfully.

### Find a User by Email

```http
GET http://localhost:8081/usuario?email=john@example.com
```

Example response:

```json
{
  "id": 1,
  "nome": "John Silva",
  "email": "john@example.com"
}
```

If the email does not exist, the API returns `404 Not Found` with an error message.

### Update a User

Updates an existing user by ID. Only the provided fields are updated.

```http
PUT http://localhost:8081/usuario?id=1
Content-Type: application/json
```

```json
{
  "nome": "John Silva Santos",
  "email": "john.silva@example.com"
}
```

Returns `200 OK` when the user is updated successfully.

### Delete a User

Removes a user by email:

```http
DELETE http://localhost:8081/usuario?email=john@example.com
```

Returns `200 OK` when the user is deleted successfully.

## 🧪 Running the Tests

Run all tests:

```bash
mvn test
```

Run a specific test:

```bash
mvn test -Dtest=UserRegisterApplicationTests
```

## 🏗️ Architecture

The project follows a layered architecture:

```text
Controller (REST)
    ↓
Service (Business Logic)
    ↓
Repository (Data Access / JPA)
    ↓
Entity (Database Model / H2)
```

- **Controller:** receives HTTP requests and returns responses.
- **Service:** contains business logic and validations.
- **Repository:** provides JPA-based database access.
- **Entity:** represents the database table.

## 🧱 User Entity

The `Usuario` entity contains the following fields:

- An automatically generated `id`.
- A unique `email`.
- A `nome` field containing the user's name.

Validations and constraints include:

- Email uniqueness through a `UNIQUE` constraint.
- Automatic ID generation.
- Name and email are required.

## ⚙️ Configuration

The application uses the following main settings:

```properties
spring.application.name=user-register
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.datasource.url=jdbc:h2:mem:usuarios
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
server.port=8081
```

## 🐛 Error Handling

The application currently handles scenarios such as:

| Error | Scenario |
|---|---|
| `RuntimeException: "Email não encontrado"` | GET request with a non-existent email |
| `RuntimeException: "Usuario Não Encontrado"` | PUT request with a non-existent ID |
| `DataIntegrityViolationException` | Duplicate email |

## 💡 Future Improvements

- [ ] Implement DTOs for improved data transfer
- [ ] Add validation with `@Valid` and `@NotNull`
- [ ] Implement global exception handling with `ExceptionHandler`
- [ ] Add authentication and authorization
- [ ] Create comprehensive integration tests
- [ ] Implement detailed logging
- [ ] Add Swagger/OpenAPI documentation
- [ ] Migrate to a production database such as PostgreSQL or MySQL

## 👥 Author

- **Ana Laura** — [GitHub](https://github.com/analaurafra)

## 📄 License

This project is for personal and educational use.

## 🔗 Useful Links

- 🔧 **H2 Console:** [http://localhost:8081/h2-console](http://localhost:8081/h2-console)
- 📚 **Spring Boot Documentation:** [spring.io](https://spring.io)
- 🗄️ **H2 Database:** [h2database.com](http://h2database.com)
- 🧪 **Insomnia:** [insomnia.rest](https://insomnia.rest)
- 📚 **Referências:** [javanauta.youtube](https://insomnia.rest)](https://www.youtube.com/watch?v=yW7RrWfUeHE)

---

**Built with ❤️ in Java**
