package com.skill3.main;

import com.skill3.entity.ProductEntity;
import com.skill3.util.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class HQLSkill3App {

    public static void main(String[] args) {

        Session session = HibernateConfig.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

      
        session.save(new ProductEntity("Laptop", 55000, 10, "Electronics"));
        session.save(new ProductEntity("Mobile", 25000, 15, "Electronics"));
        session.save(new ProductEntity("Keyboard", 1200, 25, "Accessories"));
        session.save(new ProductEntity("Monitor", 15000, 5, "Electronics"));
        session.save(new ProductEntity("Tablet", 18000, 8, "Electronics"));

        tx.commit();

        
        Query<Object[]> q1 = session.createQuery(
                "select p.description, count(p) from ProductEntity p group by p.description",
                Object[].class
        );
        List<Object[]> groupList = q1.list();
        for (Object[] o : groupList) {
            System.out.println(o[0] + " : " + o[1]);
        }

        
        Query<ProductEntity> q2 = session.createQuery(
                "from ProductEntity p where p.price between :min and :max",
                ProductEntity.class
        );
        q2.setParameter("min", 1000.0);
        q2.setParameter("max", 30000.0);
        q2.list();

        
        session.createQuery(
                "from ProductEntity p where p.productName like 'M%'",
                ProductEntity.class
        ).list();

        
        session.createQuery(
                "from ProductEntity p where p.productName like '%e'",
                ProductEntity.class
        ).list();

       
        session.createQuery(
                "from ProductEntity p where p.productName like '%top%'",
                ProductEntity.class
        ).list();

       
        session.createQuery(
                "from ProductEntity p where length(p.productName) = 5",
                ProductEntity.class
        ).list();

        session.close();
        HibernateConfig.getSessionFactory().close();
    }
}
