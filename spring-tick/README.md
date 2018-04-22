## Spring - tick

This example uses the [TICK stack](https://www.influxdata.com/time-series-platform/)  for monitoring and alerts.

This sample project is based on the post  [Spring boot metrics with tick stack](https://aboullaite.me/spring-boot-metrics-monitoring-using-tick-stack/).

> This is a simple project using docker swarm mode.


# Table of contents
1. [Configuration](#configuration)
    1. [Dowload project](#download)
    2. [Create the services](#services)
    3. [Chronograf Portal](#chronograf)
    6. [Take a look and fun](#end)
2. [Todos](#todos)
3. [Links](#Links)
4. [License](#license)


### Configuration<a name="configuration"></a>

1) Download the [project](https://github.com/guedim/spring-projects.git/) and go into the spring-tick  folder:<a name="download"></a>
```sh
wget https://github.com/guedim/spring-projects.git/
cd spring-projects\spring-tick
```

2) Start [TICK stack](https://www.influxdata.com/time-series-platform/)  and the spring-boot project :<a name="services"></a>
```sh
docker-componse up
```
3) Go to [Chronograf](https://docs.influxdata.com/chronograf/v1.4//) portal (http://host:8888), for example:<a name="chronograf"></a>

```sh
http://192.168.99.100:8888/
```

![Chronograf](https://github.com/guedim/spring-projects/blob/master/spring-tick/src/main/resources/static/chronograf.png "Chronograf portal")


4) Finally, you create custom dashboards and alerts:<a name="end"></a>

- Metrics for host
- Metrics for JVM 
- Metrics for spring project:

![end](https://github.com/guedim/spring-projects/blob/master/spring-tick/src/main/resources/static/sample-dashboard.png "Sample dashboards")



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
