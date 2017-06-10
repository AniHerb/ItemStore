package ua.itemstore.controllers;

import ua.itemstore.domains.*;
import ua.itemstore.enums.StatusEnum;

public interface BookController {
     StatusEnum createBook(Book book);

     StatusEnum createSupplier(BookSupplier bookSupplier);

     StatusEnum createBookConsumer(BookConsumer bookConsumer);

     StatusEnum createOperationBookSupply(BookSupplyOperation bookSupplyOperation);

     Book getBookByID(Long id);

     BookSupplyOperation getBookSupplyOperationByID(Long id);

     StatusEnum createOperationBookConsumer(BookConsumerOperation bookConsumerOperation);
}
