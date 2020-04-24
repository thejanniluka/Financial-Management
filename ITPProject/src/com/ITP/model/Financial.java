package com.ITP.model;


public class Financial {

	private String MonthID;
	
	private int PhoneCost;

	private int WaterCost;

	private int TransportCost;

	private int ExpensesCost;

	private int Income;
	
	private int NetProfit;
	
	public Financial() {}

	public Financial(String monthID, int phoneCost, int waterCost, int transportCost, int expensesCost, int income,
			int netProfit) {
		super();
		MonthID = monthID;
		PhoneCost = phoneCost;
		WaterCost = waterCost;
		TransportCost = transportCost;
		ExpensesCost = expensesCost;
		Income = income;
		NetProfit = netProfit;
	}

	public String getMonthID() {
		return MonthID;
	}

	public void setMonthID(String monthID) {
		MonthID = monthID;
	}

	public int getPhoneCost() {
		return PhoneCost;
	}

	public void setPhoneCost(int phoneCost) {
		PhoneCost = phoneCost;
	}

	public int getWaterCost() {
		return WaterCost;
	}

	public void setWaterCost(int waterCost) {
		WaterCost = waterCost;
	}

	public int getTransportCost() {
		return TransportCost;
	}

	public void setTransportCost(int transportCost) {
		TransportCost = transportCost;
	}

	public int getExpensesCost() {
		return ExpensesCost;
	}

	public void setExpensesCost(int expensesCost) {
		ExpensesCost = expensesCost;
	}

	public int getIncome() {
		return Income;
	}

	public void setIncome(int income) {
		Income = income;
	}

	public int getNetProfit() {
		return NetProfit;
	}

	public void setNetProfit(int netProfit) {
		NetProfit = netProfit;
	}
	

	
}
