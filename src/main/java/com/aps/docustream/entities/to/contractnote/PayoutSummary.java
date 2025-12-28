package com.aps.docustream.entities.to.contractnote;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PayoutSummary implements Serializable{
	
	private static final long serialVersionUID = -6515248679201417959L;

	@JsonProperty
	private String exchangeSegment;
	
	@JsonProperty
	private BigDecimal grossAmount;
	
	@JsonProperty
	private BigDecimal securitiesTransactionTax;
	
	@JsonProperty
	private BigDecimal taxableValue;
	
	@JsonProperty
	private BigDecimal cgst;
	
	@JsonProperty
	private BigDecimal sgst;
	
	@JsonProperty
	private BigDecimal exchangeTransactionCharges;
	
	@JsonProperty
	private BigDecimal sebiFees;
	
	@JsonProperty
	private BigDecimal stampTax;
	
	@JsonProperty
	private BigDecimal ipfCharges;
	
	@JsonProperty
	private BigDecimal auctionOrOtherCharges;
	
	@JsonProperty
	private BigDecimal netAmount;

	public String getExchangeSegment() {
		return exchangeSegment;
	}

	public void setExchangeSegment(String exchangeSegment) {
		this.exchangeSegment = exchangeSegment;
	}

	public BigDecimal getGrossAmount() {
		return grossAmount;
	}

	public void setGrossAmount(BigDecimal grossAmount) {
		this.grossAmount = grossAmount;
	}

	public BigDecimal getSecuritiesTransactionTax() {
		return securitiesTransactionTax;
	}

	public void setSecuritiesTransactionTax(BigDecimal securitiesTransactionTax) {
		this.securitiesTransactionTax = securitiesTransactionTax;
	}

	public BigDecimal getTaxableValue() {
		return taxableValue;
	}

	public void setTaxableValue(BigDecimal taxableValue) {
		this.taxableValue = taxableValue;
	}

	public BigDecimal getCgst() {
		return cgst;
	}

	public void setCgst(BigDecimal cgst) {
		this.cgst = cgst;
	}

	public BigDecimal getSgst() {
		return sgst;
	}

	public void setSgst(BigDecimal sgst) {
		this.sgst = sgst;
	}

	public BigDecimal getExchangeTransactionCharges() {
		return exchangeTransactionCharges;
	}

	public void setExchangeTransactionCharges(BigDecimal exchangeTransactionCharges) {
		this.exchangeTransactionCharges = exchangeTransactionCharges;
	}

	public BigDecimal getSebiFees() {
		return sebiFees;
	}

	public void setSebiFees(BigDecimal sebiFees) {
		this.sebiFees = sebiFees;
	}

	public BigDecimal getStampTax() {
		return stampTax;
	}

	public void setStampTax(BigDecimal stampTax) {
		this.stampTax = stampTax;
	}

	public BigDecimal getIpfCharges() {
		return ipfCharges;
	}

	public void setIpfCharges(BigDecimal ipfCharges) {
		this.ipfCharges = ipfCharges;
	}

	public BigDecimal getAuctionOrOtherCharges() {
		return auctionOrOtherCharges;
	}

	public void setAuctionOrOtherCharges(BigDecimal auctionOrOtherCharges) {
		this.auctionOrOtherCharges = auctionOrOtherCharges;
	}

	public BigDecimal getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(BigDecimal netAmount) {
		this.netAmount = netAmount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "PayoutSummary [exchangeSegment=" + exchangeSegment + ", grossAmount=" + grossAmount
				+ ", securitiesTransactionTax=" + securitiesTransactionTax + ", taxableValue=" + taxableValue
				+ ", cgst=" + cgst + ", sgst=" + sgst + ", exchangeTransactionCharges=" + exchangeTransactionCharges
				+ ", sebiFees=" + sebiFees + ", stampTax=" + stampTax + ", ipfCharges=" + ipfCharges
				+ ", auctionOrOtherCharges=" + auctionOrOtherCharges + ", netAmount=" + netAmount + "]";
	}
	
	

}
