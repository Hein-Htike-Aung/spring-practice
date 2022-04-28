package com.hha.service;

import com.hha.beans.qualifier02.ClassQualifier;
import com.hha.beans.qualifier03.AnnotationQualifier;
import com.hha.beans.qualifier03.AnnotationQualifierType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class FieldQualifierService03 {

    @Autowired
    @AnnotationQualifierType(AnnotationQualifierType.AnnotationQualifier.ANNOTATION_QUALIFIER_01)
    private AnnotationQualifier annotationQualifierImpl01;

    @Autowired
    @AnnotationQualifierType(AnnotationQualifierType.AnnotationQualifier.ANNOTATION_QUALIFIER_02)
    private AnnotationQualifier annotationQualifierImpl02;

    public void print() {
        System.out.println(annotationQualifierImpl01.getClass().getSimpleName());
        System.out.println(annotationQualifierImpl02.getClass().getSimpleName());
    }
}
