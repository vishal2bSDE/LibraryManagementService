package main.java.domain;

import java.util.ArrayList;
import java.util.List;

public class User {

	private int id;
	private String name;
	private List<Book> booksBorrowed;
	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		booksBorrowed=new ArrayList();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Book> getBooksBorrowed() {
		return booksBorrowed;
	}
	public void setBooksBorrowed(List<Book> booksBorrowed) {
		this.booksBorrowed = booksBorrowed;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", booksBorrowed=" + booksBorrowed + "]";
	}
	
}
