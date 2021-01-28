package com.example.creditcard.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.creditcard.rest.dto.RewardDto;
import com.example.creditcard.rest.model.CreditTransaction;
import com.example.creditcard.rest.model.Customer;
import com.example.creditcard.rest.service.ICustomerService;

@CrossOrigin
@RestController
public class CreditCardController {

		@Autowired
		private ICustomerService service;
			
		@PostMapping("/customers")
		public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
			customer = service.update(customer);
			ResponseEntity<Customer> response = new ResponseEntity<>(customer, HttpStatus.OK);
			return response;
		}	
		
		@PostMapping("/transactions")
		public ResponseEntity<CreditTransaction> updateTransactions(@RequestBody CreditTransaction transaction) {
			CreditTransaction updated = service.update(transaction);
			ResponseEntity<CreditTransaction> response = new ResponseEntity<>(updated, HttpStatus.OK);
			return response;
		}
		
		@GetMapping("/rewards/{id}")
		@ResponseBody
		public ResponseEntity<RewardDto> getStudent(@PathVariable long id, 
				@RequestParam("from") String from,
				@RequestParam("to") String to) {
			RewardDto rewardInfo = service.getRewardInfo(id, from, to);
			ResponseEntity<RewardDto> response = new ResponseEntity<>(rewardInfo, HttpStatus.OK);
			return response;
		}	
}
