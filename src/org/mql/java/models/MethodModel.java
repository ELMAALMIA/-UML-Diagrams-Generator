package org.mql.java.models;

import java.util.List;
import java.util.Vector;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

import org.mql.java.enumerations.AccessModifier;
import org.mql.java.utils.VisibilityUtils;

public class MethodModel {
	public String name;
	private List<ParameterModel> parameters;
	private int modifier;
	private AccessModifier visibility;
	private boolean isStatic;
	private boolean isFinal;

//	private boolean isConstruct;
	private String typeReturn;

	public MethodModel() {
		this.parameters = new Vector<>();
	}

	public MethodModel(Method m) {
		this.parameters = new Vector<>();
		this.name = m.getName();

		addAll(m.getParameters());
		this.modifier = m.getModifiers();

		this.isStatic = Modifier.isStatic(this.modifier);
		this.isFinal = Modifier.isFinal(this.modifier);

		this.visibility = VisibilityUtils.determineVisibility(this.modifier);

		this.typeReturn = m.getReturnType().getSimpleName();
	}

	private void addAll(Parameter[] parametersadd) {
		for (Parameter parameter : parametersadd) {
			parameters.add(new ParameterModel(parameter));
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AccessModifier getVisibility() {
		return visibility;
	}

	public void setVisibility(AccessModifier visibility) {
		this.visibility = visibility;
	}

	public String getTypeReturn() {
		return typeReturn;
	}

	public void setTypeReturn(String typeReturn) {
		this.typeReturn = typeReturn;
	}

	public boolean isStatic() {
		return isStatic;
	}

	public void setStatic(boolean isStatic) {
		this.isStatic = isStatic;
	}

	public boolean isFinal() {
		return isFinal;
	}

	public void setFinal(boolean isFinal) {
		this.isFinal = isFinal;
	}

	@Override
	public String toString() {
		String s = "";
		s += visibility.getSymbol();
		s = getVisibility().getSymbol() + " " + getName();
		s += "(";
		for (int i = 0; i <= parameters.size() - 1; i++) {
			s += parameters.get(i);
			if (i != parameters.size() - 1)
				s += ", ";
		}
		s += ") " + " : " + getTypeReturn();

		return s;
	}

}
