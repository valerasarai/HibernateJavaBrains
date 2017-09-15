package com.valerastudy.Hibernate;

import com.valerastudy.HibernateMaps.BookCRUD;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTestCRUD {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

/*
// 21 -- 22
        BookCRUD book = new BookCRUD();
        book.setBookName("Book 1");

        Session session = sessionFactory.openSession();
        session.beginTransaction();

*/
/*
//21 21 21 21 21 21 21 21 21 21 21 21 21 21 21 21 21 21 21 21 21 21
        for (int i = 0; i < 10; i++) {
            BookCRUD book = new BookCRUD();
            book.setBookName("Book "+i);
            session.save(book);
        }
//--------------------------------------------------------------------
*//*


*/
/*
//21 21 21 21 21 21 21 21 21 21 21 21 21 21 21 21 21 21 21 21 21 21
        BookCRUD book1 = session.get(BookCRUD.class, 6);

//        System.out.println(book1.getBookId() + " " + book1.getBookName());
//        book1.setBookName("Update data");
//        session.delete(book1);
//        session.update(book1);
//--------------------------------------------------------------------
*//*


*/
/*
//22 22 22 22 22 22 22 22 22 22 22 22 22 22 22 22 22 22 22 22 22 22
        session.save(book);
        session.getTransaction().commit();

        session.beginTransaction();
        session.save(book);
        book.setBookName("Updated Book!");
//--------------------------------------------------------------------
*//*

        session.getTransaction().commit();
        session.close();
*/

/*
// 24 24 24 24 24 24 24 24 24 24 24 24 24 24 24 24 24 24 24 24 24 24
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        BookCRUD book = (BookCRUD) session.get(BookCRUD.class, 1);

        session.getTransaction().commit();
        session.close();

        book.setBookName("Book after session closed!");

        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(book);
//        book.setBookName("Book change after session closed!");
        session.getTransaction().commit();
        session.close();
//--------------------------------------------------------------------
*/

        sessionFactory.close();
    }
}
