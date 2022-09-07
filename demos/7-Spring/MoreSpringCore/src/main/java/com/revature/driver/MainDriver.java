package com.revature.driver;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.models.GamePlayer;
import com.revature.services.PlayerService;
import com.revature.services.PlayerServiceImpl;

public class MainDriver {

	//here the steps that we would have to do to create the ioc container remains the same as the XML config steps
	private static ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
	
	//we are also going to record the events that occur in the main method by using log4j
	private static Logger log = Logger.getLogger(MainDriver.class);
	
	public static void main(String[] args) {
		//1. log the start of this task
		log.info("In main driver...printing all player high score histories...");
		
		//2. make a new instance of our service object
		//using the appContext's getBean() to create that service
		PlayerService playerServ = appContext.getBean(PlayerServiceImpl.class);
		
		//Q: In the background, how can we tell where this bean exist? How does the appContext know that the service implementation class is a bean?
		//1. looking at our beans.xml to see that annotation-based configuration are on
		//2. the annotation that is on top of that class is denotes as a bean because it uses the sterotype annotations for component scanning
		
		//3. getting our information by making the service
		List<GamePlayer> list = playerServ.getAllPlayers();
		
		//4. print off all of our players to the console
		System.out.println("Player Summary: \n");
		for(GamePlayer player : list) {
			System.out.println(String.format("Gamer by the nickname %s, ID# %d, has a high score of %d.", player.getGamerNickname(), player.getGamerTagId(), player.getHighScore()));
		}
		
		log.info("In main driver - summary list is complete. Ending program...");

	}

}
