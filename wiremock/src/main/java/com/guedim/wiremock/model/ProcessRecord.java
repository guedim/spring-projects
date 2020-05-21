package com.guedim.wiremock.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Entity
@Table(name = "process_record")
public class ProcessRecord {

	// id INT PRIMARY KEY BIGINT NOT NULL AUTO_INCREMENT,
	// id SERIAL PRIMARY KEY NOT NULL,

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "process_record_id", columnDefinition = "serial")
	private Long id;
	
	@Column(name = "creation_date", columnDefinition = "DATE")
	private LocalDate creationDate;
	
	@Column(name = "merchant_id")
	private Integer merchantId;
	
	@Column(name = "value")
	private BigDecimal value;
	
	@Column(name = "process_record_state")
	@Enumerated(EnumType.STRING)
	private ProcessRecodState processRecordState;
	
	@Column(name = "fraud_state")
	@Enumerated(EnumType.STRING)
	private FraudState fraudState;
	
	@Column(name = "fraud_description")
	private String fraudDescription;
	
	@Column(name = "url_notification")
	private String urlNotification;
	
	@Column(name = "notification_http_code")
	private Integer notificationHttpCode;
}
