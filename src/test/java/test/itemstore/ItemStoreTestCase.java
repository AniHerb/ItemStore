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
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ua.itemstore.configuration.BeanConfigurator;
import ua.itemstore.controllers.BookController;
import ua.itemstore.domains.*;


import java.util.Date;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BeanConfigurator.class, loader = AnnotationConfigContextLoader.class)
public class ItemStoreTestCase {
    /*TODO
            1) При створенні книжки створювати запис в ProductBalance
                запис з кількістю 0
            2) При створенні БукСуплієрОператіон оновлювати запис на
                кількіть яка в полі коунт

                а) Знайти в ProductBalance по бук ід
                б) Якщо він не знайдений кинути екешин
                в) в обекті змінити коунт
                г) заперсісттинстнути обеєк

         */

    @Autowired
    private BookController bookController;

    @Before
    public void prepareTests(){

    }

    @Test
    public void testCreateBook(){
        Book book = Instruments.createBook();
        int res = bookController.createBook(book);
        Assert.assertEquals(res, 0);
    }

    @Test
    @Transactional
    public void testCreateBookSupplier(){


        BookSupplier bookSupplier = new BookSupplier();
        bookSupplier.setName("supplier");
        bookSupplier.setSomeInformation("some info");
        int res = bookController.createSupplier(bookSupplier);
        Assert.assertEquals(res, 0);
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
        int res = bookController.createBookConsumer(bookConsumer);
        Assert.assertEquals(res, 0);
    }


    @Test(expected = Exception.class)
    public void testCheckDuplicateCreateBookName(){
        Book book = new Book();
        //10000000,'{}','init_authors','2017-05-02','init_name'
        book.setId(10000000l);
        book.setIOSN("{}");
        book.setDate(new Date());
        book.setAutuhors("init_authors");
        book.setName("init_name");
        bookController.createBook(book);
    }

    @Test(expected = Exception.class)
    public void testNotNullForBookFieldName(){
        Book book = new Book();
        book.setName(null);
        bookController.createBook(book);


    }

    @Test(expected = Exception.class)
    public void testNotNullForBookFieldAuthor(){
        Book book = new Book();
        book.setName("");
        book.setAutuhors(null);
        bookController.createBook(book);

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
        bookConsumerOperation.setCount(1);
        bookConsumerOperation.setBook(book);
        bookConsumerOperation.setBookConsumer(bookConsumers);
        int res = bookController.createOperationBookConsumer(bookConsumerOperation);
        Assert.assertEquals(res, 0);
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
        int res = bookController.createOperationBookSupply(bookSupplyOperation);
        Assert.assertEquals(res, 0);
    }





}
