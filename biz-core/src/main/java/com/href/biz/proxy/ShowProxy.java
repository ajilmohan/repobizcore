package com.href.biz.proxy;

import java.util.Date;
import java.util.List;

import com.href.biz.domain.Show;
import com.href.biz.dto.ScreenDTO;
import com.href.biz.dto.ShowDTO;

public interface ShowProxy extends BaseProxy<Show> {
	
	List<ShowDTO> getShowsOnScreen(ScreenDTO screen , Date date);

}
