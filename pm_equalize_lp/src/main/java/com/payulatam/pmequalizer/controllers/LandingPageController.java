package com.payulatam.pmequalizer.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.payulatam.pmequalizer.bd.PmEqualizerBusinessDelegate;

@Controller
@RequestMapping("/lp")
public class LandingPageController {
	
	private final Logger LOG = LoggerFactory.getLogger(EqualizeController.class);

	@Autowired
    PmEqualizerBusinessDelegate businessDelegate;


    @GetMapping("/{accountId}")
    public String landingPage(@PathVariable Integer accountId, @RequestParam String signature) {
    	
    	LOG.info("receiving lp request for account id {} with signature {}", accountId, signature);
    	
    	//TODO: No olvidar hacer POSTpara confirmar !!!!!!
    	//   http://localhost:8080/equlize//confirm/{accountId}
    	// @Santiago
    	// @Daniel
    	
        return "index";
    }
}
