package com.website.filmlist.service;

import java.io.IOException;
import java.util.ArrayList;
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
import com.website.filmlist.repository.FilmlistRepository;

@RunWith(MockitoJUnitRunner.class)
public class FilmlistServiceTest {
	
	@InjectMocks
	private FilmlistService filmlistService;
	
	@Mock
	private FilmlistRepository filmlistRepositoryMock;
	
	@Mock
	private MovieRatingService MovieRatingServiceMock;
	
	FilmlistItem item1 = new FilmlistItem("Star Wars", 10.0, "https://m.media-amazon.com/images/M/MV5BNDM0NDk2Nzc5N15BMl5BanBnXkFtZTcwMDg1NzEzOA@@._V1_UX256,0,256,256_AL_.jpg",1);
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
	 * In the first version of test of getAndSetFilmListRepository, we fix 
	 * at the origin the value of FilmlistRepository for seeing if the FilmlistRepository
	 * works good (= if getAndSetFilmRepository give the same list to FilmlistRepository).
	 */
	@Test
	public void testGetAndSetFilmListRepositoryReturnsAllItemsFromRepository() {
		List<FilmlistItem> mockItemsFilmlistRepository = Arrays.asList(item1);
		
		Mockito.doReturn(mockItemsFilmlistRepository).when(filmlistRepositoryMock).getList();

		List<FilmlistItem> list=filmlistService.setAndGetFilmListRepository();

		Assert.assertTrue(list.size() == 1);
		Assert.assertTrue(list.get(0).getTitle().equals("Star Wars"));
	}
	
	/**
	 * In the second version of test of getAndSetFilmListRepository, we fix 
	 * at the origin the value of MovieRatingService and give an empty value
	 * to FilmlistRepository. We would like to see if MovieRatingService works
	 * good i.e that the value of Movie Rating is passed in FilmlistRepository
	 * because we know that FilmlistRepository works good with the first version of test.
	 */
	@Test
	public void testGetAndSetFilmListRepositoryReturnsAllItemsFromMovieRatingService() {
		List<FilmlistItem> mockItemsMovieRatingService = Arrays.asList(item1, item2);
		List<FilmlistItem> mockItemsFilmlistRepository= new ArrayList<FilmlistItem>();
		
		Mockito.doReturn(mockItemsFilmlistRepository).when(filmlistRepositoryMock).getList();
		Mockito.doReturn(mockItemsMovieRatingService).when(MovieRatingServiceMock).getAllFilm();

		List<FilmlistItem> list=filmlistService.setAndGetFilmListRepository();

		Assert.assertTrue(list.size() == 2);
		Assert.assertTrue(list.get(0).getTitle().equals("Star Wars"));
		Assert.assertTrue(list.get(1).getTitle().equals("Star Treck"));
	}
	
	@Test
	public void testGetFilmlistItemSize() {
		List<FilmlistItem> mockItems = Arrays.asList(item1, item2);
		
		Mockito.when(filmlistRepositoryMock.getList()).thenReturn(mockItems);

		int size=filmlistService.getFilmlistItemSize();
		
		Assert.assertTrue(2 == size);
	}
	
	/**
	 * In this test we fix filmlistRepository and the list of integer that return getFilmlistInteger.
	 * We execute the getRandomList.
	 * And we verify that all item who has an id contents in IntegerList are returned by getRandomList 
	 * and the list of film returned is smaller than 10.
	 */
	@Test
	public void testGetRandomListFilm() throws Exception {
		List<FilmlistItem> mockItems = Arrays.asList(item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11, item12, item13, item14);
		List<Integer> integerList=Arrays.asList(13,5,6,4,9,10,2,7,11);
		
		Mockito.when(filmlistRepositoryMock.getList()).thenReturn(mockItems);
		Mockito.when(filmlistRepositoryMock.getListInteger(0,filmlistService.getFilmlistItemSize())).thenReturn(integerList);
		Mockito.when(filmlistRepositoryMock.getFilmlistItem(2)).thenReturn(item3);
		Mockito.when(filmlistRepositoryMock.getFilmlistItem(4)).thenReturn(item5);
		Mockito.when(filmlistRepositoryMock.getFilmlistItem(5)).thenReturn(item6);
		Mockito.when(filmlistRepositoryMock.getFilmlistItem(6)).thenReturn(item7);
		Mockito.when(filmlistRepositoryMock.getFilmlistItem(7)).thenReturn(item8);
		Mockito.when(filmlistRepositoryMock.getFilmlistItem(9)).thenReturn(item10);
		Mockito.when(filmlistRepositoryMock.getFilmlistItem(10)).thenReturn(item11);
		Mockito.when(filmlistRepositoryMock.getFilmlistItem(11)).thenReturn(item12);
		Mockito.when(filmlistRepositoryMock.getFilmlistItem(13)).thenReturn(item14);
		
		List<FilmlistItem> list = filmlistService.getRandomListFilm();
		
		boolean item1_list=false;
		boolean item2_list=false;
		boolean item3_list=false;
		boolean item4_list=false;
		boolean item5_list=false;
		boolean item6_list=false;
		boolean item7_list=false;
		boolean item8_list=false;
		boolean item9_list=false;
		boolean item10_list=false;
		boolean item11_list=false;
		boolean item12_list=false;
		boolean item13_list=false;
		boolean item14_list=false;
		
		for(int i=0;i<14;i++) {
		
			item1.setId(i);
			item2.setId(i);
			item3.setId(i);
			item4.setId(i);
			item5.setId(i);
			item6.setId(i);
			item7.setId(i);
			item8.setId(i);
			item9.setId(i);
			item10.setId(i);
			item11.setId(i);
			item12.setId(i);
			item13.setId(i);
			item14.setId(i);

			
			item1_list=item1_list||(list.contains(item1));
			item2_list=item2_list||(list.contains(item2));
			item3_list=item3_list||(list.contains(item3));
			item4_list=item4_list||(list.contains(item4));
			item5_list=item5_list||(list.contains(item5));
			item6_list=item6_list||(list.contains(item6));
			item7_list=item7_list||(list.contains(item7));
			item8_list=item8_list||(list.contains(item8));
			item9_list=item9_list||(list.contains(item9));
			item10_list=item10_list||(list.contains(item10));
			item11_list=item11_list||(list.contains(item11));
			item12_list=item12_list||(list.contains(item12));
			item13_list=item13_list||(list.contains(item13));
			item14_list=item14_list||(list.contains(item14));
		}
		
		Assert.assertFalse(item1_list);
		Assert.assertFalse(item2_list);
		Assert.assertTrue(item3_list);
		Assert.assertFalse(item4_list);
		Assert.assertTrue(item5_list);
		Assert.assertTrue(item6_list);
		Assert.assertTrue(item7_list);
		Assert.assertTrue(item8_list);
		Assert.assertFalse(item9_list);
		Assert.assertTrue(item10_list);
		Assert.assertTrue(item11_list);
		Assert.assertTrue(item12_list);
		Assert.assertFalse(item13_list);
		Assert.assertTrue(item14_list);
		Assert.assertTrue(list.size()<10);
	}
	
