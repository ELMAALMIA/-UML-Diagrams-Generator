package org.mql.java.models;

import org.mql.java.enumerations.RelationType;

public class RelationModel {
    private Object sourceModel;
    private Object targetModel;     
    private RelationType relationType;

    public RelationModel(Object sourceModel, Object targetModel, RelationType relationType) {
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

	public void setSourceModel(Object sourceModel) {
		this.sourceModel = sourceModel;
	}

	public Object getTargetModel() {
		return targetModel;
	}

	public void setTargetModel(Object targetModel) {
		this.targetModel = targetModel;
	}

	public void setRelationType(RelationType relationType) {
        this.relationType = relationType;
    }

    @Override
    public String toString() {
        return "Relation : "  +   sourceModel.getClass().getSimpleName() + "-----------------"+ getRelationType().getSymbol()+ targetModel.getClass().getSimpleName() ;
    }
}
