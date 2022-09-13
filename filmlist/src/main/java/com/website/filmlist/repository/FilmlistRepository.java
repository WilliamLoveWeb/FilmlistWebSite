package com.website.filmlist.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.website.filmlist.domain.FilmlistItem;
/**
 * This class takes care of list of filmlistItem.
 * @author williammeilland
 *
 */
@Service
public class FilmlistRepository {
	
	private List<FilmlistItem> filmlistItems; 
	
	public FilmlistRepository() {
		this.filmlistItems=new ArrayList<FilmlistItem>();
	}
	public List<FilmlistItem> getList(){
		return filmlistItems;
	}
	
	public void setFilmlistItems(List<FilmlistItem> filmlistItems) {
		this.filmlistItems=filmlistItems;
	}
	
	public FilmlistItem getFilmlistItem(int index) {
		return filmlistItems.get(index);
	}
	
	/**
	 * This function get random list of integer that matches with the index of filmlistItem of
	 * the list. The filmlistItem can't be in double in the return list and should have URL's poster 
	 * that works. 
	 * @param min value minimum
	 * @param max value maximum
	 * @return list of random integer between min(include) and max(exclude).
	 * @throws IOException
	 */
	public List<Integer> getListInteger(int min,int max) throws IOException{
		List<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<9;i++) {
			int random_int = getRandomInt(min,max);
			while(list.contains(random_int)||(!getFilmlistItem(random_int).verifyURL())) {
				random_int = getRandomInt(min,max);
			}
			list.add(random_int);
		}
		return list;
	}
	
	/**
	 * 
	 * @param min include
	 * @param max exclude
	 * @return Random integer between min and max
	 */
	public int getRandomInt(int min,int max) {
		return (int)Math.floor(Math.random()*(max-min+1)+min);
	}
	
	/**
	 * This function give the 3 film that will be display in the first line
	 * @param list
	 * @return the first 3 film Item of the parameter in a list
	 */
	public List<FilmlistItem> FirstLine(List<FilmlistItem> list){
		List<FilmlistItem> listFirstLine=new ArrayList<FilmlistItem>();
		for(FilmlistItem filmlistItem : list) {
			Integer id=filmlistItem.getId();
			if((id==0)||(id==1)||(id==2)) {
				listFirstLine.add(filmlistItem);
			}
		}
		return listFirstLine;
	}
	
	/**
	 * This function give the 3 film that will be display in the second line
	 * @param list
	 * @return the fourth to sixth film Item of the parameter in a list
	 */
	public List<FilmlistItem> SecondLine(List<FilmlistItem> list){
		List<FilmlistItem> listSecondLine=new ArrayList<FilmlistItem>();
		for(FilmlistItem filmlistItem : list) {
			Integer id=filmlistItem.getId();
			if((id==3)||(id==4)||(id==5)) {
				listSecondLine.add(filmlistItem);
			}
		}
		return listSecondLine;
	}
	
	/**
	 * This function give the 3 film that will be display in the third line
	 * @param list
	 * @return the seventh to ninth film Item of the parameter in a list
	 */
	public List<FilmlistItem> ThirdLine(List<FilmlistItem> list){
		List<FilmlistItem> listThirdLine=new ArrayList<FilmlistItem>();
		for(FilmlistItem filmlistItem : list) {
			Integer id=filmlistItem.getId();
			if((id==6)||(id==7)||(id==8)) {
				listThirdLine.add(filmlistItem);
			}
		}
		return listThirdLine;
	}
}