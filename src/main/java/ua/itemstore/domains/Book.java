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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (id != null ? !id.equals(book.id) : book.id != null) return false;
        if (name != null ? !name.equals(book.name) : book.name != null) return false;
        if (date != null ? !date.equals(book.date) : book.date != null) return false;
        if (autuhors != null ? !autuhors.equals(book.autuhors) : book.autuhors != null) return false;
        return IOSN != null ? IOSN.equals(book.IOSN) : book.IOSN == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (autuhors != null ? autuhors.hashCode() : 0);
        result = 31 * result + (IOSN != null ? IOSN.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", autuhors='" + autuhors + '\'' +
                ", IOSN='" + IOSN + '\'' +
                '}';
    }
}
