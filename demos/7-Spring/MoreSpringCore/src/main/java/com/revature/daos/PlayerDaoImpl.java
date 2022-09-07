package com.revature.daos;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.revature.models.GamePlayer;

//here is where we would mark a class as a component for the ioc container to scan for beans
//to mark it as such, we will be using the @Repository annotation to denote this class as a DAO component:
@Repository
public class PlayerDaoImpl implements PlayerDao {
	
	//for good event tracking for this example, we will using log4j to implement logging in each layer
	private static Logger log = Logger.getLogger(PlayerDaoImpl.class);

	@Override
	public List<GamePlayer> getAll() {
		//OPTIONAL: you could also use the Reflections API from Java to reflect the class/method metadata (aka name of the class & method can be done like this:
		//log.info(String.format("%s - %s --> getting all players from database", getClass().getName(), getClass().getMethods()[0].getName()));
		
		//For good practice, we need to log the activity of this method into our log outputs
		log.info("In PlayerDaoImpl class - getAll() - getting list of players...");
		
		//implement some logic here
		//here I will be providing some GamePlayer objects within arraylist instead of making a database call
		List<GamePlayer> players = new ArrayList<>();
		
		players.add(new GamePlayer(1, "ScaryCat75", 2_829_109));
		players.add(new GamePlayer(2, "RevaBoy2308", 283_882));
		players.add(new GamePlayer(3, "FortnightFan7", 3_873_801));
		players.add(new GamePlayer(4, "YOLO_Dude345", 1_000_000));
		
		log.info("In PlayerDaoImpl class - getAll() - list has been retrieved successfully. List: \n" + players.toString());
		return players;
	}

}
