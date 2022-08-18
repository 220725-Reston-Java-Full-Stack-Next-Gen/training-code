package com.revature.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revature.services.UserService;
import com.revature.services.UserServiceImpl;

public class RequestHelper {

	private static final Logger LOGGER = LoggerFactory.getLogger(RequestHelper.class);
	
	//because we are making service method calls here, we need an instance of the UserService object
	private static UserService userService = new UserServiceImpl();
	
	//These methods will make the service call as well as create the dynamic response that is returning to the client
	@SuppressWarnings("deprecation") //this annotation will suppress the Java compiler of its warnings of deprecated classes/methods
	public static void processRegistration(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//NOTE: These steps are to be followed by only POST RequestHelper methods!!! Not as GET, PATCH, DELETE, etc.
		//1. log the event
		LOGGER.debug("In RequestHelper - processRegistration() started");
		int id = 0;
		
		//2. extract the user information from the HTTP request body
		//a. initialize a BufferReader object and a StringBuilder object
		
		//bufferedreader is a input stream that reads binary / non-human readable data
		//because it is retrieving data from a stream, java will throw I/OException if it is unable to read the characters in stream
		BufferedReader reader = req.getReader();
		StringBuilder sb = new StringBuilder();
		
		//now I will transfer our Reader data to our StringBuilder object, line by line
		String line = reader.readLine();
		
		while(line != null) {
			sb.append(line);
			line = reader.readLine();
		}
		
		String body = sb.toString();
		
		//now that we have our body, we are going to 1) log, 2) split the body up based on individual parameters of information
		LOGGER.debug("Request body for registration is: " + body);
		
		//Q: How to split body string up into different info (name, job title, hiredate)
		String[] info = body.split(",");
		List<String> values = new ArrayList<>();
		
		//each element in the info array, I can calling them pair in this for loop
		//in the loop, appending/adding a string to the values arraylist
		//in that string, we trim the string to look only for the value from the request body
		
		//reader: { "name": "bob", "jobTitle": "worker", "hiredate": "2022-08-18" }
		//body would have had this same format
		//info[]: ["name: bob", "jobTitle: worker", "hiredate: 2022-08-18"]
		//ex. name=bob
		//result: values["name:bob", etc.]
		
		for(String pair : info) {
			values.add(pair.substring(pair.indexOf("=") + 1)); //here, I trimmed each string in the body to be just displaying the value 
			//aka removed the extra characters and key from the string. Then added it to the values arraylist
		}
		
		//3. put that information into a temporary User object before making the service method call
		LOGGER.debug("User information extracted is: " + values.toString());
		if(body.startsWith("name")) {
			//a. set the content type of my response to return to the browser
			resp.setContentType("application/json");
			
			//b. here is where we make the service method call
			String name = values.get(0);
			String jobTitle = values.get(1);
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate hiredate = LocalDate.parse(values.get(2), formatter);
			
			User target = new User(name, jobTitle, hiredate);
			//4. do the service method call
			id = userService.registerUser(target);
			
			//5. write the response that is returning to the client
			if(id != 0) {
				//convert our response into JSON using Jackson Databind
				PrintWriter pw = resp.getWriter();
				
				target.setId(id);
				
				//this comes from Jackson Databind
				ObjectMapper om = new ObjectMapper();
				
				//now converted our User object into a JSON string that will be added to the response
				String json = om.writeValueAsString(target);
				
				//adding JSON to response
				pw.println(json);
				
				resp.setStatus(200);
				LOGGER.debug("New user info: " + target);
			}else {
				//if userId is 0, that means that request was successful but no new resource was made! (status code of 204)
				resp.setStatus(204, "Failed to add account in RequestHelper");
			}
		}
		
		LOGGER.debug("In RequestHelper - processRegistration() ended");
	}

}
