package com.aps.docustream.wrapper;

import com.aps.docustream.entities.enums.DocumentType;
import com.aps.docustream.entities.enums.PayloadType;
import com.aps.docustream.entities.to.DocumentPayload;
import com.aps.docustream.entities.to.contractnote.ContractNote;
import com.aps.docustream.validators.PayloadTypeDetector;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ContractNoteWrapper extends DocumentPayload{

	private static final long serialVersionUID = -7597031177860856311L;

	@JsonProperty
	private ContractNote contractNote;
	
	public ContractNoteWrapper(ContractNote contractNote) {
		this.contractNote = contractNote;
	}
	
	public ContractNote getContractNote() {
		return contractNote;
	}

	public void setContractNote(ContractNote contractNote) {
		this.contractNote = contractNote;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public DocumentType getDocumentType() {

		return DocumentType.CONTRACT_NOTE;
	}

	@Override
	public boolean isValidPayload(DocumentPayload payload) {

		PayloadType payloadType = PayloadTypeDetector.checkAndValidatePayloadType(payload.toString().getBytes());
		
		if(payloadType.compareTo(PayloadType.UNKNOWN) == 0) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public String toString() {
		return "ContractNoteWrapper [contractNote=" + contractNote + "]";
	}
	
	

}
