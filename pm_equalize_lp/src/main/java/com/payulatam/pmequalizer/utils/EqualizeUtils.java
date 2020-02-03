package com.payulatam.pmequalizer.utils;

import java.security.MessageDigest;
import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class EqualizeUtils {
	
	private final static Logger LOG = LoggerFactory.getLogger(EqualizeUtils.class);
	
    public static String generateSignature(Integer accountID, Date currentDate) {
        String value = accountID + String.valueOf(currentDate.getTime());
        System.out.println(value);
        String myHash = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(value.getBytes());
            byte[] digest = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            myHash = sb.toString();
        } catch (Exception e) {
        	LOG.error("an error ocurred generating the signature {}", e.getMessage());
        }
        return myHash;
    }
}