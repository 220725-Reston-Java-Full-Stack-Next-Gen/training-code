package com.revature.driver;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.model.Pokemon;
import com.revature.service.PokemonService;
import com.revature.service.PokemonServiceImpl;

public class MainDriver {

	//1. set up our AppContext so I can define where my IoC container is
	//Q: Where is the contents of my IoC container? beans.xml
	private static ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
	
	public static void main(String[] args) {
		// 2. make an instance of my service using our AppContext
		PokemonService pokeService = appContext.getBean(PokemonServiceImpl.class);
		//In the background, Spring will automatically inject this service's dependencies into an operational functionality within that class upon it being created
		
		//3. make the service call that will return our fake db pokemon
		List<Pokemon> list = pokeService.retrieveAll();
		
		//4. print out my list to the console
		System.out.println("My Amazing Pokemon Team:");
		for(Pokemon pokemon : list) {
			System.out.println(pokemon);
		}

	}

}
