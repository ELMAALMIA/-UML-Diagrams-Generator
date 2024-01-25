package org.mql.java.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import org.mql.java.models.Enumeration;

public class EnumerationDesigner extends JPanel {
    private static final long serialVersionUID = 1L;

    private Enumeration enumModel;

    public EnumerationDesigner(Enumeration enumModel) {
        this.enumModel = enumModel;
        setLayout(new BorderLayout());
        drawEnumTitle();
        drawConstants();
        setPreferredSize(new Dimension(200, getPreferredSize().height));
    }

    private void drawEnumTitle() {
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        titlePanel.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, Color.black));
        titlePanel.setBackground(new Color(250, 128, 114));
        LabelUi titleLabel = new LabelUi("Enum: " + enumModel.getName());
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);
    }

    private void drawConstants() {
        JPanel constantsPanel = new JPanel();
        constantsPanel.setLayout(new BoxLayout(constantsPanel, BoxLayout.Y_AXIS));
        constantsPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        constantsPanel.setBackground(new Color(255, 228, 196));

        for (String constant : enumModel.getValuesEnum()) {
            LabelUi constantLabel = new LabelUi(constant);
            constantsPanel.add(constantLabel);
        }

        add(constantsPanel, BorderLayout.CENTER);
    }
}
