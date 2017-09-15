package com.valerastudy.HibernateMaps;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Entity (name = "materials")
public class Materials {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int materialsID;
    private String materialsName;
//    @ManyToOne
//    private BookO2M book;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    private BookM2O book;

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

//    public BookO2M getBook() {
//        return book;
//    }
//
//    public void setBook(BookO2M book) {
//        this.book = book;
//    }

    public BookM2O getBook() {
        return book;
    }

    public void setBook(BookM2O book) {
        this.book = book;
    }
}
