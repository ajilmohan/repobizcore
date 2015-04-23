package com.href.biz.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.href.biz.domain.Cinema;
import com.href.biz.domain.Movie;
import com.href.biz.domain.Screen;
import com.href.biz.domain.Show;
import com.href.biz.dto.DicnShowDTO;
import com.href.biz.dto.MovieDTO;
import com.href.biz.dto.ScreenDTO;
import com.href.biz.dto.ShowDTO;
import com.href.biz.proxy.CinemaProxy;
import com.href.biz.repository.CinemaRepo;
import com.href.biz.repository.ScreenRepo;

/****
 * Class represent service for {@link com.href.biz.domain.Cinema}
 * @author Ajil
 *
 */

@Service("cinemaService")
@Transactional
public class CinemaService  implements CinemaProxy {
	
	final static Logger logger = LoggerFactory.getLogger(CinemaService.class);
	
	@Autowired
	CinemaRepo cinemaRepo;
	
	@Autowired
	ScreenRepo screenRepo;

	public Cinema save(Cinema entity) {
		return cinemaRepo.save(entity);
	}

	public void delete(long id) {
		cinemaRepo.delete(id);
	}

	public void deleteAll() {
		cinemaRepo.deleteAll();
	}

	public Cinema findOne(long id) {
		return cinemaRepo.findOne(id);
	}

	public List<Cinema> findAll() {
		return cinemaRepo.findAll();
	}
	
	public List<ShowDTO> getShowsForScreen(long screenId){
		logger.info("Service 'getShowsForScreen' invoked . ");
		Screen screen = screenRepo.findOne(screenId);
		List<Show> shows = screen.getShows();
		//Iterate shows to fetch movie object
		for(Show show : shows){
			show.getMovie();
		}
		List<ShowDTO> showDtos = convertShowToShowSTOs(shows);
		logger.info("Exit 'getShowsForScreen'. ");
		return showDtos;
	}

	public List<ScreenDTO> getScreensForCinema(long cinemaId) {
		logger.info("Service 'getScreensForCinema' invoked . ");
		Cinema cinema = findOne(cinemaId);
		List<Screen> screens = cinema.getScreens();
		List<ScreenDTO> dtos = convertScreensToScreeDTOs(screens);
		logger.info("Exit 'getScreensForCinema'. ");
		return dtos;
	}
	
	private List<ScreenDTO> convertScreensToScreeDTOs(List<Screen> screens){
		logger.info(".convertScreensToScreeDTOs() invoked . ");
		List<ScreenDTO> screenDtos = new ArrayList<ScreenDTO>();
		ScreenDTO dto = null;
		for(Screen screen : screens) {
			dto = new ScreenDTO();
			dto.setId(screen.getId());
			dto.setName(screen.getName());
			screenDtos.add(dto);
		}
		
		logger.info("Exit .convertScreensToScreeDTOs() ");
		return screenDtos;
	}
	
	private List<ShowDTO> convertShowToShowSTOs(List<Show> shows){
		logger.info(".convertShowToShowSTOs() invoked . ");
		List<ShowDTO> showDtos = new ArrayList<ShowDTO>();
		ShowDTO showDto = null;
		DicnShowDTO dicn = null;
		for(Show show : shows){
			showDto = new ShowDTO();
			showDto.setId(show.getId());
			dicn = new DicnShowDTO();
			dicn.setId(show.getDicnShow().getId());
			dicn.setName(show.getDicnShow().getName());
			dicn.setShowTime(show.getDicnShow().getShowTime());
			showDto.setDicnShow(dicn);
			showDto.setMovie(convertMovieToMovieDTO(show.getMovie()));
			showDtos.add(showDto);
		}
		logger.info("Exit .convertShowToShowSTOs() ");
		return showDtos;
		
	}
	
	private MovieDTO convertMovieToMovieDTO(Movie movie){
		logger.info(".convertMovieToMovieDTO() invoked . ");
		MovieDTO movieDTO = new MovieDTO();
		movieDTO.setDistributor(movie.getDistributor());
		movieDTO.setEndDate(movie.getEndDate());
		movieDTO.setId(String.valueOf( movie.getId()));
		movieDTO.setLanguage(movie.getLanguage());
		movieDTO.setName(movie.getName());
		movieDTO.setStartDate(movie.getStartDate());
		movieDTO.setStatus(movie.getStatus());
		logger.info("Exit .convertMovieToMovieDTO() ");
		return movieDTO;
	}
		
	}
