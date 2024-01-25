package org.mql.java.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import org.mql.java.models.AnnotationModel;
import org.mql.java.models.ClassModel;
import org.mql.java.models.Enumeration;
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
		 setPreferredSize(new Dimension(200, getPreferredSize().height));
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
		dataPanel.setLayout(new BoxLayout(dataPanel, BoxLayout.Y_AXIS));
		dataPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		dataPanel.setBackground(new Color(119, 158, 203));

		for (ClassModel classModel : pkg.getClasses()) {
			LabelUi classLabel = new LabelUi("Class: " + classModel.getName());
			dataPanel.add(classLabel);
		}

		for (InterfaceModel interfaceModel : pkg.getInterfaces()) {
			LabelUi interfaceLabel = new LabelUi("Interface: " + interfaceModel.getInterfaceName());
			dataPanel.add(interfaceLabel);
		}

		for (Enumeration enumModel : pkg.getEnumerations()) {
			LabelUi enumLabel = new LabelUi("Enum: " + enumModel.getName());
			dataPanel.add(enumLabel);
		}

		for (AnnotationModel annotation : pkg.getAnnotations()) {
			LabelUi annotationLabel = new LabelUi("Annotation: " + annotation.getName());
			dataPanel.add(annotationLabel);
		}

		for (PackageModel p : pkg.getPackages()) {
			LabelUi packageItem = new LabelUi("Package: " + p.getName());
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
