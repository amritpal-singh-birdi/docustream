package com.aps.docustream.entities.to.contractnote;

import java.io.Serializable;
import java.util.Vector;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IndividualTradeDetails implements Serializable {

	private static final long serialVersionUID = 2275886602257885527L;
	
	@JsonProperty
	private Vector<TradeDetail> trade;

	public Vector<TradeDetail> getTrade() {
		return trade;
	}

	public void setTrade(Vector<TradeDetail> trade) {
		this.trade = trade;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "IndividualTradeDetails [trade=" + trade + "]";
	}
	
	
}
