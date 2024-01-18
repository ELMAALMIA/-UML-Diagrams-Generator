package org.mql.java.parsers.parserImp;

import java.io.File;
import java.text.Annotation;
import java.util.List;
import java.util.Vector;

import org.mql.java.models.AnnotationModel;
import org.mql.java.models.ClassModel;
import org.mql.java.models.Enumeration;
import org.mql.java.models.InterfaceModel;
import org.mql.java.models.PackageModel;
import org.mql.java.models.RelationModel;
import org.mql.java.utils.ClassesLoaderUtils;

public class PackageParser {

	private String packageName;
	private List<PackageModel> packages;
	private List<ClassModel> classes;
	private List<InterfaceModel> interfaces;
	private List<Enumeration> enumerations;
	private List<AnnotationModel> annotations;
	private PackageModel packageModel;
    private List<RelationModel> relations;

	public PackageParser(String path, String packageName) {
		this.packageName = packageName;
		packages = new Vector<>();
		classes = new Vector<>();
		interfaces = new Vector<>();
		enumerations = new Vector<>();
		annotations = new Vector<>();
		packageModel = new PackageModel(packageName);
		relations = new Vector<>();

		String packagePath = packageName.replace(".", "/");

		File dir = new File(path + "/bin/" + packagePath);

		File[] files = dir.listFiles();

		if (files != null) {
			for (File file : files) {
				String name = file.getName().replace(".class", "");
				String fullName = packageName + "." + name;

				if (file.isFile() && file.getName().endsWith(".class")) {
					Class<?> classFile = ClassesLoaderUtils.forName(path, fullName);

					if (classFile.isAnnotation()) {
						annotations.add(new AnnotationParser(classFile).getAnnotation());
					} else if (classFile.isInterface()) {
						interfaces.add(new InterfaceParser(classFile).getInterfaceModel());
					} else if (classFile.isEnum()) {
						enumerations.add(new EnumerationParser(classFile).getEnumeration());
					} else {
						classes.add(new ClassParser(classFile).getClassModel());
					}
				} else if (file.isDirectory()) {
					packages.add(new PackageParser(path, fullName).getPackageModel());
				}
			}
		}

		packageModel.setClasses(classes);
		packageModel.setInterfaces(interfaces);
		packageModel.setEnumerations(enumerations);
		packageModel.setAnnotations(annotations);
		packageModel.setPackages(packages);
		packageModel.setRelationst(relations);
		

	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageModel(PackageModel packageModel) {
		this.packageModel = packageModel;
	}

	public PackageModel getPackageModel() {
		return packageModel;
	}
}
