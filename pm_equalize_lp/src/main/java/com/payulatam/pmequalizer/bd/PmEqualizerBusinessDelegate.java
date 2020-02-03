package com.payulatam.pmequalizer.bd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.payulatam.pmequalizer.services.IEqualizeService;
import com.payulatam.pmequalizer.services.IPmGigaspacesService;

@Service
public class PmEqualizerBusinessDelegate {
	
	@Autowired
    IEqualizeService equalizeService;
	
	@Autowired
	IPmGigaspacesService pmGigaspacesService;
	
	
	public void equalizePm(Integer accountId){
		
		// validate accountId is not null
		Assert.notNull(accountId, "The accountId should not be null");
		
		// update PMEquilize with confirmation Date and Last value
		equalizeService.confirmPmEqualizer(accountId);
		
		// update GS account configuration Option
		pmGigaspacesService.equalizeSpace(accountId);
		
	}


}
