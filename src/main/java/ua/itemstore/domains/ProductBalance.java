package ua.itemstore.domains;

import javax.persistence.*;

/**
 * Created by xnx_ on 24.06.2017.
 */
@Entity
@Table(name = "product_balance")
public class ProductBalance {
    @Id
    private Long id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    @JoinColumn(name="book_id",nullable = false)
    private Book book;

    @Column(name = "count")
    private Integer count;

    public ProductBalance() {
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
