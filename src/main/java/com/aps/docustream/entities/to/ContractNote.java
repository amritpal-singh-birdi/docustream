package com.aps.docustream.entities.to;

import java.io.Serializable;

import com.aps.docustream.entities.enums.DocumentType;
import com.aps.docustream.entities.enums.PayloadType;
import com.aps.docustream.utils.Utilites;
import com.aps.docustream.validators.PayloadTypeDetector;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ContractNote{

	private static final long serialVersionUID = -8435333156373661867L;
	
	@JsonProperty
	private Integer contractCodeNum;
	
	@JsonProperty
	private ClientDetails clientDetails;
	
	@JsonProperty
	private TradeSummary tradeSummary;
	
	@JsonProperty
	private TransactionSummary transactionSummary;
	
	public Integer getContractCodeNum() {
		return contractCodeNum;
	}

	public void setContractCodeNum(Integer contractCodeNum) {
		this.contractCodeNum = contractCodeNum;
	}

	public ClientDetails getClientDetails() {
		return clientDetails;
	}

	public void setClientDetails(ClientDetails clientDetails) {
		this.clientDetails = clientDetails;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public TradeSummary getTradeSummary() {
		return tradeSummary;
	}

	public void setTradeSummary(TradeSummary tradeSummary) {
		this.tradeSummary = tradeSummary;
	}
	
	
	public TransactionSummary getTransactionSummary() {
		return transactionSummary;
	}

	public void setTransactionSummary(TransactionSummary transactionSummary) {
		this.transactionSummary = transactionSummary;
	}

	@Override
	public String toString() {
		return "ContractNote [contractCodeNum=" + contractCodeNum + ", clientDetails=" + clientDetails
				+ ", tradeSummary=" + tradeSummary + ", transactionSummary=" + transactionSummary + "]";
	}

	/**@Override
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
**/

	
	
	
	
}
