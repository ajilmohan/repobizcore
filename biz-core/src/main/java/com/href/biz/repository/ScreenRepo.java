package com.href.biz.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.href.biz.domain.Screen;

public interface ScreenRepo extends JpaRepository<Screen, Serializable>{
	
	// Get Discount,  Year and Month
    @Query("select sc from Screen sc where sc.cinema.name = :name")
    public List<Screen> getScreensByCinema(@Param("name") String name);

}
