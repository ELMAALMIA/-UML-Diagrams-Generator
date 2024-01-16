package org.mql.java.parsers.parserImp;

import java.io.File;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Logger;


import org.mql.java.models.Enumeration;
import org.mql.java.models.Field;
import org.mql.java.models.Interface;
import org.mql.java.models.Method;
import org.mql.java.models.ModelEntity;
import org.mql.java.models.Project;
import org.mql.java.parsers.Parser;

public class ClassParser implements Parser<File> {
	private static Logger logger = Logger.getLogger(ClassParser.class.getName());
	private static URLClassLoader loader = null;

	public ClassParser() {

	}

	@Override
	public File parse(File file) {
		// parse into model
		logger.info("Parsing file: " + file.getName());
		ModelEntity classEntity = null;
		Class<?> c = loadClass(file);
        // initialize classEntity by type 
		if (c != null) {
			String name = retrieveClassPath(file.getAbsolutePath());
			if (c.isAnnotation()) {
				logger.info("annotation: ");
			} else if (c.isEnum()) {
				classEntity = new Enumeration(name);

			} else if (c.isInterface()) {
				classEntity = new Interface(name);

			} else {
				
				//get interface if it class
				classEntity = new org.mql.java.models.Class(name);
				for(Class<?> i: c.getInterfaces()) {
					String nameIter = i.getName();
					((org.mql.java.models.Class)classEntity).addInterface(nameIter)	;
				}
				
			}
          
			if(c.isEnum()){
				System.out.println("enuum");
			}
			else {
				
			}
                  // parent class
                String parent ;
                if(c.getSuperclass()==null) {
                	parent = "";
                }else {
                        parent = c.getSuperclass().getName();
                }
			classEntity.setParent(parent);
            // get Methods
            for (java.lang.reflect.Method m : c.getDeclaredMethods()) {
//                String nameMethod = m.getName();
//                String typeMethod = m.getReturnType().getName();
                ((org.mql.java.models.Class)classEntity).addpropertie(new Method(m));
            }
			}

            //get Fields
            for (java.lang.reflect.Field f : c.getDeclaredFields()) {
                String nameField = f.getName();
                String typeField = f.getType().getName();
                ((org.mql.java.models.Class)classEntity).addpropertie(new Field(f));	

                //  get constructor
                if(c.isInterface()) {
                	System.out.println("interface");
                }else {
                	System.out.println("interface");
                	for(Constructor<?> constructor : c.getDeclaredConstructors()) {
                	     ((org.mql.java.models.Class)classEntity).addpropertie(new Field(f));	
                	}
                }
		}
       

		return null;
		}

	

	private Class<?> loadClass(File file) {
		try {
			if (loader == null) {
				// absute path ( eviter erreur null)
				URL classUrl = new URL("file:///" + Project.getAbsolutePath().replace('\\', '/') + "/");
				loader = URLClassLoader.newInstance(new URL[] { classUrl });
			}
			String className = convertFileToClassName(file);
			return loader.loadClass(className);
		} catch (Exception e) {
			logger.severe("Failed to load class from file: " + file.getName());
			e.printStackTrace();
		}
		return null;
	}

	private String convertFileToClassName(File file) {
		String relativePath = file.getAbsolutePath().replace(Project.getAbsolutePath() + File.separator, "");
		String className = relativePath.replace(File.separatorChar, '.');
		if (className.endsWith(".class")) {
			className = className.substring(0, className.length() - 6);
		}
		return className;
	}

	private String retrieveClassPath(String absolutePath) {
		String relativePath = absolutePath.replace(Project.getAbsolutePath() + File.separator, "");
		return relativePath.replace(File.separatorChar, '.');
	}

	private String retrieveProjectPathFrom(String str) {
		return str.replace(Project.getAbsolutePath() + File.separator, "");
	}
}
