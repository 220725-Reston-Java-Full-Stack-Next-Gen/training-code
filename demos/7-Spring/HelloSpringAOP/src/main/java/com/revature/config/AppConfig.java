package com.revature.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//To turn on component scanning via a configuration class, we must do the following:
//1. denote this class as a configuration class by using the @Configuration annotation
//2. use the @ComponentScan annotation and provide a list of packages for the IoC container to scan for beans
//
//Also, we need to enable aspect coding by using the @EnableAspectJAutoProxy annotation. This annotation allows for AspectJ to work properly with Spring AOP
@Configuration
@ComponentScan(basePackages = {"com.revature.repos", "com.revature.services", "com.revature.aspects"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {

	//here I don't have to provide any additional code because the annotations' metadata will be used to help the Spring AOP look for our components and make sure the Spring AOP is working
}
