package com.revature.driver;

import java.util.Scanner;

import com.revature.models.Box;
import com.revature.models.Cat;

public class MainDriver {

	public static void main(String[] args) {
		// generics allow us to have type safety at compile time
		Box<Cat> kittyBox = new Box<Cat>();
		
		Cat fluffy = new Cat("Fluffy", "black", "persian", 9);
		
		//Q: How do we put Fluffy in the box?
		kittyBox.add(fluffy);
		
		//to show that fluffy made it to the box
		System.out.println("Here kitty kitty: " + kittyBox.get());
		
		//we can put other things inside of a box
		Box<Integer> numberBox = new Box<Integer>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter a number to put in the box: ");
		int number = scanner.nextInt();
		numberBox.add(number); //why am I able to put an int inside of an Integer box? Autoboxing!
		System.out.println("The number drawn from the box is: " + numberBox.get());
		
		//now we can utilize our generic method with any type of array
		Integer[] intArray = {21, 45, 62};
		Character[] charArray = {'a', 'b', 'z'};
		
		System.out.println("Now using the generic method....");
		printArray(charArray); //using generics allows us to have reusable pieces of code and reduces the amount of refactoring in your code
	}
	
	//this generic method will print the elements with a given array
	public static <E> void printArray(E[] arr) {
		for(E element: arr) {
			System.out.println(element);
		}
	}

}
