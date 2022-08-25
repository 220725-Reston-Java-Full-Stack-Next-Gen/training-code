package com.revature.models;

//to make a class generic, you must put the type parameter in the class signature following the name of the class
public class Box <T>{
	
	//can also have generic class members
	private T t;
	
	//making some generic methods here
	public void add(T t) {
		this.t = t;
	}
	
	public T get() {
		return t;
	}
}
