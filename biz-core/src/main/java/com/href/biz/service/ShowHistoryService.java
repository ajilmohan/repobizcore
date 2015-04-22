package com.href.biz.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.href.biz.domain.Screen;
import com.href.biz.domain.Show;
import com.href.biz.domain.ShowHistory;
import com.href.biz.proxy.ScreenProxy;
import com.href.biz.proxy.ShowHistoryProxy;
import com.href.biz.repository.ShowHistoryRepo;

@Service("showHistoryService")
@Transactional
public class ShowHistoryService implements ShowHistoryProxy {
	
	@Autowired
	private ShowHistoryRepo showHistoryRepo;
	
	@Autowired
	private ScreenProxy screenProxy;

	public ShowHistory save(ShowHistory entity) {
		return showHistoryRepo.save(entity);
	}

	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	public ShowHistory findOne(long id) {
		return showHistoryRepo.findOne(id);
	}

	public List<ShowHistory> findAll() {
		return showHistoryRepo.findAll();
	}

	public void postShowHistoryDet() {

		
		ShowHistory history  = new ShowHistory();
 		
 		for(Screen screen : screenProxy.findAll()){
 			
 			for(Show show : screen.getShows()){
 				
 				history  = new ShowHistory();
	 			history.setCinemaId(1L);
	 			history.setScreenId(screen.getId());
 				history.setShowId(show.getId());
 				history.setMovieId(show.getMovie().getId());
 				history.setShowDate(new Date());
 				//histories.add(history);
 		 		this.save(history);
 			}
 		}
 		
	}

}
