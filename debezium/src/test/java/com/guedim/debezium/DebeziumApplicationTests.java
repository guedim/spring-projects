package com.guedim.debezium;

import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.Network;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.elasticsearch.ElasticsearchContainer;

import com.guedim.debezium.elasticsearch.service.StudentService;
import com.guedim.debezium.utils.Operation;

@SpringBootTest
@ContextConfiguration(initializers = DebeziumApplicationTests.Initializer.class)
class DebeziumApplicationTests {
	
    private static final Network network = Network.newNetwork();

	
	
	@Autowired
	private StudentService studentService;

	@ClassRule
	public static PostgreSQLContainer postgres = new PostgreSQLContainer<>(
			"debezium/postgres")
			.withDatabaseName("studentdb")
			.withPassword("password")
			.withUsername("user")
			.withNetwork(network)
            .withNetworkAliases("postgres-alias");;

	@ClassRule
	public static ElasticsearchContainer es = new ElasticsearchContainer(
			"docker.elastic.co/elasticsearch/elasticsearch:6.8.1")
			.withEnv("discovery.type","single-node")
			.withNetwork(network)
            .withNetworkAliases("es-alias")
            .dependsOn(postgres);
	
	public static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
		@Override
		public void initialize(@NotNull ConfigurableApplicationContext configurableApplicationContext) {

			postgres.start();
			configurableApplicationContext.getEnvironment().getSystemProperties().put("student.datasource.databasename",
					postgres.getDatabaseName());
			configurableApplicationContext.getEnvironment().getSystemProperties().put("student.datasource.username",
					postgres.getUsername());
			configurableApplicationContext.getEnvironment().getSystemProperties().put("student.datasource.password",
					postgres.getPassword());
			configurableApplicationContext.getEnvironment().getSystemProperties().put("student.datasource.port",
					postgres.getFirstMappedPort());
			
			es.start();
			String str = es.getHttpHostAddress(); 
	        String[] arrOfStr = str.split(":", 2); 
	        configurableApplicationContext.getEnvironment().getSystemProperties().put("elasticsearch.host",
					arrOfStr[0]);
			configurableApplicationContext.getEnvironment().getSystemProperties().put("elasticsearch.port",
					arrOfStr[1]);
		}
	}

	@Test
	void esTest() throws InterruptedException {
		Map<String, Object> studentData = new HashMap<String, Object>();
		studentData.put("id","1");
		studentData.put("name","mario");
		studentData.put("address","my direction");
		studentData.put("email","guedim@gmail.com");
		studentService.maintainReadModel(studentData, Operation.CREATE);
		studentService.maintainReadModel(studentData, Operation.UPDATE);
		studentService.maintainReadModel(studentData, Operation.DELETE);
		Thread.sleep(999999999999L);
	}

}
