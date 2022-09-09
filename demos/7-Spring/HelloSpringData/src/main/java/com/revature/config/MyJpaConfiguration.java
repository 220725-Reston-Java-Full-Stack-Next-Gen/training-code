package com.revature.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//1. mark this class as a configuration component for the spring ioc container to manage as a bean
//2. need to mark this particular configuration for Spring Data JPA
@Configuration
@EnableJpaRepositories("com.revature.repositories")
@EnableJpaAuditing
@EnableTransactionManagement
public class MyJpaConfiguration {
	//there will be no need to add code here. All of the configuration data is stored in the metadata inside of the annotations that we will be using
}
