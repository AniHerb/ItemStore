package ua.itemstore.services;

import ua.itemstore.domains.*;
import ua.itemstore.enums.StatusEnum;

public interface ItemStoreService {
    StatusEnum createBook(Book book);
    boolean checkIfExistBook(Book book);

    StatusEnum createSupplier(BookSupplier bookSupplier);

    StatusEnum createBookConsumer(BookConsumer bookConsumer);

    StatusEnum createOperationBookSupply(BookSupplyOperation bookSupplyOperation);

    Book getBookByID(Long id);

    BookSupplyOperation getBookSupplyOperationByID(Long id);

    StatusEnum createOperationBookConsumer(BookConsumerOperation bookConsumerOperation);
}
