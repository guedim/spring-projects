# SpringBoot TestContainer

This project demonstrates on how to set-up TestContainers in a Spring Boot application.

This sample project is based on [integration testing with TestContainers](https://speakerdeck.com/nikolayk812/integration-testing-with-testsontainers-and-junit-5) and [TestContainers + JUnit5](https://www.youtube.com/watch?v=wR3mP9NLn38).



## How to Run the project and tests

### Run application

There are 2 services in this demo:

- User service: Use ``Postgres`` to persit data.
- Item service: uses ``Redis`` to persist data and depends on User service.

Each service is a Spring Boot project which uses non-mocked DB started by ``TestContainers`` library.  

- test-runner: Is a module to start ``User`` and ``Item`` services and their dependencies (``Postgeres`` & ``Redis``) in order  to perform end-to-end tests.


### Setup

- Clone this repository 

```
 git https://github.com/guedim/spring-projects.git
```

- Move to the directory `testcontainer`

```
cd spring-projects/testcontainer
```

### Build project & Docker images

- To build User and Item services and build docker images, run next script:
 
```
sh build-all.sh
```


### Run end-to-end tests

To run end-to-end tests go to `test-runner` project:

```
cd spring-projects/testcontainer/test-runner
```

Run `mvn test` for excuting end-to-end Test:

```
mvn test
```
