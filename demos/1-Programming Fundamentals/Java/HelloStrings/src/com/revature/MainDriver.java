package com.revature;


/*
 * What is a string?
 * 
 * Definition: a string is an array of characters (an array is a sequence or container of elements of a similar datatype)
 * 
 * In Java, strings & arrays are immutable (cannot be changed after creation)
 * 
 * We can manipulate and make complex strings with the use of Java's String API
 * 		- API = application programming interface
 * 		- here, this API consists of built-in methods that help us develop complex strings in our program and allow
 * 			us to do string manipulation
 */
public class MainDriver {

	public static void main(String[] args) {
		String greetings1 = "Hello, my name is Azhya.";
		String greetings2 = "Welcome to Revature.";
		
		//how do strings index their characters?
		//indexing with strings starts at 0, just like with arrays
		
		//to access the letter 'z' in greetings1 variable
		
		//eric's way
		System.out.println(greetings1.charAt(19)); //charAt() = return the character that is at that specified index
		
		//sharky's way
		char[] letters = greetings1.toCharArray(); //toCharArray() = converts your string contents into a char array
		System.out.println(letters[19]);
		
		//azhya's way - in case you do know the index of the element that you are looking for
		System.out.println(greetings1.indexOf('z')); //indexOf() = will return the index of the char specified, 
		//or its first occurrance of that character
		//note: this method is case-sensitive
		
		//how would I join my two greetings together into one sentence?
		//the concat() method joins two strings together
		System.out.println(greetings1.concat(" " + greetings2));
		
		//how can I tell how large my string is? How would I know the size?
		int size = greetings1.length();
		System.out.println("Size: " + size);
		
		//what if I just want to print 'Azhya' from greetings1 to the console?
		//substring() splits your string at the starting index and optional ending index
		String name = greetings1.substring(greetings1.indexOf('A'), size - 1);
		System.out.println("My name is: " + name);
		
		String badString = "Lions, Tigers, Bears";
		//how can I separate these animals within this string?
		//split() will divide your string into an array of strings based on a delimiter (aka a separator (, -) that the dev denotes)
		String[] animals = badString.split(",");
		
		//Alternative solution:
		//String[] animals = badString.replaceAll(" ", "").split(","); //replace() will replace a given character with another
		//replaceAll() will replace all instances of that character in the string with another specified character
		
		for(String animal : animals) {
			//how would I clear whitespace from the string?
			System.out.println(animal.trim()); //trim() will remove all leading and trailing whitespace in a string
		}
		
		/**
		 * StringBuilder vs. StringBuffer vs. String
		 * - Sbuild, Sbuff extend from the Object class (the parent class of all objects in java)
		 * - So in comparsion to each other:
		 * 
		 *	                STRING          STRINGBUFFER       STRINGBUILDER
		 *	----------------------------------------------------------------------
		 * 	Storage      |   String Pool     Heap                Heap
		 * 	Modifiable   |   Immutable   	Mutable           	Mutable
		 *	Thread Safe  |   YES             YES                 NO
		 *	Performance  |   FAST            VERY SLOW           FAST
		 * 
		 * - Sbuild, Sbuff has access to some object class methods like equals(), clone(), and toString() 
		 **/
		
	}

}
