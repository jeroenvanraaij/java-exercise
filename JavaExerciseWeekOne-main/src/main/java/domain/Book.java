package domain;

import java.time.LocalDate;

public class Book {
    private String name;
    private String language;
    private LocalDate releaseDate;
    private int numberOffPages;
    private String author;
    private String isbn;

    public Book(String name, String language, LocalDate releaseDate, int numberOffPages, String author, String ISBN) {
        this.name = name;
        this.language = language;
        this.releaseDate = releaseDate;
        this.numberOffPages = numberOffPages;
        this.author = author;
        this.isbn = ISBN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getNumberOffPages() {
        return numberOffPages;
    }

    public void setNumberOffPages(int numberOffPages) {
        this.numberOffPages = numberOffPages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return isbn;
    }

    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" + "name='" + name + '\'' + ", language='" + language + '\'' + ", releaseDate=" + releaseDate + ", numberOffPages=" + numberOffPages + ", author='" + author + '\'' + ", isbn='" + isbn + '\'' + '}';
    }
}
