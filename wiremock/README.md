# SpringBoot TestContainer

This project shows how to set up an spring boot project for running Integration test using  [TestContainers](http://testcontainers.org) and [Wiremock](http://wiremock.org).


# Table of contents
1. [Application Description](#app_description)
2. [Integration Test](#integration_test)
3. [Setup Project](#setup_project)
4. [References](#references)


## Application Description<a id="app_description"></a>

Next section shows application processing flow its dependencies:

### Application process flow:<a name="app_flow"></a>

Main goal for this project, is receive a HTTP Request and process following next steps:

1. **Persist request**: Save data request  with ``NEW`` state into database.

2. **Get merchant configurations**: Call an external web service to get the merchant configuration.

3. **Evaluate fraud**: If merchant has enabled fraud validation option, it calls Fraud Control web service (update the request to ``EVALUATED`` status in database). 

4. **WebHook for final state**: If merchant has enabled web hook notifications, it sends an http post to the merchant web page. (update the request  to ``NOTIFIED`` status in database).

**NOTE**:
- If one error occurs,  system update the record in ``ERROR`` state and return a HTTP response with error message.

<p align="center">
  <img width="300" height="600" src="img/wiremock-flow.png">
</p>

### Application external dependencies:<a name="app_dependencies"></a>

This project process a request using next 4  dependencies:

1. **ConfigurationService**: External rest web service for getting up merchant configurations. Implementation using declarative [Feign client](https://cloud.spring.io/spring-cloud-netflix/multi/multi_spring-cloud-feign.html).

2. **FraudControlService**: External rest web service for evaluation/scoring fraud risk. Implementation using Spring [RestTemplate](https://spring.io/guides/gs/consuming-rest/).

3. **MerchantWebHook**: External merchant web endpoint for receiving HTTP notifications. Implementation using Spring [RestTemplate](https://spring.io/guides/gs/consuming-rest/).

4. **DBMS**: Relational database managment system for persisting process flow and process result.  This project uses [Postgres](http://postgresql.org).

<br/>

<p align="center">
  <img width="800" height="300" src="img/wiremock-sequence.png">
</p>


## Integrations test<a id="integration_test"></a>

### JPA Layer
explicar pruebas de jpa

### External services
explciar pruebas de services

### End to End test
explicar end to end


## Setup Project<a id="setup_project"></a>

- Clone this repository 

```
 git https://github.com/guedim/spring-projects.git
```

- Move to the directory `wiremock`

```
cd spring-projects/wiremock
```

### Run Integration Test

- For running integration test (without external system dependencies and without a ``Postgres`` database) execute next command:
 
```
mvn test
```



## References:<a id="references"></a>

- https://docs.pact.io/

- https://spring.io/projects/spring-cloud-contract

- http://wiremock.org/

- https://dzone.com/articles/easy-integration-testing-with-testcontainers

- https://sunshined.gitbooks.io/spring-cloud/spring_cloud_contract/spring_cloud_contract_wiremock.html

- https://engineering.pivotal.io/post/faking_oauth_sso/

- https://robintegg.com/2019/02/24/testing-spring-boot-applications-with-testcontainers-and-selenium-webdriver-part-three

- https://blog.sandra-parsick.de/2020/05/21/using-testcontainers-in-spring-boot-tests-for-database-integration-tests/