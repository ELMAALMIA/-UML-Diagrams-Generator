package org.mql.java.models;

import java.util.List;
import java.util.Vector;

public class PackageModel {
	private String name;
	public List<PackageModel> packages;
	public List<ClassModel> classes;
	private List<InterfaceModel> interfaces;
	private List<Enumeration> enumerations;
	private List<AnnotationModel> annotations;
	public List<RelationModel> relations;
	
	public PackageModel(String name) {
	    this.name = name;
	    this.packages = new Vector<>();
	    this.classes = new Vector<>();
	    this.interfaces = new Vector<>();
	    this.enumerations = new Vector<>();
	    this.annotations = new Vector<>();
	    this.relations = new Vector<>();
	}
	
	public PackageModel() {
		    this.packages = new Vector<>();
		    this.classes = new Vector<>();
		    this.interfaces = new Vector<>();
		    this.enumerations = new Vector<>();
		    this.annotations = new Vector<>();
		    this.relations = new Vector<>();
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
		return this.relations;
	}

	public void setRelations(List<RelationModel> relations) {
		this.relations = relations;
	}
	
	public void showRelarion() {
		System.out.println("relation");
		System.out.println("relation ; "+relations.size());
		for (RelationModel r: this.getRelations()) {
			System.out.println(r);
		}
	}

	public void addRelation(RelationModel relation) {
		this.relations.add(relation);
	}

	@Override
	public String toString() {
		String s = "";

		s += "Package : " + getName() + "\n";

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
		
		//for (RelationModel r: this.getRelations()) 	s += "\t" + r + "\n";
		return s;
	}

	
}
