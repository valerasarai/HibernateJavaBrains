package com.valerastudy.Hibernate;

import com.mysql.cj.xdevapi.CreateIndexParams;
import com.sun.javafx.collections.MappingChange;
import com.valerastudy.HibernateMaps.BookHQL;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.*;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Map;

public class HibernateTestHQL {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
/*
// creating the objects
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        for (int i = 0; i < 10; i++) {
            BookHQL book = new BookHQL();
            book.setBookName("Book "+i);
            session.save(book);
        }
        session.getTransaction().commit();
        session.close();
*/

/*
// 25 25 25
//--------------------------------------------------------------------
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("from BookHQL where bookId > 2");
        List<BookHQL> books = query.list();
        session.getTransaction().commit();
        session.close();

        System.out.println("Number of records: " + books.size());
//--------------------------------------------------------------------
*/

/*
// 26 26 26
//--------------------------------------------------------------------
        Session session = sessionFactory.openSession();
        session.beginTransaction();

//ex1
//        Query query = session.createQuery("from BookHQL");
//        query.setFirstResult(5);
//        query.setMaxResults(2);
//        List<BookHQL> books = query.list();

//ex2
//        Query query = session.createQuery("select bookName from BookHQL");
//        query.setFirstResult(5);
//        query.setMaxResults(2);
//        List<String> books = query.list();

//ex3
//        Query query = session.createQuery("select new map(bookId, bookName) from BookHQL");
//        List<Map> books = query.list();

//ex4
        Query query = session.createQuery("select max(bookId) from BookHQL");
//        List<Integer> books = query.list();
//        Integer books = (Integer) query.list().get(0);
//        int maxId = books.intValue();
        int maxId = ((Integer) query.list().get(0)).intValue();

        session.getTransaction().commit();
        session.close();

//ex1
//        for (BookHQL book : books) System.out.println(book.getBookId() + " " + book.getBookName());
//ex2
//        for (String book : books) System.out.println(book);
//ex3
//        for (Map book : books) System.out.println(book.toString());
//ex4
//        for (Integer book : books) System.out.println(book);
//        System.out.println("Maxima index of bookId = " + books.toString());
        System.out.println("Maxima index of bookId = " + maxId);
//--------------------------------------------------------------------
*/

/*
// 28 28 28 28
//--------------------------------------------------------------------
        Session session = sessionFactory.openSession();
        session.beginTransaction();

//ex1
//        Query query = session.getNamedQuery("BookHQL.byId")
//        query.setInteger(0, 3);

//ex2
        Query query = session.getNamedQuery("BookHQL.byName");
        query.setString(0, "Book 7");

        List<BookHQL> books = query.list();
        session.getTransaction().commit();
        session.close();

        for (BookHQL book : books) System.out.println(book.getBookId() + " " + book.getBookName());
//--------------------------------------------------------------------
*/

/*
// 29 29 29 29 29
// 30 30 30 30 30
//--------------------------------------------------------------------
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(BookHQL.class);
//        criteria.add(Restrictions.eq("bookName", "Book 5"));
//        criteria.add(Restrictions.ge("bookId",4));

//And structure
//        criteria
//                .add(Restrictions.like("bookName", "Book 1%"))
//                .add(Restrictions.between("bookId",4, 50));

// OR structure
//        criteria.add(Restrictions.or(Restrictions.like("bookName", "Book 1%"),
//                Restrictions.between("bookId",4, 50)));
//
        criteria.add(Restrictions.or(Restrictions.between("bookId", 0, 3),
                Restrictions.between("bookId", 7, 50)))
                .add(Restrictions.like("bookName", "Book 1%"));

        List<BookHQL> books = criteria.list();
        session.getTransaction().commit();
        session.close();

        for (BookHQL book : books) System.out.println(book.getBookId() + " " + book.getBookName());
//--------------------------------------------------------------------
*/


/*
// 31 31 31 31 31 31
//--------------------------------------------------------------------
        Session session = sessionFactory.openSession();
        session.beginTransaction();

//example object
        BookHQL exampleBook = new BookHQL();
//        exampleBook.setBookId(5);
        exampleBook.setBookName("Book 1%");

//        Example example = Example.create(exampleBook);
//        Example example = Example.create(exampleBook).excludeProperty("bookName");
        Example example = Example.create(exampleBook).enableLike();

        Criteria criteria = session.createCriteria(BookHQL.class)
//                .setProjection(Projections.property("bookId"))
//                .setProjection(Projections.count("bookId"))
//                .addOrder(Order.desc("bookId"))
                .add(example)
                ;

        List<BookHQL> books = criteria.list();
        session.getTransaction().commit();
        session.close();

        for (BookHQL book : books) System.out.println(book.getBookId() + " " + book.getBookName());
//--------------------------------------------------------------------
*/



// 32 32 32 32 32 32
//--------------------------------------------------------------------
// 32
    //        Session session1 = sessionFactory.openSession();
    //        session1.beginTransaction();
    //        BookHQL book1 = (BookHQL) session1.get(BookHQL.class, 1);
    //        session1.getTransaction().commit();
    //        session1.close();
    //
    //        Session session2 = sessionFactory.openSession();
    //        session2.beginTransaction();
    //        BookHQL book2 = (BookHQL) session2.get(BookHQL.class, 1);
    //        session2.getTransaction().commit();
    //        session2.close();

// 33
        Session session1 = sessionFactory.openSession();
        session1.beginTransaction();

        BookHQL book1 = (BookHQL) session1.get(BookHQL.class, 1);

        session1.getTransaction().commit();
        session1.close();

        Session session2 = sessionFactory.openSession();
        session2.beginTransaction();

        BookHQL book2 = (BookHQL) session2.get(BookHQL.class, 1);

        session2.getTransaction().commit();
        session2.close();

//--------------------------------------------------------------------

        sessionFactory.close();
    }
}
