package com.aps.docustream.entities.to;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClientDetails implements Serializable{

	private static final long serialVersionUID = -9151815845896103153L;

	@JsonProperty
	private String name;
	
	@JsonProperty
	private AddressDetails address;
	
	@JsonProperty
	private String clientCode;
	
	@JsonProperty
	private String panNumber;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AddressDetails getAddress() {
		return address;
	}

	public void setAddress(AddressDetails address) {
		this.address = address;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	@Override
	public String toString() {
		return "ClientDetails [name=" + name + ", address=" + address + ", clientCode=" + clientCode + ", panNumber="
				+ panNumber + "]";
	}
	
	

}
