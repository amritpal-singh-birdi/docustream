package com.aps.docustream.entities.to;

import java.io.Serializable;

import com.aps.docustream.entities.enums.DocumentType;
import com.aps.docustream.wrapper.ContractNoteWrapper;
import com.aps.docustream.wrapper.InvoiceWrapper;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import io.swagger.v3.oas.annotations.media.DiscriminatorMapping;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
		description = "",
		discriminatorProperty = "type",
		discriminatorMapping = {
				@DiscriminatorMapping(value = "CONTRACT_NOTE", schema = ContractNoteWrapper.class),
				@DiscriminatorMapping(value = "INVOICE", schema = InvoiceWrapper.class)
		}
		
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY,property = "type")
@JsonSubTypes({
	@JsonSubTypes.Type(value = ContractNoteWrapper.class, name = "CONTRACT_NOTE"),
	@JsonSubTypes.Type(value = InvoiceWrapper.class, name = "INVOICE")
})
public abstract class DocumentPayload implements Serializable{

	private static final long serialVersionUID = -4616327612415784245L;

	public abstract DocumentType getDocumentType();
	
	public abstract boolean isValidPayload(DocumentPayload payload);

}
