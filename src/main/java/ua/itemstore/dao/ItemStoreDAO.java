package ua.itemstore.dao;

import ua.itemstore.domains.*;


import java.util.Set;

public interface ItemStoreDAO {
    int createBook(Book book);

    int createBookInProductBalance(ProductBalance productBalance);

    Set<Book> getBooksByBook(Book book);

    int createSupplier(BookSupplier bookSupplier);

    int createBookConsumer(BookConsumer bookConsumer);

    int createOperationBookSupply(BookSupplyOperation bookSupplyOperation);

    Book getBookByID(Long id);

    BookSupplyOperation getBookSupplyOperationByID(Long id);

    int createOperationBookConsumer(BookConsumerOperation bookConsumerOperation);

    int getCountBookToSell(Book book);

    int deleteBook(Book b);
}
