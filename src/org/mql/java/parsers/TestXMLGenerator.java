package org.mql.java.parsers;

import java.util.List;

import org.mql.java.models.PackageModel;
import org.mql.java.models.ProjectModel;
import org.mql.java.parsers.parserImp.ProjectParser;
import org.mql.java.parsers.parserImp.XMLGenerator;

public class TestXMLGenerator {

	public TestXMLGenerator() {
		String completePath = "D:/MQL-2023/Java/";

		String projectName = "El Maalmi Ayoub-UML Diagrams Generator";
		ProjectParser projectParser = new ProjectParser(completePath + "/" + projectName);

		XMLGenerator xmlGenerator = new XMLGenerator();

		System.out.println(projectParser.getProject());
		projectParser.parse();

		// Chemin où le fichier XML sera enregistré (dans le dossier resources)
		String xmlOutput = completePath + projectName + "/resources/project-UML.xml";
		// Générer le fichier XML
		// xmlGenerator.generateXML(packagesList,nameProject, xmlOutput);
		xmlGenerator.generateXML(projectParser.getProject(), xmlOutput);

		System.out.println("Fichier XML généré avec succès : " + xmlOutput);
	}

	public static void main(String[] args) {
		new TestXMLGenerator();
	}
}
