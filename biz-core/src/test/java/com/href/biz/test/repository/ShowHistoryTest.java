package com.href.biz.test.repository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.href.biz.domain.Clazz;
import com.href.biz.domain.ShowDetail;
import com.href.biz.domain.ShowHistory;
import com.href.biz.repository.ClazzRepo;
import com.href.biz.repository.MovieRepo;
import com.href.biz.repository.ShowHistoryRepo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:config.xml",
        "classpath:repo.xml"
})

@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class })
public class ShowHistoryTest {
	
	@Autowired
	ShowHistoryRepo showHistoryRepo;
	
	@Autowired
	MovieRepo movieRepo;
	
	@Autowired
	ClazzRepo clazzRepo;
	
//	@Test
	public void showHistoryTest(){
		String startDateString = "02/20/2015";

		 DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
		    Date startDate = null;
		    try {
		        startDate = df.parse(startDateString);
		        String newDateString = df.format(startDate);
		        System.out.println(newDateString);
		        HashMap<String,String> test = new HashMap<String,String>();
		    } catch (ParseException e) {
		        e.printStackTrace();
		    }
		
		    ShowHistory history  = showHistoryRepo.getShowHistory(1L, startDate);
		if(history == null){
			System.out.println("Test fail");
		}
		
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void createShowhistory(){
		
		List<ShowDetail> details = new ArrayList<ShowDetail>();
		//List<Clazz> clazzes= clazzRepo.findAll();
		
		ShowHistory hist = new ShowHistory();
		hist.setCinemaId(1L);
		hist.setMovieId(1L);
		hist.setScreenId(1L);
		hist.setShowId(1L);
		
		ShowDetail det = new ShowDetail();
		det.setClazz(clazzRepo.findOne(1L));
		det.setGrossAmnt(100);
		det.setSlFrom("SL200");
		det.setSlto("SL250");
		det.setShowHist(hist);
		details.add(det);
		
		det = new ShowDetail();
		det.setClazz(clazzRepo.findOne(2L));
		det.setGrossAmnt(100);
		det.setSlFrom("SL300");
		det.setSlto("SL150");
		det.setShowHist(hist);
		details.add(det);
		
		hist.setShowDetails(details);
		hist.setShowDate(new Date());
		
		showHistoryRepo.save(hist);
		
	}

}
