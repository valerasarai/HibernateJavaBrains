package com.valerastudy.Hibernate;

import com.valerastudy.HibernateMaps.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MaterialsTestInheritance {
    public static void main(String[] args) {
        MaterialsInheritance materials = new MaterialsInheritance();
        MaterialsInheritance1 materials1 = new MaterialsInheritance1();
        MaterialsInheritance2 materials2 = new MaterialsInheritance2();

        materials.setMaterialsName("Material");
        materials1.setMaterialsName("Material 1");
        materials1.setStrong("Material 1 Strong");
        materials2.setMaterialsName("Material 2");
        materials2.setPermiability("Material 2 Permiability");


        //1. Create Session factory
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        //2. Create Session from the Session factory
        Session session = sessionFactory.openSession();

        //3. Use the Session to save Model Objects
        session.beginTransaction();
        session.save(materials);
        session.save(materials1);
        session.save(materials2);
        session.getTransaction().commit();
        session.close();

        sessionFactory.close();
    }

}
