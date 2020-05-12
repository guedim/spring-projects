# SpringBoot Micrometer

This project shows how to set-up Micrometer in a Spring Boot application, using ``Influx`` and ``Prometheus``.



## How to Run the project

### Application

This springboot app has enabled ``actuator`` to persist metrics in 2 micrometer implementations:

- ``Influx``: Metrics saved in metrics data base and exposed in url http://localhost:8086/.
- ``Prometheus``: Metrics exposed in url http://localhost:9090/.


### Setup

- Download the [docker-compose](https://docs.docker.com/compose/) file:

```sh
wget https://raw.githubusercontent.com/guedim/spring-projects/master/micrometer/docker-compose.yml
```

- Next, start SpringBoot service with its dependencies ([Influx](https://www.influxdata.com) and [Prometheus](https://prometheus.io) using [docker-compose](https://docs.docker.com/compose/)):

```sh
docker-compose up
```

### Run Tests

For getting service metrics run multiple times SpringBoot endpoint :

```sh
http://localhost:8080/jobs/github/1

http://localhost:8080/jobs/github/2

http://localhost:8080/jobs/github/3
```

### Influx Metrics

First, connect to the container:

```sh
docker exec -it micrometer_influxdb_1 influx
```
Into influx container, run the command:

```sh
SHOW DATABASES;
```
Next, connect to ``metrics`` database and list all metrics:

```sh
USE metrics;
SHOW MEASUREMENTS;
```
Finally, run querys for some specific ``MEASUREMENTS`` i.e:

```sh
select * from process_cpu_usage;
```

### Prometheus Metrics

Validate Prometheus is collecting SpringBoot metrics checking our endpoint ``my.local.machine`` and job ``prometheus-spring`` are running: 

```sh
http://localhost:9090/targets
```

Next, check we have Spring metrics in section ``Highest Cardinality Metric Names``: 

```sh
http://localhost:9090/status
```

Finally, query some metrics using next endpoint:

```sh
http://localhost:9090/graph
```

# Notes

- For build project in local env without docker use next command:

```sh
mvn clean package docker:build -DskipTests
```
- For osx with docker, please run next command:

```sh
sudo ifconfig lo0 alias 172.16.222.111
```


# References

- https://egkatzioura.com/2020/05/07/spring-boot-and-micrometer-with-prometheus-part-6-securing-metrics/

- https://stackabuse.com/monitoring-spring-boot-apps-with-micrometer-prometheus-and-grafana/