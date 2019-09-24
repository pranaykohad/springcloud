package com.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.ProxyRequestHelper;
import org.springframework.stereotype.Component;

//import com.dao.APIBillingDaoInterface;
//import com.model.APIBilling;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.service.APIBillingServiceImpl;

public class MyFilter extends ZuulFilter {
	
//	@Autowired
//	private ProxyRequestHelper helper;
//	
//	@Autowired
//	APIBillingDaoInterface billingServiceInterface;
	
	
	private static Logger LOG = LoggerFactory.getLogger(MyFilter.class);
	
	  @Override
	  public String filterType() {
	    return "pre";
	  }

	  @Override
	  public int filterOrder() {
	    return 1;
	  }

	  @Override
	  public boolean shouldFilter() {
	    return true;
	  }

	  @Override
	  public Object run() {
//		  RequestContext ctx = RequestContext.getCurrentContext();
//		  HttpServletRequest request = ctx.getRequest();
//		  if(request != null) {
//			  String uri = this.helper.buildZuulRequestURI(request);
//			  if(uri.equals("/flight-service")) {
//				  LOG.info("/flight-service hit");
//				  APIBilling billing = new APIBilling();
//				  billing.setAPIBillingId(1);
//				  billing.setApi("/flight-service");
//			      billing.setCount(1);
//				  billing.setDiscount(10);
//				  billing.setPrice(1500);
//				  billing.setTotalAmt(1250);
//				  billingServiceInterface.save(billing);
//			  }
//			  if(uri.equals("/location-service")) {
//				LOG.info("/location-service hits");
//			  }
//	       }
		   return null;
	  }
	  
}
