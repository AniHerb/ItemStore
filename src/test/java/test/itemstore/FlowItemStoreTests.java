package test.itemstore;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import ua.itemstore.configuration.BeanConfigurator;
import ua.itemstore.controllers.BookController;
import ua.itemstore.domains.*;

import java.util.Date;

/**
 * Created by Nazar on 25.06.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BeanConfigurator.class, loader = AnnotationConfigContextLoader.class)

public class FlowItemStoreTests {

    @Autowired
    private BookController bookController;

    @Test
    public void testFlowCreateAndDeleteBook(){
        Book b = Instruments.createBook();
        bookController.createBook(b);
        Book insertedBookForSearsh = bookController.getBookByID(b.getId());
        Assert.assertNotNull(insertedBookForSearsh);
        bookController.deleteBook(b);
        Book insetedBook = bookController.getBookByID(b.getId());
        Assert.assertNull(insetedBook);
    }

    @Test
    public void createBookConsumerOperationTest(){
        createFlowSell();
    }

    @Test
    public void createReturnedOperation(){
       TwoSideHolder<Book,BookConsumer> holder = createFlowSell();
       createReturnBook(holder);
    }

    private void createReturnBook( TwoSideHolder<Book,BookConsumer> holder) {
        BookReturnOperation bookReturnOperation = new BookReturnOperation();
        bookReturnOperation.setDate(new Date());
        bookReturnOperation.setBook(holder.getT());
        bookReturnOperation.setConsumer(holder.getR());
        bookController.createBookReturnOperation(bookReturnOperation);
    }

    private TwoSideHolder<Book, BookConsumer> createFlowSell(){
        Book book = createBook();  // створюємо книгу, як номенклатуру
        BookSupplier bookSupplier =  creteBookSupply(); //Створюємо постачальника книги
        creatBookSupplierOperation(book,bookSupplier); //постачажмо книгу
        BookConsumer bookConsumer =  createBookConsumer(); //створюємо покупця
        int res = createSell(book,bookConsumer); // створюємо продажу
        Assert.assertEquals(res, 0);
        return new TwoSideHolder<>(book,bookConsumer);
    }

    private int createSell(Book book, BookConsumer bookConsumer) {
        BookConsumerOperation bookConsumerOperation = new BookConsumerOperation();
        bookConsumerOperation.setDate(new Date());
        bookConsumerOperation.setCount(1);
        bookConsumerOperation.setBook(book);
        bookConsumerOperation.setBookConsumer(bookConsumer);
        int res = bookController.createOperationBookConsumer(bookConsumerOperation);
        return res;
    }

    private BookConsumer createBookConsumer() {
        BookConsumer bookConsumer = Instruments.createBookConsumers();
        bookController.createBookConsumer(bookConsumer);
        return bookConsumer;
    }

    private void creatBookSupplierOperation(Book book, BookSupplier bookSupplier) {
        BookSupplyOperation bookSupplierOperation = new BookSupplyOperation();
        bookSupplierOperation.setSupplier(bookSupplier);
        bookSupplierOperation.setCount(1);
        bookSupplierOperation.setDate(new Date());
        bookSupplierOperation.setBook(book);
        bookController.createOperationBookSupply(bookSupplierOperation);
    }

    private BookSupplier creteBookSupply() {
        BookSupplier bookSupplier = new BookSupplier();
        bookSupplier.setSomeInformation("iiiii");
        bookSupplier.setName("someName");
        bookController.createSupplier(bookSupplier);
        return bookSupplier;
    }

    private Book createBook() {
        Book book = Instruments.createBook();
        bookController.createBook(book);
        return book;
    }

    private class TwoSideHolder<T,R>{
        private T t;
        private R r;

        public TwoSideHolder(T t, R r) {
            this.t = t;
            this.r = r;
        }

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }

        public R getR() {
            return r;
        }

        public void setR(R r) {
            this.r = r;
        }
    }
}
