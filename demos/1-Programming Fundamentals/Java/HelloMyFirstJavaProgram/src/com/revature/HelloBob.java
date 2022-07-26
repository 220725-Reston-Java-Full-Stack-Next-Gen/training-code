package com.revature;

public class HelloBob {
//a class is a blueprint of our objects - allowing us to make sophsicated and flexible apps
	//for any java program, the entrypoint to that program is called a main method
	
	public static void main(String[] args) {
		//single line comment
		/* 
		 * multi-line comment
		 * 
		 */
		
		//to make a variable in java, you must have the following:
		//1. datatype = because of Java being a strictly typed language, all variables must be a datatype
			//2 types of data:
			//primitives and objects
			//primitive: int, short, long, double, boolean, char, byte, float
			//objects: strings, arrays, collections, objects
		//2. variable name = unique identifer for that variable
		//3. (optional) must be initialized (aka given an initial assignment)
		int num = 5;
		int bob = 'b'; //unicode for b is 98
		
		// in order to print to console, you must use System.out.println
		System.out.println(bob); //print 98
		
		/* Why?
		 * 
		 * Casting is the converting from one datatype to another
		 * 
		 * Casting goes in two directions:
		 * ex. int to double / double to int
		 * 
		 * 
		 * 1) downcasting = from a high precision type to a lower precision type
		 * 4.05 -> 4
		 * 		could lose some data in this conversion
		 * 2) upcasting = from a low-level precision type to higher precision type
		 * 		can have extra placeholders here
		 * 2 -> 2.00
		 * */
		
		//we would need to call own methods in order to use them
		countdown(num);
		
		//make an instance of our person and print out his info
		//here we will use the new keyword
		Person john = new Person(28, 50001.40, "John Smith");
		System.out.println(john);
		
		//you change values from an object by using a setter
		john.setAge(19);
		System.out.println(john.getAge());
	}
	
	//a method is a function or block of code that performs a certain task
	//parameter = an argument that provides input into a method = provide info to our block of code
	
	//public = access modifier that indicates that this method is available for entire app
	//static = non-access modifier indicates that this method belongs to this class only and that all other classes must make an instance of this class in order to use this method = class-only modifier
	//void = non-access modifier = returns nothing
	public static void countdown(int startNumber) {
		//algorithm is a series of step at which a developer proceeds to solve a problem in their code
		//we usually outline this thru the use of pseudocode
		//1. input
		//startNumber = int
		
		//2. process
		//a. iterate or loop from my starting number to 0
		
		//this is a control flow statement
		//control flow statement is a block of code that execute some task based on a condition
		//3 parts:
			//1. condition
			//2. action performed during condition
			//3. update trigger from condition (aka constant changing variable that will make your condition go from 
			//true to false
		while(startNumber != 0) {
			//b. for each number, print it to the console
			System.out.println(startNumber);
			
			//-- will decrease any number by 1; ++ increases by 1
			//startNumber -= 1;
			//5 - 1 = 4
			startNumber--;
		}
		
		//3. output/end result
		//print out "end of countdown"
		System.out.println("end of countdown");
	}
}