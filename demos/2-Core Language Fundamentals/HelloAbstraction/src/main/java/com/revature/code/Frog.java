package com.revature.code;

//this class is known as a concrete class
//in order to inherit the behaviors of a abstract class, we must extend that class
//in order to inherit/sign this concrete class to an interface, we must implement that interface

//NOTE: know the difference between extends vs implements keywords!

//Java does NOT support multi-inheritance, meaning I can only extend ONE class 
//but you can implement MULTIPLE interfaces
public class Frog extends Animal implements Amphibious, Ectothermic{

	@Override
	public void heatUp() {
		System.out.println("Heating in the sun");
	}

	@Override
	public void coolDown() {
		System.out.println("Chilling in the pond");
	}

	@Override
	public void swim() {
		System.out.println("Using slimy skin to glide in water");
	}

	@Override
	public void makeSound() {
		int times = 3;
		
		for(int i = 0; i < times; i++) {
			System.out.print("ribbit ");
		}
	}

}
