# Library API

## Table of Contents

1. [Introduction](#introduction)
2. [Configuration](#configuration)
3. [Local Development](#local-development)
4. [Docker](#docker)
5. [API](#api-docs)
6. [Contributing](#contributing)
7. [License](#license)

## Introduction

Library API is a web backend application. It provides CRUD APIs to manage authors and books.

It uses

* Gradle 8 for builds
* Spring Boot 3 for web backend
* Java 17 for programming language
* [spring-boot-crud](https://github.com/makiftutuncu/spring-boot-crud) for CRUD
* PostgreSQL for database
* Flyway for DB schema management
* Spring Data JPA for database access
* JUnit 5 for testing

## Configuration

Configuration can be modified via [application.yml](src/main/resources/application.yml) or following environment variables. The default values allow you to run Library API out-of-the-box.

| Variable Name       | Data Type | Description                                          | Required                      |
|---------------------|-----------|------------------------------------------------------|-------------------------------|
| LIBRARY_API_PORT    | Integer   | Port to bind in the host machine for the application | No, defaults to `8080`        |
| LIBRARY_API_DB_HOST | String    | Host address of application database                 | No, defaults to `localhost`   |
| LIBRARY_API_DB_PORT | Integer   | Port of application database                         | No, defaults to `5432`        |
| LIBRARY_API_DB_NAME | String    | Name of application database                         | No, defaults to `library-api` |
| LIBRARY_API_DB_USER | String    | User of application database                         | No, defaults to `library-api` |
| LIBRARY_API_DB_PASS | String    | Password of application database                     | No, defaults to `library-api` |

## Local Development

You can use Gradle tasks like `clean`, `compileJava`, `compileTestJava` and `test` for local development. To run the application:
```shell
gradle bootRun
```

If you don't have Gradle installed, you can replace `gradle` commands with `./gradlew` to use Gradle wrapper.

## Docker

Library API can be built and run in Docker along with its database. To build and run using Docker:

```shell
docker compose up -d --build
```

This will create database container, build the application image, create application container and run everything together in detached mode. Remove `-d` if you want to run them directly and follow the logs.

Docker builds can also be customized by environment variables so the application image that is built is configured by those environment variables. This way, when you run the stack as following:

```shell
LIBRARY_API_PORT=80 LIBRARY_API_DB_PORT=1234 docker-compose up -d --build
```

you'll be able to access the application at `http://localhost:80` and the database at `jdbc:postgresql://localhost:1234/library-api`. Please note that configuring the ports will only affect the host side of the mapping. Inside the container, the default values will be used for the ports.

If you are running on a different host platform and get image related errors during build, you may need to change the base image in [Dockerfile](Dockerfile) to an available Java 17 image for your platform.

## API Docs

Library API provides OpenAPI documentation and a Swagger UI to browse them. After running the application, you may go to [/swagger-ui.html](http://localhost:8080/swagger-ui.html) to launch Swagger UI.

## Contributing

All contributions are welcome. Please feel free to send a pull request. Thank you.

## License

Library API is licensed with [MIT License](LICENSE).
