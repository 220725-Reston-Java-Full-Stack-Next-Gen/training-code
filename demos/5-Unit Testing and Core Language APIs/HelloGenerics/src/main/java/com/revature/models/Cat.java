package com.revature.models;

public class Cat {
	
	private String name;
	private String color;
	private String breed;
	private int lives;
	
	public Cat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cat(String name, String color, String breed, int lives) {
		super();
		this.name = name;
		this.color = color;
		this.breed = breed;
		this.lives = lives;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	@Override
	public String toString() {
		return "Cat [name=" + name + ", color=" + color + ", breed=" + breed + ", lives=" + lives + "]";
	}

}
