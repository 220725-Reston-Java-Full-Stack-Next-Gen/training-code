/*
    In 2017, ES8 was released and with it came the async & await keywords

    We use the async keyword to define functions that handle asynchronous operations.
*/

//to make an async function, we must use the following syntax:
async function sayHi(){
    return "Hi"; //NOTE: implicitly, async functions return a Promise
}

//to invoke an async function, we would do so like this:
sayHi().then(console.log);
//Naturally, async functions execute asynchronously in the event loop 
//that is occuring in the JS engine on the browser

//Let's have some fun with async
async function sayHi2(){
    //this time, I will explicitly state that I am returning a Promise
    return Promise.resolve("Hi too");
}

sayHi2().then(console.log);

//Now I am making an anonymous async function
let sayHi3 = async function(){
    return "Hello";
};

//With the await keyword, it must be used inside of an async function
//await sayHi3; //show error in console

//Now I will make an arrow async function
let sayHi4 = async() => {
    return 'Hiya';
};

async function display(){
    try {
        //we can execute other async functions by using the 'await' keyword
        // let result = await sayHi3();
        let result = await sayHi4();
        console.log(result);
    } catch (error) {
        //this block of code will execute if the promise state was rejected
        console.log(error);
    }
}

display();
//Overall, async/await gives us more control over our asynchronous code execution