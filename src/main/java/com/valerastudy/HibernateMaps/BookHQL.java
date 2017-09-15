package com.valerastudy.HibernateMaps;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
//For 33 ---------------------------------------------------------------------
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
//----------------------------------------------------------------------------
//For 28 ---------------------------------------------------------------------
@NamedQuery(name = "BookHQL.byId", query = "from BookHQL where bookId = ?")
@NamedNativeQuery(name = "BookHQL.byName", query = "select * from user_details where bookName = ?", resultClass = BookHQL.class)
//----------------------------------------------------------------------------
@Table(name = "USER_DETAILS")
public class BookHQL {
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
