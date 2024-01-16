package org.mql.java.models;

import java.util.List;
import java.util.Vector;
import java.lang.reflect.Modifier;

import org.mql.java.enumerations.AccessModifier;

public class Method extends Property {
	private List<Parameter> parameters;
	private int modifier;

//	private boolean isConstruct;
//	private String typereturn;
	public Method(java.lang.reflect.Method m) {

		super(m.getName());
		this.parameters = new Vector<>();
		addAll(m.getParameters());
		 this.modifier = m.getModifiers();
		setNiveauVisiblity( determineVisibility(modifier));

	}

	private void addAll(java.lang.reflect.Parameter[] parametersadd) {
		for (java.lang.reflect.Parameter parameter : parametersadd) {
			parameters.add(new Parameter(parameter.getType().getName()));
		}

	}

	private AccessModifier determineVisibility(int mod) {
		if (Modifier.isPublic(mod)) {
			return AccessModifier.PUBLIC;
		} else if (Modifier.isPrivate(mod)) {
			return AccessModifier.PRIVATE;
		} else if (Modifier.isProtected(mod)) {
			return AccessModifier.PROTECTED;
		}
		return AccessModifier.PACKAGE; 
		}

	public List<Parameter> getParameters() {
		return parameters;
	}

	public void setParameters(List<Parameter> parameters) {
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
