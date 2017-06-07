package ua.itemstore.domains;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "book_supplier_operation")
public class BookSupplyOperation {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "date")
    private Date date;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Book book;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private BookSupplier supplier;


    @Column(name = "count")
    private Integer count;

    public BookSupplyOperation() {
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

    public BookSupplier getSupplier() {
        return supplier;
    }

    public void setSupplier(BookSupplier supplier) {
        this.supplier = supplier;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
