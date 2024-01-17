package org.mql.java.models;

public class ParameterModel {
	private String name;
	private String type;
	public ParameterModel() {

	}
	
	
	public ParameterModel(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}


	public ParameterModel(String type) {
		super();
		this.type = type;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return name+ " "+type;
	}
	
	

}
