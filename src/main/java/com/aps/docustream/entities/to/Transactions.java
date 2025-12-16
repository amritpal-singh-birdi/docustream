package com.aps.docustream.entities.to;

import java.io.Serializable;
import java.util.Vector;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Transactions implements Serializable{

	private static final long serialVersionUID = -5734494975391395736L;
	@JsonProperty
	private Vector<Transaction> transaction;

	@JsonProperty
	public Vector<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(Vector<Transaction> transaction) {
		this.transaction = transaction;
	}

	@Override
	public String toString() {
		return "Transactions [transaction=" + transaction + "]";
	}
	
	
}
