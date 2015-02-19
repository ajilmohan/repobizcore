package com.href.biz.dto;


public class ClazzDTO {

	private Long id;
	private DicnClazzDTO dicnClazz;
	private int seats;
	private ScreenDTO screen;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public DicnClazzDTO getDicnClazz() {
		return dicnClazz;
	}
	public void setDicnClazz(DicnClazzDTO dicnClazz) {
		this.dicnClazz = dicnClazz;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public ScreenDTO getScreen() {
		return screen;
	}
	public void setScreen(ScreenDTO screen) {
		this.screen = screen;
	}
	
	
}
