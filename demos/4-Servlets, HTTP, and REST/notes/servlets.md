# Servlets
## Session Management
- The practice of storing information about the user in the server in order
  to improve user experience

**Why do sessions matter**?
- User Experience: Saving session information locally prevents
  needless hits to your database, which improves performance and allows you
  to personalize a user's experience.
- Security: Verify that a user actually has access to a resource that was
  provided by your website. Disallow access to sensitive information.

## Sending Users to different locations on the Web / Redirects
- Servlets take requests from clients and forward them to requested resources. How?
  - There are 2 ways:
    - `SendRedirect`
      - Supplied by Response object
      - This is a method: response.sendRedirect(location);
      - Actually send a response back to the client and then
        sends a new request back.
      - As a result, the information in the previous request is lost
      - Returns a 300 Series status code
    - `Forward`
      - Supplied by Request object
      - This method is declared on the RequestDispatcher Interface
      - When you use forward, the request never leaves the server
      - You can't request dispatch into another location (stay within same domain)
      - You make only 1 request, not 2

  - Main Takeaway:
    - Use sendRedirect when your client asks for a resource that is in some
      other location (the extra request is visible in the client as a new request)
    - Use forward if the your client is asking for a resource from the same
      project (something you have access to immediately)
    - Forward is handled by the server
    - sendRedirect is handled by the browser/client

## Servlet Config
- ServletConfig (interface) provides objects that are used by the Servlet
  containers (aka web container) to pass information to a servlet during
  initialization
  - getInitParameter()
  - getServletContext()
- Serializable interface is a marker interface (an empty interface) that can be
  implemented in order to allow an object to be "serialized" (to basically save
  to a file) and "deserialized".
  - In particular, if our Servlet classes implement Serializable, then we can serialize
    them to allow the servlet to "survive" restarting the web container.
- GenericServlet is an abstract class which supports any protocol, HTTP, UDP, TCP, etc
  - It is not necessarily designed for HTTP
- HttpServlet abstract class which allows you to create a servlet suitable
  for handling http requests.
  - doPOST, doGET, etc
  - Note, HttpServlet is an abstract class, so it is meant to be extended

## ServletConfig vs ServletContext

- The ServletConfig is unique to each individual servlet
  - No other servlet can access another's config
- The ServletContext is shared across all servlets

## Servlet QC Questions

1.  What is a servlet? What about a servlet container? Which servlet container have you worked with?
2.  Describe the servlet class inheritance hierarchy. What methods are declared in each class or interface?
3.  How would you create your own servlet?
4.  What is the deployment descriptor? What file configures your servlet container?   
5.  Explain the lifecycle of a servlet - what methods are called and when are they called?
6.  Is eager or lazy loading of servlets the default? How would you change this?
7.  What are some tags you would find in the web.xml file?
8.  What is the difference between the ServletConfig and ServletContext objects? How do you retrieve these in your servlet?
9.  What is the purpose of the RequestDispatcher?
10.  Explain the difference between RequestDispatcher.forward() and HttpServletResponse.sendRedirect()
11.  What are some different ways of tracking a session with servlets?
12.  What is object mapping? Any Java libraries for this?
13.  How would you send text or objects back in the body of the HTTP response from a servlet?
14.  What is the difference between getParameter() and getAttribute() methods?
15.  Explain the front controller design pattern

## Servlet Study Guide

- **Servlet Inheritance Hierarchy**
  - Servlet interface
  - GenericServlet abstract class
  - HttpServlet abstract class
- Servlet container
- Servlet lifecycle
- **Deployment descriptor**
  - What folder is it in?
  - web.xml tags
- Creating custom servlets
- Eager vs lazy loading / instantiation of servlets
- ServletConfig object
- ServletContext object
- RequestDispatcher
- Forwarding vs redirecting
- **Session tracking**
  - HttpSession API
  - Cookies
  - URL rewriting
  - HTML hidden fields
- Retrieving request parameters
- Retrieving data submitted from a form
- Sending a plain text response from a servlet 
- Sending a JSON object via mapping with Jackson
- Front controller design pattern