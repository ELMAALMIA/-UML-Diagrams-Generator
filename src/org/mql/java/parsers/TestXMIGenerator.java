package org.mql.java.parsers;


import java.util.List;

import org.mql.java.models.PackageModel;
import org.mql.java.models.ProjectModel;
import org.mql.java.parsers.parserImp.ProjectParser;
import org.mql.java.parsers.parserImp.XMIGenerator;
import org.mql.java.parsers.parserImp.XMLGenerator;

public class TestXMIGenerator {

	public TestXMIGenerator() {
		String completePath = "D:/MQL-2023/Java/";

		String projectName = "El Maalmi Ayoub-UML Diagrams Generator";
		ProjectParser projectParser = new ProjectParser(completePath + "/" + projectName);

		XMIGenerator xmiGenerator = new XMIGenerator();

		System.out.println(projectParser.getProject());
		projectParser.parse();

		String xmlOutput = completePath + projectName + "/resources/project-UML-XMI.xml";

		xmiGenerator.generateXMI(projectParser.getProject(), xmlOutput);

		System.out.println("Fichier XML généré avec succès : " + xmlOutput);
	}

	public static void main(String[] args) {
		new TestXMIGenerator();
	}
}
