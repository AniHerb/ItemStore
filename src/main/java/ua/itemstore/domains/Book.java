package ua.itemstore.domains;

        import javax.persistence.Column;
        import javax.persistence.Entity;
        import javax.persistence.Id;
        import javax.persistence.Table;
        import java.util.Date;

/**
 * Created by xnx_ on 10.02.2017.
 */
@Entity
@Table(name = "book")
public class Book {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    private Date date;

    @Column(name = "autuhors")
    private String autuhors;

    @Column(name = "iosn")
    private String IOSN;

    public Book() {
        this.id = System.currentTimeMillis();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAutuhors() {
        return autuhors;
    }

    public void setAutuhors(String autuhors) {
        this.autuhors = autuhors;
    }

    public String getIOSN() {
        return IOSN;
    }

    public void setIOSN(String IOSN) {
        this.IOSN = IOSN;
    }
}
