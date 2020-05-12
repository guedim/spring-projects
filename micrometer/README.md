
https://egkatzioura.com/2020/05/07/spring-boot-and-micrometer-with-prometheus-part-6-securing-metrics/
https://stackabuse.com/monitoring-spring-boot-apps-with-micrometer-prometheus-and-grafana/


mvn clean package docker:build -DskipTests


docker-compose up


http://localhost:8080/actuator

http://localhost:8080/actuator/prometheus


http://localhost:9090/status

http://localhost:9090/targets