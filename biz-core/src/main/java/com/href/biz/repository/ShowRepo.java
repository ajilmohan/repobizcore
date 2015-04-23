package com.href.biz.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.href.biz.domain.Show;

public interface ShowRepo extends ShowRepoCustom , JpaRepository<Show, Serializable>  {
	
	

}
