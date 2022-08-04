package com.revature.code;

public abstract class Animal {
	
	/*
	 * An abstract class cannot be instantiated! 
	 */
	
	private int legs;
	private String color;
	
	public Animal() {
		System.out.println("Hello joyful creature created!");
	}
	
	//abstract methods are methods that have no body and  
	//are meant to be inherited and implemented in the subclass

	//NOTE: be sure to study and know the difference between a method signature
	//and a method body!
	public abstract void makeSound();
	
	public void exists() {
		System.out.println("This animal is existing!");
	}
}
