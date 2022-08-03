package com.revature.drivers;

import com.revature.models.Saiyan;

public class MainDriver {

	/*
	 * variable scope = where java can see this variable and be able to use it
	 * 
	 * 3 scopes in Java:
	 * 1. static/class scope = only visible within the class
	 * 2. method scope = visible within the given method
	 * 3. block scope - visible within a block of code (ex. inside of a for loop)
	 */
	
	private static Saiyan goku = new Saiyan(1, "Goku", "Spirit Bomb", 9001, 1000);
	private static Saiyan vegeta = new Saiyan(2, "Vegata", "Final Flash", 9001, 1000);
	private static Saiyan goku2 = new Saiyan(1, "Goku", "Spirit Bomb", 9001, 1000);
	
	//what type of scope --> static/class scope
	//static int troubleNumber = 2000;
	
	public static void main(String[] args) {
//		for(int troubleNumber = 0; troubleNumber < 10; troubleNumber++) {
//			
//			//what type of scope is this one?
//			//block scope
//			System.out.println(troubleNumber);
//		}
		
		attack(goku, goku2);
		
		
	}
	
	
	public static void scopeExample() {
		//where can this variable be accessed?
		//what type of scope --> method scope
		//int troubleNumber = 2000;
		
	}
	
	public static void attack(Saiyan s1, Saiyan s2) {
		if(s1.equals(s2)) {
			//then you shouldn't attack yourself
			System.out.println("No punchie in the face please.");
		}else {
			//\n = new line
			//put the console cursor down to the start of the next line
			System.out.println("Two different saiyans: \n" + s1 + "\n" + s2);
		}
	}

}
