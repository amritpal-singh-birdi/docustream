package com.aps.docustream.entities.to.contractnote;

import java.io.Serializable;
import java.math.BigDecimal;

import com.aps.docustream.entities.enums.TradeType;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Transaction implements Serializable {

	private static final long serialVersionUID = -3527871030049198236L;

	@JsonProperty
	private Integer tradeNumber;
	
	@JsonProperty
	private Integer tradeTime;
	
	@JsonProperty
	private String securityName;
	
	@JsonProperty
	private String securityIsin;
	
	@JsonProperty
	private TradeType tradeType;
	
	@JsonProperty
	private BigDecimal quantity;
	
	@JsonProperty
	private BigDecimal rate;
	
	@JsonProperty
	private BigDecimal netTotal;
	
	@JsonProperty
	private BrokerageDetails brokerageDetails;

	public Integer getTradeNumber() {
		return tradeNumber;
	}

	public void setTradeNumber(Integer tradeNumber) {
		this.tradeNumber = tradeNumber;
	}

	public Integer getTradeTime() {
		return tradeTime;
	}

	public void setTradeTime(Integer tradeTime) {
		this.tradeTime = tradeTime;
	}

	public String getSecurityName() {
		return securityName;
	}

	public void setSecurityName(String securityName) {
		this.securityName = securityName;
	}

	public String getSecurityIsin() {
		return securityIsin;
	}

	public void setSecurityIsin(String securityIsin) {
		this.securityIsin = securityIsin;
	}

	public TradeType getTradeType() {
		return tradeType;
	}

	public void setTradeType(TradeType tradeType) {
		this.tradeType = tradeType;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public BigDecimal getNetTotal() {
		return netTotal;
	}

	public void setNetTotal(BigDecimal netTotal) {
		this.netTotal = netTotal;
	}

	public BrokerageDetails getBrokerageDetails() {
		return brokerageDetails;
	}

	public void setBrokerageDetails(BrokerageDetails brokerageDetails) {
		this.brokerageDetails = brokerageDetails;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Transaction [tradeNumber=" + tradeNumber + ", tradeTime=" + tradeTime + ", securityName=" + securityName
				+ ", securityIsin=" + securityIsin + ", tradeType=" + tradeType + ", quantity=" + quantity + ", rate="
				+ rate + ", netTotal=" + netTotal + ", brokerageDetails=" + brokerageDetails + "]";
	}
	
	
	
}
