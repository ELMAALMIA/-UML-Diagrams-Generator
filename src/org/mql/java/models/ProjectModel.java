package org.mql.java.models;

import java.util.List;
import java.util.Vector;

public class ProjectModel {
	private String name;
	public List<PackageModel> packagesList;
	private List<RelationModel> relationsList;
	private String path;
	private ProjectModel projectModel;

	public ProjectModel() {
		packagesList = new Vector<>();
		relationsList = new Vector<>();

	}

	public ProjectModel(List<PackageModel> packagesList, List<RelationModel> relations, String name, String path) {
		packagesList = new Vector<>();
		relationsList = new Vector<>();
		this.packagesList = packagesList;
		this.relationsList = relations;
		this.name = name;
		this.path = path;
	}

	public void setProjectModel(ProjectModel projectModel) {
		this.projectModel = projectModel;
	}

	public ProjectModel getProjectModel() {
		return projectModel;
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
			string += packageModel.getName() + "\n";
		}
		return string + "\n" + "test";
	}

}
