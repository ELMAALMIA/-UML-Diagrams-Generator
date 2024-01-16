package org.mql.java.models;

import java.util.List;

public class Method {
	private String name;
	private List<Parameter> parameters;
	private int modifier;
	private boolean isConstruct;
	private String typereturn;
	public Method() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Parameter> getParameters() {
		return parameters;
	}
	public void setParameters(List<Parameter> parameters) {
		this.parameters = parameters;
	}
	public int getModifier() {
		return modifier;
	}
	public void setModifier(int modifier) {
		this.modifier = modifier;
	}
	public boolean isConstruct() {
		return isConstruct;
	}
	public void setConstruct(boolean isConstruct) {
		this.isConstruct = isConstruct;
	}
	public String getTypereturn() {
		return typereturn;
	}
	public void setTypereturn(String typereturn) {
		this.typereturn = typereturn;
	}

	

	@Override
	public String toString() {
	
		return super.toString();
	}
}
