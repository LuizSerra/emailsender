package com.netmaxi.emailsender.application;

import org.springframework.stereotype.Service;

import com.netmaxi.emailsender.adapters.EmailSenderGateway;
import com.netmaxi.emailsender.core.EmailSenderUC;

@Service
public class EmailSenderService implements EmailSenderUC {
	
	private final EmailSenderGateway emailSenderGateway;
	
	public EmailSenderService(EmailSenderGateway emailSenderGateway) {
		this.emailSenderGateway = emailSenderGateway;
	}


	@Override
	public void send(String to, String subject, String body) {
		this.emailSenderGateway.send(to, subject, body);		
	}

}
