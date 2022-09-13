package com.website.filmlist.domain;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * This is class is the class model of the table named "film" of database
 * 
 * @author williammeilland
 *
 */
@Entity
@Table(name="film")
public class FilmlistItem {
	@Column (name="poster")
	private String poster;
	@Column (name="title")
	private String title;
	@Column (name="rating")
	private Double rating;
	@Id
	@Column (name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private static Integer index=0;
	
	public FilmlistItem() {
	}
	
	public FilmlistItem(String title, Double rating, String poster,Integer id) {
		super();
		this.title = title;
		this.rating = rating;
		this.poster= poster;
		this.id = index++;
	}
	
	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public static Integer getIndex() {
		return index;
	}

	public static void setIndex(Integer index) {
		FilmlistItem.index = index;
	}
	
	/**
	 * This function tests if all word that user put in the bar are in the title of film item
	 * regardless of upper and lower case.
	 * @param nameSearch it's string that input user in the search bar.
	 * @return the boolean of the test
	 */
	public boolean testEqualityWithoutUppercaseAndSpace(String nameSearch) {
		String wrd[]=nameSearch.split(" ");
		String tle[]=this.title.split(" ");
		boolean b=true;
		for(String word:wrd) {
			boolean c=false;
			for(String t:tle) {
				c=c||(t.toLowerCase().equals(word.toLowerCase()));
			}
			b=b&&c;
		}
		return b;
	}

	/**
	 * This function tests if the URL of poster works.
	 * @return the boolean of the test
	 */
	public boolean verifyURL() throws IOException {
		URL Url = new URL(poster);
		HttpURLConnection huc = (HttpURLConnection) Url.openConnection();
		 
		int responseCode = huc.getResponseCode();
		
		return (responseCode == HttpURLConnection.HTTP_OK);
	}
}
