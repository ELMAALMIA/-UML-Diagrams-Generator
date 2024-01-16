package org.mql.java.xml.dom.parserImp;

import java.io.File;
import java.util.logging.Logger;

import org.mql.java.xml.dom.Parser;

public class PackageParser implements Parser{

	private static  Logger logger ;
	@Override
	public Object parse(File packageFolder) {
		logger= Logger.getLogger(PackageParser.class.getName());
//		 FilesUtils filesUtils = new FilesUtils(); 
//
//		if(filesUtils.isAValidPackage(packageFolder)) {
//			logger.info("Parsing package : " + packageFolder.getAbsolutePath());
//			Package thePackage = new Package(packageFolder.getAbsolutePath());
//			Parser parser = new ClassifierParser();
//			for(File file : packageFolder.listFiles()) {
//				if(FileUtils.isAValidClassFile(file)) {
//					UMLClassifier classifier = (UMLClassifier) parser.parse(file);
//					thePackage.addClassifier(classifier);
//				}
//			}
//			return thePackage;
//	}
		return null;
	
}}
