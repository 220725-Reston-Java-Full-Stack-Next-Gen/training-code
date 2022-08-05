package com.revature.garbagecollection;

public class GarbageDriver {
	
	//fields
	
	//The static keyword means that this value is shared on a global or class level
	//The final keyword means that the variable's value cannot be changed once assigned
	public final static int numThatNeverChanges = 9000;
	
	//this is an instance variable. So it's a property that can be set for each
	//GarbageDriver (GD) object
	int someNum;

	public static void main(String[] args) {
		
		System.out.println("Instantiating a GarageDriver Object");
		
		GarbageDriver gd1 = new GarbageDriver(); //new object was sent to the heap!
		gd1.someNum = 42;
		
		System.out.println("Instantiating another GarageDriver Object");
		GarbageDriver gd2 = new GarbageDriver();
		gd2.someNum = 4200;
		gd2.someNum = 1;
		
		System.out.println(gd2.someNum); //prints 1
		
		System.out.println("The static variable for the GarbageDriver is " + numThatNeverChanges);
		
		//this is impossible to assign due to this being a final variable
		//numThatNeverChanges = 1000;
		
		//how can we trigger gc in this example?
		gd1 = new GarbageDriver(); //here, gd1 now points to a new object so the 
		//object instantiated on line 19 will be garbage collected
		
		gd1 = null; //now the object instantiated on line 35 will be garbage collected
		
		//The Garbage collector is non-deterministic, which means that the GC process never has 
		//repeating process to it. This is why we never know when GC actually occurs
		
		//we can suggest that garbage collection occurs at a certain point in our code
		//by using System.gc() method
		System.gc(); //will encourage the collection of non-referenced objects in the heap
		
		//for triggering this event -- do not use this code in your projects!
		//this is an infinite loop (it's bad mojo)
		for(;;) {
			System.out.println("...");
		}
	}
	
	//Every object has a method called finalize() which is invoked by the GC when it
	//is removing objects from the heap
	
	@Override
	protected void finalize() {//this is inherited from the java.lang.Object class
		System.out.println("The object's (Garbage Driver) finalize method has been called!");
		
		System.out.println("************");
		System.out.println("************");
		System.out.println("************");
		System.out.println("************");
		System.out.println("************");
		System.out.println("************");
		
		System.out.println("goodbye!");
		
		System.exit(0); //this will end the program; the 0 means that nothing bad happened - a normal exit
	}

}
