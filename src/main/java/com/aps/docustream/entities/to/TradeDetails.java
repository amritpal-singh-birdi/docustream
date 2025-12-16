package com.aps.docustream.entities.to;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TradeDetails implements Serializable {

	private static final long serialVersionUID = -5653542165192360769L;

	@JsonProperty
	private IndividualTradeDetails individualTrades;
	
	@JsonProperty
	private TotalTradeDetails totalTrades;

	public IndividualTradeDetails getIndividualTrades() {
		return individualTrades;
	}

	public void setIndividualTrades(IndividualTradeDetails individualTrades) {
		this.individualTrades = individualTrades;
	}

	public TotalTradeDetails getTotalTrades() {
		return totalTrades;
	}

	public void setTotalTrades(TotalTradeDetails totalTrades) {
		this.totalTrades = totalTrades;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "TradeDetails [individualTrades=" + individualTrades + ", totalTrades=" + totalTrades + "]";
	}
	
	
	
}
