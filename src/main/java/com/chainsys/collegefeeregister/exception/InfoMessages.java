package com.chainsys.collegefeeregister.exception;

public class InfoMessages {

	private InfoMessages() {
		throw new IllegalStateException("Utility Class");
	}
	
	public static final String CONNECTION = "Unable to establish connection 'SERVER ERROR'";
	public static final String NOT_FOUND = "NOT FOUND";
	public static final String MAIL_ERROR="MAIL NOT SENT";
}
