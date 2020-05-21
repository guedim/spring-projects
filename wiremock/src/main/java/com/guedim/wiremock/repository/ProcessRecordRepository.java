package com.guedim.wiremock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.guedim.wiremock.model.FraudState;
import com.guedim.wiremock.model.ProcessRecord;

public interface ProcessRecordRepository extends JpaRepository<ProcessRecord, Long> {
	
	@Modifying
	@Query("UPDATE ProcessRecord SET processRecordState = 'ERROR' WHERE id = :processRecordId")
	void updateErrorState(@Param("processRecordId") Long processRecordId);
	
	@Modifying
	@Query("UPDATE ProcessRecord SET fraudState = :fraudeState, fraudDescription= :fraudDescription, processRecordState = 'EVALUATED' WHERE id = :processRecordId")
	void updateEvaluated(@Param("fraudeState") FraudState fraudState, @Param("fraudDescription") String fraudDescription, @Param("processRecordId") Long processRecordId);

	@Modifying
	@Query("UPDATE ProcessRecord SET urlNotification = :urlNotification, notificationHttpCode= :notificationHttpCode, processRecordState = 'NOTIFIED' WHERE id = :processRecordId")
	void updateNotified(@Param("urlNotification") String urlNotification, @Param("notificationHttpCode") Integer notificationHttpCode, @Param("processRecordId") Long processRecordId);

}
