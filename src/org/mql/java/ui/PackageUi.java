package org.mql.java.ui;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import org.mql.java.models.PackageModel;

public class PackageUi extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PackageUi(List<PackageModel> rootPackages) {
		
        setLayout(new FlowLayout(FlowLayout.LEFT)); 
        drawPackages(rootPackages);
    }

    private void drawPackages(List<PackageModel> pkgs) {
        for (PackageModel p : pkgs) {
            if (p!=null) { 
                PackageItem packageItem = new PackageItem(p);
                add(packageItem);
            }
            if (p.getPackages() != null) {
                drawPackages(p.getPackages());
            }
        }
    }

    public static void displayPackageDiagram(String projectName, List<PackageModel> rootPackages) {
        JFrame frame = new JFrame("Package Diagram: " + projectName);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        PackageUi packageUi = new PackageUi(rootPackages);
        JScrollPane scrollPane = new JScrollPane(packageUi);
        frame.add(scrollPane);
        frame.setSize(new Dimension(800, 600));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
