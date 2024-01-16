package org.mql.java.models;

import java.lang.reflect.Modifier;

import org.mql.java.enumerations.AccessModifier;

public class Canstant {
private String name;
	public Canstant() {
		// TODO Auto-generated constructor stub
	}
	protected AccessModifier visibility(int modifier) {
		String str = Modifier.toString(modifier);
		if(str.contains("public"))
			return AccessModifier.PUBLIC;
		else if(str.contains("private"))
			return AccessModifier.PRIVATE;
		else if(str.contains("protected"))
			return AccessModifier.PROTECTED;
		return AccessModifier.PACKAGE;
	}
}
