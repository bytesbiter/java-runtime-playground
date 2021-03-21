package com.softwarecrafter.annotation.library;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.ExecutableType;
import javax.tools.Diagnostic;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@SupportedAnnotationTypes("com.softwarecrafter.annotation.library.BuilderProperty")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
//@AutoService(Processor.class)
public class BuilderProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        for (TypeElement annotation : annotations) {
            Set<? extends Element> annotatedElements = roundEnv.getElementsAnnotatedWith(annotation);

            annotatedElements.forEach(System.out::println);

            Map<Boolean, List<Element>> annotatedMethods = annotatedElements.stream().collect(
                    Collectors.partitioningBy(element ->
                            ((ExecutableType) element.asType()).getParameterTypes().size() == 1
                                    && element.getSimpleName().toString().startsWith("set")));

            List<Element> setters = annotatedMethods.get(true);
            List<Element> otherMethods = annotatedMethods.get(false);

            otherMethods.forEach(element -> processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR,
                            "@BuilderProperty must be applied to a setXxx method with a single argument", element));

        }

        return false;
    }
}