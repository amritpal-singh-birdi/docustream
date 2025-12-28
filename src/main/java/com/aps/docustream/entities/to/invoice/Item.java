package com.aps.docustream.entities.to.invoice;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item implements Serializable {

	private static final long serialVersionUID = 6258616956677746854L;

	@JsonProperty
	private String description;
	
	@JsonProperty
	private BigDecimal unitPrice;
	
	@JsonProperty
	private String unitPriceCurrency;
	
	@JsonProperty
	private Integer quantity;
	
	@JsonProperty
	private BigDecimal itemAmount;
	
	@JsonProperty
	private String itemAmountCurrency;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getUnitPriceCurrency() {
		return unitPriceCurrency;
	}

	public void setUnitPriceCurrency(String unitPriceCurrency) {
		this.unitPriceCurrency = unitPriceCurrency;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getItemAmount() {
		return itemAmount;
	}

	public void setItemAmount(BigDecimal itemAmount) {
		this.itemAmount = itemAmount;
	}

	public String getItemAmountCurrency() {
		return itemAmountCurrency;
	}

	public void setItemAmountCurrency(String itemAmountCurrency) {
		this.itemAmountCurrency = itemAmountCurrency;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Item [description=" + description + ", unitPrice=" + unitPrice + ", unitPriceCurrency="
				+ unitPriceCurrency + ", quantity=" + quantity + ", itemAmount=" + itemAmount + ", itemAmountCurrency="
				+ itemAmountCurrency + "]";
	}
	
	
	
}
