package ua.itemstore.dao;

import com.sun.org.apache.bcel.internal.generic.NOP;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.itemstore.domains.Book;
import ua.itemstore.enums.BookStatusEnum;

import java.util.Set;

/**
 * Created by xnx_ on 01.06.2017.
 */
@Repository
public class ItemStoreDAOImpl implements ItemStoreDAO {

    //// TODO: 01.06.2017 Розрообити внятку систему вивуду і контроля помилок, щоб було легше шукати баги

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public BookStatusEnum createBook(Book book) {
        try {
            persist(book);
            return handleException(BookStatusEnum.CREATED,null);
        } catch (Exception e) {

            return handleException(BookStatusEnum.ERROR,e);
        }
    }

    @Override
    public Set<Book> getBooksByBook(Book book) {
        throw new UnsupportedOperationException("not implement yet");
    }

    private BookStatusEnum handleException(BookStatusEnum bookStatusEnum, Throwable throwable){
        if (throwable == null){
            bookStatusEnum.setError("");
        }else{
            throwable.printStackTrace();
            bookStatusEnum.setError(stackTraceToString(throwable));
        }
       return bookStatusEnum;
    }

    private String stackTraceToString(Throwable e) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement element : e.getStackTrace()) {
            sb.append(element.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    private <T> void persist(T t){
        sessionFactory.getCurrentSession().persist(t);
    }
}
