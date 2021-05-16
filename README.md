# java-runtime-playground
A little gimmick with Java runtime from within a running Java application. 
The main purpose is to understand the handling of the JVM. 
Will be extended continuously.

## Annotations
Ever wondered how annotations work in Java and how they get processed or process data? Let's have a look
and do a deep dive on some examples.

This topic is divided into two separate modules to distinguish the configuration and implementation part from
the usage part. 

### annotation-library 
This is the implementation of some examples of annotations. Right now we have got two of those:
    
1. ***@CreationDate*** which adds the creation date metadata.
2. ***@BuilderProperty*** which generates a class Builder for the annotated class.

### annotation-sample
You can find example for usage of the annotation-library implementation.

### runtime-sample: 
Contains some samples to handle java runtime environment from within the running application.

### classloader-sample: 
Contains an example of how the JVM handles classloading.

## Links & Sources
 - Java Runtime Class Tutorial: https://www.javatpoint.com/java-runtime-class
 - JRE - Memory and Runtime Analysis: https://www.vogella.com/tutorials/JavaPerformance/article.html
