package com.azhya.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@SuppressWarnings("serial")
public class FrontController extends HttpServlet{
	
	private static Logger logger = Logger.getLogger(FrontController.class);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//we use URI rewriting to better manage the naviagation of our HTTP requests as they come to the FrontController
		final String URI = req.getRequestURI().replace("/FakeProject1Scraper/", "");
		
		logger.info("User trying to access endpoint: " + URI);
		
		switch(URI) {
			case "register":
				logger.info("User is registering for a new user account...");
				RequestHelper.processRegistration(req, resp);
				break;
			case "login":
				logger.info("User is logging in...");
				RequestHelper.processLogin(req, resp);
				break;
			case "accounts/new":
				logger.info("User is trying to make a new bank account...");
				RequestHelper.processCreateNewAccount(req, resp);
				break;
			default:
				logger.warn("No path present: " + URI);
				break;
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//we use URI rewriting to better manage the naviagation of our HTTP requests as they come to the FrontController
		final String URI = req.getRequestURI().replace("/FakeProject1Scraper/", "");
		
		logger.info("User trying to access endpoint: " + URI);
		
		switch(URI) {
			case "users":
				logger.info("User is searching by username...");
				RequestHelper.processSearchByUsername(req, resp);
				break;
			default:
				logger.warn("No path present: " + URI);
				break;
		}
	}

}
