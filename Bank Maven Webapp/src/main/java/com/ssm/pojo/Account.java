package com.ssm.pojo;

public class Account {
	
	private int id;
	private long cardId;
	private int userId;
	private int bankId;
	private String password;
	private float balance;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getCardId() {
		return cardId;
	}
	public void setCardId(long cardId) {
		this.cardId = cardId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBankId() {
		return bankId;
	}
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}

}
