package com.aps.docustream.entities.to;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionDetails implements Serializable{

	private static final long serialVersionUID = 6113272241270592079L;

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

	@Override
	public String toString() {
		return "TransactionDetails [transactions=" + transactions + "]";
	}
	
	
	
}
