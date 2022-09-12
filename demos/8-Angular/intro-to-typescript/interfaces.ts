//Interfaces in TS are an abstract type that tells the compiler which property name a given object can have
//aka a template of what this object's structure suppose to be
//Interfaces allow for us to have a way to have pre-compiled JS objects without worrying about its implementation
//This is the idea for when we say that there is OOP introduced into JS/TS

//1. make a interface
interface Person{
    name: string;
    title: string;
    salary: number;
    toDos: any[]
}

//2. implementing this interface by declaring a new JS object that this interface will be based on
const user: Person = {
    name: "Bob the Builder",
    title: "Construction Worker",
    salary: 60000,
    toDos: [34, true, "sleeping all day on the job"]
};

//3. printing our object to the console
console.log(user);