package com.payulatam.pmequalizer.repositories;

import java.sql.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.payulatam.pmequalizer.model.PmEqualizer;


public interface  IEqualizeRepository extends JpaRepository<PmEqualizer, Integer> {

	
	@Transactional
	@Modifying
	@Query("UPDATE PmEqualizer SET pmPreviousValue = :pmPreviousValue, confirmationDate = :confirmationDate WHERE accountId = :accountId")
	void confirmEqualize(
			@Param("pmPreviousValue") String pmPreviousValue,
			@Param("confirmationDate") Date confirmationDate,
			@Param("accountId") Integer accountId);
	
}
