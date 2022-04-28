package com.hha.beans.qualifier02;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("class-qualifier-impl02")
public class ClassQualifierImpl02 implements ClassQualifier{
}
