package com.href.biz.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.href.biz.domain.DicnShow;
import com.href.biz.dto.DicnShowDTO;
import com.href.biz.proxy.DicnShowProxy;
import com.href.biz.repository.DicnShowRepo;

/****
 * 
 * @author Ajil
 *
 */

@Service("dicnShowService")
@Transactional
public class DicnShowService implements DicnShowProxy {
	
	final static Logger logger = LoggerFactory.getLogger(DicnShowService.class);
	
	@Autowired
	DicnShowRepo dicnShowRepo;
	
	public DicnShow save(DicnShow entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	public DicnShow findOne(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DicnShow> findAll() {
		return null;
	}
	
	public List<DicnShowDTO> getAllShows() {
		return convertDomainTODtos(dicnShowRepo.findAll());
	}
	
	private List<DicnShowDTO> convertDomainTODtos(List<DicnShow> dicnShows){
		logger.info("Fn: convertDomainToDtos()  invoked . ");
		List<DicnShowDTO> dtos = new ArrayList<DicnShowDTO>();
		DicnShowDTO diDto = null;
		if(dicnShows != null){
			for(DicnShow show : dicnShows){
				diDto = new DicnShowDTO();
				BeanUtils.copyProperties(show, diDto); 
				dtos.add(diDto);
			}
		}
		logger.info("Exit. ");
		return dtos;
		
	}

}
