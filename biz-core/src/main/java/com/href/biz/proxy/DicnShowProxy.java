package com.href.biz.proxy;

import java.util.List;

import com.href.biz.domain.DicnShow;
import com.href.biz.dto.DicnShowDTO;

public interface DicnShowProxy extends BaseProxy<DicnShow> {
	
	List<DicnShowDTO> getAllShows();

}
