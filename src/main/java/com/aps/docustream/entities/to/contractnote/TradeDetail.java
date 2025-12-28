package com.aps.docustream.entities.to.contractnote;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TradeDetail implements Serializable{

	private static final long serialVersionUID = -5279252753358430590L;

	@JsonProperty
	private String segment;
	
	@JsonProperty
	private String tradeType;
	
	@JsonProperty
	private Integer tradeQuantity;
	
	@JsonProperty
	private BigDecimal marketRate;
	
	@JsonProperty
	private BigDecimal brokerage;
	
	@JsonProperty
	private BigDecimal stampTax;
	
	@JsonProperty
	private BigDecimal otherCharge;
	
	@JsonProperty
	private BigDecimal total;

	public String getSegment() {
		return segment;
	}

	public void setSegment(String segment) {
		this.segment = segment;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public BigDecimal getMarketRate() {
		return marketRate;
	}

	public void setMarketRate(BigDecimal marketRate) {
		this.marketRate = marketRate;
	}

	public BigDecimal getBrokerage() {
		return brokerage;
	}

	public void setBrokerage(BigDecimal brokerage) {
		this.brokerage = brokerage;
	}

	public BigDecimal getStampTax() {
		return stampTax;
	}

	public void setStampTax(BigDecimal stampTax) {
		this.stampTax = stampTax;
	}

	public BigDecimal getOtherCharge() {
		return otherCharge;
	}

	public void setOtherCharge(BigDecimal otherCharge) {
		this.otherCharge = otherCharge;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "TradeDetail [segment=" + segment + ", tradeType=" + tradeType + ", marketRate=" + marketRate
				+ ", brokerage=" + brokerage + ", stampTax=" + stampTax + ", otherCharge=" + otherCharge + ", total="
				+ total + "]";
	}
	
	
	
}
