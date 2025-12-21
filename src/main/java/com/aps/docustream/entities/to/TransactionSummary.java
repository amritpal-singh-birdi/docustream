package com.aps.docustream.entities.to;

import java.io.Serializable;
import java.util.Vector;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionSummary implements Serializable {

	private static final long serialVersionUID = 8321709559053729716L;

	@JsonProperty
	private Vector<TransactionDetails> transactionDetail;
	
	@JsonProperty
	private PayoutSummary payoutSummary;

	public Vector<TransactionDetails> getTransactionDetail() {
		return transactionDetail;
	}

	public void setTransactionDetail(Vector<TransactionDetails> transactionDetail) {
		this.transactionDetail = transactionDetail;
	}

	public PayoutSummary getPayoutSummary() {
		return payoutSummary;
	}

	public void setPayoutSummary(PayoutSummary payoutSummary) {
		this.payoutSummary = payoutSummary;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "TransactionSummary [transactionDetail=" + transactionDetail + ", payoutSummary=" + payoutSummary + "]";
	}
	
}
