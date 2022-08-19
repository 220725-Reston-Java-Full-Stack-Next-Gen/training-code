package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

//in order to make a class into a servlet, it must extends the HttpServlet!
public class FrontController extends HttpServlet{
	private static final long serialVersionUID = -2358633602178580852L;
	
	private static Logger LOGGER = Logger.getLogger(FrontController.class);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//URI Rewriting = doing some string manpulation in order to get a clean format to my URI pattern
		//then send the request to its appropriate RequestHelper method
		
		//	1. save the URI and rewrite it to determine what functionality that my user is seeking
		final String URI = req.getRequestURI().replace("/HelloServlets/", "");
		
		//2. log this altered URI to my log files
		LOGGER.info("User trying to access resource at URI: " + URI);
		
		//3. now that we have rewritten the URI, we will use a SWITCH statement to call the appropriate RequestHelper method
		switch(URI) {
			case "register":
				//a. log this choice to log file
				LOGGER.info("User is trying to register for a new account...");
				
				//b. make the RequestHelper method call
				RequestHelper.processRegistration(req, resp);
				break;
			case "login":
				LOGGER.info("User is trying to login to application using id and name...");
				RequestHelper.processLogin(req, resp);
				break;
			default:
				LOGGER.warn("ERROR: " + URI);
				break;
		}
	}

}
