package com.revature.models;

public class Saiyan {
	
	/*
	 * Topic: Access Modifers
	 * - What is an access modifier?
	 * 
	 * An access modifier is a special keyword that determines whether other
	 * classes can use a particular field or invoke a particular method
	 * 
	 * Link: https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html
	 * 
	 * Types:		Class			Package			Subclass			World (Entire Program)
	 * public 		Y					Y				Y					Y
	 * private      Y					N				N					N
	 * protected    Y					Y				Y					N
	 * default      Y					Y				N					N
	 * 
	 * QC: know what is access modifiers, what are the types, and be able to explain each!
	 */
	
	/*
	 * Topic: Non-access modifiers
	 * 
	 * - Modifiers are keywords that let us fine-tune access to our classes, methods, and its members/fields in certain situations
	 * 
	 * final - makes variables unable to change value once assigned and methods unable to be overridden and classes unable from being inherited
	 * 
	 * abstract - if applied to a method, this keyword will make the method have to implement some logic in a subclass. if applied to a class, this keyword will make the class have to contain abstract methods (partial contract to our code)
	 * 
	 * static - the member belongs to the class, not to objects of that class
	 * (aka you do not have to use the object to access a static method or variable if it already belongs to the class)
	 * 
	 * NOTE: THESE 3 ARE NOT IMPORTANT UNTIL LATER!
	 * transisent - the member is skipped when serializing an object
	 * volatile - the variable value is always read from the main memory, not from a specific thread's memory
	 * synchronized - controls thread access to a block/method
	 */
	
	private int id;
	private String name;
	private String move;
	private int powerLevel;
	private int defenseLevel;
	
	// 3 types of constructors: no args, all args, and one with all args except id (this constructor is useful when creating data for your databases)
	public Saiyan() {
		super();
	}

	public Saiyan(int id, String name, String move, int powerLevel, int defenseLevel) {
		super();
		this.id = id;
		this.name = name;
		this.move = move;
		this.powerLevel = powerLevel;
		this.defenseLevel = defenseLevel;
	}

	public Saiyan(String name, String move, int powerLevel, int defenseLevel) {
		super();
		this.name = name;
		this.move = move;
		this.powerLevel = powerLevel;
		this.defenseLevel = defenseLevel;
	}
	
	//getters & setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMove() {
		return move;
	}

	public void setMove(String move) {
		this.move = move;
	}

	public int getPowerLevel() {
		return powerLevel;
	}

	public void setPowerLevel(int powerLevel) {
		this.powerLevel = powerLevel;
	}

	public int getDefenseLevel() {
		return defenseLevel;
	}

	public void setDefenseLevel(int defenseLevel) {
		this.defenseLevel = defenseLevel;
	}

	@Override
	public String toString() {
		return "Saiyan [id=" + id + ", name=" + name + ", move=" + move + ", powerLevel=" + powerLevel
				+ ", defenseLevel=" + defenseLevel + "]";
	}

	//hashcode is a function that returns the hashcode value of an object when called. hashcode = an integer that is generated by a hashing algorithm; this helps with quicker access to an object vs using the object's memory location or variable reference
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + defenseLevel;
		result = prime * result + id;
		result = prime * result + ((move == null) ? 0 : move.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + powerLevel;
		return result;
	}

	//== vs equals()
	//The equals method compares two objects and returns true if the objects are equal and false if not
	//== will only check if both objects point to the same memory location, and not check the contents
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Saiyan other = (Saiyan) obj;
		if (defenseLevel != other.defenseLevel)
			return false;
		if (id != other.id)
			return false;
		if (move == null) {
			if (other.move != null)
				return false;
		} else if (!move.equals(other.move))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (powerLevel != other.powerLevel)
			return false;
		return true;
	}
	
	
	
	

}