package org.mql.java.models;

import java.util.List;
import java.util.Vector;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

import org.mql.java.enumerations.AccessModifier;

public class MethodModel  {
	private List<ParameterModel> parameters;
	private int modifier;
	private AccessModifier visibility;

//	private boolean isConstruct;
	private String typeReturn;
	public MethodModel(Method m) {

		
		this.parameters = new Vector<>();
		addAll(m.getParameters());
		 this.modifier = m.getModifiers();
		

	}

	private void addAll(Parameter[] parametersadd) {
		for (Parameter parameter : parametersadd) {
			parameters.add(new ParameterModel(parameter.getType().getName()));
		}

	}



	public List<ParameterModel> getParameters() {
		return parameters;
	}

	public void setParameters(List<ParameterModel> parameters) {
		this.parameters = parameters;
	}

	public int getModifier() {
		return modifier;
	}

	public void setModifier(int modifier) {
		this.modifier = modifier;
	}
//	public boolean isConstruct() {
//		return isConstruct;
//	}
//	public void setConstruct(boolean isConstruct) {
//		this.isConstruct = isConstruct;
//	}
//	public String getTypereturn() {
//		return typereturn;
//	}
//	public void setTypereturn(String typereturn) {
//		this.typereturn = typereturn;
//	}

	@Override
	public String toString() {

		return super.toString();
	}
}
