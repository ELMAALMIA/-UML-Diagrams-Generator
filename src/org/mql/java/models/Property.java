package org.mql.java.models;

import org.mql.java.enumerations.AccessModifier;

public class Property {
	protected String name;
	protected AccessModifier niveauVisiblity;
	protected String type;
	protected boolean isStatic;
	protected boolean isFinal;
	public Property() {
	
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public AccessModifier getNiveauVisiblity() {
		return niveauVisiblity;
	}
	public void setNiveauVisiblity(AccessModifier niveauVisiblity) {
		this.niveauVisiblity = niveauVisiblity;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public AccessModifier visibility() {
		return null;
	}
	@Override
	public String toString() {
		return "Property " + getName() + ", Visiblity" + getNiveauVisiblity() + ", getType()="
				+ getType() + ", isStatic()=" + isStatic() + ", isFinal()=" + isFinal() ;
	}
	

}
