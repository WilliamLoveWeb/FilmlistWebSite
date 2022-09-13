package com.website.filmlist.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.website.filmlist.domain.FilmlistItem;
/**
 * This class retrieve data of the database that has been configure
 * @author william meilland
 *
 */
@Transactional
@Repository
public class FilmlistDao{
	
	@Autowired
	private SessionFactory factory;
	
	public void saveFilm(FilmlistItem filmlistItem) {
		getSession().save(filmlistItem);
	}
	
	public List<FilmlistItem> getFilmlist(){
		
        CriteriaQuery<FilmlistItem> criteriaQuery = getSession().getCriteriaBuilder().createQuery(FilmlistItem.class);
        criteriaQuery.from(FilmlistItem.class);

        List<FilmlistItem> list = getSession().createQuery(criteriaQuery).getResultList();
        return list;
	}
	
	private Session getSession() {
		Session session = factory.getCurrentSession();
		if(session == null) {
			session = factory.openSession();
		}
		return session;
	}
}
