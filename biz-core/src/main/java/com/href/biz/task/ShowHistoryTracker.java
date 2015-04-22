package com.href.biz.task;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.href.biz.proxy.ScreenProxy;
import com.href.biz.proxy.ShowHistoryProxy;

@Component
public class ShowHistoryTracker {
	
	
		@Autowired
		ScreenProxy screenProxy;
		
		
		@Autowired
		ShowHistoryProxy showHistoryProxy;
	
	 	@Scheduled(cron="*/30 * * * * ?")
	    public void demoServiceMethod()
	    {
	        //System.out.println("Method executed at every 5 seconds. Current time is :: "+ new Date());
	        //readRunningShows();
	    }
	 	
	 	
	 	private void readRunningShows(){
	 		
	 		showHistoryProxy.postShowHistoryDet();
	 		
	 	}

}
