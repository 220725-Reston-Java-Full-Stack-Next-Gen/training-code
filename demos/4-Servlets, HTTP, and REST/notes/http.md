## HTTP Study Guide:
> *Resources:* :mag:
> - [MDN Overview of HTTP](https://developer.mozilla.org/en-US/docs/Web/HTTP/Overview)
> - [What is HTTP and How does it work?](https://whatis.techtarget.com/definition/HTTP-Hypertext-Transfer-Protocol)

- HyperText Transfer Protocol

- Primary networking protocol used for client-server communication
  - The internet (world-wide-web) 

- This is also specifically used for RESTful web services

- For now, it's important to understand the differences between different
  HTTP verbs (methods), such as <code>GET</code> and <code>POST</code> as well as HTTP status codes

- All HTTP messages are composed of a **header** and a **body** which contains different
  pieces of information.. 
    - The header normally represents the metadata about the request. 
    - The body represents the data in the message, or the message itself
   
- **GET vs POST**
  - **GET** is utilized to retrieve data. We're retrieving data from some url, or endpoint,
    and normally clients and servers are not expecting these messages to contain content
    within the body. (Although, you definitely still can)
  - **POST** is generally used to send/update information on the url/endpoint, which means
    that the server os expecting the message to have information in the body.
    
 ### Check out this [HTTP Verbs guide](https://github.com/210517-Enterprise/demos/blob/main/week4/notes/http-verbs.md).

- HTTP responses have a status code that represent the status of the request. We'll talk
  more about them in a moment, but we have seen examples such as 200 OK, and 201 CREATED *see the **HTTP Status Codes** listed below***

- HTTP responses can also have a body. If a GET request was performed, generally,the response is stored in the body.


- **HTTP request contents**
  - HTTP version
  - URL
  - HTTP verb / method
  - Request Headers
  - Request Body
  
- **HTTP response contents**
  - HTTP version
  - Status code
  - Response Headers
  - Response Body

- **HTTP verbs**
  - GET
  - POST
  - PUT
  - DELETE
  - PATCH
  - HEAD
  - OPTIONS
  - TRACE
  
### HTTP Response status codes
  - 100-199: informational
  - 200-299: success
    - 201: Created
    - 204: No content
  - 300-399: redirect
    - 301: Moved permanently
    - 304: Not modified
  - 400-499: client error
    - 403: Forbidden
    - 404: Not Found
    - 405: Method not allowed
    - 415: Unsupported media type
    - 451: Unavailable for legal reasons
  - 500-599: server error
    - 501: Not implemented
    - 502: Bad Gateway
    - 503: Service unavailable

## Client/Server Architecture
- A Client and a Server establish a connection according to a set of rules called a protocol. 
- [**HTTP**](https://developer.mozilla.org/en-US/docs/Web/HTTP/Overview) is a protocol which allows the fetching of resources, such as HTML documents. 
    - It is the foundation of any data exchange on the Web and it is a **client-server protocol**, which means requests are initiated by the recipient, usually the Web browser (client).
- *Describe the difference between **2 Tier**, **3 Tier**, **n-Tier** architecture*