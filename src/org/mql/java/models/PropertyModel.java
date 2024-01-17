package org.mql.java.models;



import org.mql.java.enumerations.AccessModifier;

public class PropertyModel {
	private String name;
	private AccessModifier niveauVisiblity;
	private String type;
	private boolean isStatic;
	private boolean isFinal;

	public PropertyModel(String name) {
		setName(name);
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



	@Override
	public String toString() {
		return "Property " + getName() + ", Visiblity" + getNiveauVisiblity() + ", getType()=" + getType()
				+ ", isStatic()=" + isStatic() + ", isFinal()=" + isFinal();
	}

}
