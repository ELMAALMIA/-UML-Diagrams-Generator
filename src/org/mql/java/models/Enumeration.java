package org.mql.java.models;

import java.util.List;
import java.util.Vector;

public class Enumeration {

	private String name;
	private List<String> valuesEnum;

	public Enumeration(Class<?> classe) {

		name = classe.getSimpleName();

		valuesEnum = new Vector<>();

		for (Object value : classe.getEnumConstants()) {
			valuesEnum.add(value.toString());
		}
	}

	public String getName() {
		return name;
	}

	public List<String> getValuesEnum() {
		return valuesEnum;
	}
	

	@Override
	public String toString() {
		return "enumeration : " + name;
	}
}
