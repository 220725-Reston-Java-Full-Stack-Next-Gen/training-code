package com.java;

//how would you inherit an abstract class?
public class MemphisZoo extends Zoo{

	@Override
	public int add(int a, int b) {
		return a + (b * 2);
	}

	@Override
	public String speak() {
		return "Hello Animal ";
	}
}
