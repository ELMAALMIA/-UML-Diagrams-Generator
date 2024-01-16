package org.mql.java.models;

import java.util.List;

public class Project {
	private List<Package> packagesList;
	private List<Relation> relationsList;
	private String name;
	private String path;
	public Project() {
		// TODO Auto-generated constructor stub
	}
	public Project(List<Package> packagesList, List<Relation> relations, String name, String path) {
		super();
		this.packagesList = packagesList;
		this.relationsList = relations;
		this.name = name;
		this.path = path;
	}
	public List<Package> getPackagesList() {
		return packagesList;
	}
	public void setPackagesList(List<Package> packagesList) {
		this.packagesList = packagesList;
	}
	public List<Relation> getRelations() {
		return relationsList;
	}
	public void setRelations(List<Relation> relations) {
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
	@Override
	public String toString() {
		return "Project [getPackagesList()=" + getPackagesList() + ", getRelations()=" + getRelations() + ", getName()="
				+ getName() + ", getPath()=" + getPath() + "]";
	}
	

}
