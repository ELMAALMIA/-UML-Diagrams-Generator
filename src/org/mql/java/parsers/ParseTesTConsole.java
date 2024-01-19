package org.mql.java.parsers;

import java.util.List;

import org.mql.java.models.RelationModel;
import org.mql.java.parsers.parserImp.ProjectParser;

public class ParseTestConsole {
	public ParseTestConsole() {
		String completePath = "D:/MQL-2023/Java/";

		String projectName = "El Maalmi Ayoub-UML Diagrams Generator";
		ProjectParser projectParser = new ProjectParser(completePath + "/" + projectName);
	//	System.out.println(projectParser.getProject());
	
//        List<RelationModel> relations = projectParser.getRelations();
//        for (RelationModel relation : relations) {
//            System.out.println("Relation: " + relation);
//        }

	}

	public static void main(String[] args) {
		new ParseTestConsole();
	}

}