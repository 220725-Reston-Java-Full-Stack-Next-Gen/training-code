/*
    What is TypeScript and how is it related to JavaScript?

    - TS is a SUPER SET of JavaScript, meaning that all valid JavaScript code works in a TS file 
    BUT not all TS code can do into a JS file

    - What do I mean by this?
        - TS is like JS - but differs in syntax and other concepts
        - TS is OOP --> allows for more OOP features like interfaces, classes, etc., to be used in TS
        - tsc = typescript compiler = used to transpile our code from TS to JS so our browsers can understand the code
        - NOTE: the browser cannot read TS; must be "transpiled" (aka compiling from one high-level language to another high-level language) vs being "compiled" like Java code (aka converting from a high-level language into a low-level/assembly language)

    - How do we work with other JS-like applications?
        - Node is an open-sourced, cross-platform, JavaScript runtime environment.
        - This environment can run on the browser's V8 engine (which is responsible for code compiling) and execute JS code outside of a web browser
        - Within Node, we have the NPM (node package manager). It is a package manager for JS programs and is responsible for managing the program's dependencies (aka external package of libraries/tools that are needed for a JS app)
            - Ex. used NPM to install TypeScript
*/

//One of the major differences between TS and JS is that TS is strongly-typed
function sayHi(message: string){
    return `Hi, here is your message: ${message}`;
}

console.log(sayHi("Goku is the best!"));