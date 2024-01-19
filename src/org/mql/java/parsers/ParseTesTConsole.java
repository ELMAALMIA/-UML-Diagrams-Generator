package org.mql.java.parsers;

import java.util.Iterator;
import java.util.List;

import org.mql.java.models.ClassModel;
import org.mql.java.models.PackageModel;
import org.mql.java.models.RelationModel;
import org.mql.java.parsers.parserImp.ProjectParser;

public class ParseTestConsole {
	public ParseTestConsole() {
		String completePath = "D:/MQL-2023/Java/";

		String projectName = "El Maalmi Ayoub-UML Diagrams Generator";
		ProjectParser projectParser = new ProjectParser(completePath + "/" + projectName);



	projectParser.getProject();
//        if (relations != null) {
//            for (RelationModel relation : relations) {
//                System.out.println("Relation: " + relation.toString());
//            }
//        } else {
//            System.out.println("Aucune relation trouvée.");
//        }

	}

	public static void main(String[] args) {
		new ParseTestConsole();
	}

}