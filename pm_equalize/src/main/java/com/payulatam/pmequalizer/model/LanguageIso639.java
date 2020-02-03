/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payulatam.com
 */
package com.payulatam.pmequalizer.model;

/**
 * The system's language according the ISO 639-1 codes. Alpha-2 code.
 * 
 * @author Mario Guerrero (mario.guerrero@payulatam.com)
 * @date 23/11/2010
 */
public enum LanguageIso639 {

	/**
	 * Spanish; Castilian
	 */
	es,

	/**
	 * English, Middle (1100-1500).
	 */
	en,

	/**
	 * Portuges.
	 */
	pt;

	/**
	 * Return an LanguageIso639 Object from the String.<br>
	 * Ex. LanguageIso639.fromString("es") return LanguageIso639.es Ex.
	 * LanguageIso639.fromString("ES") return LanguageIso639.es Ex.
	 * LanguageIso639.fromString("XX") return null
	 *
	 * @param languageIso639
	 * @return
	 */
	public static LanguageIso639 fromString(String languageIso639) {
		if (languageIso639 != null) {
			for (LanguageIso639 lang : LanguageIso639.values()) {
				if (languageIso639.equalsIgnoreCase(lang.toString())) {
					return lang;
				}
			}
		}
		return null;
	}
}