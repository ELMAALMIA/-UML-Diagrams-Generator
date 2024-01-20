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
		
	
		projectParser.parse();

		List<PackageModel> packagesList = projectParser.getProject().getPackagesList();
				
		for (PackageModel item : packagesList) {
			item.getRelations().forEach(e->System.out.print(e));
			item.showRelarion();
			
		}

	}

	public static void main(String[] args) {
		new ParseTestConsole();
	}

}