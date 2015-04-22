package com.href.biz.test.repository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.href.biz.domain.ShowHistory;
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
	
	@Test
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

}
