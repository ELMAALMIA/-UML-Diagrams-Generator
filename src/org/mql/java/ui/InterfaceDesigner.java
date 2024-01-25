package org.mql.java.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import org.mql.java.models.InterfaceModel;
import org.mql.java.models.MethodModel;
import org.mql.java.models.FieldModel;

public class InterfaceDesigner extends JPanel {
    private static final long serialVersionUID = 1L;

    private InterfaceModel interfaceModel;

    public InterfaceDesigner(InterfaceModel interfaceModel) {
        this.interfaceModel = interfaceModel;
        setLayout(new BorderLayout());
        drawInterfaceTitle();
        drawAttributesAndMethods();
        setPreferredSize(new Dimension(200, getPreferredSize().height));
    }

    public InterfaceModel getInterfaceModel() {
		return interfaceModel;
	}
    private void drawInterfaceTitle() {
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        titlePanel.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, Color.black));
        titlePanel.setBackground(new Color(119, 158, 203));
        LabelUi titleLabel = new LabelUi("Interface: " + interfaceModel.getInterfaceName());
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);
    }

    private void drawAttributesAndMethods() {
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        
        drawAttributes(contentPanel);
        
        // Ajout d'un séparateur entre les attributs et les méthodes
        JSeparator separator = new JSeparator();
        separator.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
        contentPanel.add(separator);
        
        drawMethods(contentPanel);

        add(contentPanel, BorderLayout.CENTER);
    }

    private void drawAttributes(JPanel panel) {
        JPanel attributesPanel = new JPanel();
        attributesPanel.setLayout(new BoxLayout(attributesPanel, BoxLayout.Y_AXIS));
        attributesPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        attributesPanel.setBackground(new Color(233, 236, 239));

        for (FieldModel field : interfaceModel.getFields()) {
            LabelUi fieldLabel = new LabelUi(field.getNiveauVisiblity().getSymbol() + " " + field.getName() + ": " + field.getType());
            attributesPanel.add(fieldLabel);
        }

        panel.add(attributesPanel);
    }

    private void drawMethods(JPanel panel) {
        JPanel methodsPanel = new JPanel();
        methodsPanel.setLayout(new BoxLayout(methodsPanel, BoxLayout.Y_AXIS));
        methodsPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        methodsPanel.setBackground(new Color(233, 236, 239));

        for (MethodModel method : interfaceModel.getMethods()) {
            LabelUi methodLabel = new LabelUi(method.getVisibility().getSymbol() + " " + method.getName() + "()");
            methodsPanel.add(methodLabel);
        }

        panel.add(methodsPanel);
    }
}
