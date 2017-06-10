package ua.itemstore.domains;


        import javax.persistence.*;
        import java.util.Date;

@Entity
@Table(name = "book",uniqueConstraints=
@UniqueConstraint(columnNames={"name", "autuhors"}))
public class Book {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "date")
    private Date date;

    @Column(name = "autuhors",nullable = false)
    private String autuhors;

    @Column(name = "iosn")
    private String IOSN;

    public Book() {
        //TODO avoid costyl with generateID;
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
