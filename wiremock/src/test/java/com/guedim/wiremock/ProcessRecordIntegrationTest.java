package com.guedim.wiremock;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.ClassRule;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.PostgreSQLContainer;

import com.guedim.wiremock.model.ProcessRecodState;
import com.guedim.wiremock.model.ProcessRecord;
import com.guedim.wiremock.repository.ProcessRecordRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(initializers = ProcessRecordIntegrationTest.Initializer.class)
public class ProcessRecordIntegrationTest {

	@Autowired
	private ProcessRecordRepository repository;

	@Test
    @Order(1)
	public void findByIdTest() {
		Optional<ProcessRecord> record = repository.findById(1L);
		assertThat(record.isPresent()).isFalse();
	}
	
	@Test
    @Order(2)
	public void crudTest() throws InterruptedException {
		ProcessRecord record =  ProcessRecord.builder().merchantId(1).value(BigDecimal.TEN).creationDate(LocalDateTime.now()).processRecordState(ProcessRecodState.NEW).build();
		
		ProcessRecord result =   record = repository.save(record);
		Optional<ProcessRecord> newRecord =  repository.findById(record.getId());

		assertThat(result.getMerchantId().equals(1)).isTrue();
		
		repository.updateErrorState(newRecord.get().getId());
		
		//repository.updateEvaluated(FraudState.APPROVED, "fraudDescription", newRecord.get().getId());
		
		//repository.updateNotified("urlNotification", 200, newRecord.get().getId());
		
		Thread.sleep(1000);
		
		Optional<ProcessRecord> finalRecord =  repository.findById(newRecord.get().getId());
		
		Thread.sleep(1000);
		
		//System.out.println(finalRecord.get());

	}
	
	@Test
    @Order(3)
	public void findTest() throws InterruptedException {
		Optional<ProcessRecord> finalRecord =  repository.findById(1L);
		
		Thread.sleep(1000);
		
		System.out.println(finalRecord.get());
	}
	

	@ClassRule
	public static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer().withDatabaseName("demo")
			.withPassword("demopassword").withUsername("demouser");

	public static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
		@Override
		public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
			postgreSQLContainer.start();
			configurableApplicationContext.getEnvironment().getSystemProperties().put("spring.datasource.url",
					postgreSQLContainer.getJdbcUrl());
			configurableApplicationContext.getEnvironment().getSystemProperties().put("spring.datasource.username",
					postgreSQLContainer.getUsername());
			configurableApplicationContext.getEnvironment().getSystemProperties().put("spring.datasource.password",
					postgreSQLContainer.getPassword());

		}
	}
}
