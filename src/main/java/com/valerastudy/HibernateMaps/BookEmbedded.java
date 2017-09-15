package com.valerastudy.HibernateMaps;

import javax.persistence.*;

@Entity
public class BookEmbedded {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int bookId;
    private String bookName;
    private String bookAuthor;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "name1")),
            @AttributeOverride(name = "city", column = @Column(name = "city1")),
            @AttributeOverride(name = "address", column = @Column(name = "address1"))})
    private PublishEmbedded bookPublish;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "name2")),
            @AttributeOverride(name = "city", column = @Column(name = "city2")),
            @AttributeOverride(name = "address", column = @Column(name = "address2"))})
    private PublishEmbedded bookPublish1;

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

    public PublishEmbedded getBookPublish() {
        return bookPublish;
    }

    public void setBookPublish(PublishEmbedded bookPublish) {
        this.bookPublish = bookPublish;
    }

    public PublishEmbedded getBookPublish1() {
        return bookPublish1;
    }

    public void setBookPublish1(PublishEmbedded bookPublish1) {
        this.bookPublish1 = bookPublish1;
    }
}
