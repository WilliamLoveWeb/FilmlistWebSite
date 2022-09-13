package com.website.filmlist.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.filmlist.domain.FilmlistItem;
import com.website.filmlist.repository.FilmlistRepository;
/**
 * 
 * @author williammeilland
 *
 */
@Service
public class FilmlistService {
	
	@Autowired
	FilmlistRepository filmlistRepository;
	@Autowired
	MovieRatingService movieRatingService;
	
	/**
	 * This function takes care to put data of movieRatingService(data of true database) 
	 * in filmlistItem. 
	 * @return filmlistItems
	 */
	public List<FilmlistItem> setAndGetFilmListRepository(){
		if(getFilmlistItemSize()==0) {
			List<FilmlistItem> list=movieRatingService.getAllFilm();
			filmlistRepository.setFilmlistItems(list);
			return list;
		}
		return filmlistRepository.getList();
	}
	
	/**
	 * 
	 * @return Random listFilm with items that have an URL's poster
	 * that work.
	 * @throws IOException due to call getListInteger
	 */
	public List<FilmlistItem> getRandomListFilm() throws IOException {
		this.setAndGetFilmListRepository();
		List<FilmlistItem> RandomList = new ArrayList<FilmlistItem>();
	    int i=0;
	    for(Integer index: filmlistRepository.getListInteger(0,getFilmlistItemSize())) {
	    	FilmlistItem film=filmlistRepository.getFilmlistItem(index);
	    	film.setId(i++);
	    	RandomList.add(film);
	    }
	    return RandomList;
	}
	
	/**
	 * 
	 * @return the size of list
	 */
	public int getFilmlistItemSize() {
		return this.filmlistRepository.getList().size();
	}
	
	/**
	 * 
	 * @param NameSearch that has been input in the bar of search
	 * @return a list of item that title return true with the Test of correspondence 
	 * with the nameSearch
	 */
	public List<FilmlistItem> getFilmListSearch(String NameSearch){
		this.setAndGetFilmListRepository();
		List<FilmlistItem> list=new ArrayList<FilmlistItem>();
		int i=0;
		for(FilmlistItem film: filmlistRepository.getList()) {
			if((film.testEqualityWithoutUppercaseAndSpace(NameSearch))&&(list.size()<9)) {
				film.setId(i++);
				list.add(film);
			}
		}
		return list;
	}
	
	/**
	 * According NameSearch the value of return changes :
	 * it's empty or it's value or getFilmlistSearch
	 * @param NameSearch 
	 * @return 
	 */
	public List<FilmlistItem> ReturnFilmlistSearch(String NameSearch){
		if(NameSearch!=null) {
			if(NameSearch.equals("")) {
				return new ArrayList<FilmlistItem>();
			}
			return this.getFilmListSearch(NameSearch);	
		}
		return new ArrayList<FilmlistItem>();
	}
	
	public List<FilmlistItem> FirstLine(List<FilmlistItem> list){
		return filmlistRepository.FirstLine(list);
	}
	
	public List<FilmlistItem> SecondLine(List<FilmlistItem> list){
		return filmlistRepository.SecondLine(list);
	}
	
	public List<FilmlistItem> ThirdLine(List<FilmlistItem> list){
		return filmlistRepository.ThirdLine(list);
	}
}
