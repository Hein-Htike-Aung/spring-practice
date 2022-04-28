package com.hha.beans.qualifier03;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Qualifier
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationQualifierType {

    AnnotationQualifier value();

    enum AnnotationQualifier {
        ANNOTATION_QUALIFIER_01, ANNOTATION_QUALIFIER_02
    }

}
