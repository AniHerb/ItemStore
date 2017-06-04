package ua.itemstore.services;

import ua.itemstore.domains.Book;
import ua.itemstore.enums.BookStatusEnum;

/**
 * Created by xnx_ on 01.06.2017.
 */
public interface ItemStoreService {
    BookStatusEnum createBook(Book book);

    boolean checkIfExistBook(Book book);
}
