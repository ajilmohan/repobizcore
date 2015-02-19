package com.href.biz.test.repository;

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

import com.href.biz.domain.DicnShow;
import com.href.biz.domain.Movie;
import com.href.biz.domain.Show;
import com.href.biz.repository.DicnShowRepo;
import com.href.biz.repository.MovieRepo;
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
public class ShowRepoTest {
	
	@Autowired
	ShowRepo showRepo;
	
	@Autowired
	DicnShowRepo dicnShowRepo;
	
	@Autowired
	MovieRepo movieRepo;
	
	@Test
	@Transactional
	@Rollback(false)
	public void saveTest(){
		
		DicnShow dicn = null;
		
		dicn  = dicnShowRepo.findOne(1L);
		
		Movie movie  = null;
		
		movie = movieRepo.findOne(1L);
		
		Show show = new Show();
		show.setDicnShow(dicn);
		show.setMovie(movie);
		
		showRepo.save(show);
		
	}

}
