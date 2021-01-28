package com.example.creditcard.rest.service;

import java.util.List;

import com.example.creditcard.rest.dto.RewardDto;
import com.example.creditcard.rest.model.CreditTransaction;
import com.example.creditcard.rest.model.Customer;

public interface ICustomerService {

	public Customer get(long id);
	
	public List<Customer> getAll();
	
	public String delete(long id);
	
	public Customer update(Customer customer);
	
	public CreditTransaction update(CreditTransaction transaction);
	
	public RewardDto getRewardInfo(long id, String from, String to);
	
}
