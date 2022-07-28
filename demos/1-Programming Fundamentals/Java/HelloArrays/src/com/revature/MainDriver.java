package com.revature;

import java.util.Arrays;

/*
 * What is an array?
 * - In Java, arrays are objects!!
 * - an container or grouping of similar elements
 * - holds a fixed number of values of the same type
 * - ex. array of integers for student's grade, array of names of employees
 * 
 * - Note:
 * Once you set the size of your array, you cannot change it again
 * makes array "immutable" (cannot be changed once initialized)
 * 
 * - How are array organized?
 * - By indexing its elements, index for an array will always start at 0 and go up to the array's length - 1
 * 
 * Ex:
 * int[] nums = {1,2,3};
 * -- to access element in array, you must use square notation
 * System.out.println(nums[0]); //print 1
 * System.out.println(nums[3]); //print an exception
 * 
 * There are some methods that we can use to manipulate or change the way our array will look.
 */
public class MainDriver {

	public static void main(String[] args) {
		System.out.println("Welcome to my zombie killer program! Let's kill some arrays!!");
		
		String[] zombies = {"runner", "bomber", "spitter", "crawler", "walker", "tanker", "nerd"};
		
		int size = zombies.length;

		System.out.println(size);
		
		//to iterate thru an array, we must use a for loop or an enhanced for loop (difference in the loop signature syntax)
		
		//normal for loop
		for(int i = 0; i < zombies.length; i++) {
			System.out.println("Zombie #" + i + " is a " + zombies[i]);
		}
		
		//System.out.println(zombies[7]); //prints exception
		//what is this red text all about?
		//a stack trace is a report of the active stack frames at a certain point in time during a program's execution
		//here, we can analyze the exception message to determine why and where our code is failing
		
		zombies[0] = "sprinter";
		
		//enhanced for loop
		//also iterates thru our array without the need to worry about indexing nor updates as we loop
		for(String zombie : zombies) {
			System.out.println("Zombie: " + zombie);
		}
		
		int[] bullets = new int[10];
		int counter = 0;
		
		//how do I fill each element in my bullets array to have a number value?
		while(counter < bullets.length) {
			bullets[counter] += counter;
			counter++;
		}
		
		//prevent hashcode of object showing, we will be using the toString() method
		//because I haven't overridden the default toString behavior, I will still see the hashcode
		//System.out.println(bullets.toString());
		System.out.println(Arrays.toString(bullets)); //this is the Arrays utility class that allows us to manpulate our arrays to show or change some data
		//https://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html
	}

}
