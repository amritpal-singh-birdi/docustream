package com.aps.docustream.wrapper;

import com.aps.docustream.entities.enums.DocumentType;
import com.aps.docustream.entities.to.DocumentPayload;
import com.aps.docustream.entities.to.invoice.Invoice;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InvoiceWrapper extends DocumentPayload {

	private static final long serialVersionUID = -6331743121217413771L;

	@JsonProperty
	private Invoice invoice;
	
	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public DocumentType getDocumentType() {
		return DocumentType.INVOICE;
	}

	@Override
	public boolean isValidPayload(DocumentPayload payload) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "InvoiceWrapper [invoice=" + invoice + "]";
	}
	
	

}
