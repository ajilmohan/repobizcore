package com.href.biz.test.repository;

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

import com.href.biz.domain.Movie;
import com.href.biz.repository.MovieRepo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:config.xml",
        "classpath:repo.xml"
})

@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class })
public class MovieRepoTest  {

	@Autowired
	private MovieRepo movieRepo;
	
//	@Test
	public void saveMovie(){
		
		Movie movie = new Movie();
		movie.setName("Picket");
		movie.setLanguage("Malayalam");
		movie.setStatus("Open");
		movie.setEndDate("05/05/2015");
		movie.setStartDate("05/05/2015");
		
		movieRepo.save(movie);
		
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void getActiveMovies(){
		
		List<Movie> movies  = movieRepo.getAllActivemovies("Open");
		if(movies != null) {
			System.out.println("Movies."+movies.size());
		}
		
	}
}
