package org.mql.java.parsers.parserImp;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Vector;
import org.mql.java.enumerations.RelationType;
import org.mql.java.models.RelationModel;

public class RelationParser {

	private Class<?> c;
	private List<RelationModel> relations;

	public RelationParser(Class<?> c) {
		this.c = c;
		this.relations = analyseClass(c);
	}

	private List<RelationModel> analyseClass(Class<?> c2) {
		List<RelationModel> relationsList = new Vector<>();

		for (Field field : c2.getDeclaredFields()) {
			Class<?> fieldType = field.getType().getClass();
			RelationType relationType = determineFieldRelationType(field);
			relationsList.add(new RelationModel(c2, fieldType, relationType));
		}

		Class<?> parentClass = c2.getSuperclass();
		if (parentClass != null && !parentClass.getName().equals("java.lang.Object")) {
			relationsList.add(
					new RelationModel(c2, parentClass, RelationType.GENERALIZATION));
		}
		for (Class<?> interfaceClass : c2.getInterfaces()) {
			relationsList.add(
					new RelationModel(c2, interfaceClass, RelationType.REALIZATION));
		}

		return relationsList;
	}

	private RelationType determineFieldRelationType(Field field) {
		if (Modifier.isStatic(field.getModifiers()) && Modifier.isFinal(field.getModifiers())) {
			return RelationType.COMPOSITION;
		} else if (field.getType().isArray() || Iterable.class.isAssignableFrom(field.getType())) {
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
		StringBuilder sb = new StringBuilder();
		for (RelationModel relation : relations) {
			sb.append(relation).append("\n");
		}
		return sb.toString();
	}
}
