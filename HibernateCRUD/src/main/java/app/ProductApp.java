package app;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Product;
import util.HibernateUtil;

public class ProductApp {

    public static void main(String[] args) {

        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Product p1 = new Product("Laptop", "Dell i5", 55000, 10);
        Product p2 = new Product("Mouse", "Wireless", 600, 40);

        session.save(p1);
        session.save(p2);

        tx.commit();
        session.close();

        session = HibernateUtil.getSessionFactory().openSession();
        Product product = session.get(Product.class, 1);
        System.out.println(product.getName() + " " + product.getPrice());
        session.close();

       
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        product = session.get(Product.class, 1);
        product.setPrice(58000);
        product.setQuantity(8);
        session.update(product);
        tx.commit();
        session.close();

        
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        product = session.get(Product.class, 2);
        session.delete(product);
        tx.commit();
        session.close();

        System.out.println("CRUD Operations Completed");
    }
}
