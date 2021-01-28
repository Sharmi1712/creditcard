package com.example.creditcard.rest.util;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.BiFunction;
import java.util.function.Function;

import com.example.creditcard.rest.dto.Reward;
import com.example.creditcard.rest.model.CreditTransaction;

public class Utilities {
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	private static BigDecimal hundred = new BigDecimal(100);
	private static BigDecimal fifty = new BigDecimal(50);
	
	public static Function<String, LocalDateTime> convert = (dt)-> LocalDateTime.parse(dt, formatter);
	
	public static BiFunction<String, String,LocalDateTime> getLocalDateTime = (dt, format) ->{
		return LocalDateTime.parse(dt, DateTimeFormatter.ofPattern(format));
	};
	
	public static final Function<BigDecimal, Integer>  getRewards_100 = (amt) ->{
		if(amt == null || BigDecimal.ZERO.compareTo(amt) >=0) {
			return 0;
		}
		return (amt.remainder(hundred)).intValue();
	};
	
	public static final BiFunction<BigDecimal, Integer, Integer>  getRewards_50 = (amt, points) ->{
		if(amt == null || BigDecimal.ZERO.compareTo(amt) >=0) {
			return 0;
		}
		BigDecimal effectiveAmt = amt.subtract(fifty);
		if(BigDecimal.ZERO.compareTo(effectiveAmt) >= 0) {
			return 0;
		}
		effectiveAmt  = effectiveAmt.subtract(new BigDecimal(points));
		if(BigDecimal.ZERO.compareTo(effectiveAmt) >= 0) {
			return 0;
		}
		return effectiveAmt.intValue();
	};
	
	public static final Function<CreditTransaction, Reward> getReward = (ct) -> {
		int points_100 = getRewards_100.apply(ct.getAmount());
		int points_50 = getRewards_50.apply(ct.getAmount(), points_100);
		int total = points_100+points_50;
		return new Reward(ct.getTime().getMonth().toString(), total);
	};
}
