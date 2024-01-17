package org.mql.java.parsers;

import org.mql.java.parsers.parserImp.ProjectParser;

public class ParseTesTConsole {

	String completePath = "D:/MQL-2023/Java/";

	String projectName = "El Maalmi Ayoub-UML Diagrams Generator";

	public ParseTesTConsole() {
		ProjectParser projectParser = new ProjectParser(completePath + "/" + projectName);
		System.out.println(projectParser.getProject());

	}

	public static void main(String[] args) {
		new ParseTesTConsole();
	}

}