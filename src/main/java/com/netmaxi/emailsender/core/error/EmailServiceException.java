package com.netmaxi.emailsender.core.error;

public class EmailServiceException extends RuntimeException {

	private static final long serialVersionUID = -1757560388890163102L;

	public EmailServiceException(String msg){
        super(msg);
    }

    public EmailServiceException(String msg, Throwable cause){
        super(msg, cause);
    }

}
