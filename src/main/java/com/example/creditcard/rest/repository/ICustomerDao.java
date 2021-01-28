package com.example.creditcard.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.creditcard.rest.model.Customer;

@Repository
public interface ICustomerDao extends JpaRepository<Customer, Long>{
	
}