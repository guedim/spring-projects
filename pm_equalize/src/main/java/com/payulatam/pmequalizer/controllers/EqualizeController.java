package com.payulatam.pmequalizer.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payulatam.pmequalizer.bd.PmEqualizerBusinessDelegate;

/**
 * Internal request
 * @author mario.guerrero
 *
 */
@RestController
@RequestMapping("/equalize")
public class EqualizeController{
	
	private final Logger LOG = LoggerFactory.getLogger(EqualizeController.class);

	@Autowired
    PmEqualizerBusinessDelegate businessDelegate;

	
    @PostMapping("/email/{accountId}")
    public ResponseEntity<?> notify(@PathVariable Integer accountId){
        
    	LOG.info("receiving pm equilizer email post for account id {}", accountId);
    	businessDelegate.notifyEmail(accountId);
    	
    	return new ResponseEntity<>("Funciona", HttpStatus.OK);
    }
    
    @PostMapping("/confirm/{accountId}")
    public ResponseEntity<?> equalize(@PathVariable Integer accountId, @RequestBody String signature){
        
    	LOG.info("receiving pm equilizer confirmation post for account id {}", accountId);
    	businessDelegate.equalizePm(accountId);
    	
    	return new ResponseEntity<>("Funciona", HttpStatus.OK);
    }

}