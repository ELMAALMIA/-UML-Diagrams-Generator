package org.mql.java.models;

import java.util.List;

public class Enumeration {
	private List<Attribute> valuesEnums;

	public Enumeration() {
		// TODO Auto-generated constructor stub
	}

	public List<Attribute> getValuesEnums() {
		return valuesEnums;
	}

	public void setValuesEnums(List<Attribute> valuesEnums) {
		this.valuesEnums = valuesEnums;
	}

	public void add(Attribute a) {
		valuesEnums.add(a);
	}

	public void remove(Attribute a) {
		valuesEnums.remove(a);
	}

}
