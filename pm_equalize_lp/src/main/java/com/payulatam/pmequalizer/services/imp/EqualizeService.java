package com.payulatam.pmequalizer.services.imp;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payulatam.pmequalizer.model.NotificationType;
import com.payulatam.pmequalizer.model.PmEqualizer;
import com.payulatam.pmequalizer.repositories.AccountConfigurationOptionJpaRepository;
import com.payulatam.pmequalizer.repositories.IEqualizeRepository;
import com.payulatam.pmequalizer.services.IEqualizeService;
import com.payulatam.pmequalizer.utils.EqualizeUtils;

@Service
public class EqualizeService implements IEqualizeService {
	
	private final Logger LOG = LoggerFactory.getLogger(EqualizeService.class);


    @Autowired
    private IEqualizeRepository equalizeRepository;
    
    @Autowired
    private AccountConfigurationOptionJpaRepository accountConfigRepository;


    @Override
    public PmEqualizer intializeSingleEqualize(int accountId) {
    	
    	Date date = new Date(new java.util.Date().getTime());
    	String md5 = EqualizeUtils.generateSignature(accountId, date);
    	
    	
    	LOG.info("initializing pm equalizer object for accountId {}", accountId);
        PmEqualizer pmEquailizer = new PmEqualizer(accountId, md5, date,NotificationType.EMAIL);
        
    	LOG.info("created pmEquilizer object for accountId {} with signature", accountId, pmEquailizer.getSignature());
        
    	LOG.info("saving pm equalizer object for accountId {}", accountId);
        return equalizeRepository.save(pmEquailizer);
    }


	@Override
	public void confirmPmEqualizer(Integer accountId) {
		
    	LOG.info("finding payment methods enabled for  accountId {}", accountId);
    	String pmPreviousValue = accountConfigRepository.findByAccountId(accountId).getValue();
    	
		
    	LOG.info("saving pmEnabled last value {} for accountId {}", pmPreviousValue, accountId);
    	equalizeRepository.confirmEqualize(pmPreviousValue, new Date(new java.util.Date().getTime()),accountId);
    	
	}
}
