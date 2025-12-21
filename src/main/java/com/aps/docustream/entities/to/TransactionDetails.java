package com.aps.docustream.entities.to;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionDetails implements Serializable{

	private static final long serialVersionUID = 6113272241270592079L;

	@JsonProperty
	private String orderNumber;
	
	@JsonProperty
	private Integer orderTime;
	@JsonProperty
	private Transactions transactions;

	public Transactions getTransactions() {
		return transactions;
	}

	public void setTransactions(Transactions transactions) {
		this.transactions = transactions;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Integer getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Integer orderTime) {
		this.orderTime = orderTime;
	}
	
	@Override
	public String toString() {
		return "TransactionDetails [orderNumber=" + orderNumber + ", orderTime=" + orderTime + ", transactions="
				+ transactions + "]";
	}


}
