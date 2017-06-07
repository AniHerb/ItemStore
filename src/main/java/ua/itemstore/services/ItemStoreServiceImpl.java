package ua.itemstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ua.itemstore.dao.ItemStoreDAO;
import ua.itemstore.domains.Book;
import ua.itemstore.domains.BookConsumer;
import ua.itemstore.domains.BookSupplier;
import ua.itemstore.domains.BookSupplyOperation;
import ua.itemstore.enums.StatusEnum;

import java.util.Set;

public class ItemStoreServiceImpl implements ItemStoreService{

    @Autowired
    private ItemStoreDAO itemStoreDAO;

    @Override
    @Transactional
    public StatusEnum createBook(Book book) {
        return itemStoreDAO.createBook(book);
    }

    @Override
    @Transactional
    //// TODO: 06.06.2017 createIntegrarionTest
    public boolean checkIfExistBook(Book book) {
        Set<Book> booksFromDB = itemStoreDAO.getBooksByBook(book);
        if (booksFromDB.isEmpty()) {
            return false;
        }else{
            return true;
        }
    }

    @Override
    @Transactional
    public StatusEnum createSupplier(BookSupplier bookSupplier) {
        return itemStoreDAO.createSupplier(bookSupplier);
    }

    @Override
    @Transactional
    public StatusEnum createBookConsumer(BookConsumer bookConsumer) {
        return itemStoreDAO.createBookConsumer(bookConsumer);
    }

    @Override
    @Transactional
    public StatusEnum createOperationBookSupply(BookSupplyOperation bookSupplyOperation) {
        return itemStoreDAO.createOperationBookSupply(bookSupplyOperation);
    }
}
