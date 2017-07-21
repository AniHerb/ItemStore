package ua.itemstore.domains;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Nazar on 11.07.2017.
 */

@Entity
@Table(name = "book_return_operation")
public class BookReturnOperation {

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "date")
    private Date date;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    @JoinColumn(name="book_id",nullable = false)
    private Book book;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    @JoinColumn(name="book_consumer_id",nullable = false)
    private BookConsumer consumer;

    public BookReturnOperation() {
        this.id = System.currentTimeMillis();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public BookConsumer getConsumer() {
        return consumer;
    }

    public void setConsumer(BookConsumer consumer) {
        this.consumer = consumer;
    }
}
