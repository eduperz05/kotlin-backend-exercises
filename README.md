

# Albums API

This API provides access to albums and photos from JSON Placeholder.

## Table of Contents

- [Technologies Used](#technologies-used)
- [Features](#features)
- [Getting Started](#getting-started)
- [API Documentation](#api-documentation)
- [Improvements and Features](#improvements-and-features)
- [Contact](#contact)

## Technologies Used

- **Language:** Kotlin
- **Framework:** Spring Boot
- **Testing:** JUnit, Mockito
- **Documentation:** Swagger

## Features

- Fetch all albums.
- Fetch photos for a specific album.

## Getting Started

### Prerequisites

- Docker compose
- Browser

### Initiating the application

1. Clone the repository.
2. Run the following command to build the application:

```bash
docker-compose up
```
**Note:** The application is resulting to be so heavy, the build process will take about 1min.

3. The application will be available at [http://localhost:8080](http://localhost:8080).


## API Documentation

API documentation is available at [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html).
Test coverage is available at [http://localhost:8080/jacoco/index.html](http://localhost:8080/jacoco/index.html).

## Improvements and Features

- Implemented SOLID principles and Clean Architecture.
- Enhanced domain models to avoid anemic models.
- Comprehensive testing for services and domain models.
- Global exception handling.
- API documentation using Swagger.
- Building and running the application using Docker.
- Semantic versioning.
- JaCoCo test coverage.

## Contact

For any questions or feedback, reach out to:

- Name: Eduardo Pérez Suárez
- Email: eduperz05@outlook.com
- Github: https://github.com/eduperz05