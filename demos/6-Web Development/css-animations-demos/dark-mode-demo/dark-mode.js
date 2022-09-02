//To apply a dark mode, you need 1) css styling for when dark mode is on, 2) tell js to apply the 'dark' class to those HTML elements whenever we click on the checkbox area

//1. target the checkbox
const checkbox = document.getElementById("checkbox");

//2. add an eventListener for when the state of the checkbox changes from checked to unchecked
checkbox.addEventListener('change', () => {
    //3. use the toggle() on the HTML elements to toggle when the 'dark' is added to the class attribute
    document.body.classList.toggle('dark');
    document.getElementsByClassName("sidenav")[0].classList.toggle('dark');
    document.getElementsByClassName("login-main-text")[0].classList.toggle('dark');
    document.querySelector(".btn-black").classList.toggle('dark');
    document.querySelector(".btn-secondary").classList.toggle('dark');
});

/*
    In class exercise: Create a simple website of your choosing that clones either the simple-square demo or dark-mode demo.

    Color themes of exercise must be of your choosing. Not required to turn in, but it's for your own practice.
*/