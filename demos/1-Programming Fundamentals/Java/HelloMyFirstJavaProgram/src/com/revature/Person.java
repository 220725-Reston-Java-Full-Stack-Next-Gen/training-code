package com.revature;

public class Person {
	//class is a blueprint for our objects
	//each class has properties (aka class fields, which are normally declared private primitives that make up the class)
	//each class has behaviors in the form of methods
	
	int age;
	double salary;
	String name;
	
	//what is needed to make a class?
	//the object must have a constructor
	//no args constructor
	public Person() {
		super(); //indicates that this object dervives from the Object class
		//the Object class is the parent class for all Java objects
		//therefore, the super keyword allows all subclasses to have access to the Object class's methods
		
		//is super() required to be written in here?
		//normally implicitly included in any constructor thanks to the JVM
		//always the first line in a constructor
	}
	
	//all args constructor
	public Person(int age, double salary, String name) {
		this.age = age;
		this.salary = salary;
		this.name = name;
		//this keyword refers the class member 
	}

	//access to our class fields requires us to use getters and setters
	//getter = retrieve values
	//setter = insert or add values
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//toString method comes from the Object class and allows us to see the contents of our objects
	//instead of seeing their hashcode or memory allocation 
	@Override
	public String toString() {
		return "Person [age=" + age + ", salary=" + salary + ", name=" + name + "]";
	}

}
