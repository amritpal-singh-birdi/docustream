package com.aps.docustream.entities.to.contractnote;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BrokerageDetails implements Serializable {

	private static final long serialVersionUID = -2304494934084934012L;
	
	@JsonProperty
	private BigDecimal brokerage;

	public BigDecimal getBrokerage() {
		return brokerage;
	}

	public void setBrokerage(BigDecimal brokerage) {
		this.brokerage = brokerage;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "BrokerageDetails [brokerage=" + brokerage + "]";
	}
	
	

}