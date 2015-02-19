package com.href.biz.test.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.href.biz.domain.Cinema;
import com.href.biz.domain.Clazz;
import com.href.biz.domain.DicnClazz;
import com.href.biz.domain.DicnShow;
import com.href.biz.domain.Movie;
import com.href.biz.domain.Screen;
import com.href.biz.domain.Show;
import com.href.biz.repository.CinemaRepo;
import com.href.biz.repository.ClazzRepo;
import com.href.biz.repository.DicnClazzRepo;
import com.href.biz.repository.DicnShowRepo;
import com.href.biz.repository.MovieRepo;
import com.href.biz.repository.ScreenRepo;
import com.href.biz.repository.ShowRepo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:config.xml",
        "classpath:repo.xml"
})

@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class })
public class CinemaRepoTest {
	
	@Autowired
	ScreenRepo screenRepo;
	
	@Autowired
	ShowRepo showRepo;
	
	@Autowired
	DicnShowRepo dicnShowRepo;
	
	@Autowired
	MovieRepo movieRepo;
	
	@Autowired
	DicnClazzRepo dicnClazzRepo;
	
	@Autowired
	ClazzRepo clazzRepo;
	
	@Autowired
	CinemaRepo cinemaRepo;
	
	@Test
	@Transactional
	@Rollback(false)
	public void saveTest(){
		
		Cinema cinema  = new Cinema();
		
		cinema.setName("JRH Cinema");
		cinema.setLocation("Kunnamkulam");
		
		List<Screen> screens = new ArrayList<Screen>(); 
		
		Screen screen  = new Screen();
		screen.setName("Screen-1");
		List<DicnShow> dicnShows = dicnShowRepo.findAll();
		
		List<Movie> movies = movieRepo.findAll();
		
		List<Show> shows = new ArrayList<Show>();
		Show show = null;
		for(DicnShow dicnshow :  dicnShows){
			show = new Show();
			show.setDicnShow(dicnshow);
			show.setMovie(movies.get(5));
			show.setScreen(screen);
			shows.add(show);
		}
		
		List<DicnClazz>  dicnClazzs = dicnClazzRepo.findAll();
		Clazz clazz = null;
		List<Clazz> clazzs = new ArrayList<Clazz>();
		for(DicnClazz dicnClazz :  dicnClazzs){
			
			clazz = new Clazz();
			clazz.setDicnClazz(dicnClazz);
			clazz.setScreen(screen);
			clazz.setSeats(150);
			
			clazzs.add(clazz);
			
		}
		
		
		screen.setShows(shows);
		screen.setClazzes(clazzs);
		screen.setCinema(cinema);
		
		screens.add(screen);
		
		screen  = new Screen();
		screen.setName("Screen-2");
		screen.setShows(shows);
		screen.setClazzes(clazzs);
		screen.setCinema(cinema);
		screens.add(screen);
		
		screen  = new Screen();
		screen.setName("Screen-3");
		screen.setShows(shows);
		screen.setClazzes(clazzs);
		screen.setCinema(cinema);
		screens.add(screen);
		
		cinema.setScreens(screens);
		
		cinemaRepo.save(cinema);
		
		
		
		
	}

}
