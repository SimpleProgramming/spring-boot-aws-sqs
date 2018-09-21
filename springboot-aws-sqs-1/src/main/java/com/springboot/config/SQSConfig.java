package com.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;

@Configuration
public class SQSConfig {

	@Value("${cloud.aws.region.static}")
	private String region;

	@Value("${cloud.aws.credentials.access-key}")
	private String awsAccessKey;

	@Value("${cloud.aws.credentials.secret-key}")
	private String awsSecretKey;

	@Bean
	public QueueMessagingTemplate queueMessagingTemplate() {
		return new QueueMessagingTemplate(amazonSQSAsync());
	}

	public AmazonSQSAsync amazonSQSAsync() {
		return AmazonSQSAsyncClientBuilder.standard().withRegion(Regions.US_EAST_1)
				.withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsAccessKey, awsSecretKey)))
				.build();
	}
	
//	@Bean
//	public SimpleMessageListenerContainer simpleMessageListenerContainer() {
//	    SimpleMessageListenerContainer msgListenerContainer = simpleMessageListenerContainerFactory()
//	            .createSimpleMessageListenerContainer();
//	    msgListenerContainer.setMessageHandler(queueMessageHandler());
//	    return msgListenerContainer;
//	}
//
//	@Bean
//	public SimpleMessageListenerContainerFactory simpleMessageListenerContainerFactory() {
//	    SimpleMessageListenerContainerFactory msgListenerContainerFactory = new SimpleMessageListenerContainerFactory();
//	    msgListenerContainerFactory.setAmazonSqs(amazonSQSAsync());
//	    return msgListenerContainerFactory;
//	}
//
//	@Bean
//	public QueueMessageHandler queueMessageHandler() {
//	    QueueMessageHandlerFactory queueMsgHandlerFactory = new QueueMessageHandlerFactory();
//	    queueMsgHandlerFactory.setAmazonSqs(amazonSQSAsync());
//	    QueueMessageHandler queueMessageHandler = queueMsgHandlerFactory.createQueueMessageHandler();
//	    List<HandlerMethodArgumentResolver> list = new ArrayList<>();
//	    HandlerMethodArgumentResolver resolver = new PayloadArgumentResolver(new MappingJackson2MessageConverter());
//	    list.add(resolver);
//	    queueMessageHandler.setArgumentResolvers(list);
//	    return queueMessageHandler;
//	}
}