# HTTP Activity

HTTP is a protocol for fetching resources such as HTML documents. It is the foundation of any data exchange on the Web and it is a client-server protocol, which means requests are initiated by the recipient, usually the Web browser.

Today, we will be exploring HTTP requests and response in depth by making requests to a popular, public API known as the PokeAPI.

## Tips
For Question #3: 
    1. Make a definition that works for you.
    2. Recite out loud your definition.
    3. If it is not clear enough for even you to understand, then refactor your defintion!
    
    All defintions need to answer the following:
    1. What
    2. How
    3. Why

## Instructions
1. Open Postman on your computer.

2. Make the following requests using the Postman interface to answer the following questions:
    - [ ] https://pokeapi.co/api/v2/pokemon/ditto
        1. From the JSON data, what is Ditto's primary type?
            Normal

        2. From the response headers, what is the value of the Content-Type?
            application/json; charset=utf-8

    - [ ] https://pokeapi.co/api/v2/type/3
        1. What was the HTTP status code for this request's response?
            200

        2. In which part of the response does the JSON reside in?
            body

    - [ ] https://pokeapi.co/api/v2/ability/sturdy
        1. Based on this request and the previous ones, which HTTP verb is this request's action?
            GET
        2. What is the URI for this request (Hint: it is already a part of the URL)?
            ability/sturdy

*You will need to enter the above URLs into Postman. Make notes of what your trainer does to make a Postman request.*

3. Define the following words:
    - IP address: ex. the text representation of my computer's address over the Internet
    - URL
    - URI
    - HTTP verb
    - HTTP status code
    - client-server communication
    - HTTP request
    - HTTP response
    - Contents of a HTTP request
    - Contents of a HTTP response
    - port number
    - domain
    - DNS
    - payload
    - HTTP header
    - JSON