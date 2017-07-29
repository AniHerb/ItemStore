package ua.itemstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.itemstore.domains.*;
import ua.itemstore.services.ItemStoreService;

@RestController
public class BookControllerImpl implements BookController {

    @Autowired
    private ItemStoreService itemStoreService;

    @RequestMapping(value = "/createBook/{book}",method = RequestMethod.GET)
    public int createBook(@PathVariable Book book) {
            return itemStoreService.createBook(book);
    }

    @Override
    public int createSupplier(BookSupplier bookSupplier) {
            return itemStoreService.createSupplier(bookSupplier);
    }

    @Override
    public int createBookConsumer(BookConsumer bookConsumer) {
            return itemStoreService.createBookConsumer(bookConsumer);
    }

    @Override
    public int createOperationBookSupply(BookSupplyOperation bookSupplyOperation) {
        return itemStoreService.createOperationBookSupply(bookSupplyOperation);

    }

    @Override
    public Book getBookByID(Long id) {
        return itemStoreService.getBookByID(id);
    }

    @Override
    @RequestMapping("/getBookByID/{id}")
    public BookSupplyOperation getBookSupplyOperationByID(@PathVariable Long id) {
        return itemStoreService.getBookSupplyOperationByID(id);
    }

    @Override
    public int createOperationBookConsumer(BookConsumerOperation bookConsumerOperation) {
        return itemStoreService.createOperationBookConsumer(bookConsumerOperation);
    }

    @Override
    public int deleteBook(Book b) {
        return itemStoreService.deleteBook(b);
    }

    @Override
    public void createBookReturnOperation(BookReturnOperation bookReturnOperation) {
        itemStoreService.createBookReturnOperation(bookReturnOperation);
    }

    @Override
    @RequestMapping(value = "/createBookByID/{id}}",method = RequestMethod.GET)
    public int createBookById(@PathVariable Long id) {
        long i = id;
        System.out.println("im here "+id);
        return 0;
    }

    @Override
    @RequestMapping(value = "/")
    public String getAllBook() {
        return "Its working ";
    }

}
