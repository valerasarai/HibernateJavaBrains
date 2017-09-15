package com.valerastudy.HibernateMaps;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity (name = "book_collection")
public class BookCollections {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int bookId;
    private String bookName;
    private String bookAuthor;

    @ElementCollection (fetch = FetchType.EAGER)
    @JoinTable(
            name = "PUBLISH_ADDRESS",
            joinColumns = @JoinColumn(
                    name = "BOOK_ID"))
//    private Set<PublishEmbedded> listOfPublish = new HashSet();
//    @GenericGenerator(name = "sequence-gen", strategy = "sequence")
//    @CollectionId(columns = {@Column (name = "PUBLISH_ID")}, type = @Type(type = "long"), generator = "sequence-gen")
    private Collection<PublishEmbedded> listOfPublish = new ArrayList<PublishEmbedded>();

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

    public Collection<PublishEmbedded> getListOfPublish() {
        return listOfPublish;
    }

    public void setListOfPublish(PublishEmbedded listOfPublish) {
        this.listOfPublish.add(listOfPublish);
    }
}
