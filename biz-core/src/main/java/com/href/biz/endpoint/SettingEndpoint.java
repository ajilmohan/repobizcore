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

import com.href.biz.domain.Movie;
import com.href.biz.dto.MovieDTO;
import com.href.biz.proxy.MovieProxy;

@Controller("settingEndpoint")
public class SettingEndpoint {
	
	@Autowired
	private MovieProxy movieProxy;
	
	@RequestMapping(value = "/setting/{screen}/getmovies", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<MovieDTO>> getMovies(final @PathVariable String screen){
		
		List<MovieDTO> moviesDto  = new ArrayList<MovieDTO>();
		List<Movie> movies = movieProxy.findAll();
		moviesDto = converDomainToDto(movies);
		return new ResponseEntity<List<MovieDTO>>(moviesDto, HttpStatus.OK);
		
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

}
