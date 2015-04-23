package com.href.biz.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TRNSHOW")
public class Show implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="DICN_ID", unique= true, nullable=false)
	private DicnShow dicnShow;
	
	@OneToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="MOVIE_ID",  nullable=false)
	private Movie movie;
	
	@ManyToOne
    @JoinColumn(name="SCREEN_ID", nullable=false)
	private Screen screen;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "SHOW_DATE")
	@Temporal(TemporalType.DATE)
	private Date showDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DicnShow getDicnShow() {
		return dicnShow;
	}

	public void setDicnShow(DicnShow dicnShow) {
		this.dicnShow = dicnShow;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getShowDate() {
		return showDate;
	}

	public void setShowDate(Date showDate) {
		this.showDate = showDate;
	}
	
	

}
