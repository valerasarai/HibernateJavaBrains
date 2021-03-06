package com.valerastudy.Hibernate;

import com.valerastudy.HibernateMaps.BookM2M;
import com.valerastudy.HibernateMaps.Materials;
import com.valerastudy.HibernateMaps.MaterialsM2M;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BookTestM2M {
    public static void main(String[] args) {
        BookM2M book1 = new BookM2M();
        MaterialsM2M materials1 = new MaterialsM2M();
        MaterialsM2M materials2 = new MaterialsM2M();

        materials1.setMaterialsName("Material 1");
        materials2.setMaterialsName("Material 2");

        book1.setBookName("Book 1");
        book1.setBookAuthor("Author 1");
        book1.setBookMaterial(materials1);
        book1.setBookMaterial(materials2);

        materials1.setBook(book1);
        materials2.setBook(book1);

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
//        session.save(book2);
        session.save(materials1);
        session.save(materials2);
        session.getTransaction().commit();
        session.close();

        sessionFactory.close();

    }

}
