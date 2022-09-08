package com.revature.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//This class will serve as a Java template for how I would like to format certain HTTP responses
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientMessage {

	private String message;
}
