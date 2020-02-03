/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payulatam.com
 */
package com.payulatam.pmequalizer.model;

/**
 * Mime types enum.
 * 
 * http://www.webmaster-toolkit.com/mime-types.shtml
 * 
 * @author <a href="jorge.porras@pagosonline.com">Jorge D. Porras</a>
 * @version 1.0
 * 
 */
public enum EmailMimeTypeEnum {

	/**
	 * JPEG image file
	 */
	IMAGE_JPEG("image/jpeg", "jpeg"),

	/**
	 * PDF file
	 */
	PDF("application/pdf", "pdf"),

	/**
	 * TXT file
	 */
	TXT("text/plain", "txt"),

	/**
	 * ZIP file.
	 */
	ZIP("application/zip", "zip");

	/**
	 * The MIME type definition.
	 */
	private String mimeTypeDefinition;

	/**
	 * The extensions.
	 */
	private String[] extensions;

	/**
	 * Creates a new enum instance
	 * 
	 * @param mimeTypeDefinition
	 * @param extensions         Supported extensions
	 */
	private EmailMimeTypeEnum(final String mimeTypeDefinition, final String... extensions) {
		this.mimeTypeDefinition = mimeTypeDefinition;
		this.extensions = extensions;
	}

	/**
	 * Gets the mime type definition.
	 *
	 * @return the mime type definition
	 */
	public String getMimeTypeDefinition() {
		return mimeTypeDefinition;
	}

	/**
	 * Gets the extensions.
	 *
	 * @return the extensions
	 */
	public String[] getExtensions() {
		return extensions;
	}
	
}