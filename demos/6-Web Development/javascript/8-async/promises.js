/*
    To avoid the callback hell, ES6 introduced promises.

    This allowed us to write asynchrous code in a more manageable way

    What is a promise?
    Definition: A promise is an object that MAY produce a single value at some point in the future, 
    either as resolved or rejected (rejected due to some network error)

    In other words, we are able to execute our promises without it halting the main program flow

    A promise may be in 1 of 3 possible states:
        1. Fulfilled - able to receive a successful result
        2. Rejected - failed to get a successful result
        3. Pending - processing for a result
*/

function getUser(userId){
    return new Promise((resolve, reject) => {
        console.log("Get user from database");

        setTimeout(() => {
            resolve({
                userId: userId,
                username: "John Smith"
            })
        }, 1000);
    });
}

function getServices(user){
    return new Promise((resolve, reject) => {
        console.log(`Get services of ${user.username} from the API`);

        setTimeout(() => {
            resolve(['Email', 'VPN', 'CDN']);
        }, 2 * 1000);
    });
}

function getServiceCost(services){
    return new Promise((resolve, reject) => {
        console.log(`Calculate service costs of ${services}`);

        setTimeout(() => {
            resolve(services.length * 100);
        }, 3 * 1000);
    });
}

//instead of the messy nesting that we did before, we can just chain our function calls like this:
getUser(104).then(getServices).then(getServiceCost).then(console.log);
//Overall, promises are the ideal choice for handling async operations as they provide better error handling than
//callbacks and events. Also allow for more modular & readable code.
//Key Thing: Promises will always look out for changes/information updates in your JS code asynchronously (aka without you the developer having to manage that)