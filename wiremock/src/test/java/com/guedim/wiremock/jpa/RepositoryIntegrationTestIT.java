package com.guedim.wiremock.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.guedim.wiremock.model.FraudState;
import com.guedim.wiremock.model.ProcessRecodState;
import com.guedim.wiremock.model.ProcessRecord;
import com.guedim.wiremock.repository.ProcessRecordRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(initializers = RepositoryIntegrationTestIT.Initializer.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Testcontainers
public class RepositoryIntegrationTestIT {

	private static Long processId = null;

	@Autowired
	private ProcessRecordRepository repository;

	@Test
	@Order(1)
	public void findByIdTest() {
		// given when
		Optional<ProcessRecord> record = repository.findById(1L);

		// then
		assertThat(record.isPresent()).isFalse();
	}

	@Test
	@Commit
	@Order(2)
	public void createTest() throws InterruptedException {

		// given
		ProcessRecord record = ProcessRecord.builder().merchantId(1).value(BigDecimal.TEN)
				.creationDate(LocalDateTime.now()).processRecordState(ProcessRecodState.NEW).build();

		// when
		record = repository.save(record);
		Optional<ProcessRecord> newRecord = repository.findById(record.getId());
		processId = newRecord.get().getId();

		// then
		assertThat(newRecord.get().getId().equals(processId)).isTrue();
		assertThat(newRecord.get().getMerchantId().equals(1)).isTrue();
		assertThat(newRecord.get().getProcessRecordState().equals(ProcessRecodState.NEW)).isTrue();
	}

	@Test
	@Commit
	@Order(3)
	public void updateErrorTest() {

		// given -- when
		repository.updateErrorState(processId);
		
		// then
		Optional<ProcessRecord> newRecord = repository.findById(processId);
		assertThat(newRecord.get().getId().equals(processId)).isTrue();
		assertThat(newRecord.get().getProcessRecordState().equals(ProcessRecodState.ERROR)).isTrue();
	}
	
	@Test
	@Commit
	@Order(4)
	public void updateFraudTest() {

		// given
		FraudState state = FraudState.APPROVED;
		String description = "fraud description";
		
		// when
		repository.updateEvaluated(state, description, processId);
		
		// then
		Optional<ProcessRecord> newRecord = repository.findById(processId);
		assertThat(newRecord.get().getId().equals(processId)).isTrue();
		assertThat(newRecord.get().getFraudState().equals(state)).isTrue();
		assertThat(newRecord.get().getFraudDescription().equals(description)).isTrue();
		assertThat(newRecord.get().getProcessRecordState().equals(ProcessRecodState.EVALUATED)).isTrue();
	}
	
	@Test
	@Commit
	@Order(5)
	public void updateNotifiedTest() {

		// given
		String urlNotification = "http://localhost";
		Integer notificationHttpCode = 200;
		
		// when
		repository.updateNotified(urlNotification, notificationHttpCode, processId);
		
		// then
		Optional<ProcessRecord> newRecord = repository.findById(processId);
		assertThat(newRecord.get().getId().equals(processId)).isTrue();
		assertThat(newRecord.get().getUrlNotification().equals(urlNotification)).isTrue();
		assertThat(newRecord.get().getNotificationHttpCode().equals(notificationHttpCode)).isTrue();
		assertThat(newRecord.get().getProcessRecordState().equals(ProcessRecodState.NOTIFIED)).isTrue();
	}

	
	@Container
	private static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>().withDatabaseName("demo")
			.withPassword("demopassword").withUsername("demouser");

	protected static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

		@Override
		public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
			TestPropertyValues
					.of("spring.datasource.url=" + postgreSQLContainer.getJdbcUrl(),
							"spring.datasource.username=" + postgreSQLContainer.getUsername(),
							"spring.datasource.password=" + postgreSQLContainer.getPassword())
					.applyTo(configurableApplicationContext);
		}
	}
}
