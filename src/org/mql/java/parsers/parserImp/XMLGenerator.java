package org.mql.java.parsers.parserImp;



import org.mql.java.models.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class XMLGenerator {

    public void generateXML(ProjectModel project, String outputPath) {
        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            // Root element
            Element root = document.createElement("project");
            document.appendChild(root);

            // Add project name
            root.setAttribute("name", project.getName());
            System.out.println(project.getName());

            // Process each package
            for (PackageModel pkg : project.getPackagesList()) {
                root.appendChild(createPackageElement(document, pkg));
            }

            // Save XML to file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(outputPath));

            transformer.transform(domSource, streamResult);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Element createPackageElement(Document document, PackageModel pkg) {
        Element packageElement = document.createElement("package");
        packageElement.setAttribute("name", pkg.getName());

 
        for (ClassModel cls : pkg.getClasses()) {
            packageElement.appendChild(createClassElement(document, cls));
        }

    
        for (InterfaceModel intf : pkg.getInterfaces()) {
            packageElement.appendChild(createInterfaceElement(document, intf));
        }
        for (RelationModel relation : pkg.getRelations()) {
            packageElement.appendChild(createRelationElement(document, relation));
        }

        return packageElement;
    }

    private Element createClassElement(Document document, ClassModel cls) {
        Element classElement = document.createElement("class");
        classElement.setAttribute("name", cls.getName());

        return classElement;
    }

    private Element createInterfaceElement(Document document, InterfaceModel intf) {
        Element interfaceElement = document.createElement("interface");
        interfaceElement.setAttribute("name", intf.getInterfaceName());


        return interfaceElement;
    }

    private Element createRelationElement(Document document, RelationModel relation) {
        Element relationElement = document.createElement("relation");
        relationElement.setAttribute("type", relation.getRelationType().toString());
        relationElement.setAttribute("source", relation.getSourceModel().toString());
        relationElement.setAttribute("target", relation.getTargetModel().toString());
        return relationElement;
    }

  
}
