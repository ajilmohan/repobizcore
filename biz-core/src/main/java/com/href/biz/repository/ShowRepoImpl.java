package com.href.biz.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import com.href.biz.domain.Show;

public class ShowRepoImpl  implements ShowRepoCustom {
	
	@PersistenceContext
	private EntityManager em;

		
	/****
	 * 
	 * Reference http://www.objectdb.com/java/jpa/query/parameter
	 */
	public List<Show> getShowsForADate(Date date) { 
		
		/*String query = "SELECT sh FROM Show sh  WHERE sh.showDate = ?1" ;
		Query q = em.createQuery(query , Show.class).setParameter(1,date,TemporalType.DATE);*/
		
		String query = "SELECT sh FROM Show sh  WHERE sh.status = ?1 AND sh.showDate = ?2 " ;
		Query q = em.createQuery(query , Show.class).setParameter(1,"RUNNING")
													.setParameter(2, date, TemporalType.DATE);
		
		/*String query = "SELECT sh FROM Show sh  WHERE sh.status = 'RUNNING' AND sh.showDate = '"+date+"'" ;
		Query q = em.createQuery(query , Show.class);*/
		
		/*return em.createQuery(
				   "from Show where active = false", Show.class
		).getResultList();*/
		
		return q.getResultList();
	}

}
