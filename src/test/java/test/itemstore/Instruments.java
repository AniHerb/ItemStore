package test.itemstore;

import ua.itemstore.domains.Book;
import ua.itemstore.domains.BookConsumer;
import ua.itemstore.domains.BookSupplier;


import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Date;

public class Instruments {

    private static SecureRandom random = new SecureRandom();

    public static String nextSessionId() {
        return new BigInteger(130, random).toString(32);
    }

    public static Book createBook(){
        Book book = new Book();
        book.setDate(new Date());
        book.setAutuhors(nextSessionId());
        book.setIOSN(nextSessionId());
        book.setName(nextSessionId());
        return book;
    }

    public static BookSupplier createBookSupplier(){
        BookSupplier bookSupplier = new BookSupplier();
        bookSupplier.setName(nextSessionId());
        bookSupplier.setSomeInformation(nextSessionId());
        return bookSupplier;
    }

    public static BookConsumer createBookConsumers() {
        BookConsumer bookConsumer = new BookConsumer();
        bookConsumer.setName(nextSessionId());
        bookConsumer.setEmail(nextSessionId());
        bookConsumer.setLogin(nextSessionId());
        bookConsumer.setPassword(nextSessionId());
        bookConsumer.setSurname(nextSessionId());
        return bookConsumer;
    }
}
