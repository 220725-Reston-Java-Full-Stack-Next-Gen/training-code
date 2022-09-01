/*
Life before JS Classes
- What is a prototype in JS?
    - Every object in JS has a built-in property, which is called its prototype
    - The prototype is itself an object, so the prototype will have its own prototype that can be later associated in a thing known as a prototype chain.
    - The chain ends when we reach a prototype that has null for its own prototype.
- Why use prototypes? 
    - Before ES6, prototypes were commonly used to make object constructors
*/