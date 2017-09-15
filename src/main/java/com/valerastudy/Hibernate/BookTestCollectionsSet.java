package com.valerastudy.Hibernate;

import com.valerastudy.HibernateMaps.BookCollections;
import com.valerastudy.HibernateMaps.BookEmbedded;
import com.valerastudy.HibernateMaps.PublishEmbedded;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Set;

public class BookTestCollectionsSet {
    public static void main(String[] args) {
        BookCollections book1 = new BookCollections();
        PublishEmbedded publish = new PublishEmbedded();

        publish.setName("ARC");
        publish.setCity("Chisinau");
        publish.setAddress("1, Columna str.");

        PublishEmbedded publish1 = new PublishEmbedded();
        publish1.setName("ARC1");
        publish1.setCity("Chisinau1");
        publish1.setAddress("1, Columna str.1");

        book1.setBookName("Book 1");
        book1.setBookAuthor("Author 1");
        book1.setListOfPublish(publish);
        book1.setListOfPublish(publish1);

        //1. Create Session factory
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        //2. Create Session from the Session factory
        Session session = sessionFactory.openSession();

        //3. Use the Session to save Model Objects
        session.beginTransaction();
        session.save(book1);
        session.getTransaction().commit();
        session.close();


        book1 = null;
        publish = null;

        session = sessionFactory.openSession();
//        session.beginTransaction();
        book1 = (BookCollections) session.get(BookCollections.class, 1);
        session.close();

        System.out.println(book1.getBookName());
        publish = (PublishEmbedded) (book1.getListOfPublish().toArray())[0];
        System.out.println(publish.getAddress());
        System.out.println(((PublishEmbedded) (book1.getListOfPublish().toArray())[0]).getAddress());

//        System.out.println(book1.getListOfPublish().size());
//        session.getTransaction().commit();
        sessionFactory.close();

    }

}
