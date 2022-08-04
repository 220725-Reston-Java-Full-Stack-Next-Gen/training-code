package com.revature.code;

public class Fish extends Animal{

	@Override
	public void makeSound() {
		System.out.println("*bubbles*");
	}
	
	//NOTE: abstract classes are like a binding contract in itself because 
	// its subclass must use its method signatures and its method signatures only!!
	//this method is not listed as a method signature in the Animal class
	public static void makeActualSound(int times) {
		for(int i = 0; i < times; i++) {
			System.out.print("gulp ");
		}
	}

}
