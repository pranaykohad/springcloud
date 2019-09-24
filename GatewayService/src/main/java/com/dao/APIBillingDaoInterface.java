package com.dao;

import org.springframework.data.repository.CrudRepository;

import com.model.APIBilling;

public interface APIBillingDaoInterface extends CrudRepository<APIBilling, Integer> {
	
	public APIBilling findByApi(String apiname);
	
}
