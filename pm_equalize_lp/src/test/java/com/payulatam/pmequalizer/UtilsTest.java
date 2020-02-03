package com.payulatam.pmequalizer;

import java.sql.Date;

import com.payulatam.pmequalizer.utils.EqualizeUtils;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UtilsTest {

    @Test
    public void testSignatureGeneration() {
        Date date = java.sql.Date.valueOf( "2010-01-31" );
        String md5 = EqualizeUtils.generateSignature(224225, date);
        Assert.assertEquals("8b4b2f18a0129de119a983eece484959", md5);
    }
}