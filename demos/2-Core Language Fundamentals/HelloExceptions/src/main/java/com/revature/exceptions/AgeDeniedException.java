package com.revature.exceptions;

/* Topic: Exception Handling
 * 
 * An exception is an unexpected interruption from your regular program flow
 * 
 * Exceptions therefore have to be caught and handled by the program.
 * 
 * 2 types of exceptions:
 * Checked - known as compile-time exceptions - these exceptions are checked at compile-time by the compiler
 * 
 * Unchecked - known as runtime exceptions - these exceptions will not be checked at compile-time but at runtime
 * 
 * - What makes an error different from an exception?
 * - An error is NOT the same as an exception!!!
 * - Error is the subclass of Throwable class
 * - when errors occur, they show as compiliation errors (aka red underlined code)
 * - ex. StackOverflowError = memory full, app crashes
 * 
 * We can handle exceptions by using try/catch/finally loops!
 */
public class AgeDeniedException extends RuntimeException{
	//to make your own exceptions, you must extend your class from the RuntimeException or Exception class
	//extends keyword is how java inherits from parent class to child class
	
	//constructor that takes in a string message
	//constructor = special method that is used to initialize objects
	public AgeDeniedException(String message) {
		super(message);
	}
}
