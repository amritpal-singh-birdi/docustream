package com.aps.docustream.entities.to;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressDetails implements Serializable{

	private static final long serialVersionUID = -4211113376237329224L;
	
	@JsonProperty
	private String addressLine1;
	
	@JsonProperty
	private String addressLine2;
	
	@JsonProperty
	private String addressLine3;
	
	@JsonProperty
	private String city;
	
	@JsonProperty
	private String state;
	
	@JsonProperty
	private String postCode;
	
	@JsonProperty
	private String country;

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "AddressDetails [addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", addressLine3="
				+ addressLine3 + ", city=" + city + ", state=" + state + ", postCode=" + postCode + ", country="
				+ country + "]";
	}
	
	

}
