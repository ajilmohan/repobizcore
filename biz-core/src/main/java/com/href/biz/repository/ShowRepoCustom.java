package com.href.biz.repository;

import java.util.Date;
import java.util.List;

import com.href.biz.domain.Screen;
import com.href.biz.domain.Show;

public interface ShowRepoCustom {
	
	List<Show> getShowsForADate(Date date , Screen screen);

}
