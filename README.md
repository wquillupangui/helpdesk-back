# Spring Boot Application edimca/helpdesk-back

## Brief

helpdesk-back is a REST services provider over Java, using PostgreSQL server for the data persist. The project is the back-end of edimca helpdesk project.

## Built With

- [Maven](https://maven.apache.org/) - Dependency Management
- [JDK 11](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html) - Java™ Platform, Standard Edition Development Kit
- [Spring Boot](https://spring.io/projects/spring-boot) - Framework to ease the bootstrapping and development of new Spring Applications
- [PostgreSQL](https://www.postgresql.org) - Open-Source Relational Database Management System
- [git](https://git-scm.com/) - Free and Open-Source distributed version control system

### Sample Data (Optional)

A sample database for PostgreSQL to be used with edimca/helpdesk-back application.

- Dump file :
  `helpdesk-back\sql\backupDB_sample.sql` schema with data.
- You can restore your database by using PostgreSQL interactive terminal, and running the following command:

```
psql -U postgres edimca < backupDB_sample.sql
```

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.edimca.hdesk.HelpdeskBackApplication` class from your IDE.

- Download the zip or clone the Git repository.

```sh
git clone https://github.com/wquillupangui/helpdesk-back.git
```

- Unzip the zip file (if you downloaded one)
- Edit the `helpdesk-back\src\main\resources\application.properties` file with the PostgreSQL DB credentials:

```java
spring.datasource.url=jdbc:postgresql://localhost:5432/edimca
spring.datasource.username=postgres
spring.datasource.password=admin
```

  - If you use a Sample Data :

```java
spring.jpa.hibernate.ddl-auto=update
```

  - If you start a DB from scratch :

```java
spring.jpa.hibernate.ddl-auto=create
```

- Open Command Prompt and Change directory (cd) to folder containing pom.xml
- Open Eclipse
  - File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip
  - Select the project
- Choose the Spring Boot Application file (search for @SpringBootApplication)
- Right Click on the file and Run as Java Application

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```
mvn spring-boot:run
```

## Author

- **[Washington Quiillupangui](https://github.com/phillipjohnston)**
