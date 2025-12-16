package com.aps.docustream.entities.to;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContractNote implements Serializable{

	private static final long serialVersionUID = -8435333156373661867L;
	
	@JsonProperty
	private Integer contractCodeNum;
	
	@JsonProperty
	private ClientDetails clientDetails;

	private TradeSummary tradeSummary;
	
	private TransactionSummary transactionSummary;
	
	public Integer getContractCodeNum() {
		return contractCodeNum;
	}

	public void setContractCodeNum(Integer contractCodeNum) {
		this.contractCodeNum = contractCodeNum;
	}

	public ClientDetails getClientDetails() {
		return clientDetails;
	}

	public void setClientDetails(ClientDetails clientDetails) {
		this.clientDetails = clientDetails;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ContractNote [contractCodeNum=" + contractCodeNum + ", clientDetails=" + clientDetails + "]";
	}
	
	
	
}
