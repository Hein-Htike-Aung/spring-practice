package com.hha.beans.qualifier02;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("class-qualifier-impl01")
public class ClassQualifierImpl01 implements ClassQualifier{
}
