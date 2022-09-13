package com.website.filmlist.repository;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.website.filmlist.domain.FilmlistItem;

@RunWith(MockitoJUnitRunner.class)
public class FilmlistRepositoryTest{
	
	@InjectMocks
	private FilmlistRepository filmlistRepository;
	
	@Mock
	private List<FilmlistItem> filmlistItemsMocks;
	
	FilmlistItem item1 = new FilmlistItem("Star Wars", 10.0, "https://m.media-amazon.com/images/M/MV5BNDM0NDk2Nzc5N15BMl5BanBnXkFtZTcwMDg",1);
	FilmlistItem item2 = new FilmlistItem("Star Treck", 8.8, "https://m.media-amazon.com/images/M/MV5BNDM0NDk2Nzc5N15BMl5BanBnXkFtZTcwMDg1NzEzOA@@._V1_UX256,0,256,256_AL_.jpg",2);
	FilmlistItem item3 = new FilmlistItem("Pulp Fiction", 6.7, "https://m.media-amazon.com/images/M/MV5BNDM0NDk2Nzc5N15BMl5BanBnXkFtZTcwMDg1NzEzOA@@._V1_UX256,0,256,256_AL_.jpg",3);
	FilmlistItem item4 = new FilmlistItem("Mad Max", 6.9, "https://m.media-amazon.com/images/M/MV5BNDM0NDk2Nzc5N15BMl5BanBnXkFtZTcwMDg1NzEzOA@@._V1_UX256,0,256,256_AL_.jpg",4);
	FilmlistItem item5 = new FilmlistItem("Us", 8.0, "https://m.media-amazon.com/images/M/MV5BNDM0NDk2Nzc5N15BMl5BanBnXkFtZTcwMDg1NzEzOA@@._V1_UX256,0,256,256_AL_.jpg",5);
	FilmlistItem item6 = new FilmlistItem("Taxi Driver", 5.0, "https://m.media-amazon.com/images/M/MV5BNDM0NDk2Nzc5N15BMl5BanBnXkFtZTcwMDg1NzEzOA@@._V1_UX256,0,256,256_AL_.jpg",6);
	FilmlistItem item7 = new FilmlistItem("Star Crystal", 2.0, "https://m.media-amazon.com/images/M/MV5BNDM0NDk2Nzc5N15BMl5BanBnXkFtZTcwMDg1NzEzOA@@._V1_UX256,0,256,256_AL_.jpg",7);
	FilmlistItem item8 = new FilmlistItem("Star Odyssey", 1.0, "https://m.media-amazon.com/images/M/MV5BNDM0NDk2Nzc5N15BMl5BanBnXkFtZTcwMDg1NzEzOA@@._V1_UX256,0,256,256_AL_.jpg",8);
	FilmlistItem item9 = new FilmlistItem("Star Treck 2", 9.0, "https://m.media-amazon.com/images/M/MV5BNDM0NDk2Nzc5N15BMl5BanBnXkFtZTcwMDg1NzEzOA@@._V1_UX256,0,256,256_AL_.jpg",9);
	FilmlistItem item10 = new FilmlistItem("Star Treck 3", 7.8, "https://m.media-amazon.com/images/M/MV5BNDM0NDk2Nzc5N15BMl5BanBnXkFtZTcwMDg1NzEzOA@@._V1_UX256,0,256,256_AL_.jpg",10);
	FilmlistItem item11 = new FilmlistItem("Star Treck 4", 8.8, "https://m.media-amazon.com/images/M/MV5BNDM0NDk2Nzc5N15BMl5BanBnXkFtZTcwMDg1NzEzOA@@._V1_UX256,0,256,256_AL_.jpg",11);
	FilmlistItem item12 = new FilmlistItem("Star Treck 5", 8.8, "https://m.media-amazon.com/images/M/MV5BNDM0NDk2Nzc5N15BMl5BanBnXkFtZTcwMDg1NzEzOA@@._V1_UX256,0,256,256_AL_.jpg",12);
	FilmlistItem item13 = new FilmlistItem("Star Treck 6", 8.8, "https://m.media-amazon.com/images/M/MV5BNDM0NDk2Nzc5N15BMl5BanBnXkFtZTcwMDg1NzEzOA@@._V1_UX256,0,256,256_AL_.jpg",13);
	FilmlistItem item14 = new FilmlistItem("Star Treck : Generation", 8.8, "https://m.media-amazon.com/images/M/MV5BNDM0NDk2Nzc5N15BMl5BanBnXkFtZTcwMDg1NzEzOA@@._V1_UX256,0,256,256_AL_.jpg",14);
	
	/**
	 * In this test we fix filmlistItems and we creates a false URL's for items1 
	 * for to be sure that items with false URL hasn't their index return in a
	 * getListInteger.
	 * @throws IOException
	 */
	@Test
	public void testGetListInteger() throws IOException {
		List<FilmlistItem> mockItems = Arrays.asList(item1, item2, item3, item4, item5, item6, item7, item8, item9, item10);
		for(int i=0;i<10;i++) {
			Mockito.when(filmlistItemsMocks.get(i)).thenReturn(mockItems.get(i));
		}
		
		List<Integer> list=filmlistRepository.getListInteger(0, 9);
		
		Assert.assertFalse(list.contains(0));
		for(int i=1;i<10;i++) {
			Assert.assertTrue(list.contains(i));
		}
	}
	
	@Test
	public void testFirstSecondThirdLine() {
		List<FilmlistItem> mockItems = Arrays.asList(item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11, item12, item13, item14);
		List<FilmlistItem> resultFirstLine=Arrays.asList(item1, item2, item3);
		List<FilmlistItem> resultSecondLine=Arrays.asList(item4, item5, item6);
		List<FilmlistItem> resultThirdLine=Arrays.asList(item7, item8, item9);
		
		Assert.assertEquals(filmlistRepository.FirstLine(mockItems), resultFirstLine);
		Assert.assertEquals(filmlistRepository.SecondLine(mockItems), resultSecondLine);
		Assert.assertEquals(filmlistRepository.ThirdLine(mockItems), resultThirdLine);
	}
}
