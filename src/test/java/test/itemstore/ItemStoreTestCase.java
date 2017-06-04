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
import ua.itemstore.controllers.BookControllerImpl;
import ua.itemstore.domains.Book;
import ua.itemstore.enums.BookStatusEnum;
import ua.itemstore.services.ItemStoreService;

import java.util.Date;


/**
 * Created by xnx_ on 01.06.2017.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BeanConfigurator.class, loader = AnnotationConfigContextLoader.class)
public class ItemStoreTestCase {

    @Autowired
    private BookController bookController;

    @Autowired
    private ItemStoreService storeService;

    @Test
    public void testCreateBook(){
        Book book = new Book();
        book.setDate(new Date());
        book.setAutuhors("Authors");
        book.setIOSN("{}");
        BookStatusEnum statusEnum = bookController.createBook(book);
        Assert.assertEquals(statusEnum.getError(),BookStatusEnum.CREATED,statusEnum);
        storeService.checkIfExistBook(book);
    }
}
