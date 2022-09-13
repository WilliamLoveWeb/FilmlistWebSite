package com.website.filmlist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import com.website.filmlist.dao.FilmlistDao;
import com.website.filmlist.domain.FilmlistItem;

@ConditionalOnProperty(name="app.environment" , havingValue="prod")
@Service
public class MovieRatingServiceLiveImpl implements MovieRatingService{

	@Autowired
	private FilmlistDao filmlistDao;
	
	/**
	 * 
	 * This function get data of table "film" of table that
	 * are in form of list of filmlistItem
	 *
	 */
	@Override
	public List<FilmlistItem> getAllFilm() {
		return filmlistDao.getFilmlist();
	}

}
