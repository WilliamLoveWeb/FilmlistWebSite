package com.website.filmlist.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.website.filmlist.service.FilmlistService;

@WebMvcTest
@RunWith(SpringRunner.class)
public class FilmlistControllerTest {
	
	@MockBean
	private FilmlistService filmlistService;
 
	@Autowired
	MockMvc mockMvc;
	
	/**
	 * Test if controller of welcome page works correctly with 
	 * a test of a status of request,
	 * the view name that has been returned,
	 * the existence of different attributes of model
	 * @throws Exception
	 */
	@Test
	public void testGetFilm() throws Exception {
		
		mockMvc.perform(get("/home"))
		.andExpect(status().is2xxSuccessful())
		.andExpect(view().name("home"))
		.andExpect(model().size(4))
		.andExpect(model().attributeExists("FirstLine"))
		.andExpect(model().attributeExists("SecondLine"))
		.andExpect(model().attributeExists("ThirdLine"))
		.andExpect(model().attributeExists("numberOfMovies"));
		
	}
	
	/**
	 * Test if controller of search page for post request works 
	 * correctly with a test of a status of request,
	 * the view name that has been returned,
	 * the existence of different attributes of model
	 * @throws Exception
	 */
	@Test 
	public void testSubmitFilmlistSearch() throws Exception {
		mockMvc.perform(post("/search")
				.param("NameSearch","Bad"))
		.andExpect(status().is2xxSuccessful())
		.andExpect(view().name("search"))
		.andExpect(model().size(5))
		.andExpect(model().attributeExists("FirstLine"))
		.andExpect(model().attributeExists("SecondLine"))
		.andExpect(model().attributeExists("ThirdLine"))
		.andExpect(model().attributeExists("numberOfMovies"))
		.andExpect(model().attributeExists("name"));
	}
	
	/**
	 * Test if controller of search page for get request works 
	 * correctly with a test of a status of request,
	 * the view name that has been returned,
	 * the existence of different attributes of model
	 * @throws Exception
	 */
	@Test 
	public void testShowFilmlistSearch() throws Exception {
		mockMvc.perform(get("/search"))
		.andExpect(status().is2xxSuccessful())
		.andExpect(view().name("search"))
		.andExpect(model().size(5))
		.andExpect(model().attributeExists("FirstLine"))
		.andExpect(model().attributeExists("SecondLine"))
		.andExpect(model().attributeExists("ThirdLine"))
		.andExpect(model().attributeExists("numberOfMovies"))
		.andExpect(model().attributeExists("name"));
	}
}
