package org.mql.java.models;

import java.util.List;

public class Enumeration {
	private String name;
	private List<Method> methods;
	private String parent;
	private List<Class> interfacesImp;
	protected List<Property> properties;
	private List<Attribute> attributes;

	public Enumeration() {
		// TODO Auto-generated constructor stub
	}
	

	public Enumeration(String name, List<Method> methods, String parent, List<Class> interfacesImp,
			List<Property> properties, List<Attribute> attributes) {
		super();
		this.name = name;
		this.methods = methods;
		this.parent = parent;
		this.interfacesImp = interfacesImp;
		this.properties = properties;
		this.attributes = attributes;
	}


	public Enumeration(String name) {
		super();
		this.name = name;
	}


	public List<Attribute> getValuesEnums() {
		return attributes;
	}

	public void setValuesEnums(List<Attribute> valuesEnums) {
		this.attributes = valuesEnums;
	}

	public void add(Attribute a) {
		attributes.add(a);
	}

	public void remove(Attribute a) {
		attributes.remove(a);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Method> getMethods() {
		return methods;
	}

	public void setMethods(List<Method> methods) {
		this.methods = methods;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public List<Class> getInterfacesImp() {
		return interfacesImp;
	}

	public void setInterfacesImp(List<Class> interfacesImp) {
		this.interfacesImp = interfacesImp;
	}

	public List<Property> getProperties() {
		return properties;
	}

	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}

	public List<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}
	

}
