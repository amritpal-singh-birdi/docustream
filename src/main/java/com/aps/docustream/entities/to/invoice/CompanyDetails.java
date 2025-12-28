package com.aps.docustream.entities.to.invoice;

import java.io.Serializable;

public class CompanyDetails implements Serializable {

	private static final long serialVersionUID = -408656175839677290L;
	
	private String companyName;
	
	private Address address;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "CompanyDetails [companyName=" + companyName + ", address=" + address + "]";
	}
	
	

}
