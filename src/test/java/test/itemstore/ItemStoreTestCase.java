package test.itemstore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;
import ua.itemstore.configuration.BeanConfigurator;
import ua.itemstore.controllers.BookController;
import ua.itemstore.domains.Book;
import ua.itemstore.domains.BookConsumer;
import ua.itemstore.domains.BookSupplyOperation;
import ua.itemstore.domains.BookSupplier;
import ua.itemstore.enums.StatusEnum;

import java.util.Date;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BeanConfigurator.class, loader = AnnotationConfigContextLoader.class)
public class ItemStoreTestCase {

    //create cleaner dataBase
    //modify statuses



    @Autowired
    private BookController bookController;


    @Before
    public void prepareTests(){

    }

    @Test
    @Transactional
    public void testCreateBook(){
        Book book = Instruments.createBook();
        StatusEnum statusEnum = bookController.createBook(book);
        Assert.assertEquals(statusEnum.getError(), StatusEnum.CREATED,statusEnum);
    }

    @Test
    @Transactional
    public void testCreateBookSupplier(){
        BookSupplier bookSupplier = new BookSupplier();
        bookSupplier.setName("supplier");
        bookSupplier.setSomeInformation("some info");
        StatusEnum statusEnum = bookController.createSupplier(bookSupplier);
        Assert.assertEquals(statusEnum.getError(), StatusEnum.CREATED,statusEnum);
    }

    @Test
    @Transactional
    public void testBookConsumer(){
        BookConsumer bookConsumer = new BookConsumer();
        bookConsumer.setName("name");
        bookConsumer.setEmail("email");
        bookConsumer.setLogin("login");
        bookConsumer.setPassword("password");
        bookConsumer.setSurname("surname");
        StatusEnum statusEnum = bookController.createBookConsumer(bookConsumer);
        Assert.assertEquals(statusEnum.getError(), StatusEnum.CREATED,statusEnum);
    }

    @Test
    @Transactional
    public void testSupplyBook(){
        Book book = Instruments.createBook();
        BookSupplier supplier = Instruments.createBookSupplier();
        BookSupplyOperation bookSupplyOperation = new BookSupplyOperation();
        bookSupplyOperation.setBook(book);
        bookSupplyOperation.setCount(10);
        bookSupplyOperation.setDate(new Date());
        bookSupplyOperation.setSupplier(supplier);
        StatusEnum statusEnum = bookController.createOperationBookSupply(bookSupplyOperation);
        Assert.assertEquals(statusEnum.getError(), StatusEnum.CREATED,statusEnum);
    }

    @Test
    public void testCheckDuplicateCreateBookName(){
        Book book = Instruments.createBook();
        StatusEnum statusEnum = bookController.createBook(book);
        Assert.assertEquals(statusEnum.getError(), StatusEnum.CREATED,statusEnum);
        book.setId(System.currentTimeMillis());
        statusEnum = bookController.createBook(book);
        Assert.assertEquals(statusEnum.getError(), StatusEnum.ERROR,statusEnum);
    }

    @Test
    @Transactional
    public void testNotNullForBookFieldName(){
        Book book = new Book();
        book.setName(null);
        StatusEnum statusEnum = bookController.createBook(book);
        Assert.assertEquals(statusEnum.getError(), StatusEnum.ERROR,statusEnum);

    }

    @Test
    @Transactional
    public void testNotNullForBookFieldAuthor(){
        Book book = new Book();
        book.setName("");
        book.setAutuhors(null);
        StatusEnum statusEnum = bookController.createBook(book);
        Assert.assertEquals(statusEnum.getError(), StatusEnum.ERROR,statusEnum);
    }
}
