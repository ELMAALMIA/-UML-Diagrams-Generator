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
	private List<RelationModel> relations;

	public InterfaceModel(Class<?> class1) {
		   fields = new Vector<>();
		    methods = new Vector<>();
		    relations =new Vector<>();
		interfaceName = class1.getSimpleName();
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
	
	public void setRelations(List<RelationModel> relations) {
		this.relations = relations;
	}
	public List<RelationModel> getRelations() {
		return relations;
	}
	
	@Override
	public String toString() {
		String s ="";
		for (FieldModel fieldModel : fields) {
			s+="\n\t\t\t"+fieldModel; 
		}
		for(MethodModel model : methods) s+="\n\t\t\t"+model; 

		return " Interface : " + getInterfaceName()+s;
	}
	

}
