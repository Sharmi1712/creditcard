package com.example.creditcard.rest.dto;

public class Reward {
	
	private String month;
	private int points;
	
	
	public Reward(String month, int points) {
		super();
		this.month = month;
		this.points = points;
	}
	
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((month == null) ? 0 : month.hashCode());
		result = prime * result + points;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reward other = (Reward) obj;
		if (month == null) {
			if (other.month != null)
				return false;
		} else if (!month.equals(other.month))
			return false;
		if (points != other.points)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Reward [month=" + month + ", points=" + points + "]";
	}
	
	
}
