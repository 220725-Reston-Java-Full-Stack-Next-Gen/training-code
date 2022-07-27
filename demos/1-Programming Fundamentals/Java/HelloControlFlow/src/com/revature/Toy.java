package com.revature;

public class Toy {

	private int id;
	private String toyName;
	private String color;
	private double price;
	private int quantity;
	private boolean isFlashy;
	
	//for this demo, i will not be providing a constructor for this object
	//so you guys can see what the JVM does when one is not presented by the developer
	
	
	//this is a getter
	public int getId() {
		return id;
	}

	//this is a setter
	public void setId(int id) {
		//the this keyword refers to the current object in a method or constructor
		//always refers the current object
		//in this case, this is referring to this class's id number
		this.id = id;
	}
	
	public String getToyName() {
		return toyName;
	}
	public void setToyName(String toyName) {
		this.toyName = toyName;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public boolean getIsFlashy() {
		return isFlashy;
	}
	public void setFlashy(boolean isFlashy) {
		this.isFlashy = isFlashy;
	}

	//this is an Java annotation
	// annotation = a tag that holds some metadata that provides useful information about our block of code 
	//and how it functions
	//here we are converting this Object class method to print out our class's contents in a more human-readable manner
	//this method comes originally from the Object class
	@Override
	public String toString() {
		return "Toy [id=" + id + ", toyName=" + toyName + ", color=" + color + ", price=" + price + ", quantity="
				+ quantity + ", isFlashy=" + isFlashy + "]";
	}
	
	
	
}
