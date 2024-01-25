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
import org.mql.java.parsers.Parser;
import org.mql.java.utils.ClassesLoaderUtils;

public class PackageParser implements Parser {

	private String packageName;
	private List<PackageModel> packages;
	private List<ClassModel> classes;
	private List<InterfaceModel> interfaces;
	private List<Enumeration> enumerations;
	private List<AnnotationModel> annotations;
	private PackageModel packageModel;
	private List<RelationModel> relations;
	private List<RelationModel> relationlistsProject = new Vector<>();
	private String path;

	public PackageParser(String path, String packageName) {
		this.packageName = packageName;
		this.path = path;
		this.packages = new Vector<>();
		this.classes = new Vector<>();
		this.interfaces = new Vector<>();
		this.enumerations = new Vector<>();
		this.annotations = new Vector<>();
		this.packageModel = new PackageModel(packageName);
		this.relations = new Vector<>();
	}

	@Override
	public void parse() {
		String packagePath = packageName.replace(".", "/");

		File dir = new File(path + "/bin/" + packagePath);

		File[] files = dir.listFiles();

		if (files != null) {
			for (File file : files) {
				String name = file.getName().replace(".class", "");
				String fullName = packageName + "." + name;
				

				if (file.isFile() && file.getName().endsWith(".class")) {
					System.out.println(fullName);
					Class<?> classFile = ClassesLoaderUtils.forName(path, fullName);
					System.out.println(classFile);
					RelationParser relationParser = new RelationParser(classFile);
					if (classFile.isAnnotation()) {
						annotations.add(new AnnotationParser(classFile).getAnnotation());
					} else if (classFile.isInterface()) {
						InterfaceModel i = new InterfaceParser(classFile).getInterfaceModel();
						i.setRelations(relationParser.getRelations());
						relations.addAll(relationParser.getRelations());
						interfaces.add(i);
					} else if (classFile.isEnum()) {
						enumerations.add(new EnumerationParser(classFile).getEnumeration());
					} else {
						ClassModel c = new ClassParser(classFile).getClassModel();
						c.setRelations(relationParser.getRelations());
						relations.addAll(relationParser.getRelations());
						classes.add(c);
					}
				} else if (file.isDirectory()) {
					PackageParser packageParser = new PackageParser(path, fullName);
					packageParser.parse();
					packages.add(packageParser.getPackageModel());
				}
			}
		}

		packageModel.setClasses(classes);
		packageModel.setInterfaces(interfaces);
		packageModel.setEnumerations(enumerations);
		packageModel.setAnnotations(annotations);
		packageModel.setRelations(relations);
		packageModel.setPackages(packages);
		relationlistsProject.addAll(relations);
	}

	public String getPackageName() {
		return packageName;
	}

	private void getAll() {
		System.out.println(relationlistsProject);

	}

	public void setPackageModel(PackageModel packageModel) {
		this.packageModel = packageModel;
	}

	public List<RelationModel> getRelations() {
		return relationlistsProject;
	}

	public PackageModel getPackageModel() {
		return packageModel;
	}
}
