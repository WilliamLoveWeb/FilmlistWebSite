package com.website.filmlist.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.website.filmlist.domain.FilmlistItem;
import com.website.filmlist.domain.Name;
import com.website.filmlist.service.FilmlistService;
/**
 * This class is the controller of our Project 
 * 
 * @author williammeilland
 *
 */
@Controller
public class FilmlistController {

	@Autowired
	FilmlistService filmlistService;
	
	/**
	 * 
	 * This function takes care of the welcome page("/home"), in this page we display 9 random film
	 * "FirstLine" matches with list of film that are displaying in the first line of page
	 * "SecondLine" matches with list of film that are displaying in the second line of page
	 * "ThirdLine" matches with list of film that are displaying in the third line of page
	 * "numberOfMovies" matches with the number that we have in total in the database
	 * @return ModelAndView the same view with the different data that we put in the model
	 * @throws IOException is require due to the function that return random list
	 */
	@GetMapping("/home")
	public ModelAndView getFilmlist() throws IOException  {
		
		String viewName="home";
		
		Map<String,Object> model=new HashMap<String,Object>();
		List<FilmlistItem> list=filmlistService.getRandomListFilm();
		model.put("FirstLine", filmlistService.FirstLine(list));
		model.put("SecondLine", filmlistService.SecondLine(list));
		model.put("ThirdLine", filmlistService.ThirdLine(list));
		model.put("numberOfMovies",filmlistService.getFilmlistItemSize());
		return new ModelAndView(viewName,model);
	}
	
	/**
	 * 
	 * This function takes care of the page("/search") when the user arrived, this page should display 
	 * the list of film that title matches with that is user put in the search bar.
	 * "name" matches with what user input in the search bar, in the case where user arrive in the
	 * page nothing is written. That is the reason why there is new Name() in name
	 * @return ModelAndView the same view with the different data that we put in the model
	 * @throws IOException is require due to the function that return list of film that title match with the search
	 */
	@GetMapping("/search")
	public ModelAndView ShowFilmlistSearch() throws IOException{
		
		String viewName="search";
		
		Map<String,Object> model=new HashMap<String,Object>();
		List<FilmlistItem> list=filmlistService.ReturnFilmlistSearch("");
		model.put("FirstLine", filmlistService.FirstLine(list));
		model.put("SecondLine", filmlistService.SecondLine(list));
		model.put("ThirdLine", filmlistService.ThirdLine(list));
		model.put("name", new Name());
		model.put("numberOfMovies",filmlistService.getFilmlistItemSize());
		return new ModelAndView(viewName,model);
	}

	/**
	 * 
	 * This function takes care of the page("/search") , in this page we display 
	 * film with title that matches with what user input in the search bar
	 * @return ModelAndView the same view with the different data that we put in the model
	 * @throws IOException is require due to the function that return list of film that title match with the search
	 */
	@PostMapping("/search")
	public ModelAndView SubmitFilmlistSearch(Name name) throws IOException {
		
		String viewName="search";
		
		Map<String,Object> model=new HashMap<String,Object>();
		model.put("name", name);
		List<FilmlistItem> list=filmlistService.ReturnFilmlistSearch(name.getNameSearch());
		model.put("FirstLine", filmlistService.FirstLine(list));
		model.put("SecondLine", filmlistService.SecondLine(list));
		model.put("ThirdLine", filmlistService.ThirdLine(list));
		model.put("numberOfMovies",filmlistService.getFilmlistItemSize());
		return new ModelAndView(viewName,model);
	}
}
