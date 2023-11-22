package com.netmaxi.emailsender.core;

public interface EmailSenderUC {

	void send(String to, String subject, String body);
}
