package com.softwarecrafter.classloader;

/**
 * To test classloading please execute following command:
 * 1. java -verbose:class -classpath <asolute path to directory containing the compiled .class files of classloader directory> com.softwarecrafter.classloader.SampleLoader
 *    Example: java -verbose:class -classpath /Users/roman/projects/java-runtime-playground/target/classes com.softwarecrafter.classloader.SampleLoader
 * 1.1 check verbose output containing the "Test!" printout
 * 2. Uncomment ClassA from below and rerun compilation as well as the java command from 1
 */
public class SampleLoader {

    public static void main(String[] args) {
        System.out.println("Test!");

        /**
         * Uncomment this for step 2.
         */
        ClassA a = new ClassA();
        a.method();
    }
}
