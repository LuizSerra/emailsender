package com.netmaxi.emailsender.infra.ses;

import org.springframework.stereotype.Service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.netmaxi.emailsender.adapters.EmailSenderGateway;
import com.netmaxi.emailsender.core.error.EmailServiceException;

@Service
public class SesEmailSender implements EmailSenderGateway {
	
	private final AmazonSimpleEmailService amazonSimpleEmailService;
	
	public SesEmailSender(AmazonSimpleEmailService amazonSimpleEmailService) {
		this.amazonSimpleEmailService = amazonSimpleEmailService;
	}

	@Override
	public void send(String to, String subject, String body) {
		SendEmailRequest sendEmailRequest = new SendEmailRequest()
				.withSource("lserra.trade@gmail.com")
				.withDestination(new Destination().withBccAddresses(to))
				.withMessage(new Message()
						.withSubject(new Content(subject))
						.withBody(new Body().withText(new Content(body))));
		
		try {
			this.amazonSimpleEmailService.sendEmail(sendEmailRequest);
		} catch (AmazonServiceException e) {
			throw new EmailServiceException("Failure while sending email", e);
		}
	}

}
