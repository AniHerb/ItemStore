package ua.itemstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ua.itemstore.dao.ItemStoreDAO;
import ua.itemstore.domains.Book;
import ua.itemstore.enums.BookStatusEnum;

import java.util.Set;

/**
 * Created by xnx_ on 01.06.2017.
 */
public class ItemStoreServiceImpl implements ItemStoreService{

    @Autowired
    private ItemStoreDAO itemStoreDAO;

    @Override
    @Transactional
    public BookStatusEnum createBook(Book book) {
        return itemStoreDAO.createBook(book);
    }

    @Override
    @Transactional
    public boolean checkIfExistBook(Book book) {
        Set<Book> booksFromDB = itemStoreDAO.getBooksByBook(book);
        if (booksFromDB.isEmpty()) {
            return false;
        }else{
            return true;
        }



    }
}
