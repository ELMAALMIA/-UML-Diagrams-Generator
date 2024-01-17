package org.mql.java.models;

import java.util.List;
import java.util.Vector;

public class ModelEntity {
	private String name;
	private List<PropertyModel> properties;
	private String parent;
	public ModelEntity(String name) {
		super();
		this.name = name;
		this.properties =new Vector<>();
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<PropertyModel> getProperties() {
		return properties;
	}
	public void setProperties(List<PropertyModel> properties) {
		this.properties = properties;
	}
	public void addProperties(PropertyModel p) {
		properties.add(p);
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "ModelEntity tName" + getName() + ", Properties()=" + getProperties() + "parent "+getParent();
	}
	
	
}
