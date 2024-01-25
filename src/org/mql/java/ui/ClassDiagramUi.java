package org.mql.java.ui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.mql.java.models.*;

public class ClassDiagramUi extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ClassModel> classes;
    private List<InterfaceModel> interfaces;
    private List<RelationModel> relations;
    private List<Enumeration> enumerations;

    public ClassDiagramUi(List<PackageModel> packageModels) {
        classes = new Vector<>();
        interfaces =  new Vector<>();
        enumerations = new Vector<>();
        relations= new Vector<>();
        parse(packageModels);

       // setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setLayout(new GridLayout(0, 4, 30, 30));
        for (ClassModel classModel : classes) {
            ClassDesigner classDesigner = new ClassDesigner(classModel);
            add(classDesigner);
        }

        for (InterfaceModel interfaceModel : interfaces) {
            InterfaceDesigner interfaceDesigner = new InterfaceDesigner(interfaceModel);
            add(interfaceDesigner);
        }

        for (Enumeration enumModel : enumerations) {
            EnumerationDesigner enumerationDesigner = new EnumerationDesigner(enumModel);
            add(enumerationDesigner);
        }
    }

    private void parse(List<PackageModel> packageModels) {
        for (PackageModel packageModel : packageModels) {
            classes.addAll(packageModel.getClasses());
            interfaces.addAll(packageModel.getInterfaces());
            enumerations.addAll(packageModel.getEnumerations());
            relations.addAll(packageModel.getRelations());

            if (packageModel.getPackages() != null) {
                parse(packageModel.getPackages());
            }
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        for (RelationModel relation : relations) {
            Point startPoint = findCoordinates(relation.getSourceModel());
            Point endPoint = findCoordinates(relation.getTargetModel());

            g2d.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
      
        }
    }
    private Point findCoordinates(Class<?> model) {
       
        for (Component comp : this.getComponents()) {
            if (comp instanceof ClassDesigner) {
                ClassDesigner classDesigner = (ClassDesigner) comp;
                if (classDesigner.getClassModel().equals(model)) {
                    
                    return new Point(comp.getX() + comp.getWidth() / 2, comp.getY() + comp.getHeight() / 2);
                }
            } else if (comp instanceof InterfaceDesigner) {
                InterfaceDesigner interfaceDesigner = (InterfaceDesigner) comp;
                if (interfaceDesigner.getInterfaceModel().equals(model)) {
                    return new Point(comp.getX() + comp.getWidth() / 2, comp.getY() + comp.getHeight() / 2);
                }
            }
           
        }
        return null;
    }

    public static void displayClassDiagram(String projectName, List<PackageModel> rootPackages) {
        JFrame frame = new JFrame("Class Diagram: " + projectName);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ClassDiagramUi classDiagramUi = new ClassDiagramUi(rootPackages);
        JScrollPane scrollPane = new JScrollPane(classDiagramUi);
        frame.add(scrollPane);
        frame.setSize(new Dimension(800, 600));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
