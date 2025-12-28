package com.aps.docustream.entities.to.invoice;

import java.io.Serializable;
import java.util.List;

public class Items implements Serializable {

	private static final long serialVersionUID = -940865211835064657L;

	private List<Item> item;

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Items [item=" + item + "]";
	}
	
	
}
