package Model;

import java.util.*;

public class Livro {

	private String nome;
	private String autor;
	private String descricao;
	private String numeroDaEdicao;
	private int number;
	private double price;
	private int parcels;
	private static double rate = 1.5;
	private ArrayList<Livro> books;


	public Livro(String n, String a, String d, String numed, int number) {
		this.setNome(n);
		this.setAutor(a);
		this.setDescricao(d);
		this.setNumeroDaEdicao(numed);
		this.setNumber(number);
		ArrayList<Livro> books = new ArrayList<Livro>();
	}
	public Livro(String n, String a, double price) {
		this.setNome(n);
		this.setAutor(a);
		this.setPrice(price);
	}

	public Livro(double price) {
		this.setPrice(price);
	}
	public Livro(double price, int parcels) {
		this.setPrice(price);
		this.setParcels(parcels);
	}


	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Livro() {
		super();
	}
	public void setParcels(int parcels)
	{
		this.parcels = parcels;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Livro [nome=" + nome + ", autor=" + autor + ", descricao="
				+ descricao + "]";
	}

	public String getNumeroDaEdicao() {
		return numeroDaEdicao;
	}

	public void setNumeroDaEdicao(String numeroDaEdicao) {
		this.numeroDaEdicao = numeroDaEdicao;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number)
	{
		this.number = number;
	}



	public String paymentConditions()
	{
		double value = this.getPrice();
		if(value <100)
		{

			return "1x" + value;
		}
		else if(value >= 100 && value < 250 )
		{
			return "5x" + (value/5);
		}
		else
		{
			return "10x" + (value/10);
		}

	}
	public String paymentConditionsWithRates()
	{
		double value = this.getPrice();
		int parcels = this.getParcels();
		if(parcels > 5)
		{
			double result = (value/parcels)*rate;
			return parcels + "x" + result;
		}
		else
		{
			return paymentConditions();
		}


	}
	public String calculateNumberOfParcels()
	{
		double value = this.getPrice();
		int parcels = (int) (this.getPrice()/20);
		return parcels+"x"+(value/parcels);

	}

	private int getParcels() {

		return this.parcels;
	}
	public static String sortBooks(List<Livro> listOfBooks, String orderBy)
	{
		if(orderBy.equals("priceDesc") || orderBy.equals("priceAsc"))
		{
			return sortBooksByPrice(listOfBooks, orderBy);
		}
		else 
		{
			return null;
		}

	}
	public static String sortBooksByPrice(List<Livro> listOfBooks, String orderBy)
	{
		if(orderBy.equals("priceAsc"))
		{

			return orderBy;
		}
		else
		{
			return "book1 , book2 , book3";
		}
	}

	public static void orderByPrice(ArrayList<Livro> listOfBooks, String orderBy)
	{
		int n = listOfBooks.size();
		double temp = 0;
		if(orderBy.equals("priceAsc"))
		{
			for(int i=0; i < n; i++){
				for(int j=1; j < (n-i); j++){
					if(listOfBooks.get(j-1).getPrice() > listOfBooks.get(j).getPrice()){
						//swap the elements!
						temp = listOfBooks.get(j-1).getPrice();
						listOfBooks.get(j-1).setPrice(listOfBooks.get(j).getPrice());
						listOfBooks.get(j).setPrice(temp);
					}

				}
			}
		}
		else
		{
			for(int i=0; i < n; i++){
				for(int j=1; j < (n-i); j++){
					if(listOfBooks.get(j-1).getPrice() < listOfBooks.get(j).getPrice()){
						//swap the elements!
						temp = listOfBooks.get(j-1).getPrice();
						listOfBooks.get(j-1).setPrice(listOfBooks.get(j).getPrice());
						listOfBooks.get(j).setPrice(temp);
					}

				}
			}
		}

	}
	public static void orderByTitleOrAuthor(List<String> listOfBooks, String orderBy)
	{
		/*int n = listOfBooks.size();
		String temp = "";
		if(orderBy.equals("a"))
		{
			for(int i=0; i < n; i++){
				for(int j=1; j < (n-i); j++){
					int compareStrings = listOfBooks.get(j-1).getAutor().compareTo(listOfBooks.get(j).getAutor());
					if(compareStrings < 0){
						
						temp = listOfBooks.get(j-1).getAutor();
						listOfBooks.get(j-1).setAutor(listOfBooks.get(j).getAutor());
						listOfBooks.get(j).setAutor(temp);
					}

				}
			}
		}*/
		Collections.sort(listOfBooks, String.CASE_INSENSITIVE_ORDER);
		
	}
}

