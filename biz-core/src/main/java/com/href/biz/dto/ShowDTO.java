package com.href.biz.dto;

import java.util.Date;


public class ShowDTO {

	private Long id;
	private DicnShowDTO dicnShow;
	private MovieDTO movie;
	private ScreenDTO screen;
	private Date showDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public DicnShowDTO getDicnShow() {
		return dicnShow;
	}
	public void setDicnShow(DicnShowDTO dicnShow) {
		this.dicnShow = dicnShow;
	}
	public MovieDTO getMovie() {
		return movie;
	}
	public void setMovie(MovieDTO movie) {
		this.movie = movie;
	}
	public ScreenDTO getScreen() {
		return screen;
	}
	public void setScreen(ScreenDTO screen) {
		this.screen = screen;
	}
	public Date getShowDate() {
		return showDate;
	}
	public void setShowDate(Date showDate) {
		this.showDate = showDate;
	}
	
	
}
