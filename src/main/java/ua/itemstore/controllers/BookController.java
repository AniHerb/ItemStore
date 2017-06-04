package ua.itemstore.controllers;

import ua.itemstore.domains.Book;
import ua.itemstore.enums.BookStatusEnum;

/**
 * Created by xnx_ on 01.06.2017.
 */
public interface BookController {
     BookStatusEnum createBook(Book book);
}
