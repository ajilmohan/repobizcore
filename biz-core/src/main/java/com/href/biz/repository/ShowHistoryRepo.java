package com.href.biz.repository;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.href.biz.domain.ShowHistory;

public interface ShowHistoryRepo extends JpaRepository<ShowHistory, Serializable>{
	
	// Get Discount,  Year and Month
    @Query("select sh from ShowHistory sh where sh.showId = :showId and sh.showDate = :showDate")
    public ShowHistory getShowHistory(@Param("showId") Long showId 	, @Param("showDate") Date showDate);
 
}
