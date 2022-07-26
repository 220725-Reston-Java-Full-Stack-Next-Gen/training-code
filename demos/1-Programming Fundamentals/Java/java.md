# Java

Java is an Object Oriented Programming language. It was picked up by Oracle, that develops 1 common implementation of the JRE and JDK, and through their (and others) efforts, Java has become very widely used.

## Features/Characteristics

- Object Oriented
- Strongly and Statically Typed
- Leverages Java ByteCode (.class files) to accomplish distribution of Java programs
    - Makes it easier to share/collaborate
- Garbage Collector handles Memory Management for the developer
- The JVM is small, and so can be run on many different platforms
    - Particularly useful for embedded systems (Raspberry Pis)
- Many standard libraries are provided
- Relatively performant
    - Not as fast as C or C++, but faster than most other languages
- As of Java 8, introduced some APIs for Functional Programming

## JVM / JRE / JDK

JDK stands for Java Development Kit

JRE stands for Java Runtime Environment

JVM stands for Java Virtual Machine

JDK contains the JRE, as well as many different developer tools, such as the compiler or the archiver.

JRE contains the JVM as well as supporting libraries that the JVM needs to function.

The Java Compiler is the executable that produces Java ByteCode from Java Source Code (From .java to .class)

The JVM (along with the libraries from the JRE) executes the Java ByteCode.


## Garbage Collection

The Java Garbage Collector is a separate thread that runs alongside your Java program. This is a Deamon Thread, which means it is a long running thread, that will often be "asleep". It will occasionally "wake up" and perform some garbage collection. This means it will find any objects in memory that are no longer being used, and freeing that memory so that other processes can use it again.

## Memory Structure

Memory is separated into 2 regions: The Stack and The Heap.

The Stack is a organized structure that stores information about method/function calls as well as local variables.

The Heap is an unstructured area of memory that stores Objects.

Java has 8 primitive datatypes that are NOT objects. These primitive datatypes are generally stored on the stack (if they are local variables).
- int
    - 4 bytes = 32 bits
- double
    - 8 bytes = 64 bits
- byte
    - 1 byte = 8 bits
- boolean
    - 1 byte = 8 bits (sort of)
    - JVM dependent
    - They can potentially be stored in only 1 bit, if many booleans are created
    - Among other optimizations
- char
    - 2 bytes = 16 bits
- long
    - 8 bytes = 64 bits
- float
    - 4 bytes = 32 bits
- short
    - 2 bytes = 16 bits

There is an additional concept of "Reference Variables". These are variables that store the memory address of an object located somewhere in the heap. These Reference variables can be stored on the Stack.

The Stack has "Stack Frames". Each frame is associated with a single function/method call. Any local variables (or parameters) created will be associated with only this stack frame.
When you call/invoke another function, a new stack frame is produced.

## Java Source Code

Syntax for a programming language is quite important. The specific grammer is interpreted another program (the Java Compiler) to produce Java ByteCode. The result of this, is that it is very particular about that grammar. We have certain specialized (reserved) keywords that indicate certain information to the Compiler. Of particular note, is the `class` keyword. Other examples are `public`, `static`, `void`, etc.
A little bit different from grammer/syntax is Naming Conventions. These are specific styles that we (as developers) like to enforce in order to make it easier for other human beings to understand the code. The first example, is having class names that begin with a capital letter. From there, every new word that is part of the name will have another capital letter. Variable names have a similar convention, except that will begin with a lowercase letter. For example, `myString`.