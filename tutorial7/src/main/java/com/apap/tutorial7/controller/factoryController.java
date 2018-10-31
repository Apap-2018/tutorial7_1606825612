package com.apap.tutorial7.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.apap.tutorial7.rest.Setting;

@RestController
public class FactoryController {
	
	//tutorial7
	@Autowired
	private RestTemplate restTemplate;
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@GetMapping(value = "/model/{namaFactory}")
	 private ResponseEntity<String> getStatus(@PathVariable ("namaFactory") String factory) throws Exception {
	  String path = Setting.factoryUrl+"&factory="+factory+"&year="+ Calendar.getInstance().get(Calendar.YEAR);
	  System.out.println(path);
	  ResponseEntity<String> response = restTemplate.getForEntity(path, String.class);
	  return response;
	 }
}
