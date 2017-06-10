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
import ua.itemstore.domains.*;
import ua.itemstore.enums.StatusEnum;

import java.util.Date;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BeanConfigurator.class, loader = AnnotationConfigContextLoader.class)
public class ItemStoreTestCase {

    //modify statuses

    //todo Зробити, щоб при помилці заповнення даниих вивалювалась помилка при заповенні даних а не
    // при виконання тесту

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
    public void testCreateSupplyBook(){
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
        Book book = new Book();
        //10000000,'{}','init_authors','2017-05-02','init_name'
        book.setId(10000000l);
        book.setIOSN("{}");
        book.setDate(new Date());
        book.setAutuhors("init_authors");
        book.setName("init_name");
        StatusEnum statusEnum = bookController.createBook(book);
        Assert.assertEquals(statusEnum.getError(), StatusEnum.ERROR,statusEnum);
    }

    @Test
    public void testNotNullForBookFieldName(){
        Book book = new Book();
        book.setName(null);
        StatusEnum statusEnum = bookController.createBook(book);
        Assert.assertEquals(statusEnum.getError(), StatusEnum.ERROR,statusEnum);

    }

    @Test
    public void testNotNullForBookFieldAuthor(){
        Book book = new Book();
        book.setName("");
        book.setAutuhors(null);
        StatusEnum statusEnum = bookController.createBook(book);
        Assert.assertEquals(statusEnum.getError(), StatusEnum.ERROR,statusEnum);
    }

    @Test
    public void searchBookByID(){
        Long id = 10000000L;
        Book book = bookController.getBookByID(id);
        Assert.assertNotNull("Book cannot be null!",book);
    }

    @Test
    public void searchBookOperationByID(){
        Long id = 2222222L;
        BookSupplyOperation bookSupplyOperation = bookController.getBookSupplyOperationByID(id);
        Assert.assertNotNull("BookOperation cannot be null! ",bookSupplyOperation);
        Assert.assertNotNull("Book in BookOperation cannot be null!",
                bookSupplyOperation.getBook());
        Assert.assertNotNull("BookSupplier in BookOperation cannot be null!",
                bookSupplyOperation.getSupplier());
    }

    @Test
    public void createBookConsumerOperation(){
        Book book = Instruments.createBook();
        BookConsumer bookConsumers = Instruments.createBookConsumers();
        BookConsumerOperation bookConsumerOperation = new BookConsumerOperation();
        bookConsumerOperation.setDate(new Date());
        bookConsumerOperation.setCount(10000);
        bookConsumerOperation.setBook(book);
        bookConsumerOperation.setBookConsumer(bookConsumers);
        StatusEnum statusEnum = bookController.createOperationBookConsumer(bookConsumerOperation);
        Assert.assertEquals(statusEnum.getError(), StatusEnum.CREATED,statusEnum);
    }

}
