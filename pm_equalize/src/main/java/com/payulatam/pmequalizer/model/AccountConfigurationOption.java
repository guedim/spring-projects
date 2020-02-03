package com.payulatam.pmequalizer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "pm_equalizer", schema = "pps")
public class AccountConfigurationOption {

	/** The Id of the Account Configuration Option */
	private String id;

	/** the account Configuration Valud */
	private String value;

	/** The Key of the Account Configuration Option */
	private AccountConfigurationOptionKey key;

	/** The Account Id */
	private Integer accountId;

	@Id
	@Column(name = "opcion_configuracion_cuenta_id", unique = true, nullable = false)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "valor", nullable = true)
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Column(name = "llave", length = 32)
	@Enumerated(value = EnumType.STRING)
	public AccountConfigurationOptionKey getKey() {
		return key;
	}

	public void setKey(AccountConfigurationOptionKey key) {
		this.key = key;
	}

	@Column(name = "cuenta_id")
	@NotNull
	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

}