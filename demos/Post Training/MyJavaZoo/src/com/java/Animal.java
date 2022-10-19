package com.java;

public class Animal {
	
	int legs;
	String name;
	String breed;
	public Animal() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Animal(int legs, String name, String breed) {
		super();
		this.legs = legs;
		this.name = name;
		this.breed = breed;
	}
	public int getLegs() {
		return legs;
	}
	public void setLegs(int legs) {
		this.legs = legs;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	@Override
	public String toString() {
		return "Animal [legs=" + legs + ", name=" + name + ", breed=" + breed + "]";
	}
}
