package org.mql.java.models;

import java.util.List;
import java.util.Vector;

public class Package {
	private String source;
	private List<Property> list;

	public Package() {

	}

	public Package(String nom) {
		source = nom;
		list = new Vector<>();
	}

	public void add(Property m) {
		list.add(m);
	}

	public String getSource() {
		return source;
	}

	public void setSource(String name) {
		this.source = name;
	}

	public List<Property> getList() {
		return list;
	}

	public void setList(List<Property> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Package Name()=" + getSource() + ", List()=" + getList() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode();
	}

}
