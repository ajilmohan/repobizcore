package com.href.biz.proxy;

import java.util.List;

import com.href.biz.domain.Screen;

public interface ScreenProxy extends BaseProxy<Screen> {
	
	List<Screen> getScreensByCinema(String cinema);

}
