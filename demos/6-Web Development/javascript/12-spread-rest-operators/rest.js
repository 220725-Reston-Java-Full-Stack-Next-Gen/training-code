//Rest parameter/operator: collects all remaining elements into an array of arguments for any given function
function foo(...args){
    console.log(args);
}

//Now I can invoke this foo() function with any number or type of parameters
foo(1, "fish", [2, 3, 4]);

foo(1, 2, 3, 4, 5, 6);

//Why use spread/rest operator?
//We can use spread/rest operators to make our JS code more flexible and readable for any incoming changes that
//our application requires as it gets bigger