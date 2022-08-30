//this is how you make a comment in JS
//1. make a variable that targets the H1 tag by its ID
//DOM = document object model = this tree-like structure represents the hierarchal order of your HTML elements on your webpage
var title = document.getElementById("my-title");
console.log(title);

//Q: How would I change the text inside of my H1 tag using JavaScript?
//Azhya's Warning: DO NOT confuse innerText with innerHTML. 
//These two functions operate differently from each other.
title.innerHTML = "Welcome, Azhya!";

//here now I will select the HTML elements by their classname
var favs = document.getElementsByClassName("fav");
console.log(favs); //this returns a collection of HTML elements instead of a single HTML element

//Q: What if I'm not sure to select the class or id for the element, what can I use?
var azhya = document.querySelectorAll(".azhya-rocks");
console.log(azhya);