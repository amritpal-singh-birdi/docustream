package com.aps.docustream.entities.to.invoice;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Invoice {

	@JsonProperty
	private CompanyDetails companyDetails;
	
	@JsonProperty
	private InvoiceDetails invoiceDetails;
	
	@JsonProperty
	private Items items;

	public CompanyDetails getCompanyDetails() {
		return companyDetails;
	}

	public void setCompanyDetails(CompanyDetails companyDetails) {
		this.companyDetails = companyDetails;
	}

	public InvoiceDetails getInvoiceDetails() {
		return invoiceDetails;
	}

	public void setInvoiceDetails(InvoiceDetails invoiceDetails) {
		this.invoiceDetails = invoiceDetails;
	}

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Invoice [companyDetails=" + companyDetails + ", invoiceDetails=" + invoiceDetails + ", items=" + items
				+ "]";
	}
	
	
}
