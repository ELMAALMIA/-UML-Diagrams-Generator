package org.mql.java.utils;

import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ClassesLoaderUtils {

	public static Class<?> forName(String projectPath, String className) {
		try {
			Path binPath = Paths.get(projectPath, "bin");

			try (URLClassLoader urlClassLoader = new URLClassLoader(new URL[] { binPath.toUri().toURL() })) {
				return urlClassLoader.loadClass(className);
			}
		} catch (Exception e) {
			System.out.println(className + " not found");
			
			return null;
		}
	}
}
