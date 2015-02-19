package com.href.biz.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.href.biz.domain.Cinema;

public interface CinemaRepo extends JpaRepository<Cinema, Serializable>{

}
