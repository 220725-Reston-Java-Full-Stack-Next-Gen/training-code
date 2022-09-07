package com.revature.drivers;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.revature.config.AppConfig;
import com.revature.models.Anime;
import com.revature.services.AnimeService;
import com.revature.services.AnimeServiceImpl;

public class MainDriver {
	
	//here is where instead of referring the beans.xml file to create our Spring IoC container,
	//we will be making a configuration class that manages the beans from using component scanning
	private static ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);

	public static void main(String[] args) {
		// 2. making the service class instance
		AnimeService animeServ = appContext.getBean(AnimeServiceImpl.class);
		
		//3. make that service call to get my anime list
		List<Anime> showList = animeServ.getAllAnimeShows();
		
		//4. print my list to the console
		System.out.println("My Netflix Watchlist: \n");
		for(Anime show : showList) {
			System.out.println(show);
		}

	}

}
