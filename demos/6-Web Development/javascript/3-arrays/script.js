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
let header = document.createElement("h3");
header.innerHTML = "Full DBZ Character List";
parentDiv.append(header);

//1. using a for loop
let container = document.createElement("div");

// for(let i = 0; i < dbzCharacters.length; i++){
//     const character = dbzCharacters[i];
//     var placeholder = document.createElement("p");
//     placeholder.innerHTML = character;
//     container.append(placeholder);
// }

//2. using the forEach function = uses an anonymous function (aka arrow function) to execute code
// dbzCharacters.forEach((element) => {
//     //this is where I can do some logic on each element within the array
//     let placeholder = document.createElement("span");
//     //no need for access to the index number when using the foreach function
//     placeholder.innerHTML = `${element} <br>`;
//     container.append(placeholder);
// });

//3. using the for-in/for-of loop
//this approach is preferred for collections or objects in JS
for(const character in dbzCharacters){
    //here I am using the object prototype to call on each element within the array
    if(Object.hasOwnProperty.call(dbzCharacters, character)){
        const person = dbzCharacters[character];
        let placeholder = document.createElement("h3");
        placeholder.innerHTML = `${person} <br>`;
        container.append(placeholder);
    }
} 

parentDiv.append(container);