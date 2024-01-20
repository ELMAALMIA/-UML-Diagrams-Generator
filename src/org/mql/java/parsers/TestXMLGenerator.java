package org.mql.java.parsers;

import org.mql.java.models.ProjectModel;
import org.mql.java.parsers.parserImp.ProjectParser;
import org.mql.java.parsers.parserImp.XMLGenerator;

public class TestXMLGenerator {

    public TestXMLGenerator() {
    	String completePath = "D:/MQL-2023/Java/";

		String projectName = "El Maalmi Ayoub-UML Diagrams Generator";
		ProjectParser projectParser = new ProjectParser(completePath + "/" + projectName);


ProjectModel projectModel = new ProjectModel();
projectModel.setProjectModel(projectParser.getProject());
System.out.println("-----------------------------------------------*********************--------------");
        XMLGenerator xmlGenerator = new XMLGenerator();

        // Chemin où le fichier XML sera enregistré (dans le dossier resources)
        String xmlOutputPath = completePath + projectName + "/resources/projectStructure.xml";

        // Générer le fichier XML
        xmlGenerator.generateXML(projectModel, xmlOutputPath);

        System.out.println("Fichier XML généré avec succès : " + xmlOutputPath);
    }

    public static void main(String[] args) {
        new TestXMLGenerator();
    }
}
