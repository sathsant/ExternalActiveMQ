package com.springboot.activemq.standalone.resource;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Publisher {
	
	@Autowired
	public JmsTemplate jmstemplate; 
	
	@Autowired
	Queue queue;
	
	//@GetMapping(path="/rest/publish/{message}")
	@GetMapping(path="/rest/publish/{message}")
	public String publish(@PathVariable String message) {
		
		jmstemplate.convertAndSend(queue, message);
		return "Published succesfully";
	}
	
	
	

}
