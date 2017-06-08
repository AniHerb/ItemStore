package ua.itemstore.dao;

import ua.itemstore.domains.Book;
import ua.itemstore.domains.BookConsumer;
import ua.itemstore.domains.BookSupplier;
import ua.itemstore.domains.BookSupplyOperation;
import ua.itemstore.enums.StatusEnum;

import java.util.Set;

public interface ItemStoreDAO {
    StatusEnum createBook(Book book);

    Set<Book> getBooksByBook(Book book);

    StatusEnum createSupplier(BookSupplier bookSupplier);

    StatusEnum createBookConsumer(BookConsumer bookConsumer);

    StatusEnum createOperationBookSupply(BookSupplyOperation bookSupplyOperation);

    Book getBookByID(Long id);

    BookSupplyOperation getBookSupplyOperationByID(Long id);
}
