package com.href.biz.endpoint;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.href.biz.dto.DicnShowDTO;
import com.href.biz.dto.MovieDTO;
import com.href.biz.proxy.DicnShowProxy;
import com.href.biz.proxy.MovieProxy;
import com.href.biz.proxy.ShowProxy;

/****
 * Class represent of endpoint for film chart related queries.
 * @author Ajil
 *
 */

@Controller("chartEndpoint")
public class ChartEndpoint {
	
	final static Logger logger = LoggerFactory.getLogger(ChartEndpoint.class);
	
	@Autowired
	private ShowProxy showProxy;
	
	@Autowired
	private DicnShowProxy dicnShowProxy;
	
	@Autowired
	private MovieProxy movieProxy;
	
	/****
	 * This service has to fetch show's for charting
	 * @return 
	 */
	
	@RequestMapping(value = "/cinema/chart/shows", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<DicnShowDTO>> getShowsForCharting(){
		logger.info("Endpoint .getShowsForCharting() '/cinema/chart/shows invoked . ");
		List<DicnShowDTO>  shows  = new ArrayList<DicnShowDTO>();
		try {
			shows = dicnShowProxy.getAllShows();
		} catch (Exception e) {
			logger.error("Error !!!");
			logger.error("Error : 'Exception' " + e.getMessage());
		}
		logger.info("Exit . ");
		return new ResponseEntity<List<DicnShowDTO>>(shows, HttpStatus.OK);
		
	}
	
	
	/****
	 * This service has to fetch movies for charting
	 * @return 
	 */
	
	@RequestMapping(value = "/cinema/chart/movies", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<MovieDTO>> getMoviesForCharting(){
		logger.info("Endpoint .getMoviesForCharting() '/cinema/chart/movies invoked . ");
		List<MovieDTO>  movies  = new ArrayList<MovieDTO>();
		try {
			movies = movieProxy.getAllActiveMovies();
		} catch (Exception e) {
			logger.error("Error !!!");
			logger.error("Error : 'Exception' " + e.getMessage());
		}
		logger.info("Exit . ");
		return new ResponseEntity<List<MovieDTO>>(movies, HttpStatus.OK);
		
	}

}
