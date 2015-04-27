package com.href.biz.endpoint;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.href.biz.domain.Cinema;
import com.href.biz.dto.ScreenDTO;
import com.href.biz.dto.ShowDTO;
import com.href.biz.proxy.CinemaProxy;
import com.href.biz.proxy.ShowProxy;
import com.href.biz.util.BizUtil;


/****
 * Class represent of endpoint for all cinema related queries.
 * @author Ajil
 *
 */

@Controller("cinemaEndpoint")
public class CinemaEndpoint {
	
	final static Logger logger = LoggerFactory.getLogger(CinemaEndpoint.class);

	@Autowired
	CinemaProxy cinemaProxy;
	
	@Autowired
	ShowProxy showProxy;
	
	
	/****
	 * This service has to fetch screen's belongs to <code>cinemaId</code>
	 * @param cinemaId
	 * @return
	 */
	
	@RequestMapping(value = "/cinema/screen/{cinemaId}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<ScreenDTO>> getScreensOfCinema(final @PathVariable Integer cinemaId){
		logger.info("Endpoint .getScreensOfCinema() '/cinema/screen/{'"+cinemaId+"' invoked . ");
		
		List<ScreenDTO>  screens  = new ArrayList<ScreenDTO>();
		Cinema cinema = null;
		try {
			cinema = cinemaProxy.findOne(cinemaId);
			screens = cinemaProxy.getScreensForCinema(cinemaId);
		} catch (Exception e) {
			logger.error("Error !!!");
			logger.error("Error : 'Exception' " + e.getMessage());
		}
		
		
		logger.info("Exit . ");
		return new ResponseEntity<List<ScreenDTO>>(screens, HttpStatus.OK);
		
	}
	
	
	/****
	 * This service has to fetch show's belongs to <code>screenId</code> and 
	 * date <code>date</code>
	 * @param screenId
	 * @return
	 */
	
	@RequestMapping(value = "/cinema/{screenId}/{date}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<ShowDTO>> getShowsForScreen(@PathVariable Integer screenId , @PathVariable String date){
		logger.info("Endpoint .getShowsForScreen() '/cinema/{'"+screenId+"'}' invoked . ");
		
		List<ShowDTO>  shows  = new ArrayList<ShowDTO>();
		try {
			//shows = cinemaProxy.getShowsForScreen(screenId);
			ScreenDTO screen  = new ScreenDTO();
			screen.setId(Long.valueOf(screenId));
			Date showDate = BizUtil.convertStringToDate(date);
			shows = showProxy.getShowsOnScreen(screen, showDate);
		} catch (Exception e) {
			logger.error("Error !!!");
			logger.error("Error : 'Exception' " + e.getMessage());
		}
		
		
		logger.info("Exit . ");
		return new ResponseEntity<List<ShowDTO>>(shows, HttpStatus.OK);
		
	}
}
