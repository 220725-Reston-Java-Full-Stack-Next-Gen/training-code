package com.azhya.code;

import java.util.Scanner;

public class MainDriver {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("Please enter a name for this device: ");
		
		String name = in.nextLine();
		
		//this is how java makes objects!!
		Thermometer obj = new Thermometer();
		
		obj.setName(name);
		
		System.out.println("Hi user, thanks for using " + obj.getName() + " today!");
		
		System.out.println("Please enter the temperature in Celsius: ");
		int celsius = in.nextInt();
		System.out.println("Please enter the temperature in Fahrenheit: ");
		int fahrenheit = in.nextInt();
		obj.setDegreesC(celsius);
		obj.setDegreesF(fahrenheit);
		
		int resultF = obj.convertToFahrenheit(celsius);
		int resultC = obj.convertToCelsius(fahrenheit);
		
		System.out.println("The temperature in " + celsius + " degrees Celsius is " + resultF + " degrees Fahrenheit.");
		System.out.println("The temperature in " + fahrenheit + " degrees Fahrenheit is " + resultC + " degrees Celsius.");
		
		
		System.out.println("Please enter three temperatures to calculate the average: ");
		int temp1 = in.nextInt();
		int temp2 = in.nextInt();
		int temp3 = in.nextInt();
		
		int[] temps = {temp1, temp2, temp3};
		
		obj.setTempReadings(temps);
		
		obj.calculateAvgTemp(obj.getTempReadings());
		
		System.out.println("Thanks for using the app. Goodbye!");
		//for good practice, it is good to close all inputstreams like Scanner to avoid memory leaks
		in.close();
	}

}
