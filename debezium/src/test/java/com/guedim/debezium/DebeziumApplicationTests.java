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

import com.guedim.debezium.elasticsearch.model.Student;
import com.guedim.debezium.elasticsearch.service.StudentService;
import com.guedim.debezium.postgres.repository.StudenRepository;
import com.guedim.debezium.utils.Operation;

@SpringBootTest
@ContextConfiguration(initializers = DebeziumApplicationTests.Initializer.class)
class DebeziumApplicationTests {
	
    private static final Network network = Network.newNetwork();

    @Autowired
    private StudenRepository studentRepository;
	
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
			// Postgres properties
			configurableApplicationContext.getEnvironment().getSystemProperties()
	          .put("spring.datasource.url", postgres.getJdbcUrl());
	        configurableApplicationContext.getEnvironment().getSystemProperties()
	          .put("spring.datasource.username", postgres.getUsername());
	        configurableApplicationContext.getEnvironment().getSystemProperties()
	          .put("spring.datasource.password", postgres.getPassword());
	        //  Postgres for debezium
			configurableApplicationContext.getEnvironment().getSystemProperties().put("student.datasource.databasename",
					postgres.getDatabaseName());
			configurableApplicationContext.getEnvironment().getSystemProperties().put("student.datasource.username",
					postgres.getUsername());
			configurableApplicationContext.getEnvironment().getSystemProperties().put("student.datasource.password",
					postgres.getPassword());
			configurableApplicationContext.getEnvironment().getSystemProperties().put("student.datasource.port",
					postgres.getFirstMappedPort());
			// Elastic
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
	public void creteStudentTest() {
		
		Student student = new Student();
		student.setId("1");
		student.setName("mario");
		student.setEmail("guedim@gmail.com");
		student.setAddress("address 122");
		
		studentRepository.save(student);
		sleep();
	}
	
	@Test
	public void updatetStudentTest() {
		
		Student student = new Student();
		student.setId("1");
		student.setName("mario upd");
		student.setEmail("guedim-upd@gmail.com");
		student.setAddress("address 122 upd");
		
		studentRepository.save(student);
		sleep();
	}
	
	@Test
	public void deleteStudentTest() {
		//studentRepository.deleteById("1");
		sleep();
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
		sleep();
	}
	
	void sleep() {
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
