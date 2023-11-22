package com.netmaxi.emailsender.infra.ses;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;

@Configuration
public class AwsSesConfig {
	
	@Value("${region}")
	String region;
	
	@Value("${accessKeyId}")
	String accessKey;
	
	@Value("${secretKey}")
	String secretKey;
	
	

    @Bean
    AmazonSimpleEmailService amazonSimpleEmailService() {
		return AmazonSimpleEmailServiceClientBuilder.standard()
				.withRegion(region)
				.withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey)))
				.build();
	}
	
}
