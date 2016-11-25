package com.ssm.pojo;

import java.util.Date;

public class Trade {
	
	private int id;
	private long cardId;
	private int type;
	private float amount;
	private Date time;
	private float charge;
	
	public Trade(long cardId,int type,float amount,Date time,float charge){
		this.cardId = cardId;
		this.type = type;
		this.amount = amount;
		this.time = time;
		this.charge = charge;
	}
	
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public float getCharge() {
		return charge;
	}
	public void setCharge(float charge) {
		this.charge = charge;
	}
	
}
