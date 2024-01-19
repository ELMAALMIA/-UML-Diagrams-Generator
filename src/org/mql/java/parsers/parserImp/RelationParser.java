package org.mql.java.parsers.parserImp;

import java.util.List;
import java.util.Vector;

import org.mql.java.enumerations.RelationType;
import org.mql.java.models.ClassModel;
import org.mql.java.models.FieldModel;
import org.mql.java.models.InterfaceModel;
import org.mql.java.models.ModelEntity;
import org.mql.java.models.PackageModel;
import org.mql.java.models.ProjectModel;
import org.mql.java.models.RelationModel;

public class RelationParser {

	private List<PackageModel> packageModel;
	private List<RelationModel> relations;

	public RelationParser(List<PackageModel> packageModels) {
	
		this.packageModel=packageModels;
		this.relations = new Vector<>();
		
		for (PackageModel packageModel : packageModels) {
			analysePackage1(packageModel);
		}
	}
	private List<RelationModel> analysePackage1(PackageModel packageModel) {

		for (ClassModel classModel : packageModel.getClasses()) {
		
			relations.addAll(analyserRelationClass1(classModel, packageModel));
		}
		for (InterfaceModel interfaceModel : packageModel.getInterfaces()) {
			//relations.addAll(analyserRelationInterface(interfaceModel, packageModel));
		}
		return relations;
	}
	 private List<RelationModel> analyserRelationClass1(ClassModel classModel, PackageModel packageModel) {
		List<RelationModel> relationlList = new Vector<>();

	//ASSOCIATION,AGGREGATION,COMPOSITION
		for (FieldModel field : classModel.getFiledes()) {
			String fieldType = field.getType();
			if (isExist(fieldType, packageModel)) {
				RelationType relationType = determineFieldRelationType(field);
				relationlList
						.add(new RelationModel(classModel,fieldType , relationType));
			}
		}

		// heritage generalization
		String parentName = classModel.getParent();
		if (parentName != null && isExist(parentName, packageModel)) {
			relationlList.add(new RelationModel(classModel, findModel(parentName, packageModel),
					RelationType.GENERALIZATION));
		}

		//  realization
		for (String interfaceName : classModel.getInterfacesImp()) {
			if (isExist(interfaceName, packageModel)) {
				relationlList.add(new RelationModel(classModel, findModel(interfaceName, packageModel),
						RelationType.REALIZATION));
			}
		}

		return relationlList;
	}


	private List<RelationModel> analyserRelationClass(ClassModel classModel, PackageModel packageModel) {
		List<RelationModel> relationlList = new Vector<>();

	//ASSOCIATION,AGGREGATION,COMPOSITION
		for (FieldModel field : classModel.getFiledes()) {
			String fieldType = field.getType();
		
				RelationType relationType = determineFieldRelationType(field);
				System.out.println(classModel+ " "+fieldType+" "+relationType);
				relationlList
						.add(new RelationModel(classModel, fieldType, relationType));
			
		}

		// heritage generalization
//		String parentName = classModel.getParent();
//		if (parentName != null && isExist(parentName, packageModel)) {
//			relationlList.add(new RelationModel(classModel, findModel(parentName, packageModel),
//					RelationType.GENERALIZATION));
//		}

		//  realization
//		for (String interfaceName : classModel.getInterfacesImp()) {
//			if (isExist(interfaceName, packageModel)) {
//				relationlList.add(new RelationModel(classModel, findModel(interfaceName, packageModel),
//						RelationType.REALIZATION));
//			}
//		}

		return relationlList;
	}

	private boolean isExist(String type, PackageModel p) {
//
//			for (ClassModel classModel : packageModel.getClasses()) {
//				if (classModel.getName().equals(type)) {
//					return true;
//				}
//			}
//			for (InterfaceModel interfaceModel : packageModel.getInterfaces()) {
//				if (interfaceModel.getInterfaceName().equals(type)) {
//					return true;
//				}
//			}
//		
		return true;
	}

	private Object findModel(String typeName, PackageModel packageModel) {
		for (ClassModel classModel : packageModel.getClasses()) {
	        if (classModel.getName().equals(typeName)) {
	            return classModel;
	        }
	    }

	   
	    for (InterfaceModel interfaceModel : packageModel.getInterfaces()) {
	        if (interfaceModel.getInterfaceName().equals(typeName)) {
	            return interfaceModel;
	        }
	    }
	    return null;
	}

	private RelationType determineFieldRelationType(FieldModel field) {
		if (field.isMultiple() && field.isFinal()) {
			return RelationType.COMPOSITION;
		} else if (field.isMultiple()) {
			return RelationType.AGGREGATION;
		} else {
			return RelationType.ASSOCIATION;
		}
	}
	public List<RelationModel> getRelations() {
		return relations;
	}

	@Override
	public String toString() {
		String s= "";
		for (RelationModel relationModel : relations) {
			s+=relationModel +"\t\t\n";
		}
		return s;
	}
	
	


}
