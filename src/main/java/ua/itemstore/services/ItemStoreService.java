package ua.itemstore.services;

import ua.itemstore.domains.*;


public interface ItemStoreService {
    int createBook(Book book);
    boolean checkIfExistBook(Book book);

    int createSupplier(BookSupplier bookSupplier);

    int createBookConsumer(BookConsumer bookConsumer);

    int createOperationBookSupply(BookSupplyOperation bookSupplyOperation);

    Book getBookByID(Long id);

    BookSupplyOperation getBookSupplyOperationByID(Long id);

    int createOperationBookConsumer(BookConsumerOperation bookConsumerOperation);

    int deleteBook(Book b);

    void createBookReturnOperation(BookReturnOperation bookReturnOperation);
}
