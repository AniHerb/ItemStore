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
import ua.itemstore.domains.Book;

/**
 * Created by Nazar on 25.06.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BeanConfigurator.class, loader = AnnotationConfigContextLoader.class)

public class FlowItemStoreTests {

    @Autowired
    private BookController bookController;

    @Test
    public void testFrowCreateAndDeleteBook(){
        Book b = Instruments.createBook();
        bookController.createBook(b);
        Book insertedBookForSearsh = bookController.getBookByID(b.getId());
        Assert.assertNotNull(insertedBookForSearsh);
        bookController.deleteBook(b);
        Book insetedBook = bookController.getBookByID(b.getId());
        Assert.assertNull(insetedBook);
    }

}
