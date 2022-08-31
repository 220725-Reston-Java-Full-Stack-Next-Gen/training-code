/*
    AJAX stands for Asynchronous JavaScript and XML.

    It allows for performing javascript actions asynchronously.
    Generally used in conjunction with HTTP requests, as we can
    wait for the response in the background while doing other tasks 
    in our JS code.

    One of the biggest advantages of JS is the responsiveness it provides
    to our webpages. We can easily respond to events on our frontend and manipulate
    the DOM using basic JS functions.

    But the magic JS does not end there. We can use JS to make asynchronous
    requests to servers. We do this with AJAX.

    We want our application to continue to be responsive, while waiting
    for the server to respond. By sending the request and receiving the
    response asynchronously, we accomplish this.
    
    Note that AJAX has XML in it's name, but that primarily has its origin in
    and older era, where XML was used far more frequently as a data interchange
    format. Nowadays, we primarily use JSON. There are still some places that
    use XML, but JSON is a bit more popular.
*/

//declare a variable that targets our button that will trigger the AJAX process
let button = document.getElementById("btn");

//add an eventListener to my button to listen for the click event
//when the event is triggered, this will start the AJAX process
button.addEventListener('click', () => {
    //this will be where AJAX process will occur
    //STEP 1: create an object called XMLHttpRequest
    let xhr = new XMLHttpRequest();

    //STEP 1.5: Make an template from the incoming form data (from our HTML input fields)
    let form = document.getElementById("poke-field").value;

    //STEP 2: Define the behaviors of our responses as they come back from the server/ external API.
    //Normally, this will require us to modify the xhr based on ready states.
    /*
        A readyState is a property which signifies the state that the request is currently in.

        There are several states:
        0: UNSENT - opening of the request, the request has not yet been called
        1: OPENED - open() has been called by the XHR object
        2: HEADERS_RECEIVED - send() has been called (aka request has been sent to server), and the headers
        of the response as well as the status code of the response are now available through our XHR object
        3: LOADING - XHR object is downloading the response; therefore, the responseText (which is a XHR property)
        is holding partial data.
        4: DONE - the entire operation is now complete

        Why need readyStates?
            - Often you can implement other CSS transitions or dynamic page behavior by triggering those transitions/animations
            at a given readyState. The most common readyState for animations is RS #3.

            EX. loading scenes while transitioning from one page to another
    */
});