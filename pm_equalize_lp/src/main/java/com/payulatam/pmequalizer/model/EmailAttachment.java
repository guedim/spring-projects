/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payulatam.com
 */
package com.payulatam.pmequalizer.model;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Represents an email attachment.
 * 
 * @author Edson D. Morelo (david.morelo@payulatam.com)
 */
public class EmailAttachment implements Serializable {

	/**
	 * Serial version.
	 */
	private static final long serialVersionUID = -6278218551472929392L;

	/**
	 * Attachment content.
	 */
	private byte[] content;

	/**
	 * Name and extension of the attachment.
	 */
	private String name;

	/**
	 * Mime type of the attachment.
	 */
	private EmailMimeTypeEnum mimeType;

	/**
	 * @return attachment content
	 */
	public byte[] getContent() {
		return content;
	}

	/**
	 * Sets attachment content.
	 *
	 * @param content
	 */
	public void setContent(final byte[] content) {
		if (content == null) {
			this.content = new byte[0];
		} else {
			this.content = Arrays.copyOf(content, content.length);
		}
	}

	/**
	 * Returns the name and extension of the attachment.
	 * 
	 * @return Name and extension of the attachment.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets name and extension of the attachment.
	 *
	 * @param name
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * Returns the mime type of the attachment.
	 * 
	 * @return mime type of the attachment.
	 */
	public EmailMimeTypeEnum getMimeType() {
		return mimeType;
	}

	/**
	 * Sets mime type of the attachment.
	 *
	 * @param mimeType
	 */
	public void setMimeType(final EmailMimeTypeEnum mimeType) {
		this.mimeType = mimeType;
	}
}
