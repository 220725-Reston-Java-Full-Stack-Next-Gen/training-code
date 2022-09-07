package com.revature.repos;

import java.util.List;

import com.revature.models.Anime;

public interface AnimeDao {
	
	public List<Anime> selectAll();

}
