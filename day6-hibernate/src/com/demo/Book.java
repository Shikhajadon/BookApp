package com.demo;

import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name = "book_table")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "book_title", nullable = false)
	private String title;

	@Column(name = "book_author", nullable = false)
	private String author;

	@Column(name = "book_price", nullable = false)
	private double price;

	@Column(name = "pub_date", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date pubDate;

	public Book(String title, String author, double price, Date pubDate) {
		super();
		
		this.title = title;
		this.author = author;
		this.price = price;
		this.pubDate = pubDate;
	}

	/*public Book(int id, String title, String author, double price) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
	}*/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	public void print() {
		System.out.println("id: " + id);
		System.out.println("title: " + title);
		System.out.println("author: " + author);
		System.out.println("price: " + price);
	}
}
