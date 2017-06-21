package ua.itemstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.itemstore.domains.*;
import ua.itemstore.enums.StatusEnum;
import ua.itemstore.services.ItemStoreService;

@RestController
public class BookControllerImpl implements BookController {

    @Autowired
    private ItemStoreService itemStoreService;

    @RequestMapping("/createBook/{book}")
    public StatusEnum createBook(@PathVariable Book book) {
        try {
            return itemStoreService.createBook(book);
        } catch (Exception e) {
            return handleException(StatusEnum.ERROR,e);
        }

    }

    @Override
    public StatusEnum createSupplier(BookSupplier bookSupplier) {
        try {
            return itemStoreService.createSupplier(bookSupplier);
        } catch (Exception e) {
            e.printStackTrace();
            return handleException(StatusEnum.ERROR,e);
        }
    }

    @Override
    public StatusEnum createBookConsumer(BookConsumer bookConsumer) {
        try {
            return itemStoreService.createBookConsumer(bookConsumer);
        } catch (Exception e) {
            e.printStackTrace();
            return handleException(StatusEnum.ERROR,e);
        }
    }

    @Override
    public StatusEnum createOperationBookSupply(BookSupplyOperation bookSupplyOperation) {
        try {
            return itemStoreService.createOperationBookSupply(bookSupplyOperation);
        } catch (Exception e) {
            e.printStackTrace();
            return handleException(StatusEnum.ERROR,e);
        }
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
    public StatusEnum createOperationBookConsumer(BookConsumerOperation bookConsumerOperation) {
        return itemStoreService.createOperationBookConsumer(bookConsumerOperation);
    }

    private StatusEnum handleException(StatusEnum statusEnum, Throwable throwable){
        if (throwable == null){
            statusEnum.setError("");
        }else{
            throwable.printStackTrace();
            statusEnum.setError(stackTraceToString(throwable));
        }
        return statusEnum;
    }

    private String stackTraceToString(Throwable e) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement element : e.getStackTrace()) {
            sb.append(element.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
