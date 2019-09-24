package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication  
@EnableDiscoveryClient
public class FlightService {

	public static void main(String[] args) {
		SpringApplication.run(FlightService.class, args);
		System.out.println("Flight Service started.............................");
	}
	
	@RequestMapping("/flight")
	public List<String> message() {
		return getFlightList();
	}

    private List<String> getFlightList() {
    	List<String> flightList = new ArrayList();
    	flightList.add("NG2490");
    	flightList.add("HF7655");
    	flightList.add("NJ5876");
    	flightList.add("BA4720");
    	flightList.add("EY3758");
		return flightList;
    	
    }

}

