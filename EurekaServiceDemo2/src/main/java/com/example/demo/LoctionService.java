package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication  
@EnableDiscoveryClient
public class LoctionService {

	public static void main(String[] args) {
		SpringApplication.run(LoctionService.class, args);
		System.out.println("Loction Service started.............................");
	}
	
	@RequestMapping("/location")
	public List<String> message() {
		return getLocationList();
	}
	
	 private List<String> getLocationList() {
	    	List<String> locationList = new ArrayList();
	    	locationList.add("New Delhi");
	    	locationList.add("Mumbai");
	    	locationList.add("Pune");
	    	locationList.add("Nagpur");
	    	locationList.add("Jaipur");
			return locationList;
	    	
	    }

}

