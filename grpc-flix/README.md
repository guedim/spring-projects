# SpringBoot gRPC

This project demonstrates on how to set-up [gRPC](https://grpc.io) in a Spring Boot application.

This sample project is based on [Microservices with gRPC [Java + Spring Boot  + Protobuf]](https://www.udemy.com/course/grpc-the-complete-guide-for-java-developers/) udemy course.



## How to Run the project and tests

### Application

There are 3 services in this demo:

- aggregator service: Is a HTTP Rest API using Spring Boot.
- user service: Is a gRPC service using Spring Boot with a ``H2 Database`` database.
- Item service: Is a gRPC service using Spring Boot with a ``H2 Database`` database.

<br/>

![Services](services.png "Services flow")


### Setup

- Clone this repository 

```
 git clone https://github.com/guedim/spring-projects.git
```

- Move to the directory `grpc-flix`

```
cd spring-projects/grpc-flix
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


# References

https://www.udemy.com/course/grpc-the-complete-guide-for-java-developers/
