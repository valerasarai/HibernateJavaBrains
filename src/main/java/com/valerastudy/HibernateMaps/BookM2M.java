package com.valerastudy.HibernateMaps;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity(name = "book_o2m")
public class BookM2M {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookId;
    private String bookName;
    private String bookAuthor;

//    @OneToMany(mappedBy = "book")
    @ManyToMany
    @JoinTable(name = "BOOK_MATERIALS",
            joinColumns = @JoinColumn(name = "BOOK_ID"),
            inverseJoinColumns = @JoinColumn(name = "MATERIOALS_ID"))
    private Collection<MaterialsM2M> bookMaterial = new ArrayList<MaterialsM2M>();

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public Collection<MaterialsM2M> getBookMaterial() {
        return bookMaterial;
    }

    public void setBookMaterial(MaterialsM2M bookMaterial) {
        this.bookMaterial.add(bookMaterial);
    }
}
