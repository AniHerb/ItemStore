package ua.itemstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ua.itemstore.dao.ItemStoreDAO;
import ua.itemstore.domains.*;
import ua.itemstore.exceptions.ByMoreThenExistItemException;


import java.util.Set;

@Transactional
public class ItemStoreServiceImpl implements ItemStoreService{

    @Autowired
    private ItemStoreDAO itemStoreDAO;

    @Override
    public int createBook(Book book) {
        //addBookToProductBalance(book);
         itemStoreDAO.createBook(book);
        addBookToProductBalance(book);
        return 0;
    }

    private int addBookToProductBalance(Book book) {
        ProductBalance productBalance = new ProductBalance();
        productBalance.setBook(book);
        productBalance.setCount(0);
        return itemStoreDAO.createBookInProductBalance(productBalance);
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
    public int createSupplier(BookSupplier bookSupplier) {
        return itemStoreDAO.createSupplier(bookSupplier);
    }

    @Override
    public int createBookConsumer(BookConsumer bookConsumer) {
        return itemStoreDAO.createBookConsumer(bookConsumer);
    }

    @Override
    public int createOperationBookSupply(BookSupplyOperation bookSupplyOperation) {
        itemStoreDAO.createOperationBookSupply(bookSupplyOperation);
        itemStoreDAO.updateBookBalance(bookSupplyOperation);
        return 0;
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
    public int createOperationBookConsumer(BookConsumerOperation bookConsumerOperation) {
        checkIfEnoughItem(bookConsumerOperation.getBook(),bookConsumerOperation.getCount());
        return itemStoreDAO.createOperationBookConsumer(bookConsumerOperation);
    }

    @Override
    public int deleteBook(Book b) {
       return itemStoreDAO.deleteBook(b);
    }

    @Override
    public void createBookReturnOperation(BookReturnOperation bookReturnOperation) {
        itemStoreDAO.createBookReturnOperation(bookReturnOperation);
    }

    private void checkIfEnoughItem(Book book, Integer count) {
        int countAllowToSell = itemStoreDAO.getCountBookToSell(book);
        if (count > countAllowToSell)
            throw new ByMoreThenExistItemException("Not enough books "+count+" to sale. allow to sell = "+countAllowToSell);

    }

}
