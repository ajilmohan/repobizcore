package com.href.biz.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SHOW_DETAIL")
public class ShowDetail  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="CLAZZ_ID" , nullable = false)
	private Clazz clazz;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SHOW_HIST_ID", nullable = false)
	private ShowHistory showHist;
	
	@Column(name = "SL_FROM", nullable = false)
	private String slFrom;
	
	@Column(name = "SL_TO", nullable = false)
	private String slto;
	
	@Column(name = "GROSS_AMOUNT", nullable = false)
	private double grossAmnt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Clazz getClazz() {
		return clazz;
	}

	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}

	public String getSlFrom() {
		return slFrom;
	}

	public void setSlFrom(String slFrom) {
		this.slFrom = slFrom;
	}

	public String getSlto() {
		return slto;
	}

	public void setSlto(String slto) {
		this.slto = slto;
	}

	public double getGrossAmnt() {
		return grossAmnt;
	}

	public void setGrossAmnt(double grossAmnt) {
		this.grossAmnt = grossAmnt;
	}

	public ShowHistory getShowHist() {
		return showHist;
	}

	public void setShowHist(ShowHistory showHist) {
		this.showHist = showHist;
	}

	

}
