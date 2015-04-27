package com.href.biz.endpoint;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.href.biz.domain.DicnShow;
import com.href.biz.domain.Movie;
import com.href.biz.domain.Screen;
import com.href.biz.domain.Show;
import com.href.biz.dto.DicnShowDTO;
import com.href.biz.dto.MovieDTO;
import com.href.biz.dto.ShowDTO;
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
	
	@RequestMapping(value = "/cinema/chart/getshows", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<DicnShowDTO>> getShowsForCharting(){
		logger.info("Endpoint .getShowsForCharting() '/cinema/chart/getshows invoked . ");
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
	
	@RequestMapping(value = "/cinema/chart/getmovies", method = RequestMethod.GET )
	@ResponseBody
	public ResponseEntity<List<MovieDTO>> getMoviesForCharting(){
		logger.info("Endpoint .getMoviesForCharting() '/cinema/chart/getmovies invoked . ");
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
	
	@RequestMapping(value = "/cinema/chart/show", method = RequestMethod.PUT , consumes = {"application/json"} )
	@ResponseBody
	public ResponseEntity<String> chartShow(ShowDTO showDto){
		logger.info("Endpoint .chartShow() '/cinema/chart/show invoked . ");
		try {
			showProxy.save(convertFromShowDtoToShow(showDto));
		} catch (Exception e) {
			logger.error("Error !!!");
			logger.error("Error : 'Exception' " + e.getMessage());
		}
		logger.info("Exit . ");
		return new ResponseEntity<String>("Show Charted", HttpStatus.OK);
	}
	
	
	private Show convertFromShowDtoToShow(ShowDTO showDto){
		logger.info("Endpoint .convertFromShowDtoToShow()  invoked . ");
		String[] showPropIgnore = {"dicnShow","movie","screen"};
		Show show  = new Show();
		BeanUtils.copyProperties(showDto, show,showPropIgnore);
		DicnShow dicShow  = new DicnShow();
		dicShow.setId(showDto.getDicnShow().getId());
		show.setDicnShow(dicShow);
		Movie movie = new Movie();
		movie.setId(showDto.getMovie().getId());
		show.setMovie(movie);
		Screen screen = new Screen();
		screen.setId(showDto.getScreen().getId());
		show.setScreen(screen);
		logger.info("Exit . ");
		return show;
	}
	

}
