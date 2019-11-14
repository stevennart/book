import java.util.Arrays;
import java.util.Comparator;

/**
 * A collection of {@link Book}.
 */
public class BookStorage {

	private Book[] books = new Book[100];

	public BookStorage() {

	}

	/**
	 * Initializes the book storage with some arbitrary book objects.
	 */
	public void initBooks() {
		// TODO Add your code here...
		this.books[0] = new Book("Object Oriented Programming using C#", "Simon Kendal", 403,
				Book.BookCategory.Programming);
		this.books[1] = new Book("Java: Classes in Java Applications", "David Etheridge", 118,
				Book.BookCategory.Design);
		this.books[2] = new Book("Object Oriented Programming using Java", "Simon Kendal", 216,
				Book.BookCategory.Programming);
		this.books[3] = new Book("Excel 2016 Advanced", "Shelley Fishel", 184, Book.BookCategory.Database);
		this.books[4] = new Book("Systems Analysis and Design", "Howard Gould", 147, Book.BookCategory.Design);
		this.books[5] = new Book("Introduction to Dasebases", "Steve Rogers", 136, Book.BookCategory.Database);
		this.books[6] = new Book("Programing for Beginners", "Tony Stark", 3000, Book.BookCategory.Programming);
		this.books[7] = new Book("Designing Advanced Classes", "Bruce Wayne", 196, Book.BookCategory.Design);
		this.books[8] = new Book("Extreme Databases", "Clark Kent", 100, Book.BookCategory.Database);
		this.books[9] = new Book("Designing for advanced students", "Pascal Siakam", 42, Book.BookCategory.Design);
		this.books[10] = new Book("Ultra Programming", "Bill Gates", 302, Book.BookCategory.Programming);
		this.books[11] = new Book("Designing Iphones", "Steve Jobs", 228, Book.BookCategory.Design);

		// books.setEditable(false);
	}

	/**
	 * Uses the given book to update the existing book with the same title.
	 */
	public void update(Book book) {
		// TODO Add your code here...

		// this.books = book.getTitle();
	}

	/**
	 * Removes a book by title.
	 */
	public void remove(String bookTitle) {

		// TODO Add your code here...

	}

	/**
	 * Adds a new book.
	 */
	public void add(Book book) {
		// TODO Add your code here...
	}

	/**
	 * Gets a book by title.
	 */
	public Book getByTitle(String title) {
		// TODO Add your code here...
		return null;
	}

	/**
	 * Searches for books whose title contains the keyword and returns them ordered
	 * by titles (in alphabet order).
	 */
	public Book[] titleSearch(String keyword) {
		// TODO Add your code here...
		return new Book[0];
	}

	/**
	 * Returns all books sorted by their titles (in alphabet order).
	 */
	public Book[] getAll() {
		// TODO Add your code here...
		// return new Book[0];

		int count = 0;

		for (Book book : this.books) {
			if (book != null) {
				count++;
			}
		}

		Book[] bookList = new Book[count];

		for (int i = 0; i < count; i++) {
			if (this.books[i] != null) {
				bookList[i] = this.books[i];
			}
		}

		Arrays.sort(bookList, new Comparator<Book>() {
	        @Override
	        public int compare(Book book1, Book book2) {
	            return book1.getTitle().compareTo(book2.getTitle());   
	        }
	    });
		
		return bookList;
	}

	/**
	 * Sorts an array of books by their titles in alphabet order.
	 */
	private Book[] sortByTitle(Book[] bookArray) {
		// TODO Add your code here...
		return bookArray;
	}

}
