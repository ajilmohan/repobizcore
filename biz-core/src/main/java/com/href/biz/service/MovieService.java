package com.href.biz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.href.biz.domain.Movie;
import com.href.biz.proxy.MovieProxy;
import com.href.biz.repository.MovieRepo;

@Service("movieService")
@Transactional
public class MovieService implements MovieProxy {
	
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

}
