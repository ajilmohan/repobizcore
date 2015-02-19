package com.href.biz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.href.biz.domain.Screen;
import com.href.biz.proxy.ScreenProxy;
import com.href.biz.repository.ScreenRepo;

@Service("screenService")
@Transactional
public class ScreenService implements ScreenProxy {
	
	@Autowired
	private ScreenRepo screenRepo;

	public Screen save(Screen entity) {
		return screenRepo.save(entity);
	}

	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	public Screen findOne(long id) {
		return screenRepo.findOne(id);
	}

	public List<Screen> findAll() {
		return screenRepo.findAll();
	}

	public List<Screen> getScreensByCinema(String cinema) {
		return screenRepo.getScreensByCinema(cinema);
	}

}
