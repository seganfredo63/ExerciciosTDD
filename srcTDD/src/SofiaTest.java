package src;


import static org.junit.Assert.*;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Model.Livro;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;



public class SofiaTest {
	private Livro book;
	private static final double deltaForDoubleComparison = 0;
	Livro book1 = new Livro("c","c",10.0);
	Livro book2 = new Livro(100.0,5);
	Livro book3 = new Livro(250.0, 10);
	Livro book4 = new Livro("a","a",150.0);
	Livro book5 = new Livro("b","b",60.0);
	Livro book6 = new Livro(350.0,10);
	Livro book7 = new Livro(100.0);

@Before
	public void setUp() {

	}



	@Test
	public void shouldParcelIfPriceLessThen10() 
	{
		assertEquals("Initial value", "1x"+(book1.getPrice()),book1.paymentConditions());
	}
	@Test
	public void shouldParcelIfPriceEquals100OrHigher()
	{
		assertEquals("Initial value", "5x"+(book2.getPrice()/5), book2.paymentConditions());

		
	}
	@Test
	public void shouldParcelIfPriceEquals250OrHigher()
	{
		assertEquals("Initial value", "10x"+(book3.getPrice()/10), book3.paymentConditions());
	}
	@Test
	public void shouldParcelAndShouldAddRate()
	{
		assertEquals("Initial value", "10x"+((book6.getPrice()/10)*1.5), book6.paymentConditionsWithRates());
		assertEquals("Second value", "5x" +(book2.getPrice()/5), book2.paymentConditionsWithRates());
	}
	@Test
	public void shouldCalculateTheNumberOfParcels()
	{
		assertEquals("Initial value", "5x"+(book7.getPrice()/5), book7.calculateNumberOfParcels());
		assertEquals("Initial value", "7x"+(book4.getPrice()/7), book4.calculateNumberOfParcels());
	}
	@Test
	public void shouldSortBooks()
	{
		ArrayList<Livro> listOfBooks = new ArrayList<Livro>();
		listOfBooks.add(book1);
		listOfBooks.add(book4);
		listOfBooks.add(book5);

		Livro.orderByPrice(listOfBooks,"priceAsc");
		for(int i = 0; i < listOfBooks.size(); i++)
		{
			System.out.println(listOfBooks.get(i).getPrice());
		}
		assertEquals("Initial value", "book3 , book2 , book1", Livro.sortBooks(listOfBooks,"priceDesc"));
		assertEquals("Second value", "book1 , book2 , book3", Livro.sortBooks(listOfBooks,"priceAsc"));
	}
	
	@Test
	public void shouldSortBooksByAuthor()
	{
		List<String> listOfBooks = Arrays.asList(book1.getAutor(),book4.getAutor(),book5.getAutor());
		
		Livro.orderByTitleOrAuthor(listOfBooks, "lala");
		for(int i = 0; i < listOfBooks.size(); i++)
		{
			System.out.println(listOfBooks.get(i).toString());
		}
	}


	
}
