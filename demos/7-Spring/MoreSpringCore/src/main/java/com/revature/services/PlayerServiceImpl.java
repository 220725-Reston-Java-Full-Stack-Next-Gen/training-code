package com.revature.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daos.PlayerDao;
import com.revature.models.GamePlayer;

@Service
public class PlayerServiceImpl implements PlayerService {
	private static Logger log = Logger.getLogger(PlayerServiceImpl.class);
	
	//here, because this class depends on the dao layer, I will use the @AutoWired annotation
	//to implement the bean wiring needed to do dependency injection via constructor injection
	//This will hand over control of instantation this object from the dev to the ioc container
	private PlayerDao playerDao;
	
	@Autowired
	public PlayerServiceImpl(PlayerDao playerDao) {
		this.playerDao = playerDao;
	}

	@Override
	public List<GamePlayer> getAllPlayers() {
		log.info("In PlayerServiceImpl class - getAllPlayers() - task started");
		
		List<GamePlayer> list = playerDao.getAll();
		
		log.info("In PlayerServiceImpl class - getAllPlayers() - task ended");
		
		return list;
	}

}
