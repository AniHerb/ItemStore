package ua.itemstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import ua.itemstore.domains.Book;
import ua.itemstore.enums.BookStatusEnum;
import ua.itemstore.services.ItemStoreService;

/**
 * Created by xnx_ on 01.06.2017.
 */
public class BookControllerImpl implements BookController {

    @Autowired
    private ItemStoreService itemStoreService;

    public BookStatusEnum createBook(Book book) {
       return itemStoreService.createBook(book);
    }
}
