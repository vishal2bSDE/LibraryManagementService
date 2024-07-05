package main.java;

import main.java.service.LibraryService;

public class Main {

	private static LibraryService libraryService;
	public static void main(String[] args) {
		System.out.println("Library Management System started");
		
		libraryService=new LibraryService(5);
		
		registerUser("user1");
		registerUser("user2");
		registerUser("user3");
		
		addBook("title1", "author1", "publisher1");
		addBook("title1", "author1", "publisher1");
		addBook("title1", "author1", "publisher1");
		
		removeBookCopy(1);
		
		borrowBook(9, 6, 4);
		borrowBook(5, 7, 4);
		
		System.out.println("Library Management System stopped");
	}
	private static void borrowBook(int bookId, int userId, int dueDate) {
		libraryService.borrowBook(bookId, userId, dueDate);
	}
	private static void removeBookCopy(int i) {
		libraryService.removeBookCopy(i);
	}
	private static void addBook(String title, String author, String publisher) {
		libraryService.addBook(title, author, publisher);
	}
	private static void registerUser(String userName) {
		libraryService.registerUser(userName);
	}
}
