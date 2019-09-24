package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.APIBillingDaoInterface;
import com.model.APIBilling;


@Service
public class APIBillingServiceImpl implements APIBillingServiceInterface{
	
	@Autowired
	APIBillingDaoInterface service;

	@Override
	public APIBilling saveAPIBilling(APIBilling aPIBilling) {
		return service.save(aPIBilling);
	}

	@Override
	public APIBilling getAPICountByAPIName(String APIName) {
		return service.findByApi(APIName);
	}

}
