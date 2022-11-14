import domain.Book;
import service.BookServiceImpl;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        BookServiceImpl bookService = new BookServiceImpl();

        // addBook
        Book book = new Book("De wondere wereld van EBMO - 5", "Dutch", LocalDate.of(2020, Month.DECEMBER, 12), 500, "Jeroen van Raaij", "ISBN333-1-22-666666-5");
        bookService.addBook(book);
        book = new Book("De wondere wereld van EBMO - 4", "Dutch", LocalDate.of(2020, Month.NOVEMBER, 12), 500, "Johan van Es", "ISBN333-1-22-666666-4");
        bookService.addBook(book);
        book = new Book("De wondere wereld van EBMO - 3", "Dutch", LocalDate.of(2020, Month.MARCH, 11), 500, "Leon Zoet", "ISBN333-1-22-666666-3");
        bookService.addBook(book);
        book = new Book("De wondere wereld van EBMO - 2", "Dutch", LocalDate.of(2019, Month.NOVEMBER, 11), 500, "Edwin Huijser", "ISBN333-1-22-666666-2");
        bookService.addBook(book);
        book = new Book("De wondere wereld van EBMO - 1", "Dutch", LocalDate.of(2020, Month.NOVEMBER, 11), 500, "Herre Scherpenzeel", "ISBN333-1-22-666666-1");
        bookService.addBook(book);

        // getAllBooks
        List<Book> allbooks = bookService.getAllBooks();

        for (Book b : allbooks) {
            System.out.println(b.toString());
        }
        System.out.println("----------------------------");
        System.out.println("");

        // deleteBook
        bookService.deleteBook("ISBN333-1-22-666666-3");

        for (Book b : allbooks) {
            System.out.println(b.toString());
        }
        System.out.println("----------------------------");
        System.out.println("");

        // findBook
        System.out.println("findBook: " + bookService.findBookByISBN("ISBN333-1-22-666666-5"));
        System.out.println("----------------------------");
        System.out.println("");

        // getAllBooksOrderedByReleaseDate
        List<Book> allbooksOrdered = bookService.getAllBooksOrderedByReleaseDate();

        for (Book b : allbooks) {
            System.out.println(b.toString());
        }
        System.out.println("----------------------------");
        System.out.println("");

        // deleteAllBooks
        bookService.deleteAllBooks();
        for (Book b : allbooks) {
            System.out.println(b.toString());
        }
        System.out.println("----------------------------");
        System.out.println("");

        Book bookGetSet = new Book("De wondere wereld van EBMO - 1", "Dutch", LocalDate.of(2020, Month.NOVEMBER, 11), 500, "Herre Scherpenzeel", "ISBN333-1-22-666666-1");
        System.out.println(bookGetSet.getName());
        System.out.println(bookGetSet.getLanguage());
        System.out.println(bookGetSet.getReleaseDate());
        System.out.println(bookGetSet.getNumberOffPages());
        System.out.println(bookGetSet.getAuthor());
        System.out.println(bookGetSet.getISBN());

        System.out.println("----------------------------");
        System.out.println("");

        bookGetSet.setName("De wondere wereld van JAVA");
        bookGetSet.setLanguage("English");
        bookGetSet.setReleaseDate(LocalDate.of(2022, Month.NOVEMBER, 7));
        bookGetSet.setNumberOffPages(150);
        bookGetSet.setAuthor("Olando Smits");
        bookGetSet.setISBN("ISBN999-9-99-999999-9");

        System.out.println(bookGetSet.getName());
        System.out.println(bookGetSet.getLanguage());
        System.out.println(bookGetSet.getReleaseDate());
        System.out.println(bookGetSet.getNumberOffPages());
        System.out.println(bookGetSet.getAuthor());
        System.out.println(bookGetSet.getISBN());



    }
}
