package org.mql.java.models;

public class Parameter {
	private String type;
	public Parameter() {

	}
	public Parameter(String type) {
		super();
		this.type = type;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Parameter Type " + getType() ;
	}
	
	

}
