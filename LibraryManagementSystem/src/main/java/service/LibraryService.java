package main.java.service;

import java.util.HashMap;
import java.util.Map;

import main.java.domain.Book;
import main.java.domain.Library;
import main.java.domain.Rack;
import main.java.domain.User;

public class LibraryService {
	private Library library;
	private Map<Integer, Book> booksBorrowedToUser;
	private Map<Integer, User> users;
	public LibraryService(int n) {
		super();
		System.out.println("Library creating started");
		library=new Library(n);
		booksBorrowedToUser=new HashMap();
		users=new HashMap();
		System.out.println("Library created successfully");
	}
	
	public void registerUser(String userName) {
		System.out.println("User started registering, "+userName);
		int generatedId = IDGenerator.getNextID();
		User user=new User(generatedId, userName);
		users.put(generatedId, user);
		System.out.println("User successfully registered, "+user);
	}

	public void addBook(String title, String author, String publisher) {
		int generatedId = IDGenerator.getNextID();
		Book book=new Book(generatedId, title, author, publisher);
		addToRack(book);
	}

	private void addToRack(Book book) {
		System.out.println("Racking the book, "+book);
		String rackKey = generateRackKey(book);
		boolean f=false;
		for(Rack rack: library.getRacks()) {
			if(!rack.getBooks().containsKey(rackKey)) {
				rack.getBooks().put(rackKey, book);
				rack.getIdToKeyMap().put(book.getId(), rackKey);
				System.out.println("Racked book, "+rack.getNum()+" _" +book);
				break;
			}
		}
		if(!f) {
			System.out.println("No rack free to add book, "+book);
			return;
		}
		
	}

	private String generateRackKey(Book book) {
		return book.getTitle()+"-"+book.getAuthor()+"-"+book.getPublisher();
	}

	public void removeBookCopy(int i) {
		System.out.println("Book started removing");
		for(Rack rack: library.getRacks()) {
			if(rack.getIdToKeyMap().containsKey(i)) {
				rack.getBooks().remove(rack.getIdToKeyMap().get(i));
				rack.getIdToKeyMap().remove(i);
				System.out.println("Book removed");
				return;
			}
		}
		System.out.println("Book not found");
	}

	public void borrowBook(int bookId, int userId, int dueDate) {
		for(Rack rack: library.getRacks()) {
			if(rack.getIdToKeyMap().containsKey(bookId)) {
				String key = rack.getIdToKeyMap().get(bookId);
				assignBookToUser(rack.getBooks().get(key), users.get(userId));
				removeBookCopy(bookId);
				System.out.println("Book borrowed");
				return;
			}
		}
	}

	private void assignBookToUser(Book book, User user) {
		users.put(book.getId(), user);
		user.getBooksBorrowed().add(book);
	}
	
	
}
