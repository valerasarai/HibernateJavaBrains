package com.valerastudy.Hibernate;

import com.valerastudy.HibernateMaps.BookDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class HibernateTest {
    public static void main(String[] args) {
        BookDetails book = new BookDetails();
//        book.setBookId(4);
        book.setBookName("Book 1");
        book.setBookAuthor("Author 1");
        book.setInDate(new Date());

        BookDetails book1 = new BookDetails();
//        book.setBookId(4);
        book1.setBookName("Book 1");
        book1.setBookAuthor("Author 1");
        book1.setInDate(new Date());

/*
Pasii de urmat pentru a salva transmite obiectul:
1. Create Session factory
2. Create Session from the Session factory
3. Use the Session to save Model Objects
*/
        //1. Create Session factory
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        //2. Create Session from the Session factory
        Session session = sessionFactory.openSession();

        //3. Use the Session to save Model Objects
        session.beginTransaction();
        session.save(book);
        session.save(book1);
        session.getTransaction().commit();
        session.close();

/* ---------------------------------------
        book = null;

        session = sessionFactory.openSession();
        session.beginTransaction();

//Extragerea datekir de ka session
//1. specificarea clasei
//2. specificatie care anume inregistrare ne trebuie

        book = (BookDetails) session.get(BookDetails.class, 4);
        session.close();
        System.out.println("Book name is " + book.getBookName() + " and author is " + book.getBookAuthor());
*/ //--------------------------------------------
        sessionFactory.close();

    }
}
