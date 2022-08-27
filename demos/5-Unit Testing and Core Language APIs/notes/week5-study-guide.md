# Week 5: Testing and Core Language APIs
## Testing
- What is TDD?

- What is JUnit? How would you make a unit test in your Java code?

- List some annotations that you can use in your unit tests.

- What is Mockito? What do you use it for?

## Collections (review)
- Describe the `Iterable` interface. [Resource](https://www.geeksforgeeks.org/iterable-interface-in-java/)
  - Root Interface of the Java Collections API

- What is an `iterator()`?
  - You can iterate the elements of a Java Iterable (an object of a class that implements `Iterable interface`) by obtaining a Java Iterator from it by calling the Iterable `iterator()` method. 

<br>

```java
List<String> list = new ArrayList><();

list.add("one");
list.add("two");
list.add("three");

Iterator<String> iterator = list.iterator();

while(iterator.hasNext()) {
    String element = iterator.next();
    System.out.println( element );
}
```

<br>

- What is the **time complexity (Big O notation)** of insertion from an ArrayList?
  - Big O Notation of **search from an ArrayList**?
  - Big O notation of **search from a LinkedList**?
  - Big O Notation of **search, insert & delete from a Hashmap**?

- What's the difference between TreeMap and HashMap?

<br>

## DS & A
- What is a linear search algorithm? How would one look like in your Java code? 
- What is a binary search? [Resource](https://www.geeksforgeeks.org/binary-search/)
- How does each above algorithm do in performance in an application? 
- What is the time/space complexity of each searching algorithm?

## Misc.
- List some Java 8 features.

- What are generics? How would you make a generic list? Method? Class?

- String vs. StringBuilder vs. StringBuffer

- Comparable vs Comparator