package com.href.biz.test.repository;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
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
import com.href.biz.dto.DicnShowDTO;
import com.href.biz.dto.ShowDTO;
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
	
//	@Test
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
	
	//@Test
	@Transactional
	@Rollback(false)
	public void getShowOnDate(){
		
		Date date = new Date();
		
		List<Show> shows = showRepo.getShowsForADate(date);
		
		if(shows != null){
			
		}
		
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void beanCopyTest(){
		
		List<Show> shows = showRepo.findAll();
		
		List<ShowDTO> showDTOs = new ArrayList<ShowDTO>();
		ShowDTO dto = new ShowDTO();
		DicnShowDTO dicShowDto = new DicnShowDTO();
		for(Show show : shows) {
			
			try {
				BeanUtils.copyProperties(dicShowDto, show.getDicnShow());
				System.out.println(dto.toString());
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
