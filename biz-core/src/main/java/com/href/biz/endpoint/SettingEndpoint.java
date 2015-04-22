package com.href.biz.endpoint;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.href.biz.domain.Clazz;
import com.href.biz.domain.Movie;
import com.href.biz.domain.Screen;
import com.href.biz.domain.Show;
import com.href.biz.dto.ClazzDTO;
import com.href.biz.dto.DicnClazzDTO;
import com.href.biz.dto.DicnShowDTO;
import com.href.biz.dto.MovieDTO;
import com.href.biz.dto.ScreenDTO;
import com.href.biz.dto.ShowDTO;
import com.href.biz.proxy.MovieProxy;
import com.href.biz.proxy.ScreenProxy;

@Controller("settingEndpoint")
public class SettingEndpoint {
	
	@Autowired
	private MovieProxy movieProxy;
	
	@Autowired
	private ScreenProxy screenProxy;
	
	@RequestMapping(value = "/setting/{screen}/getmovies", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<MovieDTO>> getMovies(final @PathVariable String screen){
		
		List<MovieDTO> moviesDto  = new ArrayList<MovieDTO>();
		List<Movie> movies = movieProxy.findAll();
		moviesDto = converDomainToDto(movies);
		return new ResponseEntity<List<MovieDTO>>(moviesDto, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/setting/{cinema}/getscreens", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<ScreenDTO>> getMovieScreens(final @PathVariable String cinema){
		
		List<ScreenDTO> screenDto  = new ArrayList<ScreenDTO>();
		List<Screen> screens = screenProxy.getScreensByCinema(cinema.replace("~", " "));
		screenDto = converScreenDomainToDto(screens);
		return new ResponseEntity<List<ScreenDTO>>(screenDto, HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value = "/setting/{screen}/savemovie", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<String> saveMovie(final @PathVariable String screen, 
			@RequestBody MovieDTO movieDTO){
		
		try {
			Movie movie = converDTOToDomain(movieDTO);
			movieProxy.save(movie);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String status = "";
		return new ResponseEntity<String>(status, HttpStatus.OK);
		
	}
	
	private Movie converDTOToDomain(MovieDTO movieDTO){
		
		Movie movie = new Movie();
		movie.setDistributor(movieDTO.getDistributor());
		movie.setLanguage(movieDTO.getLanguage());
		movie.setName(movieDTO.getName());
		movie.setStatus(movieDTO.getStatus());
		
		
		return movie;
	}
	
	private List<MovieDTO> converDomainToDto(List<Movie> movies){
		
		List<MovieDTO> movieDtos = new ArrayList<MovieDTO>();
		MovieDTO movieDto = new MovieDTO();
		
		for(Movie movie : movies){
			movieDto = new MovieDTO();
			movieDto.setDistributor(movie.getDistributor());
			movieDto.setName(movie.getName());
			movieDtos.add(movieDto);
		}
		
		
		return movieDtos;
		
	}
	
	private List<ScreenDTO> converScreenDomainToDto(List<Screen> screens) {
		
		List<ScreenDTO> screenDtos = new ArrayList<ScreenDTO>();
		ScreenDTO screenDTO = new ScreenDTO();
		ShowDTO showDto = new ShowDTO();
		ClazzDTO clDto = new ClazzDTO();
		List<ClazzDTO> clDtos = new ArrayList<ClazzDTO>();
		List<ShowDTO> showDtos = new ArrayList<ShowDTO>();
		DicnShowDTO dShowDto = new DicnShowDTO();
		DicnClazzDTO dClzDto = new DicnClazzDTO();
		
		for(Screen screen  : screens){
			screenDTO = new ScreenDTO();
			screenDTO.setId(screen.getId());
			//BeanUtils.copyProperties(screenDTO, screen , new String[] {"clazzes" ,"cinema" , "shows"});
			screenDTO.setName(screen.getName());
			
			for(Show show : screen.getShows()){
				showDto = new ShowDTO();
				showDto.setId(show.getId());
				dShowDto.setId(show.getDicnShow().getId());
				dShowDto.setName(show.getDicnShow().getName());
				dShowDto.setShowTime(show.getDicnShow().getShowTime());
				showDto.setDicnShow(dShowDto);
				showDtos.add(showDto);
			}
			
			for(Clazz clz : screen.getClazzes()){
				clDto = new ClazzDTO();
				clDto.setId(clz.getId());
				dClzDto.setId(clz.getDicnClazz().getId());
				dClzDto.setName(clz.getDicnClazz().getName());
				dClzDto.setRate(clz.getDicnClazz().getRate());
				clDto.setDicnClazz(dClzDto);
				clDtos.add(clDto);
				
			}
			
			screenDTO.setClazzes(clDtos);
			screenDTO.setShows(showDtos);
			
			screenDtos.add(screenDTO);
		}
		
		return screenDtos;
	}


}
