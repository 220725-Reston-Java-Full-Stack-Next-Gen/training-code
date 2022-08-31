/*
    An event = something that the browser does or the user does as an action
    ex. onclick, onchange, onload, onmouseover, etc.

    What is event propagation?
        - the order at which events are triggered in the DOM
*/

//declare some variables
let parent1 = document.getElementById("parent-1");
let parent2 = document.getElementById("parent-2");
let child1 = document.getElementById("child-1");
let child2 = document.getElementById("child-2");

//in order to know when events are triggered, we can create event listeners to 
//look for those triggers in the browser as the user interacts with our webpages
//an eventlistener handles events and can be used to manaage the actions that occur
//during that given event

//There are two types of event propagation:
/*
    Any time we click on an element in this example, it will trigger an click event.

    Bubbling:
        - If the parent element is clicked, then only the parent will be triggered to do an event. In our example,
        the p tag marked as "parent-1" will be triggered only and not its child.
        - If the child element is clicked, then the child would trigger followed by its parent.
        - IRL example: air bubbles (aka child) coming from the ocean floor and reaching the water surface (aka parent)

    Capturing:
        - If the parent element is clicked, then only the parent will be triggered (aka p tag that is marked as parent-2)
        - If the child element is clicked, then the parent will trigger first followed by its child
        - IRL example: throwing a mousetrap down on top of a mouse that is eating the cheese
*/
//example 1
//by default, eventListeners are set to bubbling
parent1.addEventListener('click', () => {
    console.log("I am the PARENT");
});

child1.addEventListener('click', () => {
    console.log("I am the CHILD");
});

//example 2
//to turn capturing, we need to set the eventListener to capturing=true
parent2.addEventListener('click', () => {
    console.log("I am the PARENT");
}, true);

child2.addEventListener('click', () => {
    console.log("I am the CHILD");
}, true);