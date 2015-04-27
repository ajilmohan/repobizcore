package com.href.biz.proxy;

import java.util.List;

import com.href.biz.domain.Movie;
import com.href.biz.dto.MovieDTO;

public interface MovieProxy  extends BaseProxy<Movie> {
	
	List<MovieDTO> getAllActiveMovies();

}
