package ua.itemstore.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.access.BootstrapException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.itemstore.domains.*;


import java.util.List;
import java.util.Set;

@Repository
public class ItemStoreDAOImpl implements ItemStoreDAO {

    //// TODO: 01.06.2017 Розрообити внятку систему вивуду і контроля помилок, щоб було легше шукати баги

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public int createBook(Book book) {
       persist(book);
        return 0;
    }

    @Override
    public int createBookInProductBalance(ProductBalance productBalance){
        persist(productBalance);
        return 0;
    }

    @Override
    public Set<Book> getBooksByBook(Book book) {
        throw new UnsupportedOperationException("not implement yet");
    }

    @Override
    public int createSupplier(BookSupplier bookSupplier) {
        persist(bookSupplier);
        return 0;
    }

    @Override
    public int createBookConsumer(BookConsumer bookConsumer) {
        persist(bookConsumer);
        return 0;
    }

    @Override
    public int createOperationBookSupply(BookSupplyOperation bookSupplyOperation) {
        //persist(bookSupplyOperation);
        save(bookSupplyOperation);
        return 0;
    }

    @Override
    public Book getBookByID(Long id) {
        return (Book)sessionFactory.getCurrentSession().get(Book.class,id);
    }

    @Override
    public BookSupplyOperation getBookSupplyOperationByID(Long id) {
        return getEntityByID(BookSupplyOperation.class,id);
    }

    @Override
    public int createOperationBookConsumer(BookConsumerOperation bookConsumerOperation) {
        save(bookConsumerOperation);
        return 0;
    }

    @Override
    public int getCountBookToSell(Book book) {
        ProductBalance currentProductBalance = getCurrentBanalce(book);
        return currentProductBalance.getCount();
    }

    @Override
    public int deleteBook(Book b) {

        Session session = sessionFactory.getCurrentSession();
        ProductBalance balance = getCurrentBanalce(b);
        session.delete(balance);
        Book entityBook = (Book) session.load(Book.class,b.getId());
        session.delete(entityBook);

        return 0;
    }

    @Override
    public void updateBookBalance(BookSupplyOperation operation) {
        ProductBalance productBalance = getCurrentBanalce(operation.getBook());
        productBalance.setCount(operation.getCount());
        this.save(productBalance);
    }

    @Override
    public void createBookReturnOperation(BookReturnOperation bookReturnOperation) {
        save(bookReturnOperation);
    }

    private <T> void persist(T t){
        sessionFactory.getCurrentSession().persist(t);
    }

    private <T> void save(T t){
        sessionFactory.getCurrentSession().saveOrUpdate(t);
    }

    private <T> T getEntityByID(Class<?> clazz,Long id){
        return (T)sessionFactory.getCurrentSession().get(clazz,id);
    }

    public ProductBalance getCurrentBanalce(Book book) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(ProductBalance.class);
        criteria.add(Restrictions.eq("book.id",book.getId()));
        List<ProductBalance> list = criteria.list();
        if (list.isEmpty()) return generateEmptyProductBalance(book);
        else return list.get(0);
    }

    private ProductBalance generateEmptyProductBalance(Book book) {
        ProductBalance res = new ProductBalance();
        res.setBook(book);
        res.setCount(0);
        return res;
    }

}
