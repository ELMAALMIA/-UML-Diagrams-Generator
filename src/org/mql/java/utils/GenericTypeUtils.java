package org.mql.java.utils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericTypeUtils {
    public static String getGenericType(  Type genericType) {
        if (genericType instanceof ParameterizedType) {
            ParameterizedType pType = (ParameterizedType) genericType;
            Type[] fieldArgTypes = pType.getActualTypeArguments();
            if (fieldArgTypes.length > 0) {
                String fullTypeName = fieldArgTypes[0].getTypeName();
                return StringUtils.getSimpleName(fullTypeName); 
            }
        }
        return ""; 
    }
}

