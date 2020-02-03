package com.payulatam.pmequalizer.bd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.payulatam.pmequalizer.model.PmEqualizer;
import com.payulatam.pmequalizer.services.IEqualizeService;
import com.payulatam.pmequalizer.services.IPmGigaspacesService;
import com.payulatam.pmequalizer.services.IPmNotifyEmailService;

@Service
public class PmEqualizerBusinessDelegate {
	
	@Autowired
    IEqualizeService equalizeService;
	
	@Autowired
	IPmNotifyEmailService pmNotifyEmailService;
	
	@Autowired
	IPmGigaspacesService pmGigaspacesService;
	
	
	public void notifyEmail(Integer accountId){
		
		// validate accountId is not null
		Assert.notNull(accountId, "The accountId should not be null");
		
		// call pmEqulizer service
		PmEqualizer pmEqualizer = equalizeService.intializeSingleEqualize(accountId);
		
		//  call pmNotifyEmailService
		pmNotifyEmailService.notifyEmail(pmEqualizer);
		
	}
	
	
	public void equalizePm(Integer accountId){
		
		// validate accountId is not null
		Assert.notNull(accountId, "The accountId should not be null");
		
		// update PMEquilize with confirmation Date and Last value
		equalizeService.confirmPmEqualizer(accountId);
		
		// update GS account configuration Option
		pmGigaspacesService.equalizeSpace(accountId);
		
	}


}
