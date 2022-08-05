package com.revature.serialization;

import java.io.Serializable;

/* What is a Java bean and how is it different from a POJO (plain old Java object)?
 * 
 * - Java beans have the following properties:
 * 		private instance variables
 * 		getters/setters
 * 		overridden hashcode and equals methods
 * 		have no-args and all-args constructor
 * 		**implement the Serializable interface** (this is what makes them different from POJOs)
 * 
 */
public class Pet implements Serializable{
	
	//instance variables/fields
	private String name;
	private int tagNumber;
	private String breed;
	private String owner;
	private int age;
	private Color color; //brown, grey, black, white
	
	//no args constructor
	public Pet() {
		super();
		// TODO Auto-generated constructor stub
	}

	//all args (fully parameterized) constructor
	public Pet(String name, int tagNumber, String breed, String owner, int age, Color color) {
		super();
		this.name = name;
		this.tagNumber = tagNumber;
		this.breed = breed;
		this.owner = owner;
		this.age = age;
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTagNumber() {
		return tagNumber;
	}

	public void setTagNumber(int tagNumber) {
		this.tagNumber = tagNumber;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((breed == null) ? 0 : breed.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + tagNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pet other = (Pet) obj;
		if (age != other.age)
			return false;
		if (breed == null) {
			if (other.breed != null)
				return false;
		} else if (!breed.equals(other.breed))
			return false;
		if (color != other.color)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (tagNumber != other.tagNumber)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pet [name=" + name + ", tagNumber=" + tagNumber + ", breed=" + breed + ", owner=" + owner + ", age="
				+ age + ", color=" + color + "]";
	}
}
