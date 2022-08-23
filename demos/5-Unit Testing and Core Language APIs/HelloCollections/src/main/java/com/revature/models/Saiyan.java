package com.revature.models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//Lombok allows us to reduce the amount of coding (akak boilerplate code)
//that we will need to do in our POJOs by using annotations above the class
//itself
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor //Lombok normally doesn't have good documentation for use of requiredArgs constructor, so you will
//still need to generate that constructor.
public class Saiyan {
	
	private int id;
	private String name;
	private String planet;
	private int powerLevel;

}
