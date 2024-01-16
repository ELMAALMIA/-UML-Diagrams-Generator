package org.mql.java.models;

import java.util.List;
import java.util.Vector;

public class Model {
	private String name;
	private List<Attribute> attributes;
	private List<Method> methods;
	private String parent;
	
	public Model(String nom) {
	name = nom;
	attributes=new Vector<>();
	methods = new Vector<>();
	}

}
