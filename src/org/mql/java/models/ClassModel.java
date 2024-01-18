package org.mql.java.models;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class ClassModel  implements ModelInterface{
	private String name;
	private List<FieldModel> filedes;
	private List<MethodModel> methods;
	private List<ConstructorModel> Constructors;
	private List<String> interfacesImp;
	private List<String> inheritanceChain;
	protected List<PropertyModel> properties;
	private String parent;
	public ClassModel(Class<?> c) {
		this.filedes = new Vector<>();
	    this.methods = new Vector<>();
	    this.Constructors = new Vector<>();
	    this.interfacesImp = new Vector<>();
	    this.inheritanceChain = new Vector<>();
	    this.properties = new Vector<>();
        this.name = c.getSimpleName();
        this.parent = (c.getSuperclass() != null) ? c.getSuperclass().getName() : null;

      
        for (Field field : c.getDeclaredFields()) {
            this.filedes.add(new FieldModel(field));
        }
        for (Method method : c.getDeclaredMethods()) {
  
            this.methods.add(new MethodModel(method));
        }

        for (Constructor<?> constructor : c.getDeclaredConstructors()) {
            this.Constructors.add(new ConstructorModel(constructor,c.getSimpleName()));
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
	

	@Override
	public String toString() {
		String s ="\n\t\t\t--------------------------------------------------"; 
		for(FieldModel f : filedes) s+="\n\t\t\t"+f; 
		s+="\n\t\t\t--------------------------------------------------"; 
		for(MethodModel methodModel : methods) s+="\n\t\t\t"+methodModel; 
		for(ConstructorModel c : Constructors) s+="\n\t\t\t"+c;
		s+="\n\t\t\t--------------------------------------------------"; 
		return "Class  " + getName() + s;
		
	}

@Override
public void getXml() {
	
}

}
