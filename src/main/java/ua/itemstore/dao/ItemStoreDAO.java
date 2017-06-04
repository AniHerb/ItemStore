package ua.itemstore.dao;

import ua.itemstore.domains.Book;
import ua.itemstore.enums.BookStatusEnum;

import java.util.Set;

/**
 * Created by xnx_ on 01.06.2017.
 */
public interface ItemStoreDAO {
    BookStatusEnum createBook(Book book);

    Set<Book> getBooksByBook(Book book);
}
