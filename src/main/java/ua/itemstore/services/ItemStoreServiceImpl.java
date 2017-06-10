package ua.itemstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ua.itemstore.dao.ItemStoreDAO;
import ua.itemstore.domains.*;
import ua.itemstore.enums.StatusEnum;

import java.util.Set;

@Transactional
public class ItemStoreServiceImpl implements ItemStoreService{

    @Autowired
    private ItemStoreDAO itemStoreDAO;

    @Override
    public StatusEnum createBook(Book book) {
        return itemStoreDAO.createBook(book);
    }

    @Override
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
    public StatusEnum createSupplier(BookSupplier bookSupplier) {
        return itemStoreDAO.createSupplier(bookSupplier);
    }

    @Override
    public StatusEnum createBookConsumer(BookConsumer bookConsumer) {
        return itemStoreDAO.createBookConsumer(bookConsumer);
    }

    @Override
    public StatusEnum createOperationBookSupply(BookSupplyOperation bookSupplyOperation) {
        return itemStoreDAO.createOperationBookSupply(bookSupplyOperation);
    }

    @Override
    public Book getBookByID(Long id) {
        return itemStoreDAO.getBookByID(id);
    }

    @Override
    public BookSupplyOperation getBookSupplyOperationByID(Long id) {
        return itemStoreDAO.getBookSupplyOperationByID(id);
    }

    @Override
    public StatusEnum createOperationBookConsumer(BookConsumerOperation bookConsumerOperation) {
        return itemStoreDAO.createOperationBookConsumer(bookConsumerOperation);
    }
}
