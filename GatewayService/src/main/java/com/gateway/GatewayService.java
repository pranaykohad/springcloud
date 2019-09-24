package com.gateway;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.APIBilling;
import com.service.APIBillingServiceImpl;
import com.service.APIBillingServiceInterface;

import reactor.core.publisher.Mono;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com")
@EntityScan("com.model")
@EnableJpaRepositories("com.dao")
@RestController
public class GatewayService {
	
	@Autowired
	APIBillingServiceInterface apiBillingService;
	
	private static int PRICE_PER_API_HIT = 10;

	public static void main(String[] args) {
		SpringApplication.run(GatewayService.class, args);
		System.out.println("GatewayService started................");
	}
	
	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("/flight", r -> r.path("/flight")
						.uri("http://localhost:8081/flight"))
				.route("/location", r -> r.path("/location")
						.uri("http://localhost:8082/location"))
			    .build();
	}
	
	@Bean
	@Order(1)
	public GlobalFilter a() {
	    return (exchange, chain) -> {
	    	ServerHttpRequest request = exchange.getRequest();
	    		if(request.getURI().toString().contains("/flight")) {
	    			String api = "/flight";
	    			//logAPICount("/flight",1);
	    			System.out.println("flight count is logged");
	    		}
	    		if(request.getURI().toString().contains("/location")) {
	    			//logAPICount("/location",2);
	    			System.out.println("location count is logged");
	    		}
	    
	    		return chain.filter(exchange).then(Mono.fromRunnable(() -> {
	               
	            }));
	    };
	}

	private void logAPICount(String api, int id) {
		APIBilling billing = new APIBilling();
		billing.setAPIBillingId(id);
		billing.setApi(api);
		billing.setCount(0);
		billing.setTotalAmt(0);
		apiBillingService.saveAPIBilling(billing);
	}
	
	
	//http://localhost:8080/totalamount?apiname=/flight
	//http://localhost:8080/totalamount?apiname=/location
	@RequestMapping("/totalamount")
	public long getAPITotalAmount(@RequestParam("apiname") String apiname) {
		long APIcount = getAPICount(apiname);
		long diccountPercent = calculateDiscountPercent(APIcount);
		long netAmt = PRICE_PER_API_HIT * APIcount;
		long discount = 0;
		if(diccountPercent != 0) {
			discount = diccountPercent * (netAmt/100); 
		}
		return netAmt - discount;
		
	}
	
	/**
	 * 
	 * for 0 to 100 => 0%
	 * for 100 to 200 => 2%
	 * for 200 to 500 => 3%
	 * for 500+ => 5%
	 */

	private long calculateDiscountPercent(long count) {
		long percent = 0;
		if(count > 100) {
			percent = 2;
		}
		if(count > 200) {
			percent = 3;
		}
		if(count > 500) {
			percent = 5;
		}
		return percent;
	}

	private long getAPICount(String apiname) {
		return apiBillingService.getAPICountByAPIName(apiname).getCount();
	}

}
