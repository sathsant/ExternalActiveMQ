package com.springboot.activemq.standalone.config;

import javax.jms.QueueBrowser;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.region.Queue;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration

public class Config {

	@Value("${activemq.broker-url}")
	private String brokerUrl;
	
	@Bean
	public javax.jms.Queue queue(){
	return new ActiveMQQueue("standalone.queue");
	}
	
	@Bean
	public ActiveMQConnectionFactory activeMQConnectionFactory() {
	ActiveMQConnectionFactory factory=new ActiveMQConnectionFactory();
	factory.setBrokerURL(brokerUrl);
	return factory;
		}
	
	@Bean
	public JmsTemplate jmstemplate() {
		return new JmsTemplate(activeMQConnectionFactory());
		
	}
}	

