package com.href.biz.dto;

import java.util.List;

public class CinemaDTO {

	private Long id;
	private String name;
	private String location;
	private List<ScreenDTO> screens;
	
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<ScreenDTO> getScreens() {
		return screens;
	}
	public void setScreens(List<ScreenDTO> screens) {
		this.screens = screens;
	}
	
	
}
