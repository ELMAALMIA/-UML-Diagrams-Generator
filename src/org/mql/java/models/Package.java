package org.mql.java.models;

import java.util.List;
import java.util.Vector;

public class Package {
	private String name;
	private List<Model> list;
	public Package() {
		
	}
public Package(String nom) {
		name=nom;
		list=new Vector<>();
	}
public void add(Model m) {
	list.add(m);
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public List<Model> getList() {
	return list;
}
public void setList(List<Model> list) {
	this.list = list;
}
@Override
public String toString() {
	return "Package Name()=" + getName() + ", List()=" + getList() + ", getClass()=" + getClass()
			+ ", hashCode()=" + hashCode() ;
}


}
