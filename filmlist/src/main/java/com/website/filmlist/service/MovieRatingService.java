package com.website.filmlist.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.website.filmlist.domain.FilmlistItem;

@Service
public interface MovieRatingService {
	List<FilmlistItem> getAllFilm();
}