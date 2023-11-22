package com.netmaxi.emailsender.adapters;

public interface EmailSenderGateway {
	void send(String to, String subject, String body);
}
