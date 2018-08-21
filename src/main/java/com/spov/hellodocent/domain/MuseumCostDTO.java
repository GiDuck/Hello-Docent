package com.spov.hellodocent.domain;

public class MuseumCostDTO{

	public MuseumCostDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	String epc_id;
	String epc_adult;
	String epc_teenager;
	String epc_child;
	String epc_etc;

	public String getEpc_id() {
		return epc_id;
	}

	public void setEpc_id(String epc_id) {
		this.epc_id = epc_id;
	}

	

	public String getEpc_adult() {
		return epc_adult;
	}

	public void setEpc_adult(String epc_adult) {
		this.epc_adult = epc_adult;
	}

	public String getEpc_teenager() {
		return epc_teenager;
	}

	public void setEpc_teenager(String epc_teenager) {
		this.epc_teenager = epc_teenager;
	}

	public String getEpc_child() {
		return epc_child;
	}

	public void setEpc_child(String epc_child) {
		this.epc_child = epc_child;
	}

	public String getEpc_etc() {
		return epc_etc;
	}

	public void setEpc_etc(String epc_etc) {
		this.epc_etc = epc_etc;
	}

}
