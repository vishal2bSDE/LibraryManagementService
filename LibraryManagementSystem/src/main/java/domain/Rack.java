package main.java.domain;

import java.util.HashMap;
import java.util.Map;

public class Rack {
	private int id;
	private int num;
	private Map<String, Book> books;
	private Map<Integer, String> idToKeyMap;
	public Rack(int id, int num) {
		super();
		this.id = id;
		this.num=num;
		books=new HashMap();
		idToKeyMap=new HashMap();
	}
	public Map<Integer, String> getIdToKeyMap() {
		return idToKeyMap;
	}
	public void setIdToKeyMap(Map<Integer, String> idToKeyMap) {
		this.idToKeyMap = idToKeyMap;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Map<String, Book> getBooks() {
		return books;
	}
	public void setBooks(Map<String, Book> books) {
		this.books = books;
	}
}
