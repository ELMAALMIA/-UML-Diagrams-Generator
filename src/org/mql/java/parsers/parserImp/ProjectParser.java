package org.mql.java.parsers.parserImp;



import java.io.File;

import java.util.List;
import java.util.Vector;

import org.mql.java.models.PackageModel;
import org.mql.java.models.ProjectModel;


public class ProjectParser {

    private String projectPath;
    private ProjectModel project;

    public ProjectParser(String path) {
        this.projectPath = path;
        project = new ProjectModel();
        
        File srcDirectory = new File(projectPath + "/bin");
        List<PackageModel> packages = new Vector<>();

        if (srcDirectory.exists() && srcDirectory.isDirectory()) {
            File[] subDirectories = srcDirectory.listFiles();
            if (subDirectories != null) {
                for (File subDirectory : subDirectories) {
                    if (subDirectory.isDirectory()) {
                        packages.add(new PackageParser(projectPath,subDirectory.getName()).getPackageModel());
                    }
                }
            }
        } else {
            System.out.println("Le chemin du projet est invalide ou n'est pas un répertoire.");
        }

        project.setPackagesList(packages);
    }

    public ProjectModel getProject() {
        return project;
    }

    public String getProjectPath() {
        return projectPath;
    }
    
    
}
