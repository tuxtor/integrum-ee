# Integrum EE

Currently integrum EE is a proof of concept of a Java EE project with support for Kotlin and Java as languages

As 2020-10-23 it has been tested with the following enterprise APIs

* JPA
* EJB
* CDI
* JAX-RS
* MicroProfile Config

All of this over Payara and Payara Micro

## Notes for development
To run this project locally you should create your own database configuration, the easiest way is to create your own `glassfish-resources.xml` file, for reference a shadow `.xml` copy has been included to use it as basis, note that this file depends on environment variables that you should set manually including:

* JDBC_URL
* POSTGRES_PASSWORD
* POSTGRES_DB

In the current configuration this project produces two artifacts:

* `integrum-ee.war` deployable over Payara Application Server
* `integrum-ee-microbundle.jar` a self contained uber jar with Payara Micro

Currently, this project supports:

- Java EE 8
- MicroProfile 3.2
- Arquillian & Junit 4
- Java 11
- Kotlin 1.4.x
- Flyway 5 

## Build with docker
mvn clean package && docker build -t tuxtor/integrum-ee .

## RUN with docker compose and PostgreSQL

By default, this project uses a vanilla definition over postgres in a database named Integrum, this could be executed easily by invoking:

    docker compose up
    
This will boot up the basic infrastructure for this using 4001 port and Docker Compose (commonly installed in Windows and MacOs docker distributions). 
