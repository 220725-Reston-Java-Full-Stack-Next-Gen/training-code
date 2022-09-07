package com.revature.daos;

import java.util.List;

import com.revature.models.GamePlayer;

public interface PlayerDao {
	
	public List<GamePlayer> getAll();

}
