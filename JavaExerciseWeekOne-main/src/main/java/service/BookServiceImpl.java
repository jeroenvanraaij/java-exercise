package service;

import domain.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookServiceImpl implements BookService {
    List<Book> books = new ArrayList<>();

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public void deleteBook(String ISBN) {
        Book book = findBookByISBN(ISBN);
        books.remove(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return this.books;
    }

    @Override
    public Book findBookByISBN(String ISBN) {
        for (Book book : this.books)
            if (book.getISBN().equals(ISBN))
                return book;
        return null;
    }

    @Override
    public List<Book> getAllBooksOrderedByReleaseDate() {
        List<Book> booksOrdered = books;

        Comparator<Book> comparatorAsc = (book1, book2) -> book1.getReleaseDate()
                .compareTo(book2.getReleaseDate());

        Collections.sort(booksOrdered, comparatorAsc);
        return booksOrdered;
    }

    @Override
    public void deleteAllBooks() {
        books.clear();
    }
}
