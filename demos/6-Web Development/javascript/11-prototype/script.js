/*
Life before JS Classes
- What is a prototype in JS?
    - Every object in JS has a built-in property, which is called its prototype
    - The prototype is itself an object, so the prototype will have its own prototype that can be later associated in a thing known as a prototype chain.
    - The chain ends when we reach a prototype that has null for its own prototype.
- Why use prototypes? 
    - Before ES6, prototypes were commonly used to make object constructors
*/
//this is the old way for objects to have constructors
function Person(name, hobby){
    this.name = name;
    this.hobby = hobby;
}

var person = new Person("John Doe", "fishing");
console.log(person);

//to receive the name of my person, i would to use this object's prototype
//console.log(person.name); //this still works
Person.prototype.getName = function(){
    return this.name;
}

console.log(person.getName());

//to add new functionality to all of my existing objects, i can use the prototype here as well
Person.prototype.age = 25;

console.log(person.age);

//NOTE: You can only modify your own prototypes, but not the prototypes of standard JavaScript objects
Object.prototype.age = 26;
console.log(Object.prototype.age); //shows 26 becuase the prototype here casts over the real standard JS object
//console.log(Object); //we cannot view what that native code is because this Object is a standard JS object