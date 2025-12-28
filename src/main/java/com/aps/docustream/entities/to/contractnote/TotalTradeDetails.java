package com.aps.docustream.entities.to.contractnote;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TotalTradeDetails implements Serializable {

	private static final long serialVersionUID = -7880356006557562714L;

	@JsonProperty
	private BigDecimal quantity;
	
	@JsonProperty
	private BigDecimal totalBrokerage;
	
	@JsonProperty
	private BigDecimal totalStampTax;
	
	@JsonProperty
	private BigDecimal totalOtherCharges;
	
	@JsonProperty
	private BigDecimal summaryTotal;

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotalBrokerage() {
		return totalBrokerage;
	}

	public void setTotalBrokerage(BigDecimal totalBrokerage) {
		this.totalBrokerage = totalBrokerage;
	}

	public BigDecimal getTotalStampTax() {
		return totalStampTax;
	}

	public void setTotalStampTax(BigDecimal totalStampTax) {
		this.totalStampTax = totalStampTax;
	}

	public BigDecimal getTotalOtherCharges() {
		return totalOtherCharges;
	}

	public void setTotalOtherCharges(BigDecimal totalOtherCharges) {
		this.totalOtherCharges = totalOtherCharges;
	}

	public BigDecimal getSummaryTotal() {
		return summaryTotal;
	}

	public void setSummaryTotal(BigDecimal summaryTotal) {
		this.summaryTotal = summaryTotal;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "TotalTradeDetails [quantity=" + quantity + ", totalBrokerage=" + totalBrokerage + ", totalStampTax="
				+ totalStampTax + ", totalOtherCharges=" + totalOtherCharges + ", summaryTotal=" + summaryTotal + "]";
	}
	
	
	
}
