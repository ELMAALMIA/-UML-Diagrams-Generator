package org.mql.java.parsers.parserImp;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;
import java.util.Vector;
import java.util.logging.Logger;

import org.mql.java.models.ClassModel;
import org.mql.java.models.ConstructorModel;
import org.mql.java.models.Enumeration;
import org.mql.java.models.FieldModel;
import org.mql.java.models.InterfaceModel;
import org.mql.java.models.MethodModel;
import org.mql.java.models.ModelEntity;
import org.mql.java.models.ModelInterface;
import org.mql.java.models.ProjectModel;
import org.mql.java.parsers.Parser;
import org.mql.java.utils.ClassesLoaderUtils;
public class ClassParser {
    private ClassModel classModel;
    private String className ;
   

    public ClassParser(Class<?> class1) {
        //loadInheritanceChain(class1);
        //classModel.InheritanceChain(inheritanceChain);
        this.classModel = new ClassModel(class1);
        this.className=class1.getName();
        
    }
    
    @Override
    public String toString() {

    	return "class "+className;
    }

	public ClassModel getClassModel() {
		return classModel;
	}

	public void setClassModel(ClassModel classModel) {
		this.classModel = classModel;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
   

}
