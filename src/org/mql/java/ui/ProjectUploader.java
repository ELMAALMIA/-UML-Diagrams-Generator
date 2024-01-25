package org.mql.java.ui;

import javax.swing.*;

import org.mql.java.models.PackageModel;
import org.mql.java.parsers.parserImp.ProjectParser;
import org.mql.java.xml.XMIGenerator;
import org.mql.java.xml.XMLGenerator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class ProjectUploader extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton uploadButton;
	private JButton downloadXMLButton;
	private JButton downloadXMIButton;
	private JButton  showPackageDiagramButton;
	private XMLGenerator xmlGenerator;
	private XMIGenerator xmiGenerator;
	private String xmlOutput;
	private String xmlOutputXmi;
    private JButton showConsoleResultButton;
    private ProjectParser projectParser; 
    private JButton showClassDiagramButton;

	public ProjectUploader() {
		xmlGenerator = new XMLGenerator();
		xmiGenerator = new XMIGenerator();
		createUI();
	}

	private void createUI() {
	    this.setLayout(new GridBagLayout());
	    GridBagConstraints gbc = new GridBagConstraints();
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    gbc.gridx = 0;
	    gbc.gridy = 0;

	    uploadButton = new JButton("Upload Project");
	    uploadButton.addActionListener(this::uploadButtonAction);
	    this.add(uploadButton, gbc);

	    downloadXMLButton = new JButton("Download XML File");
	    downloadXMLButton.addActionListener(this::downloadXMLButtonAction);
	    downloadXMLButton.setEnabled(false);
	    gbc.gridy++;
	    this.add(downloadXMLButton, gbc);

	    downloadXMIButton = new JButton("Download XMI File");
	    downloadXMIButton.addActionListener(this::downloadXMIButtonAction);
	    downloadXMIButton.setEnabled(false);
	    gbc.gridy++;
	    this.add(downloadXMIButton, gbc);

	    showPackageDiagramButton = new JButton("Show Package Diagram");
	    showPackageDiagramButton.addActionListener(this::showPackageDiagramButtonAction);
	    showPackageDiagramButton.setEnabled(false);
	    gbc.gridy++;
	    this.add(showPackageDiagramButton, gbc);

	    showClassDiagramButton = new JButton("Show Class Diagram");
	    showClassDiagramButton.addActionListener(this::showClassDiagramButtonAction);
	    showClassDiagramButton.setEnabled(false);
	    gbc.gridy++;
	    this.add(showClassDiagramButton, gbc);

	    showConsoleResultButton = new JButton("Show Console Result");
	    showConsoleResultButton.addActionListener(this::showConsoleResultButtonAction);
	    showConsoleResultButton.setEnabled(false);
	    gbc.gridy++;
	    this.add(showConsoleResultButton, gbc);

	    this.setSize(400, 300);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	}

	private void uploadButtonAction(ActionEvent e) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int option = fileChooser.showOpenDialog(ProjectUploader.this);

		if (option == JFileChooser.APPROVE_OPTION) {
			File selectedFolder = fileChooser.getSelectedFile();
			String projectPath = selectedFolder.getAbsolutePath();
			String projectName = selectedFolder.getName();

			 projectParser = new ProjectParser(projectPath);
			projectParser.parse();

			xmlOutput = projectPath + File.separator + "resources" + File.separator + "xmlDocument" + File.separator
					+ projectName + "-UML.xml";
			xmlGenerator.generateXML(projectParser.getProject(), xmlOutput);

			xmlOutputXmi = projectPath + File.separator + "resources" + File.separator + "xmlDocument" + File.separator + projectName + "-Xmi-UML.xml";
			xmiGenerator.generateXMI(projectParser.getProject(), xmlOutputXmi);

			downloadXMLButton.setEnabled(true);
			downloadXMIButton.setEnabled(true);
			showPackageDiagramButton.setEnabled(true);
			 showConsoleResultButton.setEnabled(true);
			 showClassDiagramButton.setEnabled(true);

			JOptionPane.showMessageDialog(ProjectUploader.this, "Fichier XML généré avec succès : " + xmlOutput,
					"Success", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void downloadXMLButtonAction(ActionEvent e) {
		if (xmlOutput == null || xmlOutput.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No XML file available to download.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setSelectedFile(new File(xmlOutput));
		fileChooser.setDialogTitle("Save XML File");
		int userSelection = fileChooser.showSaveDialog(this);

		if (userSelection == JFileChooser.APPROVE_OPTION) {
			File fileToSave = fileChooser.getSelectedFile();
			try {
				Files.copy(Paths.get(xmlOutput), fileToSave.toPath(), StandardCopyOption.REPLACE_EXISTING);
				JOptionPane.showMessageDialog(this, "File saved to: " + fileToSave.getAbsolutePath(), "File Saved",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void downloadXMIButtonAction(ActionEvent e) {
		if (xmlOutputXmi == null || xmlOutputXmi.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No XMI file available to download.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setSelectedFile(new File(xmlOutputXmi));
		fileChooser.setDialogTitle("Save XMI File");
		int userSelection = fileChooser.showSaveDialog(this);

		if (userSelection == JFileChooser.APPROVE_OPTION) {
			File fileToSave = fileChooser.getSelectedFile();
			try {
				Files.copy(Paths.get(xmlOutputXmi), fileToSave.toPath(), StandardCopyOption.REPLACE_EXISTING);
				JOptionPane.showMessageDialog(this, "XMI file saved to: " + fileToSave.getAbsolutePath(), "File Saved",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Error saving XMI file: " + ex.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	private void showConsoleResultButtonAction(ActionEvent e) {
	    if (projectParser != null && projectParser.getProject() != null) {
	        List<PackageModel> packagesList = projectParser.getProject().getPackagesList();
	        String  name = projectParser.getProject().getName();
	        String packageDetails = parse(packagesList);

	        JTextArea textArea = new JTextArea(30, 60);
	        textArea.setText(packageDetails);
	        textArea.setEditable(false);
	        JScrollPane scrollPane = new JScrollPane(textArea);

	        JDialog dialog = new JDialog(this, "Project Details"+name , Dialog.ModalityType.APPLICATION_MODAL);
	        dialog.getContentPane().add(scrollPane);
	        dialog.pack();
	        dialog.setLocationRelativeTo(this);
	        dialog.setVisible(true);
	    } else {
	        JOptionPane.showMessageDialog(this, "No project details available.", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}



	private String generateClassDiagram() {
		// TODO Auto-generated method stub
		return null;
	}

	public String parse(List<PackageModel> packages) {
	    StringBuilder sb = new StringBuilder();
	    for (PackageModel packageModel : packages) {
	        sb.append(packageModel);
	        if (packageModel.getPackages() != null) {
	            sb.append(parse(packageModel.getPackages()));
	        }
	    }
	    return sb.toString();
	}


	private void showPackageDiagramButtonAction(ActionEvent e) {
		if (projectParser != null && projectParser.getProject() != null) {
            List<PackageModel> rootPackages = projectParser.getProject().getPackagesList();
            String projectName = projectParser.getProject().getName();
            PackageUi.displayPackageDiagram(projectName, rootPackages);
        } else {
            JOptionPane.showMessageDialog(null, "Please parse a project first.", "No Project Data", JOptionPane.ERROR_MESSAGE);
        }
	}

	
	private void showClassDiagramButtonAction(ActionEvent e) {
	    if (projectParser != null && projectParser.getProject() != null) {
	        List<PackageModel> rootPackages = projectParser.getProject().getPackagesList();
	        ClassDiagramUi.displayClassDiagram(projectParser.getProject().getName(), rootPackages);
	    } else {
	        JOptionPane.showMessageDialog(this, "No project data available for class diagram.", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}


	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new ProjectUploader().setVisible(true));
	}
}
