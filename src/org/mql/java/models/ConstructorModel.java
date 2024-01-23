package org.mql.java.models;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.mql.java.enumerations.AccessModifier;
import org.mql.java.utils.VisibilityUtils;

public class ConstructorModel {
	private String name;// name of class
	private int modifier;
	private List<ParameterModel> parameterList;
	private AccessModifier visibility;

	public ConstructorModel(Constructor<?> c) {
		this.parameterList = new Vector<>();
	}

	public ConstructorModel() {
		this.parameterList = new Vector<>();
		this.visibility = 	AccessModifier.PUBLIC;
	}

	public ConstructorModel(Constructor<?> c, String name) {
		this.parameterList = new Vector<>();
		this.name = name;
		this.modifier = c.getModifiers();
		new VisibilityUtils();
		this.visibility = VisibilityUtils.determineVisibility(this.modifier);
		addAll(c.getParameters());

	}

	private void addAll(Parameter[] parametersadd) {
		for (Parameter parameter : parametersadd) {
			parameterList.add(new ParameterModel(parameter));
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

	public List<ParameterModel> getParameterList() {
		return parameterList;
	}

	public void setParameteeList(List<ParameterModel> parameteList) {
		this.parameterList = parameteList;
	}

	@Override
	public String toString() {
		String s = visibility.getSymbol() + " " + name + "(";
		for (int i = 0; i < parameterList.size(); i++) {
			s += parameterList.get(i);
			if (i < parameterList.size() - 1)
				s += ", ";
		}
		s += ")";
		return s;
	}

}
