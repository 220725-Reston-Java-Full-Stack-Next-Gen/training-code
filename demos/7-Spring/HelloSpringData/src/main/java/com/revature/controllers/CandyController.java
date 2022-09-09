package com.revature.controllers;

import static com.revature.util.ClientMessageUtil.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Candy;
import com.revature.models.ClientMessage;
import com.revature.services.CandyService;

@RestController
@RequestMapping("/api/candy")
public class CandyController {
	private static Logger log = Logger.getLogger(CandyController.class);
	
	@Autowired
	private CandyService candyServ;
	
	//create new candy
	@PostMapping("/create")
	public ClientMessage createCandy(@RequestBody Candy candy) {
		//Note we don't need the @ResponseBody annotation here because it is already included for all methods inside of this class thanks to the @RestController annotation
		return candyServ.createCandy(candy) ? CREATION_SUCCESSFUL : CREATION_FAILED;
	}
	
	//get candy by id
	@GetMapping("/findById")
	public Candy getCandyById(@RequestParam(value="id", name="id") int id) {
		log.info("TEST ID PARAM IS MAKING SERVICE CALL: " + candyServ.getCandyById(id));
		return candyServ.getCandyById(id);
	}
	
	//get all candies
	@GetMapping("/findAll")
	public List<Candy> getAllCandies(){
		return candyServ.getAllCandies();
	}
	
	//for updates, typically you would use the PUT verb to do those HTTP requests
	@PutMapping("/update")
	public ClientMessage updateCandy(@RequestBody Candy candy) {
		return candyServ.updateCandy(candy) ? UPDATE_SUCCESSFUL : UPDATE_FAILED;
	}

	//Obviously you would need to use the @DeleteMapping for all deletion requests
	@DeleteMapping("/delete")
	public ClientMessage deleteCandy(@RequestBody Candy candy) {
		return candyServ.deleteCandy(candy) ? DELETION_SUCCESSFUL : DELETION_FAILED;
	}
}
