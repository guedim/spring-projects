# User Manageemnt CQRS

This project demonstrates on how to set-up [CQRS](https://martinfowler.com/bliki/CQRS.html) in a Spring Boot application.

This sample project is based on [Master Spring Boot Microservices with CQRS and Event Sourcing](https://www.udemy.com/course/master-spring-boot-microservices-with-cqrs-event-sourcing/) udemy course.



## How to Run the project and tests

### Application

There are 5 services in this demo:

- Api Gateway
- User Command API
- User Query API
- Bank Command API
- Bank Query API

<br/>

![Services](./user-management.png "Services flow")


### Setup

- Clone this repository 

```
 git clone https://github.com/guedim/spring-projects.git
```

- Move to the directory `CQRS/user-management`

```
cd spring-projects/CQRS/user-management
```

### Build project & Docker images

- To build all services docker images (mongo, axon, mysql, user, bank, apigateway, etc,) run next command:
 
```
docker-compose build
```


### Start services 

For create, start and attach all containers, please run next docker-compose command:

```
 docker-compose up
```

### Test services

Finally, ``aggregaror-service`` expose two methods


# References

- https://martinfowler.com/bliki/CQRS.html
- https://www.udemy.com/course/master-spring-boot-microservices-with-cqrs-event-sourcing/