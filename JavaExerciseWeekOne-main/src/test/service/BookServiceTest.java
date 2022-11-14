package service;

import domain.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * This is a test class. Within this class we write methods to verify that are methods work as intended.
 * As you can see there are some methods that not work. The goal is to make sure that all these tests are succeeding.
 * As an extra assignment you can try to write a valid test case for the last method.
 * In IntelliJ you can use CTRL+Shift+F10, or click the run test symbol to run all the tests in this class.
 */
class BookServiceTest {

    private BookService bookService = new BookServiceImpl();

    @AfterEach
    void afterEach() {
        bookService.deleteAllBooks();
    }

    @Test
    void addBook() {
        Book book = new Book("De wondere wereld van EBMO - 1", "Dutch", LocalDate.of(2020, Month.NOVEMBER, 11), 500, "Herre Scherpenzeel", "ISBN333-1-22-666666-1");

        bookService.addBook(book);
        List<Book> allBooks = bookService.getAllBooks();

        assertEquals(allBooks.size(), 1);
    }

    @Test
    void findBookByISBN() {
        Book book = insertOneBook();

        Book bookByISBN = bookService.findBookByISBN(book.getISBN());

        assertNotNull(bookByISBN);
    }

    @Test
    void deleteBook() {
        Book bookOne = this.insertOneBook();
        Book bookTwo = this.insertOneBook();

        bookService.deleteBook(bookOne.getISBN());
        List<Book> allBooks = bookService.getAllBooks();

        assertEquals(allBooks.size(), 1);
    }

    @Test
    void getAllBooks() {
        this.insertOneBook();
        this.insertOneBook();
        this.insertOneBook();
        this.insertOneBook();

        List<Book> allBooks = bookService.getAllBooks();

        assertEquals(allBooks.size(), 4);
    }

    @Test
    void getAllBooksOrderedByReleaseDate() {
        Book book = new Book("De wondere wereld van EBMO - 1", "Dutch", LocalDate.of(2020, Month.NOVEMBER, 11), 500, "Herre Scherpenzeel", "ISBN333-1-22-666666-1");
        bookService.addBook(book);
        book = new Book("De wondere wereld van EBMO - 2", "Dutch", LocalDate.of(2019, Month.NOVEMBER, 11), 500, "Edwin Huijser", "ISBN333-1-22-666666-2");
        bookService.addBook(book);
        book = new Book("De wondere wereld van EBMO - 3", "Dutch", LocalDate.of(2020, Month.MARCH, 11), 500, "Leon Zoet", "ISBN333-1-22-666666-3");
        bookService.addBook(book);
        book = new Book("De wondere wereld van EBMO - 4", "Dutch", LocalDate.of(2020, Month.NOVEMBER, 12), 500, "Johan van Es", "ISBN333-1-22-666666-4");
        bookService.addBook(book);
        book = new Book("De wondere wereld van EBMO - 5", "Dutch", LocalDate.of(2020, Month.DECEMBER, 12), 500, "Jeroen van Raaij", "ISBN333-1-22-666666-5");
        bookService.addBook(book);

        List<Book> allBooks = bookService.getAllBooksOrderedByReleaseDate();

        assertEquals(allBooks.get(0).getReleaseDate(), LocalDate.of(2019, Month.NOVEMBER, 11));
        assertEquals(allBooks.get(1).getReleaseDate(), LocalDate.of(2020, Month.MARCH, 11));
        assertEquals(allBooks.get(2).getReleaseDate(), LocalDate.of(2020, Month.NOVEMBER, 11));
        assertEquals(allBooks.get(3).getReleaseDate(), LocalDate.of(2020, Month.NOVEMBER, 12));
        assertEquals(allBooks.get(4).getReleaseDate(), LocalDate.of(2020, Month.DECEMBER, 12));
    }

    private Book insertOneBook() {
        Book book = new Book("De wondere wereld van EBMO - 1", "Dutch", LocalDate.of(2020, Month.NOVEMBER, 11), 500, "Herre Scherpenzeel", "ISBN333-1-22-666666-1");

        bookService.addBook(book);

        return book;
    }
}