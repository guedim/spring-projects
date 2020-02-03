package com.payulatam.pmequalizer.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PmEqualizer {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "pm_equalizer_id")
	private Integer id;
	private Integer accountId;
	private String signature;
	private Date creationDate;
	private Date confirmationDate;
	private String pmPreviousValue;
	private NotificationType notificationType;

	public PmEqualizer(Integer accountId, String signature, Date creationDate, NotificationType notificationType) {
		this.accountId =  accountId;
		this.signature =  signature;
		this.creationDate = creationDate;
		this.notificationType = notificationType;
	}
}
