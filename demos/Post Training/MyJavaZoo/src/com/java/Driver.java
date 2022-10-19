package com.java;


public class Driver{

	public static void main(String[] args) {

		Animal snake = new Animal(0, "Slimy", "Cobra");
		
		Zoo zoo = new MemphisZoo();
		
		System.out.println(zoo.speak() + snake.getName());
	}
}
