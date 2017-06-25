package test.itemstore;

import ua.itemstore.domains.Book;
import ua.itemstore.domains.BookConsumer;
import ua.itemstore.domains.BookSupplier;


import java.util.Date;

public class Instruments {
    public static Book createBook(){
        Book book = new Book();
        book.setDate(new Date());
        book.setAutuhors("Authors");
        book.setIOSN("{}");
        book.setName("Name");
        return book;
    }

    public static BookSupplier createBookSupplier(){
        BookSupplier bookSupplier = new BookSupplier();
        bookSupplier.setName("supplier");
        bookSupplier.setSomeInformation("some info");
        return bookSupplier;
    }

    public static BookConsumer createBookConsumers() {
        BookConsumer bookConsumer = new BookConsumer();
        bookConsumer.setName("name");
        bookConsumer.setEmail("email");
        bookConsumer.setLogin("login");
        bookConsumer.setPassword("password");
        bookConsumer.setSurname("surname");
        return bookConsumer;
    }
}
