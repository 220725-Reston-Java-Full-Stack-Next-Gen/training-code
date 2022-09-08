package com.revature.controller;

import static com.revature.util.ClientMessageUtil.REGISTATION_SUCCESSFUL;
import static com.revature.util.ClientMessageUtil.SOMETHING_WENT_WRONG;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.model.ClientMessage;
import com.revature.model.Hero;
import com.revature.service.HeroService;

//Just like with services and repositories, we must denote this class as a controller component for the spring ioc container. We can do this by using the sterotype annotation @Controller
//Also because I want control on how the URL paths are formed in this app, I will be using Spring Web annotations for request mappings
//@RequestMapping specifies a URL at which the controller is available - binding a function/class to a URL pattern (regardless of HTTP verb):
@Controller
@RequestMapping("/api") 
public class HeroController {
	//since this controller relies on the service layer, we need to inject this dependency into this class:
	@Autowired
	private HeroService heroServ;
	
	/*
	 * Now if I want to map for specific HTTP verb methods like GET, POST, there are specific RequestMapping annotations for these:
	 * 
	 *  ex. request: get request to find all heroes
	 *  
	 *  	URL: http://localhost:8080/HelloSpringMVCandORM/api/findAllHeroes
	 *  
	 *  	denote the method with @GetMapping annotation
	 *  
	 *  Also because I want control on how I format the HTTP response, we will use the @ResponseBody annotation in the method signature. @ResponseBody specifies what we return to the client (typically in JSON format)
	 *  
	 *  Here, the @RequestBody will specify the type of information that this method is taking in as an argument. This info will be turned from JSON into actual Java objects using Jackson Databind
	 */
	@GetMapping("/findAllHeroes")
	public @ResponseBody List<Hero> findHeroes(){
		return heroServ.getAllHeroes();
	}
	
	//since creating new resources requires the POST method, there is also a PostMapping annotation
	@PostMapping(path="/register", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody ClientMessage registerHero(@RequestBody Hero hero) {
		//check if response is success -> send good clientmessage; else -> bad clientmessage
		return heroServ.registerHero(hero) ? REGISTATION_SUCCESSFUL : SOMETHING_WENT_WRONG;
	}

	//Here, the @RequestParam annotation will extract the name value from the URL params for us
	@GetMapping("/findHeroByName")
	public @ResponseBody Hero findHeroByName(@RequestParam String name) {
		return heroServ.getHeroByName(name);
	}
}
