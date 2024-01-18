package org.mql.java.models;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class InterfaceModel {
	private String interfaceName;
	private List<FieldModel> fields;
	private List<MethodModel> methods;

	public InterfaceModel(Class<?> class1) {
		   fields = new Vector<>();
		    methods = new Vector<>();
		interfaceName = class1.getName();
		for (Field field : class1.getDeclaredFields()) {
			fields.add(new FieldModel(field));
		}
		for (Method method : class1.getDeclaredMethods()) {
			methods.add(new MethodModel(method));
		}
	}

	public String getInterfaceName() {
		return interfaceName;
	}

	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}

	public List<FieldModel> getFields() {
		return fields;
	}

	public void setFields(List<FieldModel> fields) {
		this.fields = fields;
	}

	public List<MethodModel> getMethods() {
		return methods;
	}

	public void setMethods(List<MethodModel> methods) {
		this.methods = methods;
	}
	
	
	
	@Override
	public String toString() {
		String s ="";
		for(MethodModel model : methods) s+="\n\t\t\t"+model; 

		return " Interface " + getInterfaceName()+s;
	}
	

}
