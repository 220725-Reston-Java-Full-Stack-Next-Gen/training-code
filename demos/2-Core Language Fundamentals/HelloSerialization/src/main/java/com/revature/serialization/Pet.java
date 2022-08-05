package com.revature.serialization;

import java.io.Serializable;

/* What is a Java bean and how is it different from a POJO (plain old Java object)?
 * 
 * - Java beans have the following properties:
 * 		private instance variables
 * 		getters/setters
 * 		overridden hashcode and equals methods
 * 		have no-args and all-args constructor
 * 		**implement the Serializable interface** (this is what makes them different from POJOs)
 * 
 */
public class Pet implements Serializable{
	
	//instance variables/fields
	private String name;
	private int tagNumber;
	private String breed;
	private String owner;
	private int age;
	private Color color; //brown, grey, black, white

}
