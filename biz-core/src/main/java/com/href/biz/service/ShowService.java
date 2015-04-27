package com.href.biz.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.href.biz.domain.Screen;
import com.href.biz.domain.Show;
import com.href.biz.dto.DicnShowDTO;
import com.href.biz.dto.MovieDTO;
import com.href.biz.dto.ScreenDTO;
import com.href.biz.dto.ShowDTO;
import com.href.biz.proxy.ShowProxy;
import com.href.biz.repository.ShowRepo;


@Service("showService")
@Transactional
public class ShowService implements ShowProxy {
	
	final static Logger logger = LoggerFactory.getLogger(ShowService.class);
	
	@Autowired
	ShowRepo showRepo;

	public Show save(Show entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	public Show findOne(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Show> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ShowDTO> getShowsOnScreen(ScreenDTO screenDto , Date date) {
		logger.info("Service 'getShowsOnScreen' invoked . ");
		List<ShowDTO> showDTOs = new ArrayList<ShowDTO>();
		Screen screen = new Screen();
		screen.setId(screenDto.getId());
		showDTOs = convertShowToShowDTOS(showRepo.getShowsForADate(date,screen));
		logger.info("Exit 'getShowsOnScreen'. ");
		return showDTOs;
	}
	
	private List<ShowDTO> convertShowToShowDTOS(List<Show> shows){
		logger.info("Service 'convertShowToShowDTOS' invoked . ");
		List<ShowDTO> showDTOs = new ArrayList<ShowDTO>();
		String[] showPropIgnore = {"dicnShow","movie","screen"};
		String[] screenPropIgnore = {"shows" , "clazzes" , "cinema"};
		ShowDTO dto = new ShowDTO();
		DicnShowDTO dicnDto = new DicnShowDTO();
		MovieDTO movieDto = new MovieDTO();
		ScreenDTO screenDto = new ScreenDTO();
		for(Show show : shows) {
			dto = new ShowDTO();
			BeanUtils.copyProperties(show, dto,showPropIgnore);
			BeanUtils.copyProperties(show.getDicnShow() , dicnDto);
			dto.setDicnShow(dicnDto);
			BeanUtils.copyProperties(show.getMovie() , movieDto);
			dto.setMovie(movieDto);
			BeanUtils.copyProperties(show.getScreen() , screenDto , screenPropIgnore);
			dto.setScreen(screenDto);
			showDTOs.add(dto);
		}
		logger.info("Exit 'convertShowToShowDTOS'. ");
		return showDTOs;
	}

}
