//declare some variables here
var count = 'bananas';
//here is a full initialization and declaration of a TS variable
//initialization = where we set the datatype of the variable
//declaration = where we assign a value to the variable
var apples = 'granny smith';
//Q: What if I do not know what datatype to assign to a variable?
//var list: string[] = ['sleep', 'eat', 'work'];
//the any type allows us to have flexibility of our typing with any given variable, class, or interface
//to recreate our list:
var list = ['sleep', 'shop', 24];
//change the value assigned to the 'count' variable
//Because TS is strongly typed, once an variable has been assigned a datatype, TS will NOT allow for this direct type casting
//count = 6; //shows a compile-time error due to the static typing of this variable
if (list.length <= 3) {
    list[0] = 5;
}
var listItem = list[0];
listItem = "george";
//Q. What is the output of this code?
console.log(listItem); //shows george
console.log(list); //shows [5, 'shop', 24] because we never reassigned the first element after the if statement
//TS is statically typed = means you cannot reassign a variable of different types once it's initialized
//New TS datatypes are as followed:
//1. Enums
//Enums allow us to make constants in our code.
//WARNING: Enums will look weird/funky in vanilla JS
//What are enums used for?
/*
    - Enums are useful where we want to set a list/grouping of named constants in our apps
    - This will make it easier to document intentions of state for events that occur during app runtime
    - ex. in video games, devs would normally track the state of the game in named constants like IN_PLAY, STARTED, PAUSED, or GAME_OVER
    - Enums can be used in logical statements like if-elseif-else blocks and switch statements
*/
//To set up enums, there are two ways:
//a. older way of doing enums in TS
var ColorRed = 0;
var ColorBlue = 1;
var ColorGreen = 2;
console.log(ColorRed);
//b. newer way of doing enums in TS
//using the enum keyword
var Colors;
(function (Colors) {
    Colors[Colors["Red"] = 0] = "Red";
    Colors[Colors["Blue"] = 1] = "Blue";
    Colors[Colors["Green"] = 2] = "Green";
})(Colors || (Colors = {}));
; //way easier to keep organized vs the old way
console.log(Colors.Red);
