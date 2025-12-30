package com.aps.docustream.entities.to;

import java.io.Serializable;

import com.aps.docustream.entities.enums.DocumentType;
import com.aps.docustream.entities.enums.RendererType;
import com.aps.docustream.wrapper.ContractNoteWrapper;
import com.aps.docustream.wrapper.InvoiceWrapper;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import io.swagger.v3.oas.annotations.media.DiscriminatorMapping;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
		description = "",
		discriminatorProperty = "type",
		discriminatorMapping = {
				@DiscriminatorMapping(value = "INVOICE", schema = InvoiceWrapper.class),
				@DiscriminatorMapping(value = "CONTRACT_NOTE", schema = ContractNoteWrapper.class)
		}
		
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY,property = "type")
@JsonSubTypes({
	@JsonSubTypes.Type(value = InvoiceWrapper.class, name = "INVOICE"),
	@JsonSubTypes.Type(value = ContractNoteWrapper.class, name = "CONTRACT_NOTE")
})
public abstract class DocumentPayload implements Serializable{

	private static final long serialVersionUID = -4616327612415784245L;

	@JsonProperty
	private RendererType renderer;
	
	@JsonProperty
	private String version; 
	
	@JsonProperty
	private DocumentType type;
	
	public DocumentType getDocumentType() {
		return type != null ? type : DocumentType.CONTRACT_NOTE;
	}
	
	public abstract boolean isValidPayload(DocumentPayload payload);

	public RendererType getPreferredRenderer() {
		return renderer != null ? renderer : RendererType.XSL_FO;
		
	}
	
	public String getVersion() {
		return version != null ? version : "v1.0";
	}
}
