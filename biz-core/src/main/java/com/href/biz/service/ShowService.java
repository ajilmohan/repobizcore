package com.href.biz.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.href.biz.domain.Screen;
import com.href.biz.domain.Show;
import com.href.biz.dto.ShowDTO;
import com.href.biz.proxy.ShowProxy;


@Service("showService")
@Transactional
public class ShowService implements ShowProxy {
	
	final static Logger logger = LoggerFactory.getLogger(ShowService.class);

	public Show save(Show entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	public Show findOne(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Show> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ShowDTO> getShowsOnScreen(Screen screen) {
		logger.info("Service 'getShowsOnScreen' invoked . ");
		List<ShowDTO> showDTOs = new ArrayList<ShowDTO>();
		
		logger.info("Exit 'getShowsOnScreen'. ");
		return null;
	}
	
	private List<ShowDTO> convertShowToShowDTOS(List<Show> shows){
		logger.info("Service 'convertShowToShowDTOS' invoked . ");
		List<ShowDTO> showDTOs = new ArrayList<ShowDTO>();
		ShowDTO dto = null;
		for(Show show : shows) {
			dto = new ShowDTO();
			dto.setId(show.getId());
			
		}
		logger.info("Exit 'convertShowToShowDTOS'. ");
		return showDTOs;
	}

}
