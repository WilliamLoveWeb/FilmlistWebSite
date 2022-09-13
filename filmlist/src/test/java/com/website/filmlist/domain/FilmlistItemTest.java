package com.website.filmlist.domain;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class FilmlistItemTest {
	
	@MockBean
	private FilmlistItem filmlistItem;
	
	/**
	 * Test the validity of URL's poster of Item.
	 * There is one that works and an other one that doesn't work.
	 * @throws Exception
	 */
	@Test
	public void testVerifyURL() throws Exception {
		
		filmlistItem=new FilmlistItem("", 1.0, "https://m.media-amazon.com/images/M/MV5BNDM0NDk2Nzc5N15BMl5BanBnXkFtZTcwMDg1NzEzOA@@._V1_UX256,0,256,256_AL_.jpg",0);
		
		Assert.assertTrue(filmlistItem.verifyURL());
		
		filmlistItem.setPoster("https://m.media-amazon.com/images/M/MV5BNDM0NDk2");
		
		Assert.assertFalse(filmlistItem.verifyURL());
	}
	
	/**
	 * Test the validity of our test for the searching of film.
	 * @throws Exception
	 */
	@Test
	public void testTestEqualityWithoutUppercaseAndSpace() {
		filmlistItem=new FilmlistItem("Very Bad Trip 1", 1.0, "",0);
		
		Assert.assertTrue(filmlistItem.testEqualityWithoutUppercaseAndSpace("Trip"));
		
		Assert.assertTrue(filmlistItem.testEqualityWithoutUppercaseAndSpace("Very Trip"));
		
		Assert.assertFalse(filmlistItem.testEqualityWithoutUppercaseAndSpace("Trip Paris"));
		
		Assert.assertFalse(filmlistItem.testEqualityWithoutUppercaseAndSpace("Tokyo Mom"));
	}
}
