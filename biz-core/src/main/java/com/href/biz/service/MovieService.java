package com.href.biz.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.href.biz.domain.Movie;
import com.href.biz.dto.MovieDTO;
import com.href.biz.proxy.MovieProxy;
import com.href.biz.repository.MovieRepo;


/****
 * 
 * @author ajilam
 *
 */

@Service("movieService")
@Transactional
public class MovieService implements MovieProxy {
	
	final static Logger logger = LoggerFactory.getLogger(MovieService.class);
	
	@Autowired
	MovieRepo movieRepo;

	public Movie save(Movie entity) {
		return movieRepo.save(entity);
	}

	public void delete(long id) {
		movieRepo.delete(id);
	}

	public void deleteAll() {
		movieRepo.deleteAll();
	}

	public Movie findOne(long id) {
		return movieRepo.findOne(id);
	}

	public List<Movie> findAll() {
		return movieRepo.findAll();
	}

	public List<MovieDTO> getAllActiveMovies() {
		return convertDomainToDtos(movieRepo.findAll());
	}
	
	
	private List<MovieDTO> convertDomainToDtos(List<Movie> movies){
		logger.info("Fn: convertDomainToDtos()  invoked . ");
		List<MovieDTO> dtos = new ArrayList<MovieDTO>();
		MovieDTO mDto = null;
		for(Movie movie : movies){
			mDto = new MovieDTO();
			BeanUtils.copyProperties(movie, mDto);
			dtos.add(mDto);
		}
		logger.info("Exit. ");
		return dtos;
		
	}

}
