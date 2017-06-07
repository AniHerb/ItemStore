package ua.itemstore.services;

import ua.itemstore.domains.Book;
import ua.itemstore.domains.BookConsumer;
import ua.itemstore.domains.BookSupplier;
import ua.itemstore.domains.BookSupplyOperation;
import ua.itemstore.enums.StatusEnum;

public interface ItemStoreService {
    StatusEnum createBook(Book book);
    boolean checkIfExistBook(Book book);

    StatusEnum createSupplier(BookSupplier bookSupplier);

    StatusEnum createBookConsumer(BookConsumer bookConsumer);

    StatusEnum createOperationBookSupply(BookSupplyOperation bookSupplyOperation);
}
