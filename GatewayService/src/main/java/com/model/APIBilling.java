package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="APIBillingTable")
public class APIBilling {
	
	@Id
	private int APIBillingId;
	private String api;
	private long count;
	private long totalAmt;
	
	public int getAPIBillingId() {
		return APIBillingId;
	}
	public void setAPIBillingId(int aPIBillingId) {
		APIBillingId = aPIBillingId;
	}
	public String getApi() {
		return api;
	}
	public void setApi(String api) {
		this.api = api;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public long getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(long totalAmt) {
		this.totalAmt = totalAmt;
	}
	

}
