package com.mircoservice.greetingservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping(method= RequestMethod.GET, path="/hi")
	public String sayHi() {
		String name = restTemplate.getForObject("http://NAME-SERVICE/name", String.class);
		return "Hi, " + name;
	}
}
