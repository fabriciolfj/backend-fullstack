package com.nelioalves.cursomc.services.exceptions;

public class AuthorizationException extends RuntimeException{

	private static final long serialVersionUID = -7294469057899724803L;
	
	public AuthorizationException(String msg) {
		super(msg);
	}
	
	public AuthorizationException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
