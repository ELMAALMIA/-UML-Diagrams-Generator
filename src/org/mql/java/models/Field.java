package org.mql.java.models;

import java.lang.reflect.Modifier;
import java.util.Collection;

import org.mql.java.enumerations.AccessModifier;

public class Field extends Property {

	private Multiplicity multiplicity;


	public Field(java.lang.reflect.Field f) {
		super(f.getName());
		setType(f.getType().getName());
		setNiveauVisiblity(determineVisibility(f.getModifiers()));
		setStatic(Modifier.isStatic(f.getModifiers())); 
		setFinal(Modifier.isFinal(f.getModifiers()));
		multiplicity = new Multiplicity();
		if (isIterable(f)) {
			multiplicity.setUpperBound("n");
		}
	}

	public static boolean isIterable(java.lang.reflect.Field field) {
		java.lang.Class<?> type = field.getType();
		return type.isArray() || Iterable.class.isAssignableFrom(type) || Collection.class.isAssignableFrom(type)
				|| type.getName().contains("List") || type.getName().contains("Set") || type.getName().contains("Queue")
				|| type.getName().contains("Deque");
	}

	public boolean isMultiple() {
		return multiplicity != null && multiplicity.isMultiple();
	}

	private AccessModifier determineVisibility(int mod) {
		if (Modifier.isPublic(mod)) {
			return AccessModifier.PUBLIC;
		} else if (Modifier.isPrivate(mod)) {
			return AccessModifier.PRIVATE;
		} else if (Modifier.isProtected(mod)) {
			return AccessModifier.PROTECTED;
		}
		return AccessModifier.PACKAGE;
	}

	@Override
	public String toString() {
		String visibilityString = getNiveauVisiblity().getSymbol();
//		String modifiers = (_static ? "{static} " : "") + (_final ? "{readonly} " : "");
		return visibilityString + " " + getName() + " : " + getType() + " " + (isMultiple() ? "[]" : "");
	}
}
