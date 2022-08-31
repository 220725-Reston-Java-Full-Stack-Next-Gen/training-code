function changeBlue(){
    let parent = document.getElementById("parent-1");
    //set the color change to my CSS styling after a 3-second delay
    setTimeout(() => {
        console.log("Please wait...");
        //apply the class bluegradient to the parent p tag
        parent.classList.add("color-bluegradient");
    }, 3000);

    console.log("Done. Background color is now blue gradient.");
}

function changeGreen(){
    let parent = document.getElementById("parent-2");
    //set the color change to my CSS styling after a 3-second delay
    setTimeout(() => {
        console.log("Please wait...");
        //apply the class bluegradient to the parent p tag
        parent.classList.add("color-greengradient");
    }, 3000);

    console.log("Done. Background color is now green gradient.");
}