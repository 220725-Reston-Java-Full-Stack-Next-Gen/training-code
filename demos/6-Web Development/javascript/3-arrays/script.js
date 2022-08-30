//declaration for my target div
var parentDiv = document.getElementById("example");

//make an array in JS
const dbzCharacters = ["Goku", "Vegeta", "Piccolo", "Krillan", "Yamcha"];

//Same as Java, indexing of arrays in JS starts at zero
//If you need to access an element within an array, you must use square notation
let elem = document.createElement("h3");
elem.innerHTML = `Accessing an element from DBZ array: ${dbzCharacters[3]}`;
parentDiv.append(elem);
let line = document.createElement("hr");
parentDiv.append(line);
//iterating through our array can be achieved in many different ways

//1. using a for loop
let container = document.createElement("div");
for(let i = 0; i < dbzCharacters.length; i++){
    const character = dbzCharacters[i];
    var placeholder = document.createElement("p");
    placeholder.innerHTML = character;
    container.append(placeholder);
}

parentDiv.append(container);