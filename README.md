# paulabscs

## Prototype Web App
This Java Web App consists of a complete end-to-end setup. Spring Boot, Spring Data JPA, and Maven are the core features and tools in this project. Spring Boot streamlines and extends the routing setup, which is then utilized by many aspects of this program. The project employs a repository pattern to ensure completeness of a distributed web app. Communication to the end-user leverages appropriate annotations for JSON serialization. 

## Overview
Integrating the ORM, database manager and repository, the database entries are synthesized via the database populator specifically the csv reading component. An included ORM supports the repository by handling Data Transfer Objects (DTOs) and JSON-friendly mappings, making data sharing easy and keeping the inner logic smooth. This pattern helps change data forms between class types, piloting data handling capabilities while ensuring flexibility. Each layer is structured with Object Oriented Programming principles in mind.

## Structure
- **Database Layer:** `/data/db`
- **Repository Layer:** `/repository`
- **ORM Layer:** `/data/dtos`
- **Model Layer:** `/models`
- **Controller Layer:** `/controllers`
- **View Layer:** `/static`

## Specifics
### Surface-Level Backend
- `APIController.java`: Handles API endpoints and client requests.
- `MarineRepo.java`: Sets up the repo pattern for working with shark data.
- `SharkDTO.java`: Represents data transfer objects for sharks.
- `SharkConverter.java`: Turns SharkDTO into ORM models.
- `IMarineRepo.java`: Wraps the repo pattern for data tasks.

### Core Backend
- `Application.java`: Starts and sets up the Spring Boot app.
- `MarineDatabase.java`: Handles the in-memory database.
- `PopulateDatabase.java`: Fills the database from a CSV file.

## Usage Information

### Setting Up the Environment
1. **Set JAVA_HOME**
    ```sh
    set JAVA_HOME=C:\Program Files\Java\Oracle_JDK-23
    ```
2. **Set MAVEN_HOME**
    ```sh
    set MAVEN_HOME=C:\Program Files\apache-maven-3.9.0
    ```

### Running the App
1. **Clean Install**
    ```sh
    mvn clean install
    ```
2. **Package the App**
    ```sh
    mvn package
    ```
3. **Run the Spring Boot App**
    ```sh
    mvn spring-boot:run
    ```
