package org.mql.java.models;

import java.util.List;

public class ProjectModel {
    private String name;
    private List<PackageModel> packagesList;
    private List<RelationModel> relationsList;
    private String path;

    public ProjectModel() {
    }

    public ProjectModel(List<PackageModel> packagesList, List<RelationModel> relations, String name, String path) {
        this.packagesList = packagesList;
        this.relationsList = relations;
        this.name = name;
        this.path = path;
    }

    public List<PackageModel> getPackagesList() {
        return packagesList;
    }

    public void setPackagesList(List<PackageModel> packagesList) {
        this.packagesList = packagesList;
    }

    public List<RelationModel> getRelations() {
        return relationsList;
    }

    public void setRelations(List<RelationModel> relations) {
        this.relationsList = relations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

//    public static String getAbsolutePath() {
//        if (project != null)
//            return project.getPath();
//        return "";
//    }

    @Override
    public String toString() {
        String string = "";
        for (PackageModel packageModel : packagesList) {
            string += packageModel + "\n";
        }
        return string;
    }

   
}
