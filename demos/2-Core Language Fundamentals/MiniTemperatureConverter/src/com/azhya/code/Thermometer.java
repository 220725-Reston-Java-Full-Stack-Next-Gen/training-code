package com.azhya.code;

import java.util.Arrays;

public class Thermometer {

	//class fields
	private int degreesF;
	private int degreesC;
	private String name;
	private int[] tempReadings = new int[3];
	
	//constructors
	//these two constructor have the method name but they have a different number of parameters
	//this concept is known as method overloading
	//note: method overloading can also occur when there are different datatypes of parameters but same number parameters
	
	//no args constructor = a constructor that can initialized object instance of this class without any parameters for any class fields
	public Thermometer() {
		super(); //tells the JVM that this is an object and therefore is able 
		//to override the Object class's methods like toString(), equals(), and hashcode()
	}
	
	//all args
	public Thermometer(int f, int c, String n, int[] arr) {
		this.degreesF = f;
		this.degreesC = c;
		this.name = n;
		this.tempReadings = arr;
	}

	//getters and setters
	//these are neccessary when we are implementing encapulsation in our Java code
	//as we need access to our private class fields here from our Main Driver
	public int getDegreesF() {
		return degreesF;
	}

	public void setDegreesF(int degreesF) {
		this.degreesF = degreesF;
	}

	public int getDegreesC() {
		return degreesC;
	}

	public void setDegreesC(int degreesC) {
		this.degreesC = degreesC;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[] getTempReadings() {
		return tempReadings;
	}

	public void setTempReadings(int[] tempReadings) {
		this.tempReadings = tempReadings;
	}

	//this annotation lets the JVM know that we are overriding the parent class 
	//implementation of this method (aka we are doing our own way to show the 
	//Thermometer class details instead of using Object class's implementation)
	//this is called method overriding, which is another form of encapulation in Java code
	@Override
	public String toString() {
		return "Thermometer [degreesF=" + degreesF + ", degreesC=" + degreesC + ", name=" + name + ", tempReadings="
				+ Arrays.toString(tempReadings) + "]";
	}
	
	public static int convertToFahrenheit(int c) {
		//(0 × 9/5) + 32
		return (int) (c * 1.8 + 32);
	}
	
	public static int convertToCelsius(int f) {
		//(32 − 32) × 5/9 
		return (int) ((f - 32)*5)/9;
	}
	
	public static void calculateAvgTemp(int[] temps) {
		//counter for total temp numbers, start at 0
		int total = 0;
		//iterate thru the array
		for(int i = 0; i < temps.length; i++) {
			//for each temp, add it to the total counter
			total += temps[i];
		}
		//end of loop
		
		//prints the total temps divided by 3
		System.out.println("The average temperature of these readings is: " 
				+ (total/3));
	}
}
