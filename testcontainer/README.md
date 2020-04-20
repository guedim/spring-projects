# Doc

https://speakerdeck.com/nikolayk812/integration-testing-with-testsontainers-and-junit-5
https://www.youtube.com/watch?v=wR3mP9NLn38


# TestContainers demo

There are 2 services in this demo:

- User service
- Item service


*User service* uses *Postgres* and *Item service* uses *Redis* respectively and has dependency on User service. Each service has a SpringBootTest which uses non-mocked DB started by *TestContainers* library.  

*test-runner* module is an example of a framework to start all 2 services and their dependencies  together in order to perform end-to-end tests.

## Stack

- Spring Boot
- Docker
- Postgres, Redis
- TestContainers
- JUnit 5

## Setup

To build all services in Docker:
```
sh build-all.sh
```

To run end-to-end tests:
```
cd test-runner
mvn test
```
