package ua.itemstore.controllers;

import ua.itemstore.domains.*;


public interface BookController {


     int createBook(Book book);

     int createSupplier(BookSupplier bookSupplier);

     int createBookConsumer(BookConsumer bookConsumer);

     int createOperationBookSupply(BookSupplyOperation bookSupplyOperation);

     Book getBookByID(Long id);

     BookSupplyOperation getBookSupplyOperationByID(Long id);

     int createOperationBookConsumer(BookConsumerOperation bookConsumerOperation);

     int deleteBook(Book b);

     void createBookReturnOperation(BookReturnOperation bookReturnOperation);
}
