package com.revature.arraylists;

import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) {
		// An arraylist is a resizable array
		//Arraylist, like Arrays, are objects in Java
		
		//Note: modifying elements in a arraylist is very different from doing so in a array
		
		//how to create an arraylist
		
		//<String> = enclosing a Wrapper class to be the generic type for this arraylist
		//a wrapper class is a class that is dedicated to primitives
		ArrayList<String> fruits = new ArrayList<>();

		//by using wrapper classes, we can box our primitives into being "objects"
		//wrapper class have a primitive equivalent to itself
		//ex. int -> Integer, double -> Double, char-> Character, etc.
		//2 types of boxing:
		//a. Autoboxing = converting primitives to wrapper class
		int a = 100;
		Integer b = a; //autoboxing happens here!
		
		//b. Unboxing = converting wrapper class values into primitives
		Integer c = 50;
		int d = c; //unboxing happens here!
		
		//NOTE: boxing is different from casting!!!
		//casting is converting from one primitive datatype to another primitive datatype
		double e = b; //this is casting, not boxing!
		
		//how do I add elements to my arraylist?
		//the add() method inserts a single item of the same type as our list
		fruits.add("apple");
		fruits.add("banana");
		fruits.add("orange");
		
		//how do I see the elements in my arraylist?
		//the get() method will retrieve the element based on its index number
		System.out.println(fruits.get(0));
		
		//how to add a lot of elements at the same time to my arraylist
		ArrayList<String> dairy = new ArrayList<>();
		dairy.add("ice cream");
		dairy.add("yogurt");
		dairy.add("milk");
		
		fruits.addAll(dairy); //addAll() method requires a collection of the same type
		//to insert elements into its list
		
		//arraylist indexing is the same as arrays - starts at 0, 1, etc.
		System.out.println(fruits.get(4));
		
		//how to iterate thru an arraylist
		//using the enhanced for loop!
		for(String item : fruits) {
			System.out.println(item);
		}
		
		//more useful methods
		//how to remove an element from arraylist
		//remove() method deletes element by index position
		fruits.remove(2); //should remove orange
		
		System.out.println("After removal: ");
		for(String item : fruits) {
			System.out.println(item);
		}
		
		//how can I see the length of my arraylist?
		//the size() will show the arraylist length
		System.out.println("The size of this arraylist is " + fruits.size());
		
		//can I increase the size of my arraylist?
		//an arraylist by default has a capacity for 10 elements
		//arraylist can be used to increase capacity of its instances to ensure
		//that it can hold at least the number of elements specified by the minimum
		//capacity argument in the ensureCapacity() method
		
		fruits.ensureCapacity(30); //I'm not guranteed to increase the capacity here
		//because the JVM automatically sets a default of 10 and will double the capacity 
		//as elements are inserted into this list
		
		System.out.println(fruits.size());
		
		//NOTE: study the difference between capacity and size to arraylists!
		
		//how would I remove all elements at the same time from my arraylist?
		fruits.clear(); //clear() removes all contents from list
		
		System.out.println("After clear: ");
		for(String item : fruits) {
			System.out.println(item);
		}
	}

}
