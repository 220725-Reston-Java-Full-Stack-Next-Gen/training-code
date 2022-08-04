package com.revature.drivers;

import java.util.Scanner;

import com.revature.exceptions.AgeDeniedException;

public class MainDriver {

	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		divideTryCatch();
		
		int age = 20;
//here we were able to throw our exception but didn't handle it gracefully
//		boolean isValidAge = false;
//		
//		if(checkAge(age) > 1) { //this method can throw an exception. without try/catch, your program will stop at this point and not execute the rest of your code
//			isValidAge = true;
//			System.out.println("Okay for the club");
//			System.out.println("Is valid: " + isValidAge);
//		}else {
//			System.out.println("Sorry dude");
//			System.out.println("Is valid: " + isValidAge);
//		}
		
		//more graceful way to handle exception
		try {
			checkAge(age);
		}catch(AgeDeniedException exception) {
			System.out.println(exception);
		}
		
		System.out.println("Hello goodbye"); //old way never reaches this line of code
	}

	private static void divideTryCatch() {
		try {
			//some code here
			//ask the user to enter a number
			System.out.println("Please enter a dividend: ");
			int x = scan.nextInt();
			
			//ask the user to enter another number
			System.out.println("Please enter a divisor: ");
			int y = scan.nextInt();
			
			System.out.println("The answer is: " + (x/y));
		}catch(ArithmeticException e) {
			System.out.println("Please enter a number greater than 0");
		}
	}
	
//	public static int checkAge(int age) {
//		if(age < 21) {
//			//if the age is under 21, no access to the club!
//			//we throw an exception here
//			throw new AgeDeniedException("Sorry, you are " + age + " years old, which is under 21.");
//		}else {
//			return age;
//		}
//	}
	
	public static void checkAge(int age) {
		if(age < 21) {
			//if the age is under 21, no access to the club!
			//we throw an exception here
			throw new AgeDeniedException("Sorry, you are " + age + " years old, which is under 21.");
		}else {
			System.out.println("Welcome!");
		}
	}

}
