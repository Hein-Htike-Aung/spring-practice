package com.hha;

import com.hha.beans.JDKDynamicProxy;
import com.hha.beans.JDKDynamicProxyImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan
@EnableAspectJAutoProxy
//@EnableAspectJAutoProxy(proxyTargetClass = true)  -> Only will work with CGLIB proxy
public class Config {

}
