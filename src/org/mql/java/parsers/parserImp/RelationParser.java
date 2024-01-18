package org.mql.java.parsers.parserImp;

import java.util.List;

import org.mql.java.models.ProjectModel;
import org.mql.java.models.RelationModel;
import org.mql.java.parsers.Parser;
import org.mql.java.utils.RelationUtils;

public class RelationParser  {

	private ProjectModel projetModel;
	List<RelationModel> relations;
	public RelationParser(ProjectModel projetModel) {
		this.projetModel = projetModel;
		this.relations=RelationUtils.getRelations(projetModel);
		
	}
}
