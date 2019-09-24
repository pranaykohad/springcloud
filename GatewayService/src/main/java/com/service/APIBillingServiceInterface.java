package com.service;

import java.util.List;

import com.model.APIBilling;



public interface APIBillingServiceInterface {
	
	public APIBilling saveAPIBilling(APIBilling APIBilling);
	public APIBilling getAPICountByAPIName(String APIName);
//	public List<APIBilling> getAllAPIBilling();

}
