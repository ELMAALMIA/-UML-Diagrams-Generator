package org.mql.java.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Point;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import org.mql.java.models.ClassModel;
import org.mql.java.models.InterfaceModel;
import org.mql.java.models.PackageModel;

public class PackageItem extends JPanel {
    private static final long serialVersionUID = 1L;
    private PackageModel pkg;
    private String packageName;
    private Point lineFromParent;

    public PackageItem(PackageModel pkg) {
        this.pkg = pkg;
        this.packageName = pkg.getName();
        drawPackage();
    }

    public void drawPackage() {
        setLayout(new BorderLayout());
        drawPackageTitle();
        drawData();
    }
  

    public void setLineFromParent(Point parentLocation) {
        this.lineFromParent = parentLocation;
    }

    public Point getLineFromParent() {
        return lineFromParent;
    }


    private void drawData() {
    	
        JPanel dataPanel = new JPanel();
    // dataPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
     dataPanel.setLayout(new BoxLayout(dataPanel, BoxLayout.Y_AXIS)); 
        dataPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        dataPanel.setBackground(new Color(119, 158, 203));


        List<ClassModel> classes = pkg.getClasses();
        for (ClassModel classModel : classes) {
        	
            LabelUi classLabel = new LabelUi("Class: " + classModel.getName());
            dataPanel.add(classLabel);
        }

        List<InterfaceModel> interfaces = pkg.getInterfaces();
        for (InterfaceModel interfaceModel : interfaces) {
            LabelUi interfaceLabel = new LabelUi("Interface: " + interfaceModel.getInterfaceName());
            dataPanel.add(interfaceLabel);
        }
        List<PackageModel> listPackageModels = pkg.getPackages();
        for (PackageModel p : listPackageModels) {
    
            LabelUi packageItem = new LabelUi("PéACK: " +p.getName() );
            dataPanel.add(packageItem);
        }
        

        add(dataPanel, BorderLayout.CENTER);
    }



	public void drawPackageTitle() {
        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false);
        titlePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        titlePanel.setSize(100, 100);
        LabelUi titleLabel = new LabelUi(packageName);

        JPanel p = new JPanel();
        p.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        p.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, Color.black));
        p.setBackground(new Color(253, 239, 231));
        p.add(titleLabel);

        titlePanel.add(p);

        add(titlePanel, BorderLayout.NORTH);
    }
}
