# Spring Boot liquibase-demo

This project demonstrates on how to set-up liquibase in a Spring Boot application.

This sample project is based on the post  [One-Stop Guide to Database Migration with Liquibase and Spring Boot](https://reflectoring.io/database-migration-spring-boot-liquibase/).


## How to Run the project and tests

### Run application

- Clone this repository 

```
 git clone https://github.com/thombergs/code-examples/spring-boot/data-migration/liquibase
```

- Move to the directory `code-examples/spring-boot/data-migration/liquibase`


- Run the docker compose file `infra-local.yaml` in `src/docker`. This starts the postgres database needed to run the application.
```
   docker-compose -f ./src/main/docker/infra-local.yaml up -d
```

- Now run the spring boot application as follows.
```
    mvnw spring-boot:run -Dspring-boot.run.profiles=docker
```

The application should start and listening on port `8080`.

Open the url (http://localhost:8080/liquibase/users/100000000) in the browser. You should see a response as below

```json
{
"id": 100000000,
"userName": "testUser",
"firstName": "testFirstName",
"lastName": "testLastName"
}
```

You can login to the database and check the creation of `user_details` table along with some test data in it. 
```yaml
    #Use below credentials to login to the database
    databaseHost: localhost
    jdbcUrl: jdbc:postgresql://localhost:5432/liquibasedemo?current_schema=public
    port: 5432
    username: demouser
    password: demopassword
```

Also, have a look at databasechangelog and databasechangeloglock tables.


### Run Test
To run integration test, you don't need to run the docker compose file. Just run the test as follows:

```yaml
mvn test -Dspring.profiles.active=docker
 
```
The test uses [TestContainers](https://www.testcontainers.org/) to spin a postgres database, which is used during the integration test.


