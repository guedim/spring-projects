package com.payulatam.pmequalizer.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

@Entity
@Table(name = "cuenta", schema = "pps")
public class Account {

	/**
	 * The Account id
	 */
	private Integer id;

	/**
	 * The Account Creation Date
	 */
	private Date creationDate;

	/**
	 * The merchant identifier
	 */
	private Integer merchantId;

	/**
	 * The Account Balance Country ISO 3166
	 */
	private Country country;
	
	/**
	 * 
	 */
	private String description;
	
	/**
	 * 
	 */
	private String name;
	
	/**
	 * 
	 */
	private String email;

		
	/**
	 * returns the account id.
	 *
	 * @return the id
	 */
	@Id
	@Column(name = "cuenta_id", unique = true, nullable = false)
	public Integer getId() {

		return id;
	}

	/**
	 * returns the account creation date.
	 *
	 * @return the creationDate
	 */
	@Column(name = "fecha_creacion", nullable = false)
	@NotNull
	public Date getCreationDate() {

		return creationDate;
	}

	/**
	 * return the account merchant id.
	 *
	 * @return the merchantId
	 */
	@Column(name = "usuario_id", nullable = false)
	@NotNull(groups = { Default.class })
	public Integer getMerchantId() {

		return merchantId;
	}

	/**
	 * returns the account balance deposit country.
	 *
	 * @return the Country
	 */
	@Column(name = "pais_iso_3166", nullable = false, length = 3)
	@Enumerated(value = EnumType.STRING)
	public Country getCountry() {

		return country;
	}

	/**
	 * 
	 * @return
	 */
	@Column(name = "descripcion", nullable = false, length = 255)
	public String getDescription() {

		return description;
	}
	
	/**
	 * 
	 * @return
	 */
	@Column(name = "nombre", nullable = false, length = 255)
	public String getName() {

		return name;
	}

	/**
	 * 
	 * @return
	 */
	@Column(name = "email_contacto", nullable = false, length = 255)
	public String getEmail() {

		return email;
	}

	
	/**
	 * Sets the account id
	 * 
	 * @param id the account id
	 */
	public void setId(final Integer id) {

		this.id = id;
	}

	/**
	 * Set the account creation date.
	 *
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(final Date creationDate) {

		this.creationDate = creationDate;
	}

	/**
	 * Set the account merchant id.
	 *
	 * @param merchantId the merchantId to set
	 */
	public void setMerchantId(final Integer merchantId) {

		this.merchantId = merchantId;
	}

	/**
	 * Sets the account deposit currency.
	 *
	 * @param country the depositCountry to set
	 */
	public void setCountry(final Country country) {

		this.country = country;
	}
	
	/**
	 * 
	 * @return
	 */
	public void setDescription(final String description) {

		this.description = description;
	}
	
	/**
	 * 
	 * @return
	 */
	public void setName(final String name) {

		this.name = name;
	}
	
	/**
	 * 
	 * @return
	 */
	public void setEmail(final String email) {

		this.email = email;
	}
	
}