package ua.itemstore.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.itemstore.domains.Book;
import ua.itemstore.domains.BookConsumer;
import ua.itemstore.domains.BookSupplier;
import ua.itemstore.domains.BookSupplyOperation;
import ua.itemstore.enums.StatusEnum;

import java.util.Set;

@Repository
public class ItemStoreDAOImpl implements ItemStoreDAO {

    //// TODO: 01.06.2017 Розрообити внятку систему вивуду і контроля помилок, щоб було легше шукати баги

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public StatusEnum createBook(Book book) {
       persist(book);
        return StatusEnum.CREATED;
    }

    @Override
    public Set<Book> getBooksByBook(Book book) {
        throw new UnsupportedOperationException("not implement yet");
    }

    @Override
    public StatusEnum createSupplier(BookSupplier bookSupplier) {
        persist(bookSupplier);
        return StatusEnum.CREATED;
    }

    @Override
    public StatusEnum createBookConsumer(BookConsumer bookConsumer) {
        persist(bookConsumer);
        return StatusEnum.CREATED;
    }

    @Override
    public StatusEnum createOperationBookSupply(BookSupplyOperation bookSupplyOperation) {
        persist(bookSupplyOperation);
        return StatusEnum.CREATED;
    }

    @Override
    public Book getBookByID(Long id) {
        return (Book)sessionFactory.getCurrentSession().get(Book.class,id);
    }

    @Override
    public BookSupplyOperation getBookSupplyOperationByID(Long id) {
        return (BookSupplyOperation)sessionFactory.getCurrentSession().get(BookSupplyOperation.class,id);
    }

    private <T> void persist(T t){
        sessionFactory.getCurrentSession().persist(t);
    }
}
