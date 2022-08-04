package com.revature.code;

public interface Ectothermic {

	//an interface is a binding contract between itself and implementation class that is using it. this contract details what methods should be implemented by contracting class by the interface providing the method signatures
	
	//NOTE: study difference AC and interfaces!
	
	//Can interfaces have fields/class members?
	//yes you can
	// all attributes (fields) of an interface are by default PUBLIC, STATIC, and FINAL
	public static final int MIN_BODY_TEMP = -40;
	public static final int MAX_BODY_TEMP = 90;
	
	// all methods in an interface are inherently public and abstract
	void heatUp();
	void coolDown();
	
	//can interfaces contain default methods?
	//YES YOU CAN! This feature for interfaces to do this was introduced in Java 7
	default void saySomething() {
		System.out.println("Naw nah, no jose");
	}
}
