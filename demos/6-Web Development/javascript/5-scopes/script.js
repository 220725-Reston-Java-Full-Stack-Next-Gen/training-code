/*
    Scopes in JS
    - What is scope?
        - Scope determines the accessiblity/visibility of a variable in our code
    - In JS, there are three scopes:
        1. Global scope = visible anywhere
        2. Function scope = accessible within the function
        3. Block scope = accessible within a conditional statement or express
            - Block also has a special subscope known as lexical scope
                - Introduced in ES6
                - In this scope, a variable is defined outside of a function and can be available for use inside of another function despite being declared before the function was created
    - With 2 & 3, they are collectively known as local scope levels.
*/

//global scope variable
//use the var keyword
var name1 = "Bob";
console.log(name1 + " is everywhere!");

//lexical scope example
//use the let keyword
//let name2 = "John";

sayHi();
//function scope example
function sayHi(){
    /*
        Hoisting is when the variable/function is being used before it's even declared.
        The JS interpreter will hoist - or move - to the top of the scope in which the variable
        is declared.
    */
   //where we declared name3 => the interpreter moved/hoisted to this point in our code
    name3 = "Sammie"; //allow hoisting to occur here
    //without this line being here, name3 would only exist within the if block
    if(name3 === 'Sammie'){
        //const variables must have a initialization at the point of declaration, otherwise you get an referenceerror
        //const name3 = "Samuel"; //block scope
        var name3 = "Samuel";
        console.log("Hi, " + name3); //we see this line bc of the block scope of name3
    }else{
        console.log(`Hello, ${name3}`);
    }
}

let name2 = "John";

//lexical vs function scope
function eatLunch(){
    //var name2 = "Joe"; //function scope
    console.log(`${name2} is eating a sandwich.`);
}

//console.log(name2); //got error because name2 doesn't exist outside of the function
eatLunch();

//Key Takeaway:
//lexical has the flexibility to go in & out of function scope
//while function scope is restricted to remain within the scope that it was declared/initialized