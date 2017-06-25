package test.itemstore;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;
import ua.itemstore.configuration.BeanConfigurator;
import ua.itemstore.controllers.BookController;
import ua.itemstore.domains.*;
import ua.itemstore.exceptions.ByMoreThenExistItemException;

import java.util.Date;

/**
 * Created by xnx_ on 24.06.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BeanConfigurator.class, loader = AnnotationConfigContextLoader.class)

public class ItemStoreLogicalTest {

    @Autowired
    private BookController bookController;

    @Test(expected = ByMoreThenExistItemException.class)
    @Transactional
    public void testBuyMoreBookThenSupply(){
        Book book = createSupply10Books();
        createBuy100Books(book);
    }

    @Test
    public void flowCreateAndDeleteBook(){

    }

    private void createBuy100Books(Book book) {
        BookSupplier supplier = Instruments.createBookSupplier();
        BookSupplyOperation bookSupplyOperation = new BookSupplyOperation();
        bookSupplyOperation.setBook(book);
        bookSupplyOperation.setCount(10);
        bookSupplyOperation.setDate(new Date());
        bookSupplyOperation.setSupplier(supplier);
        int res = bookController.createOperationBookSupply(bookSupplyOperation);
        Assert.assertEquals(res, 0);
    }

    private Book createSupply10Books() {
        Book book = Instruments.createBook();
        BookConsumer bookConsumers = Instruments.createBookConsumers();
        BookConsumerOperation bookConsumerOperation = new BookConsumerOperation();
        bookConsumerOperation.setDate(new Date());
        bookConsumerOperation.setCount(10000);
        bookConsumerOperation.setBook(book);
        bookConsumerOperation.setBookConsumer(bookConsumers);
        int res = bookController.createOperationBookConsumer(bookConsumerOperation);
        Assert.assertEquals(res, 0);
        return book;
    }
}
