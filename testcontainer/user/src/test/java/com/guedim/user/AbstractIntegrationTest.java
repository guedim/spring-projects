package com.guedim.user;


import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest
@ContextConfiguration(initializers = {AbstractIntegrationTest.PropertiesInitializer.class})
@Testcontainers
public abstract  class AbstractIntegrationTest {

    @Container
    private static final PostgreSQLContainer postgres = new PostgreSQLContainer("postgres:9.6.15")
            .withDatabaseName("users")
            .withUsername("postgres")
            .withPassword("password");

    @Container
    protected static final KafkaContainer kafka  = new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:5.4.3"));


    static class PropertiesInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues.of(
                    "spring.datasource.url=" + postgres.getJdbcUrl(),
                    "spring.datasource.username=" + postgres.getUsername(),
                    "spring.datasource.password=" + postgres.getPassword(),
                    ProducerConfig.BOOTSTRAP_SERVERS_CONFIG + "=" + kafka.getBootstrapServers(),
                    "spring.kafka.bootstrapAddress="  + kafka.getBootstrapServers()
            ).applyTo(configurableApplicationContext.getEnvironment());
        }
    }
}