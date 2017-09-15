package com.valerastudy.HibernateMaps;

import javax.persistence.*;
import java.util.Date;

/* Annotation:
--- For class
@Entity(name = "USER_DETAILS")
@Table (name = "USER_DETAILS")

--- For field or getters
@Id                          //seteaza coloana ca Primary Key
@Column(name = "BOOK_ID")
@Basic                       //De regula nu se foloseste
@Transient                   //Ignora proprietatea la crearea tabelului
@Lob                         //nu am inteles ce face????????
@Temporal(TemporalType.DATE) //Specifica tipul de date in BD
@GeneratedValue
    @GeneratedValue(strategy = GenerationType.AUTO) - hibernate decide strategia
        IDENTITY
        SEQUENCE
        TABLE
        class: specificata intr-o clasa anume
    (se selecteaza in functie de baza de date folosita si posibilitatile ei)
*/

@Entity
@Table(name = "USER_DETAILS")
public class BookDetails {

    @Id  //seteaza coloana ca Primary Key
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookId;
    private String bookName;
    private String bookAuthor;
    private Date inDate;

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

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }
}
