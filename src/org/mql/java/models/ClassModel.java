package org.mql.java.models;

import java.awt.Component;
import java.awt.Graphics;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.mql.java.parsers.parserImp.RelationParser;

public class ClassModel implements ModelInterface {
	private String name;
	private List<FieldModel> filedes;
	private List<MethodModel> methods;
	private List<ConstructorModel> Constructors;
	private List<String> interfacesImp;
	private List<String> inheritanceChain;
	private String parent;
	private List<RelationModel> relations;

	public ClassModel() {
		this.filedes = new Vector<>();
		this.methods = new Vector<>();
		this.Constructors = new Vector<>();
		this.interfacesImp = new Vector<>();
		this.inheritanceChain = new Vector<>();
		this.relations = new Vector<>();
	}

	public ClassModel(Class<?> c) {

		this.filedes = new Vector<>();
		this.methods = new Vector<>();
		this.Constructors = new Vector<>();
		this.interfacesImp = new Vector<>();
		this.inheritanceChain = new Vector<>();
		this.relations = new Vector<>();
		this.name = c.getSimpleName();
	
		this.parent = (c.getSuperclass() != null) ? c.getSuperclass().getName() : null;

		for (Field field : c.getDeclaredFields()) {
			this.filedes.add(new FieldModel(field));
		}
		for (Method method : c.getDeclaredMethods()) {

			this.methods.add(new MethodModel(method));
		}

		for (Constructor<?> constructor : c.getDeclaredConstructors()) {
			this.Constructors.add(new ConstructorModel(constructor, c.getSimpleName()));
		}

		for (Class<?> interfaceClass : c.getInterfaces()) {
			this.interfacesImp.add(interfaceClass.getName());
		}
		inheritanceChain = new Vector<>();
		Class<?> current = c;
		while (current != null) {
			inheritanceChain.add(current.getName());
			current = current.getSuperclass();
		}

	}

	public String getName() {
		return name;
	}

	public List<FieldModel> getFiledes() {
		return filedes;
	}

	public List<MethodModel> getMethods() {
		return methods;
	}

	public void addFiled(FieldModel fieldModel) {
		filedes.add(fieldModel);
	}

	public void setMethods(List<MethodModel> methods) {
		this.methods = methods;
	}

	public void addMethod(MethodModel m) {
		this.methods.add(m);
	}

	public List<ConstructorModel> getConstructors() {
		return Constructors;
	}

	public void setRelations(List<RelationModel> relations) {
		this.relations = relations;
	}

	public List<RelationModel> getRelations() {
		return relations;
	}

	private void addAll(List<RelationModel> relations) {
		relations.addAll(relations);
	}

	public void setConstructors(List<ConstructorModel> constructors) {
		Constructors = constructors;
	}

	public List<String> getInterfacesImp() {
		return interfacesImp;
	}

	public void setInterfacesImp(List<String> interfacesImp) {
		this.interfacesImp = interfacesImp;
	}

	public List<String> getInheritanceChain() {
		return inheritanceChain;
	}

	public void setInheritanceChain(List<String> inheritanceChain) {
		this.inheritanceChain = inheritanceChain;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setFiledes(List<FieldModel> filedes) {
		this.filedes = filedes;
	}

	public void addInterfacesImp(String i) {
		interfacesImp.add(i);
		
	}

	public void addConstructor(ConstructorModel constructorModel) {
		Constructors.add(constructorModel);
		
	}

	@Override
	public String toString() {
		String s = "\n\t\t\t--------------------------------------------------";
		for (FieldModel f : filedes)
			s += "\n\t\t\t" + f;
		s += "\n\t\t\t--------------------------------------------------";
		for (ConstructorModel c : Constructors)
			s += "\n\t\t\t" + c;
		for (MethodModel methodModel : methods)
			s += "\n\t\t\t" + methodModel;
		s += "\n\t\t\t--------------------------------------------------";
		return "Class :  " + getName() + s + " ";

	}

	@Override
	public void getXml() {

	}





}
