//declare some variables
var num1 = 5;
var num2 = "45";

//functions allow us to have reusable code in JS
//similar purpose to methods in Java, but they behave different

//how would we make our own functions in JS?
//1. use the function keyword
function add(n1, n2){
    var sum;

    //check of the datatypes of our parameters
    console.log(`Number one is a number: ${Number.isInteger(n1)}`)
    console.log(`Number two is a number: ${Number.isInteger(n2)}`)

    //type coercion = the process of automatic/implicit conversion of values from one datatype to another
    //often this comes up when doing conditional statements between two pieces of data
    //use either == vs ===
    //== -> equality operator -> can be used to compare values regardless of datatype
    //=== -> will check for value matches along with checking if they are of the same datatype
    //REMEMBER: == doesn't check types, === does do type checking!
    if(Number.isInteger(n1) === Number.isInteger(n2)){
        sum = n1 + n2;
    }else{
        //I will parse the non-numbers into number values
        sum = parseInt(n1) + parseInt(n2);
    }

    //return the sum
    return sum;
}

//calling our function to execute its code
var results = add(num1, num2);
console.log(`Results: ${results}`);
document.getElementById("example-1").innerHTML = `Regular Function call: ${results}`;

//2. anonymous functions
//these functions do not have a function name; instead they can be invoked by using their assigned variable name
var multiply = function(n1, n2){
    return parseInt(n1) * parseInt(n2);
};

//call this anon function
document.getElementById("example-2").innerHTML = `Anonymous Function call: ${multiply(5, "4")}`;

//3. using arrow function
//don't have to use the function keyword or give it a function name
var square = (n) => {
    return parseInt(n) * parseInt(n);
};

document.getElementById("example-3").innerHTML = `Arrow Function call: ${square(11)}`;

//4. callback functions
//a callback function is a function passed into another function as an argument/parameter, which is then invoked
//inside of the outer function to complete some kind of action (aka a method within a method)

//the steps to making a callback function are as followed:
//a. make the inner function
function alertFunc(n){
    console.log(`Your answer is: ${n * 2}`);
}

//b. make our outer function
function callbackFunc(number, callback){
    //c. inside of this outer function, call our inner function (thus doing a callback)
    callback(number);
    return number;
}

//d. invoke our outer function so the browser can start the callback execution
document.getElementById("example-4").innerHTML = `Callback Function call: ${callbackFunc(7, alertFunc)}`;

//5. closures
//closures give you access to an outer function;s scope from using an inner function
//aka callbacks that play around with variable scoping on the outer functions
function complexCalcFunc(n){
    var secretNumber = n + 9;

    //a. make the closure here
    function crazyMath(){
        //NOTE: Here, the crazyMath function still remembers the value of secretNumber despite the number not
        //being within the same scope as the function
        console.log(`Your secret number is: ${secretNumber}`);
        console.log(`Your secret math solution is: ${secretNumber * secretNumber - 1 + 14 / 8}`);
    }

    return crazyMath;
}

let chemicalX = 24;
let myMath = complexCalcFunc(chemicalX);
myMath();

document.getElementById("example-5").innerHTML = `Closure Function call: ${chemicalX}`;

/*
    Overall we can make functions in any way possible in JS.
    Functions can be called/invoked in 3 different ways:
    1. called in our JS code (1)
    2. automatically invoked (aka self-invoked)(2-5)
    3. when an event occurs within the DOM (to be seen later)
*/