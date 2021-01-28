package com.example.creditcard.rest.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.creditcard.rest.model.CreditTransaction;

@Repository
public interface ICreditTransactionDao extends JpaRepository<CreditTransaction, Long>{
	
	//@Query(value = "SELECT c FROM CreditTransaction c WHERE c.customer.id =:customerId AND c.time BETWEEN :from AND :to")
	public List<CreditTransaction> findAllCreditTransactionsByCustomerAndTimeBetween(long customerId,LocalDateTime from, LocalDateTime to);
	
}