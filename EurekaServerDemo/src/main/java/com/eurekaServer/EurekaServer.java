package com.eurekaServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
@EnableEurekaServer
//@EnableZuulProxy
//@Configuration
//@EntityScan("com.model")
//@EnableJpaRepositories("com.dao")
public class EurekaServer {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServer.class, args);
		System.out.println("Eureka Server started.............................");
	}
	
//	@Bean
//	public MyFilter createMyFilter() {
//		return new MyFilter();
//	}
	
//	@Bean
//	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//	    return builder.routes()
//	    				.route(r -> r.path("/flight-service")
//								.uri("http://localhost:8081/flight"))
//	    				.build();
//}
	
}
