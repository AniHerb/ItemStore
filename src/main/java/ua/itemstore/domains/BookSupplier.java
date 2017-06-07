package ua.itemstore.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book_supplier")
public class BookSupplier {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "someInformation")
    private String someInformation;

    public BookSupplier() {
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

    public String getSomeInformation() {
        return someInformation;
    }

    public void setSomeInformation(String someInformation) {
        this.someInformation = someInformation;
    }
}
