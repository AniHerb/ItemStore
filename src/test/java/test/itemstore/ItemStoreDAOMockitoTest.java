package test.itemstore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.mockito.stubbing.OngoingStubbing;
import ua.itemstore.dao.ItemStoreDAO;
import ua.itemstore.domains.*;

import java.util.Set;

import static org.junit.Assert.*;

public class ItemStoreDAOMockitoTest {

    private ItemStoreDAO itemStoreDAO;
    private Book b;

    @Before
    public void init(){
          b = new Book();
          mock(b);
        //real(b);

    }

    private void real(Book b) {
        itemStoreDAO = new ItemStoreDAO() {
            @Override
            public int createBook(Book book) {
                return 0;
            }

            @Override
            public int createBookInProductBalance(ProductBalance productBalance) {
                return 0;
            }

            @Override
            public Set<Book> getBooksByBook(Book book) {
                return null;
            }

            @Override
            public int createSupplier(BookSupplier bookSupplier) {
                return 0;
            }

            @Override
            public int createBookConsumer(BookConsumer bookConsumer) {
                return 0;
            }

            @Override
            public int createOperationBookSupply(BookSupplyOperation bookSupplyOperation) {
                return 0;
            }

            @Override
            public Book getBookByID(Long id) {
                return null;
            }

            @Override
            public BookSupplyOperation getBookSupplyOperationByID(Long id) {
                return null;
            }

            @Override
            public int createOperationBookConsumer(BookConsumerOperation bookConsumerOperation) {
                return 0;
            }

            @Override
            public int getCountBookToSell(Book book) {
                return 0;
            }

            @Override
            public int deleteBook(Book b) {
                return 0;
            }

            @Override
            public void updateBookBalance(BookSupplyOperation book) {

            }

            @Override
            public void createBookReturnOperation(BookReturnOperation bookReturnOperation) {

            }
        };
    }

    private void mock(Book b) {
        itemStoreDAO = Mockito.mock(ItemStoreDAO.class);
        Mockito.when(itemStoreDAO.createBook(b)).thenReturn(5);
    }

    @Test
    public void createBook() throws Exception {
        _createBook(itemStoreDAO,b,5);

    }

    private void _createBook(ItemStoreDAO itemStoreDAO, Book b, int exp) {
        int res = itemStoreDAO.createBook(b);
        Assert.assertEquals(res,exp);
    }


    @Test
    public void createBookInProductBalance() throws Exception {
    }

    @Test
    public void getBooksByBook() throws Exception {
    }

    @Test
    public void createSupplier() throws Exception {
    }

    @Test
    public void createBookConsumer() throws Exception {
    }

    @Test
    public void createOperationBookSupply() throws Exception {
    }

    @Test
    public void getBookByID() throws Exception {
    }

    @Test
    public void getBookSupplyOperationByID() throws Exception {
    }

    @Test
    public void createOperationBookConsumer() throws Exception {
    }

    @Test
    public void getCountBookToSell() throws Exception {
    }

    @Test
    public void deleteBook() throws Exception {
    }

    @Test
    public void updateBookBalance() throws Exception {
    }

    @Test
    public void createBookReturnOperation() throws Exception {
    }

}