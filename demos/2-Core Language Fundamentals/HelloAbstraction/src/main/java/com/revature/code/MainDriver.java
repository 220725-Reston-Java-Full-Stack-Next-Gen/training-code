package com.revature.code;

public class MainDriver {

	public static void main(String[] args) {
		//Animal is my reference type for the frog object
		//I can now reassign this variable to any other object whose class extends Animal
		Animal a1 = new Frog();

		a1.exists();
		
		a1.makeSound();
		
		a1 = new Fish();
		//because we are overloading the frog methods to the fish methods by reassigning the reference
		//making it unable to view other implemented method in that subclass
		a1.makeSound();
		
		//Animal a2 = new Fish(); makeActualSound() cannot be used here
		Fish a2 = new Fish();
		a2.makeActualSound(3);
		
	}

}
