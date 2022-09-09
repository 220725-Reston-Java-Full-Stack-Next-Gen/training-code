package com.revature;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringDataApplication {
	
	private static Logger log = Logger.getLogger(HelloSpringDataApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringDataApplication.class, args);
		log.info("Hello World this is Azhya");
	}

}
