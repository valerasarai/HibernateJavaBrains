package com.valerastudy.Hibernate;

import com.valerastudy.HibernateMaps.BookO2O;
import com.valerastudy.HibernateMaps.Materials;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BookTestO2O {
    public static void main(String[] args) {
        BookO2O book1 = new BookO2O();
        Materials materials = new Materials();
        BookO2O book2 = new BookO2O();

        materials.setMaterialsName("Material 1");

        book1.setBookName("Book 1");
        book1.setBookAuthor("Author 1");
        book1.setBookMaterial(materials);

        book2.setBookName("Book 2");
        book2.setBookAuthor("Author 2");
        book2.setBookMaterial(materials);

        //1. Create Session factory
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        //2. Create Session from the Session factory
        Session session = sessionFactory.openSession();

        //3. Use the Session to save Model Objects
        session.beginTransaction();
        session.save(book1);
        session.save(book2);
        session.save(materials);
        session.getTransaction().commit();
        session.close();

        sessionFactory.close();

    }

}
