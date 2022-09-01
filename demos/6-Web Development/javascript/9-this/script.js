/*
    What is the THIS keyword?
    In JS, the 'this' keyword refers to the object that it belongs to.
    - By itself, this refers to the global object
    - In a function, this still refers the global object
    - In a method (in JS, a method is a function that belongs to an object), this refers to the owner object

    - In strict mode (Strict mode makes some bad coding practices return errors by placing your JS code in a more restricted variant of itself), this (in a function) returns undefined
*/

//set our JS code in strict mode
'use strict';

//console.log(this); //when we call the global object, since we are outside of a browser, it just calls an empty object{}

function foo(){
    console.log(this); //in strict mode, this returns as undefined; without strict mode, this refers the global object
}

//foo();

//this is a VERY bad practice to declare your variables like this in JS. Good practice would be to use var/let/const in front of x
//Therefore, declaring a variable like this in strict mode will cause an referenceError
//x = 'hi';

//Q. With strict mode on, what would I see in the console from this line below?
//console.log(x);

//make an object literal
//NOTE: object literal is NOT the same as JSON
//JSON is similar but not exactly the same in terms of formatting because its keys are strings as well as its values

const person = {
    firstName: 'John',
    lastName: 'Doe',
    id: 1234,
    //here getFullName is a method (aka a function that is set as a property of an object)
    getFullName: function(){
        return `My full name is ${this.firstName} ${this.lastName}.`;
    }
};

//Q: With strict mode on, what is the output for this line here?
//here, in non-strict mode it returns our sentence; in strict mode, we still get our sentence because the this keyword refers to the owner object (aka person)
//console.log(person.getFullName());

//here I will be setting a custom property to the global object
this.cat = 'Finn';
//Q: With strict mode on, what is the output for this line here?
//Strict mode off: shows Finn
//Strict mode on: still shows Finn because this refers to the global object
console.log(this.cat);