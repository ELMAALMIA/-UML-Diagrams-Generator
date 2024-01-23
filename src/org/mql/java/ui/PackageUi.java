package org.mql.java.ui;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;

import org.mql.java.models.PackageModel;
import org.mql.java.parsers.parserImp.ProjectParser;

public class PackageUi extends JPanel {
  
	private static final long serialVersionUID = 1L;


	public PackageUi(List<PackageModel> list) {
        drawPackages(list);
    }

    private void drawPackages(List<PackageModel> pkgs) {
    	 int x = 1, y = 1;
        for (PackageModel p : pkgs) {
          
        	
        	if (!p.getClasses().isEmpty() || !p.getInterfaces().isEmpty()) {
            PackageItem packageDiagramItem = new PackageItem(p);
            packageDiagramItem.setLocation(x, y);
            
            
         this.add(packageDiagramItem);
        	}
            if (p.packages != null) {
                drawPackages(p.packages);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String completePath = "D:/MQL-2023/Java/";
            String projectName = "El Maalmi Ayoub-UML Diagrams Generator";
            ProjectParser projectParser = new ProjectParser(completePath + projectName);
            projectParser.parse();
            List<PackageModel> rootPackages = projectParser.getProject().getPackagesList();

            JFrame frame = new JFrame("Diagramme de Package " + projectName);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            PackageUi packageUi = new PackageUi(rootPackages);
            JScrollPane scrollPane = new JScrollPane(packageUi);
            frame.setContentPane(scrollPane);

           
            frame.setVisible(true);
      frame.setLocationRelativeTo(null);
      
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int width = (int)(screenSize.width * 0.75); // 75% de la largeur de l'écran
            int height = (int)(screenSize.height * 0.75); // 75% de la hauteur de l'écran

            frame.setSize(width, height); // Définir la taille de la fenêtre
            frame.setLocationRelativeTo(null); // Centrer la fenêtre
            frame.setVisible(true);
            frame.setVisible(true);
        });
    }
}