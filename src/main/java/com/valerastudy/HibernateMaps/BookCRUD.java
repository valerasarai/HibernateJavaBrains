package com.valerastudy.HibernateMaps;

import javax.persistence.*;

@Entity
// for 24 24 24 24
@org.hibernate.annotations.Entity(selectBeforeUpdate = true)
@Table(name = "USER_DETAILS")
public class BookCRUD {
    @Id  //seteaza coloana ca Primary Key
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookId;
    private String bookName;

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
}
