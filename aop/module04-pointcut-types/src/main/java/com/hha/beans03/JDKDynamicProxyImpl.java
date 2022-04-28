package com.hha.beans03;

import com.hha.annotations.ArgumentLevelProxyAnnotation;
import com.hha.annotations.TargetClassLevelProxyAnnotation;
import com.hha.ds.Employee;
import org.springframework.stereotype.Component;

@Component
@TargetClassLevelProxyAnnotation
public class JDKDynamicProxyImpl implements JDKDynamicProxy{

    @Override
    public void target() {
    }

}
