package com.aps.docustream.entities.to.contractnote;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TradeSummary implements Serializable {

	private static final long serialVersionUID = 2901624955731215552L;

	@JsonProperty
	private String tradeDate;
	
	@JsonProperty
	private String settlementDate;
	
	@JsonProperty
	private TradeDetails tradeDetails;

	public String getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(String tradeDate) {
		this.tradeDate = tradeDate;
	}

	public String getSettlementDate() {
		return settlementDate;
	}

	public void setSettlementDate(String settlementDate) {
		this.settlementDate = settlementDate;
	}

	public TradeDetails getTradeDetails() {
		return tradeDetails;
	}

	public void setTradeDetails(TradeDetails tradeDetails) {
		this.tradeDetails = tradeDetails;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "TradeSummary [tradeDate=" + tradeDate + ", settlementDate=" + settlementDate + ", tradeDetails="
				+ tradeDetails + "]";
	}
	
	
}
