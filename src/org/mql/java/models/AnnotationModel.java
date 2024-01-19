package org.mql.java.models;

public class AnnotationModel {
private String name;
	public AnnotationModel(Class<?> c) {
	name = c.getSimpleName();
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
		public String toString() {
			return "Annotation " +getName();
		}

}
