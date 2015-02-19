package com.href.biz.dto;

import java.util.List;

public class ScreenDTO {

	private Long id;
	private String name;
	private List<ShowDTO> shows;
	private List<ClazzDTO> clazzes;
	private CinemaDTO cinema;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<ShowDTO> getShows() {
		return shows;
	}
	public void setShows(List<ShowDTO> shows) {
		this.shows = shows;
	}
	public List<ClazzDTO> getClazzes() {
		return clazzes;
	}
	public void setClazzes(List<ClazzDTO> clazzes) {
		this.clazzes = clazzes;
	}
	public CinemaDTO getCinema() {
		return cinema;
	}
	public void setCinema(CinemaDTO cinema) {
		this.cinema = cinema;
	}
	
	
	
}
