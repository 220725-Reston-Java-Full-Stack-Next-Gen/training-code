package com.revature.repos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.revature.models.Anime;

@Repository
public class AnimeDaoImpl implements AnimeDao {

	@Override
	public List<Anime> selectAll() {
		//here, I will NOT be providing the logic needed to log events in this class because Spring AOP will be managing that code implementation for me in another package (aka aspects package)
		//now that I'm not worried about logging (which is a cross-cutting concern for my app, I can just focus on providing the database implementation 
		
		List<Anime> animes = new ArrayList<>();
		
		animes.add(new Anime(1, "Dragon Ball Z", "Son Goku"));
		animes.add(new Anime(2, "One Piece", "Monkey D. Luffy"));
		animes.add(new Anime(3, "Hunter x Hunter", "Gon Freecss"));
		
		return animes;
	}

}
