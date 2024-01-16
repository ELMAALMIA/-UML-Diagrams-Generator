package org.mql.java.models;

import java.util.List;

public class Class {
	private String name;
	private List<Attribute> attributes;
	private List<Method> methods;
	private String parent;
	private List<Class> interfacesImp;
	protected List<Property> properties;
	public Class() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Attribute> getAttributes() {
		return attributes;
	}
	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}
	public List<Method> getMethods() {
		return methods;
	}
	public List<Class> getInterfacesImp() {
		return interfacesImp;
	}
	public void setInterfacesImp(List<Class> interfacesImp) {
		this.interfacesImp = interfacesImp;
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

}
