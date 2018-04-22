## Spring - tick

This example uses the [TICK stack](https://www.influxdata.com/time-series-platform/)  for monitoring and alerts.

This sample project is based on the post  [Spring boot metrics with tick stack](https://aboullaite.me/spring-boot-metrics-monitoring-using-tick-stack/).

> This is a simple project using docker swarm mode.


# Table of contents
1. [Configuration](#configuration)
    1. [Play With Docker](#playwithdocker)
    2. [Create swarm cluster](#swarmcluster)
    3. [Get the docker compose file](#dockercompose)
    4. [Create the services](#services)
    5. [Chronograf Portal](#chronograf)
    6. [Take a look and fun](#end)
2. [Todos](#todos)
3. [Links](#Links)
4. [License](#license)


### Configuration<a name="configuration"></a>

1) Open a web browser and go to [Play With Docker](play-with-docker.com) tool:<a name="playwithdocker"></a>
```sh
https://play-with-docker.com
```

![Play With Docker](https://github.com/guedim/postgres-kafka-elastic/blob/master/resources/images/Docker5Mangers.png "Play With Docker")


2) Create one instace, however to avoid performance issues we recommend you to create a swarm cluster using the [PWD](play-with-docker.com) templates  (3 Managers and 2 Workers  or 5 Managers and no workers).<a name="swarmcluster"></a>

![Play With Docker Template](https://github.com/guedim/postgres-kafka-elastic/blob/master/resources/images/template.png "Play With Docker - Template")


3) Download the [docker-compose](https://docs.docker.com/compose/) file in the new instance created in the above step:<a name="dockercompose"></a>
```sh
wget https://raw.githubusercontent.com/guedim/spring-projects/master/spring-tick/docker-compose.yml
```

4) Start [TICK stack](https://www.influxdata.com/time-series-platform/)  services in a [Swarm Mode](https://docs.docker.com/engine/swarm/):<a name="services"></a>
```sh
docker stack deploy --compose-file docker-compose.yml spring-tick
```
5) Go to [Chronograf](https://docs.influxdata.com/chronograf/v1.4//) portal (clic in 8888 port), for example:<a name="chronograf"></a>

```sh
http://pwd10-0-7-3-3030.host2.labs.play-with-docker.com/
```

![Landoop](https://github.com/guedim/postgres-kafka-elastic/blob/master/resources/images/landoop.png "Landoop portal")


6) Finally, you create custom dashboards and alerts:<a name="end"></a>

- In the Kafka Topic
![Kafka Postgres Topic](https://github.com/guedim/postgres-kafka-elastic/blob/master/resources/images/Topic.png "Kafka Postgres topic")

- In the **dejavu**  ElasticSearch plugin:

```sh
http://192.168.99.100:9200/_plugin/dejavu
```

![ElasticSearch - Dejavu](https://github.com/guedim/postgres-kafka-elastic/blob/master/resources/images/elastic-dejavu.png "ElasticSearch - Dejavu")



### Todos<a name="todos"></a>

 - How to send metrics to other repositories
 - How to create all dashboards automatically

### Links<a name="Links"></a>

- https://micrometer.io/docs
- https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#production-ready
- https://aboullaite.me/spring-boot-metrics-monitoring-using-tick-stack/

### License<a name="license"></a>
----
MIT
