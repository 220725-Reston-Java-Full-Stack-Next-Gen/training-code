package com.revature;

import java.util.Scanner; //import keyword is a java package, class, or interface that we utilizing in our own program

public class MainDriver {

	public static void main(String[] args) {
		//1. make an instance of our Toy object
		Toy car = new Toy(); //by default, the jvm will provide a default constructor 
		//if the developer doesn't make their own
		
		//how can make the car flashy
		//a: use the setter to set isFlashy to true
		car.setFlashy(true);
		
		//2. checking if toy is flashy
		ifFlashy(car.getIsFlashy());
		
		//3. iterate through inventory list based on quantity number
		car.setQuantity(10);
		
		checkToyInventory(car.getQuantity());
		
		//4. based a number, we will get back a color that we can set to our toy
		//ctrl + shift + o to automatically bring in an import
		Scanner scan = new Scanner(System.in); 
		System.out.print("Please enter a number: ");
		int choice = scan.nextInt();
		
		String color = chooseColor(choice);
		car.setColor(color);
		System.out.println("Result: " + car.getColor());
	}
	
	//what is a control flow statement?
	//a block of code that executes some task based on a condition
	//lets you control the flow of execution of code in your program
	
	//types of control flows:
	//1. if/else if/else
	//2. while/do while
	//3. switch
	//4. for/foreach
	
	public static void ifFlashy(boolean isFlashy) {
		if(isFlashy == true) {
			//if condition met, then this code block will run
			//if true
			System.out.println("I go bling bling!");
		}else {
			//if condition is not met, then the else block code is ran
			//else false
			System.out.println("No lights on this toy.");
		}
	}
	
	public static void checkToyInventory(int quantity) {
		//int i = 0 is serving as our counter for our loop => initialization = tells our for loop how many times to run
		//i = 0 -> first run
		//i = 1 -> second run
		//i = quantity -> nth run
		
		//i <= quantity is serving as our condition at which this block of code will execute => booleanExpression (true/false)
		//true => runs code
		//false => exits the code, continues program
		
		//i++ is serving as the update; the value of i will change to increase by 1 at the end of a run/iteration
		//giving our code block a reason to exit if the update causes i to be greater than quantity
		for(int i = 1; i <= quantity; i++) {
			//concatenation is the process of join two or more entities together
			//in java, we can concat a string together with a variable value by using the + operator
			
			//other operators: -, +, /, %, = 
			//logical operators: <=, >=, ==, +=, -=, && (AND), || (OR)
			//**research operators**
			System.out.println("Inventory item " + i);
		}
	}
	
	public static String chooseColor(int choice) {
		String color = "";
		
		switch(choice) {
			//in switch statements, there are cases based on the variable that we are checking
			case 1:
				System.out.println("Your color is red");
				color = "red";
				break; //the break keyword tells your program to exit this block of code at this point
				//in our case, the break tells our code to leave the switch statement
			case 2:
				System.out.println("Your color is blue");
				color = "blue";
				break;
				//no break stmt here
			default:
				//the default case will run its code if the choice isn't 1 or 2
				System.out.println("You are in the default. Try again.");
				color = "pink";
				break;
		}
		
		return color;
	}

}
