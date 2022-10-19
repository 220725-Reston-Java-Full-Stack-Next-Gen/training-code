package com.java;

public abstract class Zoo {
	//All abstract classes can contain both concrete methods and abstract methods.

	//What can go inside of an abstract class?
	//by default, all methods in an abstract class are public and abstract or default
	
	//1. abstract methods
	public abstract int add(int a, int b);
	
	//2. default methods
	int sum(int a, int b) {
		return a + b;
	}
	
	//Why use this: 
	//- Abstraction in general is when the programmer hides all but 
	//the relative information about an object to improve application security and managability
	
	//Abstract classes allow for code reusability and efficient app vunerabilities
	
	
	//An abstract method has no method body -- just the method signature. 
	//It will be the job of the implementing class that overrides this method to provide program logic
	public abstract String speak();
}
