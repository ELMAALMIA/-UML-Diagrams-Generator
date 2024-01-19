package org.mql.java.models;

import org.mql.java.enumerations.RelationType;

public class RelationModel {
    private Class<?> sourceModel;
    private Class<?> targetModel;     
    private RelationType relationType;

    public RelationModel(Class<?> sourceModel, Class<?> targetModel, RelationType relationType) {
        this.sourceModel = sourceModel;
        this.targetModel = targetModel;
        this.relationType = relationType;
    }

    // Getters et Setters
   

    public RelationType getRelationType() {
        return relationType;
    }

    public Object getSourceModel() {
		return sourceModel;
	}

	
	public void setRelationType(RelationType relationType) {
        this.relationType = relationType;
    }

    @Override
    public String toString() {
        return "Relation  : \t"+getRelationType()+ "\t"  +   sourceModel.getSimpleName() + "-----------------"+ getRelationType().getSymbol()+ targetModel.getSimpleName() +"\n";
    }
}
