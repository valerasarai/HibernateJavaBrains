package com.valerastudy.HibernateMaps;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity(name = "book_M2O")
public class BookM2O {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookId;
    private String bookName;
    private String bookAuthor;

//    @OneToMany(mappedBy = "book")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "BOOK_MATERIALS",
            joinColumns = @JoinColumn(name = "BOOK_ID"),
            inverseJoinColumns = @JoinColumn(name = "MATERIOALS_ID"))
    private Collection<Materials> bookMaterial = new ArrayList<Materials>();

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

    public Collection<Materials> getBookMaterial() {
        return bookMaterial;
    }

    public void setBookMaterial(Materials bookMaterial) {
        this.bookMaterial.add(bookMaterial);
    }
}
