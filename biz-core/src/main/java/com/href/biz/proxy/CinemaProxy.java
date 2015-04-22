package com.href.biz.proxy;

import java.util.List;

import com.href.biz.domain.Cinema;
import com.href.biz.dto.ScreenDTO;
import com.href.biz.dto.ShowDTO;

public interface CinemaProxy extends BaseProxy<Cinema> {
	
	List<ScreenDTO> getScreensForCinema(long cinemaId);
	List<ShowDTO> getShowsForScreen(long screenId);

}
