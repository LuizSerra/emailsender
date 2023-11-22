package com.netmaxi.emailsender.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netmaxi.emailsender.application.EmailSenderService;
import com.netmaxi.emailsender.core.dto.EmailRequestDTO;

@RestController
@RequestMapping("/email")
public class EmailSenderController {

	private final EmailSenderService emailSenderService;
	
	public EmailSenderController(EmailSenderService emailSenderService) {
		this.emailSenderService = emailSenderService;
	}

	@PostMapping
	public ResponseEntity<String> sendEmail(@RequestBody EmailRequestDTO emailRequestDTO) {
		try {
			this.emailSenderService.send(emailRequestDTO.to(), emailRequestDTO.subject(), emailRequestDTO.body());
			return ResponseEntity.ok("Email sent successfully!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while sending email");
		}
		
	}
	
}