	/**
	 * In this test we fix filmlistRepository.
	 * We execute the GetFilmlistSearch with star.
	 * And we verify that film with a title with star and an URL's Poster that works are returned and
	 * the list of film returned is smaller than 10.
	 */
	@Test
	public void testGetFilmListSearch() {
		List<FilmlistItem> mockItems = Arrays.asList(item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11, item12, item13, item14);
		
		Mockito.when(filmlistRepositoryMock.getList()).thenReturn(mockItems);
		List<FilmlistItem> list = filmlistService.getFilmListSearch("star");
		
		boolean item1_list=false;
		boolean item2_list=false;
		boolean item3_list=false;
		boolean item4_list=false;
		boolean item5_list=false;
		boolean item6_list=false;
		boolean item7_list=false;
		boolean item8_list=false;
		boolean item9_list=false;
		boolean item10_list=false;
		boolean item11_list=false;
		boolean item12_list=false;
		boolean item13_list=false;
		boolean item14_list=false;
		
		for(int i=0;i<14;i++) {
		
			item1.setId(i);
			item2.setId(i);
			item3.setId(i);
			item4.setId(i);
			item5.setId(i);
			item6.setId(i);
			item7.setId(i);
			item8.setId(i);
			item9.setId(i);
			item10.setId(i);
			item11.setId(i);
			item12.setId(i);
			item13.setId(i);
			item14.setId(i);

			
			item1_list=item1_list||(list.contains(item1));
			item2_list=item2_list||(list.contains(item2));
			item3_list=item3_list||(list.contains(item3));
			item4_list=item4_list||(list.contains(item4));
			item5_list=item5_list||(list.contains(item5));
			item6_list=item6_list||(list.contains(item6));
			item7_list=item7_list||(list.contains(item7));
			item8_list=item8_list||(list.contains(item8));
			item9_list=item9_list||(list.contains(item9));
			item10_list=item10_list||(list.contains(item10));
			item11_list=item11_list||(list.contains(item11));
			item12_list=item12_list||(list.contains(item12));
			item13_list=item13_list||(list.contains(item13));
			item14_list=item14_list||(list.contains(item14));
		}
		
		Assert.assertTrue(item1_list);
		Assert.assertTrue(item2_list);
		Assert.assertFalse(item3_list);
		Assert.assertFalse(item4_list);
		Assert.assertFalse(item5_list);
		Assert.assertFalse(item6_list);
		Assert.assertTrue(item7_list);
		Assert.assertTrue(item8_list);
		Assert.assertTrue(item9_list);
		Assert.assertTrue(item10_list);
		Assert.assertTrue(item11_list);
		Assert.assertTrue(item12_list);
		Assert.assertTrue(item13_list);
		Assert.assertFalse(item14_list);
		Assert.assertTrue(list.size()<10);
	}
	
	/**
	 * This test verify that function return the expected result according 
	 * the value of NameSearch the parameter.
	 * @throws IOException
	 */
	@Test
	public void testReturnFilmlistSearch() throws IOException {
		Assert.assertEquals(filmlistService.getFilmListSearch(null), new ArrayList<FilmlistItem>());
		Assert.assertEquals(filmlistService.getFilmListSearch(""), new ArrayList<FilmlistItem>());
		
		FilmlistItem item1 = new FilmlistItem("Star Wars", 10.0, "https://m.media-amazon.com/images/M/MV5BNDM0NDk2Nzc5N15BMl5BanBnXkFtZTcwMDg1NzEzOA@@._V1_UX256,0,256,256_AL_.jpg",1);
		List<FilmlistItem> mockItems = Arrays.asList(item1);
		
		Mockito.when(filmlistService.getFilmListSearch("Star")).thenReturn(mockItems);
		
		Assert.assertEquals(filmlistService.ReturnFilmlistSearch("Star"),mockItems);
	}
}
