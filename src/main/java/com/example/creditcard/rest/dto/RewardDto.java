package com.example.creditcard.rest.dto;

import java.util.Map;

public class RewardDto {
	
	private long customer;
	private int totalRewards;
	private Map<String,Integer> monthlyRewards;
	private String status;
	
	public RewardDto(long customer, int totalRewards, Map<String, Integer> monthlyRewards, String status) {
		super();
		this.customer = customer;
		this.totalRewards = totalRewards;
		this.monthlyRewards = monthlyRewards;
		this.status = status;
	}
	public RewardDto() {
	}
	public static RewardDto emptyDetails(long customerId) {
		RewardDto dto = new RewardDto();
		dto.setStatus("Np Record Found for Customer with Id : "+ customerId);
		return dto;
	}
	public long getCustomer() {
		return customer;
	}
	public void setCustomer(long customer) {
		this.customer = customer;
	}
	public int getTotalRewards() {
		return totalRewards;
	}
	public void setTotalRewards(int totalRewards) {
		this.totalRewards = totalRewards;
	}
	public Map<String, Integer> getMonthlyRewards() {
		return monthlyRewards;
	}
	public void setMonthlyRewards(Map<String, Integer> monthlyRewards) {
		this.monthlyRewards = monthlyRewards;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "RewardDto [customer=" + customer + ", totalRewards=" + totalRewards + ", monthlyRewards="
				+ monthlyRewards + ", status=" + status + "]";
	}
	
}
