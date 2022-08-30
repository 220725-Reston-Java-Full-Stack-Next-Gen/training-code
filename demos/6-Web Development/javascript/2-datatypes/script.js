//1. declare a variable based on that datatype
var num = 10;
var str = "10 is my favorite number";
var bool = true;
var nullData = null;
var undefinedData = ""; //this is declared but not initialized with a value, making it undefined

var id = Symbol("id");
var person = {
    firstname: "John",
    lastname: "Jacobs",
    toDos: ["eat", "sleep", "work", "exercise"],
    sayHi: (fname) => {
        //this is an example of string interpolation
        //interpolation = more sophsicated way of creating strings while using variable data within the string
        return `Hello ${fname}!`;
    },
    [id]: 12345 //this is a symbol, which is another datatype in JS
    //symbols allow us to create "hidden" properties for our JS objects that no other part of our code can accidently access/override.
};

//2. Display that variable's value within its labelled span
let numEx = document.getElementById("num-ex");
let strEx = document.getElementById("str-ex");
let boolEx = document.getElementById("bool-ex");
let nullEx = document.getElementById("null-ex");
let undEx = document.getElementById("und-ex");
let objEx = document.getElementById("obj-ex");
let symEx = document.getElementById("sym-ex");

numEx.innerHTML = num;
strEx.innerHTML = str;
//boolEx.innerHTML = bool;
//here I want to perform some logic if the bool variable is true or false
console.log(bool);

//In JS, there is a concept with variables being either truthy (some type of value) or falsey (no defined value)
//truthy values: true, 1, 20, "some str", etc.
//falsely values: null, undefined, 0, NaN, false, "", etc.
if(bool){
    boolEx.innerHTML = "I am a true value";
}else{
    boolEx.innerHTML = "I am a false value";
}

//! + variable name = means if that variable is not true = if it doesn't have a value, execute this code!
if(!nullData){
    //if false, execute!
    nullEx.innerHTML = "no value is home for this variable";
}

if(!undefinedData){
    undEx.innerHTML = "Sorry, I was declared but never defined with a value";
}

//Q: How to show the object as a string and display on page
//objEx.innerHTML = person; //NOPE!

//To show objects in JS, we must first convert them into JSON strings
var json = JSON.stringify(person);
console.log(json);

//you can access the values to your object's properties by using dot notation
objEx.innerHTML = `${json}, sayHi(): "${person.sayHi(person.firstname)}"`

//in order to access an object's hidden property, you must use square notation
symEx.innerHTML = person[id];
