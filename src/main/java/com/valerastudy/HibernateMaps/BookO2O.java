package com.valerastudy.HibernateMaps;

import javax.persistence.*;

@Entity (name = "book_o2m")
public class BookO2O {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int bookId;
    private String bookName;
    private String bookAuthor;

    @OneToOne
    @JoinColumn (name = "Materials_ID")
    private Materials bookMaterial;

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

    public Materials getBookMaterial() {
        return bookMaterial;
    }

    public void setBookMaterial(Materials bookMaterial) {
        this.bookMaterial = bookMaterial;
    }
}
