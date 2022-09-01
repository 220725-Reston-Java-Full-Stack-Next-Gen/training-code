/*
    JS classes were introduced in ES6 & give us the ability to implement OOP in JS. 
    
    So we can make constructors and functions that can be used in other parts of our JS code
    
    Why use JS classes?
        - offer an improved means for creating object templates
        - replace the previous means of using constructor functions for object
        - makes our code more manageable and reusable in other parts of our JS code
*/
//to make a class, we would use the class keyword
class ClassMates{
    constructor(name, age, course){
        this.name = name;
        this.age = age;
        this.course = course;
    }

    displayInfo(){
        return `${this.name} is ${this.age} years old and is studying ${this.course}`
    }
}

//Now we can use our class to make lots of classmate objects
let classmate = new ClassMates("Azhya Knox", 28, "Management Information Systems");

console.log(classmate.displayInfo());

//how would I convert our classmate's data into a JSON string?
console.log(classmate); //shows as JS object

//convert from JS object to JSON
var json = JSON.stringify(classmate);
console.log(json); //shows as JSON string

//How do we turn our JSON string back into a JS object?
var temp = JSON.parse(json);
var azhya = new ClassMates(temp.name, temp.age, temp.course);
console.log(azhya);
//note: anything that you convert your JSON string back into a JS object, they will lose their reference to the JS class that they used prior to the change
//this will require some work for it to go back and refer the class
