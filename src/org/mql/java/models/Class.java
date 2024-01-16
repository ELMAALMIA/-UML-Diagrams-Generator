package org.mql.java.models;

import java.util.List;

public class Class  extends ModelEntity{
	
	private List<Attribute> attributes;
	private List<Method> methods;

	private List<String> interfacesImp;
	protected List<Property> properties;
	public Class(String name) {
	super(name);
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
	public List<String> getInterfacesImp() {
		return interfacesImp;
	}
	public void setInterfacesImp(List<String> interfacesImp) {
		this.interfacesImp = interfacesImp;
	}
	public void setMethods(List<Method> methods) {
		this.methods = methods;
	}
	
	public void addInterface(String nameIter) {
	interfacesImp.add(nameIter);
		
	}

public void addpropertie(Property p){
	properties.add(p);
	}

}
