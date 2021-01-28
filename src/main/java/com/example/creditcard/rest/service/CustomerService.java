package com.example.creditcard.rest.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.creditcard.rest.dto.Reward;
import com.example.creditcard.rest.dto.RewardDto;
import com.example.creditcard.rest.model.CreditTransaction;
import com.example.creditcard.rest.model.Customer;
import com.example.creditcard.rest.repository.ICreditTransactionDao;
import com.example.creditcard.rest.repository.ICustomerDao;
import com.example.creditcard.rest.util.Utilities;

@Service
public class CustomerService implements ICustomerService{

	@Autowired
	private ICustomerDao customerDao;
	
	@Autowired
	private ICreditTransactionDao creditTransactionDao;
	
	
	@Override
	public Customer get(long id) {
		Optional<Customer> customer = customerDao.findById(id);
		return customer.isPresent() ? customer.get() : null;
	}

	@Override
	public String delete(long id) {
		customerDao.deleteById(id);
		return "Customer Deleted";
	}

	@Override
	public Customer update(Customer customer) {
		return customerDao.save(customer);
	}

	@Override
	public List<Customer> getAll() {
		return customerDao.findAll();
	}

	@Override
	public CreditTransaction update(CreditTransaction transaction) {
		return creditTransactionDao.save(transaction);
	}

	@Override
	public RewardDto getRewardInfo(long id, String fromStr, String toStr) {
		LocalDateTime to = StringUtils.isNotBlank(toStr) ? Utilities.convert.apply(toStr) : LocalDateTime.now();
		LocalDateTime from = StringUtils.isNotBlank(fromStr) ? Utilities.convert.apply(fromStr) : LocalDateTime.now().minusMonths(3);
		
		List<CreditTransaction> creditTransactions = creditTransactionDao.findAllCreditTransactionsByCustomerAndTimeBetween(id, from, to);
		
		if(CollectionUtils.isEmpty(creditTransactions)) {
			return RewardDto.emptyDetails(id);
		}
		Map<String, Integer> pointsMap = creditTransactions.stream()
			.map(c->Utilities.getReward.apply(c))
			.collect(Collectors.toList())
			.stream()
			.collect(Collectors.groupingBy(Reward::getMonth, Collectors.summingInt(Reward::getPoints)));
		int total = pointsMap.values().stream().collect(Collectors.summingInt(Integer::intValue));
		return new RewardDto(id,total,pointsMap, "Successfully Calculated!!" );
	}
		
}
