package org.mql.java.models;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.List;
import java.util.Vector;

public class ConstructorModel {
	private String name;// name of class
	private int modifier;
	private List<ParameterModel> parameteList;

	public ConstructorModel(Constructor<?> c) {
		parameteList= new Vector<>();
		this.name = c.getName();
		this.modifier = c.getModifiers();
		Parameter[] parameters = c.getParameters();
		for (Parameter parameter : parameters) {
			ParameterModel parameterModel = new ParameterModel();
			parameterModel.setName(parameter.getName());
			parameterModel.setType(parameter.getType().getName());
			this.parameteList.add(parameterModel);
		}

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getModifier() {
		return modifier;
	}

	public void setModifier(int modifier) {
		this.modifier = modifier;
	}

	public List<ParameterModel> getParameteList() {
		return parameteList;
	}

	public void setParameteList(List<ParameterModel> parameteList) {
		this.parameteList = parameteList;
	}

}
