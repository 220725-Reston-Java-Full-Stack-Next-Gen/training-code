package com.revature.util;

import com.revature.model.ClientMessage;

//This class is serving out some static imports that will be used in HTTP responses that will be sent back in a view to the end user
public class ClientMessageUtil {
	
	public static final ClientMessage REGISTATION_SUCCESSFUL = new ClientMessage("registation was a success!");
	public static final ClientMessage SOMETHING_WENT_WRONG = new ClientMessage("Error occurred! Please try again.");
}
