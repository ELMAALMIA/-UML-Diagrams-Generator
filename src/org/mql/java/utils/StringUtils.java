package org.mql.java.utils;

public class StringUtils {

    public static String getSimpleName(String s) {
        int s1 = s.lastIndexOf('.');
        if (s1 >= 0) {
            return s.substring(s1 + 1);
        }
        return s;
    }
}
