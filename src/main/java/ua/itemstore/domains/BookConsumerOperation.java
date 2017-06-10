package ua.itemstore.domains;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by xnx_ on 10.06.2017.
 * Modified by pupkin on 10.11.2018
 */
@Entity
@Table(name = "book_consumer_operation")
public class BookConsumerOperation {
    @Id
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    @JoinColumn(name="book_id",nullable = false)
    private Book book;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    @JoinColumn(name="book_consumer_id",nullable = false)
    private BookConsumer bookConsumer;

    @Column(name = "date")
    private Date date;

    @Column(name = "count")
    private Integer count;

    public BookConsumerOperation() {
        this.id = System.currentTimeMillis();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public BookConsumer getBookConsumer() {
        return bookConsumer;
    }

    public void setBookConsumer(BookConsumer bookConsumer) {
        this.bookConsumer = bookConsumer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
