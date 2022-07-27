package com.revature;

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

}
