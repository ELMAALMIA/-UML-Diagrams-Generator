package org.mql.java.models;

public class AnnotationModel {
private String name;
	public AnnotationModel(Class<?> c) {
		// TODO Auto-generated constructor stub
	name = c.getSimpleName();
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
