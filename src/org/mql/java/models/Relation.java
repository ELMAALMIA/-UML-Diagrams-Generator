package org.mql.java.models;

import org.mql.java.enumerations.RelationType;

public class Relation {
	private Model fils;
	private Model parent;
	private RelationType type;
	public Relation() {
	
	}
	
	public Relation(Model fils, Model parent, RelationType type) {
		super();
		this.fils = fils;
		this.parent = parent;
		this.type = type;
	}

	public Model getFils() {
		return fils;
	}
	public void setFils(Model fils) {
		this.fils = fils;
	}
	public Model getParent() {
		return parent;
	}
	public void setParent(Model parent) {
		this.parent = parent;
	}
	public RelationType getType() {
		return type;
	}
	public void setType(RelationType type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Relation Fils()=" + getFils() + ", tParent()=" + getParent() + ", Type()=" + getType() + "]";
	}
	
	
	

}
