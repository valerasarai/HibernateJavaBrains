package com.valerastudy.Hibernate;

import com.valerastudy.HibernateMaps.BookEmbedded;
import com.valerastudy.HibernateMaps.PublishEmbedded;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BookTestEmbPublish {
    public static void main(String[] args) {
        BookEmbedded book1 = new BookEmbedded();
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
        book1.setBookPublish(publish);
        book1.setBookPublish1(publish1);

        //1. Create Session factory
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        //2. Create Session from the Session factory
        Session session = sessionFactory.openSession();

        //3. Use the Session to save Model Objects
        session.beginTransaction();
        session.save(book1);
        session.getTransaction().commit();
        session.close();

        sessionFactory.close();

    }
}
