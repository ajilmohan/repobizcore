package com.href.biz.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.href.biz.domain.Movie;

public interface MovieRepo extends JpaRepository<Movie, Serializable> {

	@Query("select m from Movie m where m.status = ?")
	List<Movie> getAllActivemovies(String status);
}
