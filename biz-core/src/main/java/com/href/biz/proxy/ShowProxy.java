package com.href.biz.proxy;

import java.util.List;

import com.href.biz.domain.Screen;
import com.href.biz.domain.Show;
import com.href.biz.dto.ShowDTO;

public interface ShowProxy extends BaseProxy<Show> {
	
	List<ShowDTO> getShowsOnScreen(Screen screen);

}
