package org.mql.java.models;

import java.util.List;
import java.util.Vector;

public class PackageModel {
	private String name;
	private List<PackageModel> packages;
	private List<ClassModel> classes;
	private List<InterfaceModel> interfaces;
	private List<Enumeration> enumerations;
	private List<AnnotationModel> annotations;
	private List<RelationModel> relations;
	

	public PackageModel(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PackageModel> getPackages() {
		return packages;
	}

	public void setPackages(List<PackageModel> packages) {
		this.packages = packages;
	}

	public List<ClassModel> getClasses() {
		return classes;
	}

	public void setClasses(List<ClassModel> classes) {
		this.classes = classes;
	}

	public List<InterfaceModel> getInterfaces() {
		return interfaces;
	}

	public void setInterfaces(List<InterfaceModel> interfaces) {
		this.interfaces = interfaces;
	}

	public List<Enumeration> getEnumerations() {
		return enumerations;
	}

	public void setEnumerations(List<Enumeration> enumerations) {
		this.enumerations = enumerations;
	}

	public List<AnnotationModel> getAnnotations() {
		return annotations;
	}

	public void setAnnotations(List<AnnotationModel> annotations) {
		this.annotations = annotations;
	}

	public List<RelationModel> getRelations() {
		return relations;
	}

	public void setRelations(List<RelationModel> relations) {
		this.relations = relations;
	}

	public void addRelation(RelationModel relation) {
		this.relations.add(relation);
	}

	@Override
	public String toString() {
		String s = "";

		s += "Package : " + name + "\n";

		for (PackageModel p : packages) {
			s += "\t" + p + "\n";
		}
		for (ClassModel c : classes) {
			s += "\t" + c + "\n";
		}
		for (AnnotationModel a : annotations) {
			s += "\t" + a + "\n";
		}
		for (InterfaceModel i : interfaces) {
			s+= "\t" + i + "\n";
		}
		for (Enumeration e : enumerations) {
			s += "\t" + e + "\n";
		}
	for (RelationModel r: relations) 	s += "\t" + r + "\n";
		return s;
	}

}
