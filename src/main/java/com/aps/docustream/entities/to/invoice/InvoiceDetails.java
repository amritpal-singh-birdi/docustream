package com.aps.docustream.entities.to.invoice;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InvoiceDetails implements Serializable {

	private static final long serialVersionUID = 2803131627107237958L;

	@JsonProperty
	private Integer invoiceNumber;
	
	@JsonProperty
	private String issueDate;
	
	@JsonProperty
	private String dueDate;
	
	@JsonProperty
	private BigDecimal invoiceAmount;
	
	@JsonProperty
	private String invoiceCurrency;

	public Integer getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(Integer invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public BigDecimal getInvoiceAmount() {
		return invoiceAmount;
	}

	public void setInvoiceAmount(BigDecimal invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

	public String getInvoiceCurrency() {
		return invoiceCurrency;
	}

	public void setInvoiceCurrency(String invoiceCurrency) {
		this.invoiceCurrency = invoiceCurrency;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "InvoiceDetails [invoiceNumber=" + invoiceNumber + ", issueDate=" + issueDate + ", dueDate=" + dueDate
				+ ", invoiceAmount=" + invoiceAmount + ", invoiceCurrency=" + invoiceCurrency + "]";
	}
	
	
}
