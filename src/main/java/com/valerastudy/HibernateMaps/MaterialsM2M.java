package com.valerastudy.HibernateMaps;

import com.valerastudy.Hibernate.BookTestM2M;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity (name = "materials")
public class MaterialsM2M {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int materialsID;
    private String materialsName;
//    @ManyToOne
//    @JoinColumn(name = "BOOK_ID")
//    private BookM2M book;
    @ManyToMany(mappedBy = "bookMaterial")
    private Collection<BookM2M> book = new ArrayList<BookM2M>();

    public int getMaterialsID() {
        return materialsID;
    }

    public void setMaterialsID(int materialsID) {
        this.materialsID = materialsID;
    }

    public String getMaterialsName() {
        return materialsName;
    }

    public void setMaterialsName(String materialsName) {
        this.materialsName = materialsName;
    }

    public Collection<BookM2M> getBook() {
        return book;
    }

    public void setBook(BookM2M book) {
        this.book.add(book);
    }
}
