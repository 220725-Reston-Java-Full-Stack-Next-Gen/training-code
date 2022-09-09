package com.revature.util;

import com.revature.models.ClientMessage;

public class ClientMessageUtil {
	
	public static final ClientMessage CREATION_SUCCESSFUL = new ClientMessage("Registration was successful!");
	public static final ClientMessage CREATION_FAILED = new ClientMessage("Something went wrong during creation.");
	public static final ClientMessage UPDATE_SUCCESSFUL = new ClientMessage("Update was successful!");
	public static final ClientMessage UPDATE_FAILED = new ClientMessage("Something went wrong during update.");
	public static final ClientMessage DELETION_SUCCESSFUL = new ClientMessage("Deletion was successful!");
	public static final ClientMessage DELETION_FAILED = new ClientMessage("Something went wrong during deletion.");
}
