package org.mql.java.models;

import org.mql.java.enumerations.RelationType;

public class RelationModel {
	private ModelEntity fils;
	private ModelEntity parent;
	private RelationType type;
	public RelationModel() {
	
	}
	
	public RelationModel(ModelEntity fils, ModelEntity parent, RelationType type) {
		super();
		this.fils = fils;
		this.parent = parent;
		this.type = type;
	}

	public ModelEntity getFils() {
		return fils;
	}
	public void setFils(ModelEntity fils) {
		this.fils = fils;
	}
	public ModelEntity getParent() {
		return parent;
	}
	public void setParent(ModelEntity parent) {
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
