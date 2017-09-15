package com.valerastudy.Hibernate;

import com.valerastudy.HibernateMaps.BookM2M;
import com.valerastudy.HibernateMaps.BookM2O;
import com.valerastudy.HibernateMaps.Materials;
import com.valerastudy.HibernateMaps.MaterialsM2M;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BookTestM2O {
    public static void main(String[] args) {
        BookM2O book1 = new BookM2O();
        Materials materials1 = new Materials();
        Materials materials2 = new Materials();

        materials1.setMaterialsName("Material 1");
        materials2.setMaterialsName("Material 2");

        book1.setBookName("Book 1");
        book1.setBookAuthor("Author 1");
        book1.setBookMaterial(materials1);
        book1.setBookMaterial(materials2);


//        book2.setBookName("Book 2");
//        book2.setBookAuthor("Author 2");
//        book2.setBookMaterial(materials1);

        //1. Create Session factory
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        //2. Create Session from the Session factory
        Session session = sessionFactory.openSession();

        //3. Use the Session to save Model Objects
        session.beginTransaction();
        session.save(book1);
//        session.save(book1);
//        session.save(book2);
//        session.save(materials1);
//        session.save(materials2);
        session.getTransaction().commit();
        session.close();

        sessionFactory.close();

    }

}
